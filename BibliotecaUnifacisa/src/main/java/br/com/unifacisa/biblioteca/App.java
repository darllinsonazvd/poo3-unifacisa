package br.com.unifacisa.biblioteca;

import br.com.unifacisa.biblioteca.dao.AuthorDAO;
import br.com.unifacisa.biblioteca.dao.BookDAO;
import br.com.unifacisa.biblioteca.dao.CategoryDAO;
import br.com.unifacisa.biblioteca.dao.PublisherDAO;
import br.com.unifacisa.biblioteca.models.Author;
import br.com.unifacisa.biblioteca.models.Book;
import br.com.unifacisa.biblioteca.models.Category;
import br.com.unifacisa.biblioteca.models.Publisher;
import br.com.unifacisa.biblioteca.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        EntityManager em = JPAUtil.getEntityManager();

        // Criando clases DAO
        BookDAO bookDAO = new BookDAO(em);
        PublisherDAO publisherDAO = new PublisherDAO(em);
        CategoryDAO categoryDAO = new CategoryDAO(em);
        AuthorDAO authorDAO = new AuthorDAO(em);

        // Criando categorias
        Category c1 = new Category("Ação");
        Category c2 = new Category("Comédia");

        // Criando editorias
        Publisher p1 = new Publisher("Aleph");
        Publisher p2 = new Publisher("Rocco");

        // Criando autores
        Author a1 = new Author("Lucas Lschlestein");
        Author a2 = new Author("André Santos");

        // Criando uma lista de autores
        List<Author> authors = new ArrayList<>();
        authors.add(a1);
        authors.add(a2);

        // Criando os livros
        Book harryPotter = new Book("HarryPotter", 1999, 123456789, c1, p1, authors);
        Book piorQueTaNaoFica = new Book("Pior que tá não fica", 2015, 15198487, c2, p2, authors);
        Book oEspadachimDeCarvao = new Book("O Espadachim de Carvão", 2010, 15171378, c1, p2, authors);

        // Fazendo a transação com o banco de dados
        em.getTransaction().begin();

        // Persistindo as categorias
//        categoryDAO.save(c1);
//        categoryDAO.save(c2);
//
//        // Persistindo as editoras
//        publisherDAO.save(p1);
//        publisherDAO.save(p2);
//
//        // Persistindo os autores
//        authorDAO.save(a1);
//        authorDAO.save(a2);
//
//        // Persistindo os livros
//        bookDAO.save(harryPotter);
//        bookDAO.save(piorQueTaNaoFica);
//        bookDAO.save(oEspadachimDeCarvao);

        // Buscando os livros cadastrados
        List<Book> allBooks = bookDAO.findAll();
        allBooks.forEach(book -> {
            System.out.println("\nID do livro: " + book.getId());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Título: " + book.getTitle());
            System.out.println("Ano de lançamento: " + book.getYear());
            System.out.println("Categoria: " + book.getCategory().getName());
            System.out.println("Editora: " + book.getPublisher().getName());
            System.out.println("Autores: " + book.getAuthors());
        });

        // Atualizando um livro
        Book updateBook = em.find(Book.class, 25);
        System.out.println("Livro: " + updateBook);
        updateBook.setTitle("Senhor dos anéis");
        bookDAO.update(updateBook);

        // Buscando um livro por ID
        Book book = bookDAO.findById(25);
        System.out.println("\n" + book.getId());
        System.out.println(book.getISBN());
        System.out.println(book.getTitle());
        System.out.println(book.getYear());
        System.out.println(book.getCategory().getName());
        System.out.println(book.getPublisher().getName());
        System.out.println(book.getAuthors());

        // Excluindo um livro
        bookDAO.delete(book);

        em.getTransaction().commit();
        em.close();
    }
}
