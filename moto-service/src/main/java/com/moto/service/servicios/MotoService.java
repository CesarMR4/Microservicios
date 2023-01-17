package com.moto.service.servicios;

import java.util.List;

import com.moto.service.entidades.Moto;
import com.moto.service.repositorio.MotoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoService {

	@Autowired
	private MotoRepository motoRepositorio;

	public List<Moto> getAll() {
		return motoRepositorio.findAll();
	}

	public Moto getMotoById(int id) {
		return motoRepositorio.findById(id).orElse(null);
	}

	public Moto save(Moto moto) {
		Moto nuevaMoto = motoRepositorio.save(moto);
		return nuevaMoto;
	}

	// Buscar todos los carros de un usuario
	public List<Moto> byUsuarioId(int usuarioId) {
		return motoRepositorio.findByUsuarioId(usuarioId);
	}
}
