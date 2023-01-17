package com.carro.service.servicios;

import java.util.List;

import com.carro.service.entidades.Carro;
import com.carro.service.repositorio.CarroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepositorio;
	
	public List<Carro> getAll() {
		return carroRepositorio.findAll();
	}

	public Carro getCarroById(int id) {
		return carroRepositorio.findById(id).orElse(null);
	}

	public Carro save(Carro carro) {
		Carro nuevoCarro = carroRepositorio.save(carro);
		return nuevoCarro;
	}
	//Buscar todos los carros de un usuario
	public List<Carro> byUsuarioId(int usuarioId){
		return carroRepositorio.findByUsuarioId(usuarioId);
	}
}
