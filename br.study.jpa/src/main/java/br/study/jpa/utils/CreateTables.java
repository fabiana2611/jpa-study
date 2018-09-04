package br.study.jpa.utils;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateTables {

	public static void main(String[] args) { 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyDomainPU");
		
//		EntityManager entityManager = factory.createEntityManager();


	}
}
