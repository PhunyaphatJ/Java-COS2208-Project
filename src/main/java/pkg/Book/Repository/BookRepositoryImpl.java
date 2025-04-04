/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg.Book.Repository;

import models.Book;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author black
 */
public class BookRepositoryImpl implements IBookRepository {

    Connection db;

    public BookRepositoryImpl(Connection db) {
        this.db = db;
    }

    public ArrayList<Book> getAll() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT b.id,b.title,b.qty,b.price,b.discount,b.publisher_id,bc.category_id ,ba.author_id FROM books as b "
                + "JOIN book_category as bc ON b.id = bc.book_id "
                + "JOIN book_author as ba ON b.id = ba.book_id ORDER BY b.id";
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("qty"),
                        rs.getDouble("price"),
                        rs.getDouble("discount"),
                        rs.getInt("publisher_id"),
                        rs.getInt("author_id"),
                        rs.getInt("category_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public Boolean addBook(Book book) {
        String sql1 = "INSERT INTO books (title,qty,price,discount,publisher_id) VALUES(?,?,?,?,?)";
        String sql2 = "INSERT INTO book_author (book_id,author_id) VALUES (?,?)";
        try {
            db.setAutoCommit(false);
            PreparedStatement stmt = db.prepareStatement(sql1);
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, book.getQty());
            stmt.setDouble(3, book.getPrice());
            stmt.setDouble(4, book.getDiscount());
            stmt.setInt(5, book.getPublisherId());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    stmt = db.prepareStatement(sql2);
                    stmt.setInt(1, generatedKeys.getInt(1));
                    stmt.setInt(2, book.getAuthorId());
                    stmt.executeUpdate();
                }
            }
            db.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                db.rollback();
            } catch (SQLException rollback) {
                rollback.printStackTrace();
            }
            return false;
        }
    }

    public Boolean addBooks(ArrayList<Book> books) {
        try {
            db.setAutoCommit(false);
            String sql1 = "INSERT INTO books (title, qty, price, discount, publisher_id) VALUES (?,?,?,?,?)";
            String sql2 = "INSERT INTO book_author (book_id, author_id) VALUES (?,?)";
            String sql3 = "INSERT INTO book_category (book_id, category_id) VALUES (?,?)";

            for (Book book : books) {
                PreparedStatement stmt = db.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, book.getTitle());
                stmt.setInt(2, book.getQty());
                stmt.setDouble(3, book.getPrice());
                stmt.setDouble(4, book.getDiscount());
                stmt.setInt(5, book.getPublisherId());

                int affectedRows = stmt.executeUpdate();
                if (affectedRows > 0) {
                    ResultSet generatedKeys = stmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int bookId = generatedKeys.getInt(1);

                        stmt = db.prepareStatement(sql2);
                        stmt.setInt(1, bookId);
                        stmt.setInt(2, book.getAuthorId());
                        stmt.executeUpdate();

                        stmt = db.prepareStatement(sql3);
                        stmt.setInt(1, bookId);
                        stmt.setInt(2, book.getCategoryId());
                        stmt.executeUpdate();
                    }
                }
            }
            db.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                db.rollback();
            } catch (SQLException rollback) {
                rollback.printStackTrace();
            }
            return false;
        }
    }

    public Book findById(int id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        try (PreparedStatement stmt = db.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("qty"),
                        rs.getDouble("price"),
                        rs.getDouble("discount"),
                        rs.getInt("publisher_id")
                );
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book findByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Boolean updateBook(Book book) {
        System.out.println(book.getId());
        System.out.println(book.getCategoryId());
        String sql1 = "UPDATE books SET title = ?, qty = ?, price = ?, discount = ?,publisher_id = ? WHERE id = ?";
        String sql2 = "UPDATE book_category SET category_id = ? WHERE book_id = ?";
        try {
            db.setAutoCommit(false);
            PreparedStatement stmt = db.prepareStatement(sql1);
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, book.getQty());
            stmt.setDouble(3, book.getPrice());
            stmt.setDouble(4, book.getDiscount());
            stmt.setInt(5, book.getPublisherId());
            stmt.setInt(6, book.getId());
            stmt.executeUpdate();

            stmt = db.prepareStatement(sql2);
            stmt.setInt(1, book.getCategoryId());
            stmt.setInt(2, book.getId());
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
            return false;
        }
    }

    @Override
    public ArrayList<Book> getByPublisher(int id) {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE publisher_id = ? ORDER BY id";
        try {
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("qty"),
                        rs.getDouble("price"),
                        rs.getDouble("discount")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public ArrayList<Book> getByAuthor(int id) {
        System.out.println(id);
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT b.id, b.title, b.qty, b.price, b.discount, b.publisher_id "
                + "FROM book_author "
                + "JOIN books AS b ON book_author.book_id = b.id "
                + "WHERE book_author.author_id = ? "
                + "ORDER BY b.id";

        try {
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("qty"),
                        rs.getDouble("price"),
                        rs.getDouble("discount"),
                        rs.getInt("publisher_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public ArrayList<Book> getByCategory(int id) {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books as b JOIN book_category AS bc "
                + "ON b.id = bc.book_id WHERE bc.category_id = ? ORDER BY id";
        try {
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("qty"),
                        rs.getDouble("price"),
                        rs.getDouble("discount"),
                        rs.getInt("Publisher_ID")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

}
