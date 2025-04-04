/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author black
 */
public class Order {
    int id;
    int memberId;
    LocalDate orderDate;
    ArrayList<Order_Detail> orderDetails;

    public Order() {
    }

    
    
    public Order(int memberId ,LocalDate orderDate,ArrayList<Order_Detail> orderDetails){
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
    }
    
      public Order(LocalDate orderDate,ArrayList<Order_Detail> orderDetails){
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
    }
    
    public Order(int id, int memberId, LocalDate orderDeate) {
        this.id = id;
        this.memberId = memberId;
        this.orderDate = orderDeate;
    }

    public int getId() {
        return id;
    }

    public int getMemberId() {
        return memberId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public ArrayList<Order_Detail> getOrderDetails() {
        return orderDetails;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderDetails(ArrayList<Order_Detail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    
    public double getTotal(){
        double total = 0;
        for(Order_Detail order_detail : orderDetails){
            total += order_detail.getPrice();
        }
        return total;
    }
}
