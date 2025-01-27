package com.alkeys.rh.service.user;


import com.alkeys.rh.entity.user.User;
import com.alkeys.rh.repository.user.UserRepository;
import com.alkeys.rh.service.utils.ServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceAbstract<User, Long> {

    @Autowired
    private UserRepository userRepository;



    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    /*
    * Metodo para buscar un usuario por su nombre de usuario y contraseña
     */
    public User findByUserEmailAndPassword(String email, String password) {
        if (userRepository.findByUserEmailAndPassword(email, password) != null) {
            return userRepository.findByUserEmailAndPassword(email, password);
        }else {
            User user = new User();
            user.setUsername("null");
            user.setPassword("null");
            user.setEmail("null");
            return user;
        }

    }



    /*
    * Metodo para actualizar el estado de un usuario a activo o inactivo para ejecutar el trigger
    * de logs de auditoria
    *      */
    public Boolean UpdateActive(Long id, Boolean active) {
        User user = getById(id);
        if (user != null) {
            user.setActivo(active);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }


    @Override
    public User update(Long id, User object) {
        User user = getById(id);
        if (user != null) {
            user.setEmail(object.getEmail());
            user.setUsername(object.getUsername());
            return userRepository.save(user);
        }
        return null;
    }

    public User updatePassword(Long id, String password) {
        User user = getById(id);
        if (user != null) {
            user.setPassword(password);
            return userRepository.save(user);
        }
        return null;
    }






}
