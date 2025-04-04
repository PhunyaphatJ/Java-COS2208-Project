package pkg.Book.Service;

import pkg.Book.Repository.IBookRepository;

import java.util.ArrayList;
import models.Book;

public class BookService implements IBookService{
    IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public ArrayList<Book> getAll(){
        return bookRepository.getAll();
    }

    public Boolean addBook(String title, int qty, double price, double discount,int publisherId,int authorId) {
        if(title.isEmpty()||qty < 0 || price <0 || discount < 0){
            return false;
        }
        Book book = new Book(title,qty,price,discount,publisherId,authorId);
        return bookRepository.addBook(book);
    }
    
    public Boolean addBooks(ArrayList<Book> books){
        return bookRepository.addBooks(books);
    }
    
    public Boolean updateBook(int id,String title,int qty,double price,double discount,int publisherId,int categoryId){
        Book book = new Book(id,title,qty,price,discount,publisherId);
        book.setCategoryId(categoryId);
        return bookRepository.updateBook(book);
    }

    public Book findById(int id) {
        return bookRepository.findById(id);
    }
    
    public ArrayList<Book> getByPublisher(int id){
        return bookRepository.getByPublisher(id);
    }

    @Override
    public ArrayList<Book> getByAuthor(int id) {
        return bookRepository.getByAuthor(id);
    }

    @Override
    public ArrayList<Book> getByCategory(int id) {
        return bookRepository.getByCategory(id);
    }

}
