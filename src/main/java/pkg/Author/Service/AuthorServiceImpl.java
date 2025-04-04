/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Author.Service;

import java.util.ArrayList;
import models.Author;
import pkg.Author.Repository.IAuthorRepository;

/**
 *
 * @author black
 */
public class AuthorServiceImpl implements IAuthorService{
    IAuthorRepository authorRepo;
    
    public AuthorServiceImpl(IAuthorRepository authorRepo){
        this.authorRepo = authorRepo;
    }
    
    
    public ArrayList<Author> getAll() {
        return authorRepo.getAll();
    }

    @Override
    public Boolean addAuthor(String name) {
        if(name.isEmpty()){
            return false;
        }
        Author author = new Author(name);
        
        return authorRepo.addAuthor(author);
    }

    @Override
    public Author findById(int id) {
        return authorRepo.findById(id);
    }

    @Override
    public Boolean updateAuthor(int id,String name) {
        Author author = new Author(id,name);
        return authorRepo.updateAuthor(author);
    }
    
}
