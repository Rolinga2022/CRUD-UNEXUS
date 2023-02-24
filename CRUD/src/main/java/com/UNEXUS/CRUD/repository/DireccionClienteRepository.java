package com.UNEXUS.CRUD.repository;

import com.UNEXUS.CRUD.entity.DireccionCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionClienteRepository extends JpaRepository<DireccionCliente, Long>{
    
}
