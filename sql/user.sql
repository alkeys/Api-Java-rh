create table users (
  id bigint primary key generated always as identity,
  username text not null unique,
  password text not null,
  email text unique not null,
  activo bool
);

create table logs (
  id bigint primary key generated always as identity,
  user_id bigint not null,
  action text not null,
  timestamp timestamp default current_timestamp,
  foreign key (user_id) references users (id)
);


-- Crear la función que registra en logs
CREATE OR REPLACE FUNCTION log_user_activation()
RETURNS TRIGGER AS $$
BEGIN
    -- Verificar que el campo 'activo' cambie de FALSE a TRUE
    IF NEW.activo = TRUE AND OLD.activo = FALSE THEN
        INSERT INTO logs (user_id, action) 
        VALUES (NEW.id, 'User activo');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que llama a la función
CREATE TRIGGER trigger_user_activation
AFTER UPDATE ON users
FOR EACH ROW
WHEN (OLD.activo IS DISTINCT FROM NEW.activo)
EXECUTE FUNCTION log_user_activation();


-- Crear o reemplazar la función que registra las salidas
CREATE OR REPLACE FUNCTION log_user_logout()
RETURNS TRIGGER AS $$
BEGIN
    -- Insertar un registro en la tabla logs cuando se actualice el campo 'last_logout'
    INSERT INTO logs (user_id, action, timestamp)
    VALUES (NEW.id, 'User logout', NEW.last_logout);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;



-- Crear el trigger que llama a la función para registrar las salidas
CREATE TRIGGER trigger_user_logout
AFTER UPDATE ON users
FOR EACH ROW
WHEN (OLD.activo IS DISTINCT FROM NEW.activo)
EXECUTE FUNCTION log_user_logout();




