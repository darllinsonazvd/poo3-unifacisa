package br.com.unifacisa.biblioteca.dao;

import br.com.unifacisa.biblioteca.logs.Log;
import br.com.unifacisa.biblioteca.models.Book;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

public class BookDAO {
    private EntityManager em;

    Log log = new Log("biblioteca.txt");

    public BookDAO(EntityManager em) throws IOException {
        this.em = em;
    }

    /**
     * Salvar livro na base de dados
     *
     * @param book Livro para ser salvo
     * @author Darllinson Azevedo
     */
    public void save(Book book) {
        this.em.persist(book);
        System.out.println("O livro '" + book + "' foi criado com sucesso!");
        log.logger.info("O livro '" + book + "' foi criado na base de dados!");
    }

    /**
     * Atualizar livro na base de dados
     *
     * @param book Livro para ser atualizado
     * @author Darllinson Azevedo
     */
    public void update(Book book) {
        this.em.merge(book);
        System.out.println("O livro de id: " + book.getId() + " agora possui o título: " + book.getTitle());
        log.logger.info("O livro de id: " + book.getId() + " teve seu título atualizado para: " + book.getTitle());
    }

    /**
     * Excluir livro da base de dados
     *
     * @param book Livro para ser excluído
     * @author Darllinson Azevedo
     */
    public void delete(Book book) {
        book = this.em.merge(book);
        this.em.remove(book);
        System.out.println("O livro " + book + " foi removido com sucesso!");
        log.logger.info("O livro " + book + " foi removido na base de dados!");
    }

    /**
     * Buscar livro na base de dados pelo ID
     *
     * @param id Id do livro
     * @return Se encontrado, o livro com o id informado
     * @author Darllinson Azevedo
     */
    public Book findById(int id) {
        return this.em.find(Book.class, id);
    }

    /**
     * Buscar todos os livros e seus relacionamentos na base de dados
     *
     * @return Todos os livros da base de dados e seus relacionamentos
     * @author Darllinson Azevedo
     */
    public List<Book> findAll() {
        String jpql = "SELECT DISTINCT b FROM Book b JOIN FETCH b.authors";
        return this.em.createQuery(jpql, Book.class).getResultList();
    }
}
