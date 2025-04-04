/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pkg.Book.Repository;

import java.util.ArrayList;
import models.Book;

/**
 *
 * @author black
 */
public interface IBookRepository {
    ArrayList<Book> getAll();
    Boolean addBook(Book book);
    Book findById(int id);
    Book findByTitle(String title);
    Boolean updateBook(Book book);
    ArrayList<Book> getByPublisher(int id);
    ArrayList<Book> getByAuthor(int id);
    ArrayList<Book> getByCategory(int id);
    Boolean addBooks(ArrayList<Book> books);
}
