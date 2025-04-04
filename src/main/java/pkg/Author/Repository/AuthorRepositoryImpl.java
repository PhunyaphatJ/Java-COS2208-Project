/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Author.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Author;

/**
 *
 * @author black
 */
public class AuthorRepositoryImpl implements IAuthorRepository {

    Connection db;
    
    public AuthorRepositoryImpl(Connection db){
        this.db = db;
    }

    public ArrayList<Author> getAll() {
        ArrayList<Author> authors = new ArrayList<>();
        String sql = "SELECT * FROM authors";
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                authors.add(new Author(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    public Boolean addAuthor(Author author) {
        String sql = "INSERT INTO authors (name) VALUES(?)";
        try {
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, author.getName());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Author findById(int id) {
        String sql = "SELECT * FROM authors WHERE id = ? ";
           try (PreparedStatement stmt = db.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Author author = new Author(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                return author;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean updateAuthor(Author author) {
        String sql = "UPDATE authors SET name = ? WHERE id = ?";
        try{
            System.out.println(author.getName());
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, author.getName());
            stmt.setInt(2, author.getId());
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

}
