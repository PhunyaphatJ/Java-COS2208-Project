/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pkg.Order.Service;

import java.util.ArrayList;
import models.Order;

/**
 *
 * @author black
 */
public interface IOrderService {
    ArrayList<Order> getAll();
    ArrayList<Order> getByMember(int id);
    boolean makeOrder(Order order);
    Order findById(int id);
}
