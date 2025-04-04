package pkg.Book.Service;

import models.Book;

import java.util.ArrayList;

public interface IBookService {
    ArrayList<Book> getAll();
    Boolean addBook(String title,int qty,double price,double discount,int publisherId,int authorId);
    Boolean updateBook(int id,String title,int qty,double price,double discount,int publisherId,int categoryId);
    Book findById(int id);
    ArrayList<Book> getByPublisher(int id);
    ArrayList<Book> getByAuthor(int id);
    ArrayList<Book> getByCategory(int id);
    Boolean addBooks(ArrayList<Book> boos);
}
