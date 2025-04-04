/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Category.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Category;

/**
 *
 * @author black
 */
public class CategoryRepositoryImpl implements ICategoryRepository {

    Connection db;

    public CategoryRepositoryImpl(Connection db) {
        this.db = db;
    }

    @Override
    public ArrayList<Category> getAll() {
        ArrayList<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories ORDER BY id";
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                categories.add(new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public Category findById(int id) {
        String sql = "SELECT * FROM categories WHERE id = ?";
        try (
                PreparedStatement stmt = db.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean addCategory(Category category) {
        String sql = "INSERT INTO categories (name) VALUES(?)";
        try {
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updateCategory(Category category) {
        String sql = "UPDATE categories SET name = ? WHERE id = ?";
        try{
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setInt(2, category.getId());
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

}
