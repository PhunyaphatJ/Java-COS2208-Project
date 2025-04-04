/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author black
 */
public class Order_Detail {
    int id;
    int orderId;
    int bookId;
    int qty;
    double price;

    public Order_Detail(int id, int orderId, int bookId, int qty, double price) {
        this.id = id;
        this.orderId = orderId;
        this.bookId = bookId;
        this.qty = qty;
        this.price = price;
    }

    public Order_Detail(int orderId, int bookId, int qty, double price) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.qty = qty;
        this.price = price;
    }
    
    public Order_Detail(int bookId,int qty,double price){
        this.bookId = bookId;
        this.qty = qty;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
