/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pkg.department.departmentRepository;

import entities.Department;
import java.util.ArrayList;
import pkg.Custom.Request;

/**
 *
 * @author black
 */
public interface IDepartmentRepository {
    ArrayList<Department> get();
    Department find(Request req);
    String  delete(Request req);
    String update(Request req);
}
