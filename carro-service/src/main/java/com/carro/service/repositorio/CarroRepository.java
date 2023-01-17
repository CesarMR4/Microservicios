package com.carro.service.repositorio;

import java.util.List;

import com.carro.service.entidades.Carro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro,Integer>{
	
	List<Carro> findByUsuarioId(int usuarioId);
}
