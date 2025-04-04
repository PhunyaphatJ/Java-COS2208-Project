/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Category.Controller;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Category;
import pkg.Category.Repository.CategoryRepositoryImpl;
import pkg.Category.Repository.ICategoryRepository;
import pkg.Category.Service.CategoryServiceImpl;
import pkg.Category.Service.ICategoryService;

/**
 *
 * @author black
 */

public class CategoryController {
    ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    public ArrayList<Category> getAll(){
        return categoryService.getAll();
    }
    
    public Category findById(int id){
        return categoryService.findById(id);
    }
    
    public void addCategory(String name){
        if(categoryService.addCategory(name)){
                JOptionPane.showMessageDialog(null, "Add Category Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to Add Category!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
       public void updateCategory(int id,String name){
        if(categoryService.updateCategory(id, name)){
                JOptionPane.showMessageDialog(null, "Update Category Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to Update Category!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static CategoryController getCategoryController(Connection db){
        ICategoryRepository categoryRepo = new CategoryRepositoryImpl(db);
        ICategoryService categoryService = new CategoryServiceImpl(categoryRepo);
        return new CategoryController(categoryService);
    }
    
}
