/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Publisher.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Publisher;

/**
 *
 * @author black
 */
public class PublisherRepositoryImpl implements IPublisherRepository {

    Connection db;

    public PublisherRepositoryImpl(Connection db) {
        this.db = db;
    }

    public ArrayList<Publisher> getAll() {
        ArrayList<Publisher> publishers = new ArrayList<>();
        String sql = "SELECT * FROM publishers";
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                publishers.add(new Publisher(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publishers;
    }

    public Publisher findById(int id) {
        String sql = "SELECT * FROM publishers WHERE id = ?";
        try (PreparedStatement stmt = db.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Publisher publisher = new Publisher(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                return publisher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 

    }

    public Boolean addPublisher(Publisher publisher) {
        String sql = "INSERT INTO publishers (name) VALUES(?) ";
        try{
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, publisher.getName());
            stmt.execute();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean updatePublisher(Publisher publisher) {
        String sql = "UPDATE publishers SET name = ? WHERE id = ?";
        try{
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, publisher.getName());
            stmt.setInt(2, publisher.getId());
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
