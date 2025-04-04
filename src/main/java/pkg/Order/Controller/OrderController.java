/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Order.Controller;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Order;
import pkg.Order.Repository.IOrderRepository;
import pkg.Order.Repository.OrderRepositoryImpl;
import pkg.Order.Service.IOrderService;
import pkg.Order.Service.OrderServiceImpl;

/**
 *
 * @author black
 */
public class OrderController {
    IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }
    
    public ArrayList<Order> getAll(){
        return orderService.getAll();
    }
    
    public void makeOrder(Order order){
        if(orderService.makeOrder(order)){
            JOptionPane.showMessageDialog(null, "Add Order Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Failed to Add Order!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Order findById(int id){
        return orderService.findById(id);
    }
    
    public ArrayList<Order> getByMember(int id){
        return orderService.getByMember(id);
    }
    
    public static OrderController getOrderController(Connection db){
        IOrderRepository orderRepo = new OrderRepositoryImpl(db);
        IOrderService orderService = new OrderServiceImpl(orderRepo);
        return new OrderController(orderService);
    }
}
