package com.b2w.startwars.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.b2w.startwars.entity.Planeta;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, Integer> {
	
	@Query("select p from Planeta p")
	public List<Planeta> listarPlanetas();

	@Query("select p from Planeta p where p.nome = ?1")
	public Optional<Planeta> buscarPlanetaPeloNome(String nomeDoPlaneta);

	@Query("select p from Planeta p where p.idPlaneta = ?1")
	public Optional<Planeta> buscarPlanetaPeloId(Integer idDoPlaneta);

}