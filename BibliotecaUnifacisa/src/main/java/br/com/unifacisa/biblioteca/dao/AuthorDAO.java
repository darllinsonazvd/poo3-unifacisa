package br.com.unifacisa.biblioteca.dao;

import br.com.unifacisa.biblioteca.logs.Log;
import br.com.unifacisa.biblioteca.models.Author;
import br.com.unifacisa.biblioteca.models.Book;

import javax.persistence.EntityManager;
import java.io.IOException;

public class AuthorDAO {
    private EntityManager em;

    Log log = new Log("biblioteca.txt");

    public AuthorDAO(EntityManager em) throws IOException {
        this.em = em;
    }

    /**
     * Salvar autor na base de dados
     *
     * @param author Autor para ser salvo
     * @author Darllinson Azevedo
     */
    public void save(Author author) {
        this.em.persist(author);
        System.out.println("O autor '" + author.getName() + "' foi criado com sucesso!");
        log.logger.info("O autor '" + author.getName() + "' foi criado na base de dados!");
    }
}
