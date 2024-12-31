package com.alkeys.rh.repository;

import com.alkeys.rh.entity.Salario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SalarioRepository extends JpaRepository<Salario, Long>, JpaSpecificationExecutor<Salario> {
}