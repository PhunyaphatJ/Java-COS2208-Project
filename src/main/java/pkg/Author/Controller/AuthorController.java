/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Author.Controller;

import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Author;
import pkg.Author.Repository.AuthorRepositoryImpl;
import pkg.Author.Repository.IAuthorRepository;
import pkg.Author.Service.AuthorServiceImpl;
import pkg.Author.Service.IAuthorService;

/**
 *
 * @author black
 */
public class AuthorController {

    IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    public ArrayList<Author> getAll() {
        return authorService.getAll();
    }

    public void addAuthor(String name) {
        if (authorService.addAuthor(name)) {
            JOptionPane.showMessageDialog(null, "Add Author Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to Add Author!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Author findById(int id) {
        return authorService.findById(id);
    }

    public void updateAuthor(int id, String name) {
        if (authorService.updateAuthor(id, name)) {
            JOptionPane.showMessageDialog(null, "Update Author Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Update to Add Author!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static AuthorController getAuthorController(Connection db) {
        IAuthorRepository authorRepo = new AuthorRepositoryImpl(db);
        IAuthorService authorService = new AuthorServiceImpl(authorRepo);

        return new AuthorController(authorService);
    }
}
