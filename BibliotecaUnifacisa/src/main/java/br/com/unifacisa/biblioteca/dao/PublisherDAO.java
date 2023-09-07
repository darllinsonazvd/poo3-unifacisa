package br.com.unifacisa.biblioteca.dao;

import br.com.unifacisa.biblioteca.logs.Log;
import br.com.unifacisa.biblioteca.models.Publisher;

import javax.persistence.EntityManager;
import java.io.IOException;

public class PublisherDAO {
    private EntityManager em;

    Log log = new Log("biblioteca.txt");

    public PublisherDAO(EntityManager em) throws IOException {
        this.em = em;
    }

    /**
     * Salvar editora na base de dados
     *
     * @param publisher Editora para ser salva
     * @author Darllinson Azevedo
     */
    public void save(Publisher publisher) {
        this.em.persist(publisher);
        System.out.println("A editora '" + publisher.getName() + "' foi criada com sucesso!");
        log.logger.info("A editora '" + publisher.getName() + "' foi criada na base de dados!");
    }
}
