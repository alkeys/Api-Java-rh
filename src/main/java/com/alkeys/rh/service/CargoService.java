package com.alkeys.rh.service;


import com.alkeys.rh.entity.Cargo;
import com.alkeys.rh.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CargoService extends ServiceAbstract<Cargo, Long> {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    protected JpaRepository getRepository() {
        return cargoRepository;
    }

    @Override
    public Cargo update(Long id, Cargo object) {
        Cargo cargo = getById(id);
        if (cargo != null) {
            cargo.setNombre(object.getNombre());
            cargo.setSalarioBase(object.getSalarioBase());
            return cargoRepository.save(cargo);
        }
        return null;
    }
}