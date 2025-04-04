/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pkg.Author.Service;

import java.util.ArrayList;
import models.Author;

/**
 *
 * @author black
 */
public interface IAuthorService {
    ArrayList<Author> getAll();
    Boolean addAuthor(String name);
    Author findById(int id);
    Boolean updateAuthor(int id,String name);
}
