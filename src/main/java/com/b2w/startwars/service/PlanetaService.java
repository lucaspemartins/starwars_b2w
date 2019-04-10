package com.b2w.startwars.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2w.startwars.entity.Planeta;
import com.b2w.startwars.repository.PlanetaRepository;

@Service("PlanetaRepository")
public class PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;
	
	public List<Planeta> listarPlanetas() throws SQLException {
		return planetaRepository.listarPlanetas();
	}

	public Optional<Planeta> buscarPlanetaPeloNome(String nomeDoPlaneta) {
		return planetaRepository.buscarPlanetaPeloNome(nomeDoPlaneta);
	}

	public Optional<Planeta> buscarPlanetaPeloId(Integer idDoPlaneta) {
		return planetaRepository.buscarPlanetaPeloId(idDoPlaneta);
	}

	public void removePeloId(Integer id) {
		planetaRepository.deleteById(id);
	}	
}
