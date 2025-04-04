/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Book.Controller;

import com.mycompany.cos2208project.BookDetail;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Book;
import pkg.Book.Repository.BookRepositoryImpl;
import pkg.Book.Repository.IBookRepository;
import pkg.Book.Service.BookService;
import pkg.Book.Service.IBookService;

/**
 *
 * @author black
 */
public class BookController {

    IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    public ArrayList<Book> getBooks() {
        return bookService.getAll();
    }

    public void addBook(String title, int qty, double price, double discount, int publisherId, int authorId) {
        if (bookService.addBook(title, qty, price, discount, publisherId, authorId)) {
            JOptionPane.showMessageDialog(null, "Add Book Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to Add Book!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addBooks(ArrayList<Book> books) {
        if (bookService.addBooks(books)) {
            JOptionPane.showMessageDialog(null, "Add Books Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to Add Books!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateBook(int id, String title, int qty, double price, double discount, int publisherId, int categoryId) {
        if (bookService.updateBook(id, title, qty, price, discount, publisherId, categoryId)) {
            JOptionPane.showMessageDialog(null, "Update Book " + id + " Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to Update Book " + id + "!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Book findById(int id) {
        return bookService.findById(id);
    }

    public ArrayList<Book> getByPulisher(int id) {
        return bookService.getByPublisher(id);
    }

    public ArrayList<Book> getByAuthor(int id) {
        return bookService.getByAuthor(id);
    }

    public ArrayList<Book> getByCategory(int id) {
        return bookService.getByCategory(id);
    }

    public static BookController getBookController(Connection db) {
        IBookRepository bookRepo = new BookRepositoryImpl(db);
        IBookService bookService = new BookService(bookRepo);

        return new BookController(bookService);
    }

}
