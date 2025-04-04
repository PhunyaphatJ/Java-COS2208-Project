/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pkg.Category.Service;

import java.util.ArrayList;
import models.Category;

/**
 *
 * @author black
 */
public interface ICategoryService {
    ArrayList<Category> getAll();
    Category findById(int id);
    Boolean addCategory(String name);
    Boolean updateCategory(int id,String name);
}
