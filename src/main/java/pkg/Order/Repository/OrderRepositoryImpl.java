/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Order.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import models.Order;
import models.Order_Detail;

/**
 *
 * @author black
 */
public class OrderRepositoryImpl implements IOrderRepository {

    Connection db;

    public OrderRepositoryImpl(Connection db) {
        this.db = db;
    }

    @Override
    public ArrayList<Order> getAll() {
        String sql = "SELECT o.id as order_id , o.member_id, o.order_date, od.id as detail_id,od.order_id, od.book_id, od.qty, od.price "
                + "FROM orders AS o "
                + "JOIN order_details AS od ON o.id = od.order_id "
                + "ORDER BY o.id";

        ArrayList<Order> orders = new ArrayList<>();
        try (
                PreparedStatement stmt = db.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            Map<Integer, Order> orderMap = new HashMap<>();

            while (rs.next()) {
                int orderId = rs.getInt("order_id");

                Order order = orderMap.get(orderId);
                if (order == null) {
                    order = new Order();
                    order.setId(orderId);
                    order.setMemberId(rs.getInt("member_id"));
                    order.setOrderDate(rs.getDate("order_date").toLocalDate());
                    order.setOrderDetails(new ArrayList<>());

                    orderMap.put(orderId, order);
                    orders.add(order);
                }

                Order_Detail orderDetail = new Order_Detail(
                        rs.getInt("detail_id"),
                        rs.getInt("order_id"),
                        rs.getInt("book_id"),
                        rs.getInt("qty"),
                        rs.getDouble("price")
                );

                order.getOrderDetails().add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Boolean makeOrder(Order order) {
        String sql1 = "INSERT INTO orders (member_id, order_date) VALUES (?, ?)";
        String sql2 = "INSERT INTO order_details (order_id, book_id, qty, price) VALUES (?, ?, ?, ?)";

        try {
            db.setAutoCommit(false);

            PreparedStatement stmt = db.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            if (order.getMemberId() != 0) {
                stmt.setInt(1, order.getMemberId());
            } else {
                stmt.setNull(1, java.sql.Types.INTEGER);
            }
            stmt.setDate(2, Date.valueOf(order.getOrderDate()));

            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            int orderId;
            if (generatedKeys.next()) {
                orderId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Creating order failed, no ID. no ID ");
            }

            stmt = db.prepareStatement(sql2);
            for (Order_Detail detail : order.getOrderDetails()) {
                stmt.setInt(1, orderId);
                stmt.setInt(2, detail.getBookId());
                stmt.setInt(3, detail.getQty());
                stmt.setDouble(4, detail.getPrice());
            }

            stmt.executeUpdate();
            db.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                db.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
        return false;
    }

    public Order findById(int id) {
        String sql = "Select o.id as order_id,o.member_id,o.order_date,od.id as order_detail_id,od.book_id,od.qty,od.price From orders as o "
                + "JOIN order_details as od ON o.id = od.order_id WHERE o.id = ?";

        ArrayList<Order_Detail> order_details = new ArrayList<>();
        Order order = null;
        try {
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (order == null) {
                    order = new Order();
                    order.setId(rs.getInt("order_id"));
                    order.setMemberId(rs.getInt("member_id"));
                    order.setOrderDate(rs.getDate("order_date").toLocalDate());
                }
                order_details.add(new Order_Detail(
                        rs.getInt("order_detail_id"),
                        rs.getInt("order_id"),
                        rs.getInt("book_id"),
                        rs.getInt("qty"),
                        rs.getDouble("price")
                ));
            }
            order.setOrderDetails(order_details);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public ArrayList<Order> getByMember(int id) {
        String sql = "SELECT o.id as order_id , o.member_id, o.order_date, od.id as detail_id,od.order_id, od.book_id, od.qty, od.price "
                + "FROM orders AS o "
                + "JOIN order_details AS od ON o.id = od.order_id "
                + "WHERE o.member_id = ? ORDER BY o.id";

        ArrayList<Order> orders = new ArrayList<>();
        try {
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Map<Integer, Order> orderMap = new HashMap<>();

            while (rs.next()) {
                int orderId = rs.getInt("order_id");

                Order order = orderMap.get(orderId);
                if (order == null) {
                    order = new Order();
                    order.setId(orderId);
                    order.setMemberId(rs.getInt("member_id"));
                    order.setOrderDate(rs.getDate("order_date").toLocalDate());
                    order.setOrderDetails(new ArrayList<>());

                    orderMap.put(orderId, order);
                    orders.add(order);
                }

                Order_Detail orderDetail = new Order_Detail(
                        rs.getInt("detail_id"),
                        rs.getInt("order_id"),
                        rs.getInt("book_id"),
                        rs.getInt("qty"),
                        rs.getDouble("price")
                );

                order.getOrderDetails().add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
