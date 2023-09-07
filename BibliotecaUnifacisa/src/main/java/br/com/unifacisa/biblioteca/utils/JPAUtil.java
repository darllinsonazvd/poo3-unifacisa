package br.com.unifacisa.biblioteca.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("BibliotecaUnifacisa");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
