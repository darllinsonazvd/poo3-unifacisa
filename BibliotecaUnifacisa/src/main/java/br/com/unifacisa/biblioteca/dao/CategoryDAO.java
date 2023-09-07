package br.com.unifacisa.biblioteca.dao;

import br.com.unifacisa.biblioteca.logs.Log;
import br.com.unifacisa.biblioteca.models.Category;

import javax.persistence.EntityManager;
import java.io.IOException;

public class CategoryDAO {
    private EntityManager em;

    Log log = new Log("biblioteca.txt");

    public CategoryDAO(EntityManager em) throws IOException {
        this.em = em;
    }

    /**
     * Salvar categoria na base de dados
     *
     * @param category Categoria para ser salva
     * @author Darllinson Azevedo
     */
    public void save(Category category) {
        this.em.persist(category);
        System.out.println("A categoria '" + category.getName() + "' foi criada com sucesso!");
        log.logger.info("A categoria '" + category.getName() + "' foi criada na base de dados!");
    }
}
