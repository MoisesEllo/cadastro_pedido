package com.cadastropedido.banco;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Banco {
	
	protected EntityManagerFactory factory;
	
	public Banco() {
		factory = Persistence.createEntityManagerFactory("cadastropedido");
	}
	
}
