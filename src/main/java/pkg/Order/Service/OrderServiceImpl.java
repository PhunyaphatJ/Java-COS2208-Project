/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Order.Service;

import java.util.ArrayList;
import models.Order;
import pkg.Order.Repository.IOrderRepository;

/**
 *
 * @author black
 */
public class OrderServiceImpl implements IOrderService{

    IOrderRepository orderRepo;

    public OrderServiceImpl(IOrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }
    
    
    @Override
    public ArrayList<Order> getAll() {
        return orderRepo.getAll();
    }

    @Override
    public boolean makeOrder(Order order) {
        return orderRepo.makeOrder(order);
    }

    @Override
    public Order findById(int id) {
        return orderRepo.findById(id);
    }

    @Override
    public ArrayList<Order> getByMember(int id) {
        return orderRepo.getByMember(id);
    }
    
}
