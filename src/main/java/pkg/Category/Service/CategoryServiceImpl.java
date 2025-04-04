/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Category.Service;

import java.util.ArrayList;
import models.Category;
import pkg.Category.Repository.ICategoryRepository;

/**
 *
 * @author black
 */
public class CategoryServiceImpl implements ICategoryService {
    ICategoryRepository categoryRepo;
    
    public CategoryServiceImpl(ICategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }    
    
    @Override
    public ArrayList<Category> getAll() {
        return categoryRepo.getAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepo.findById(id);
    }

    @Override
    public Boolean addCategory(String name) {
        Category category = new Category(name);
        return categoryRepo.addCategory(category);
    }

    @Override
    public Boolean updateCategory(int id, String name) {
        Category category = new Category(id,name);
        return categoryRepo.updateCategory(category);
    }
    
}
