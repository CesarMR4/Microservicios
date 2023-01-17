package com.moto.service.controladores;

import java.util.List;

import com.moto.service.entidades.Moto;
import com.moto.service.servicios.MotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moto")
public class MotoController {
	@Autowired
	private MotoService motoService;

	@GetMapping
	public ResponseEntity<List<Moto>> listarMotos() {
		List<Moto> motos = motoService.getAll();
		// Si cuando hacemos una peticion y esta vacio entonces
		if (motos.isEmpty()) {
			// Retornamos que no hay contenido
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id) {
		Moto carro = motoService.getMotoById(id);
		if (carro == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(carro);
	}

	@PostMapping
	public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto) {
		Moto nuevaMoto = motoService.save(moto);
		return ResponseEntity.ok(nuevaMoto);
	}

	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Moto>> listarMotoPorUsuarioId(@PathVariable("usuarioId") int id) {
		List<Moto> motos = motoService.byUsuarioId(id);
		if (motos.isEmpty()) {
			// Retornamos que no hay contenido
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motos);
	}
}
