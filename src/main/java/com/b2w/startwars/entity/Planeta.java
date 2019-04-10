package com.b2w.startwars.entity;

import org.springframework.data.annotation.Id;

public class Planeta {
	
	@Id
	private Integer idPlaneta;
	
	private String nome;
	
	private String clima;
	
	private String terreno;
	
	private Integer aparicoesEmFilmes;
}
