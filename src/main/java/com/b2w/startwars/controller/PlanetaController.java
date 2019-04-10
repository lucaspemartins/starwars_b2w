package com.b2w.startwars.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.startwars.entity.Planeta;
import com.b2w.startwars.service.PlanetaService;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {
	
	@Autowired
	PlanetaService planetaService;
	
    public ResponseEntity<List<Planeta>> planetas() throws SQLException {
		List<Planeta> planetas = planetaService.listarPlanetas();

		if (planetas.isEmpty()) {
			return new ResponseEntity<List<Planeta>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Planeta>>(planetas, HttpStatus.OK);
    }
    
    @RequestMapping("/nomeDoPlaneta")
    public ResponseEntity<Optional<Planeta>> nomeDoPlaneta(@RequestParam(value="name") String nomeDoPlaneta) throws SQLException {
    	Optional<Planeta> planeta = planetaService.buscarPlanetaPeloNome(nomeDoPlaneta);
		if (planeta.isPresent()) {
			return new ResponseEntity<Optional<Planeta>>(planeta, HttpStatus.OK);
		}
		return new ResponseEntity<Optional<Planeta>>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping("/idDoPlaneta")
    public ResponseEntity<Optional<Planeta>> idDoPlaneta(@RequestParam(value="id") Integer idDoPlaneta) throws SQLException {
		Optional<Planeta> planeta = planetaService.buscarPlanetaPeloId(idDoPlaneta);

		if (planeta.isPresent()) {
			return new ResponseEntity<Optional<Planeta>>(planeta, HttpStatus.OK);
		}
		return new ResponseEntity<Optional<Planeta>>(HttpStatus.NOT_FOUND);
    }
	
	@DeleteMapping("/idDoPlaneta/{id}")
	public ResponseEntity<Optional<Planeta>> removePlaneta(@PathVariable Integer id) {
		planetaService.removePeloId(id);
		Optional<Planeta> planeta = planetaService.buscarPlanetaPeloId(id);
		
		if (planeta.isPresent()) {
			return new ResponseEntity<Optional<Planeta>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Optional<Planeta>>(HttpStatus.OK);
	}
}
