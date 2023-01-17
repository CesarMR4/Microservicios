package com.moto.service.repositorio;


import java.util.List;
import com.moto.service.entidades.Moto;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto,Integer> {

	List<Moto> findByUsuarioId(int usuarioId);         
}
