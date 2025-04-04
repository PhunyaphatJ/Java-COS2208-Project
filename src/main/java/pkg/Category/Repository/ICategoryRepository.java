/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pkg.Category.Repository;

import java.util.ArrayList;
import models.Category;

/**
 *
 * @author black
 */
public interface ICategoryRepository {
    ArrayList<Category> getAll();
    Category findById(int id);
    Boolean addCategory(Category category);
    Boolean updateCategory(Category category);
}
