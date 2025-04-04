package models;

public class Book {

    int id;
    String title;
    int qty;
    double price;
    double discount;
    int publisherId;
    int authorId;
    int categoryId;

    public Book() {
    }

    public Book(String title, int qty, double price, double discount) {
        this.title = title;
        this.qty = qty;
        this.price = price;
        this.discount = discount;
    }

    public Book(String title, int qty, double price, double discount, int publisherId, int authorId) {
        this.title = title;
        this.qty = qty;
        this.price = price;
        this.discount = discount;
        this.publisherId = publisherId;
        this.authorId = authorId;
    }

    public Book(int id, String title, int qty, double price, double discount) {
        this.id = id;
        this.title = title;
        this.qty = qty;
        this.price = price;
        this.discount = discount;
    }

    public Book(int id, String title, int qty, double price, double discount, int publisherId) {
        this.id = id;
        this.title = title;
        this.qty = qty;
        this.price = price;
        this.discount = discount;
        this.publisherId = publisherId;
    }

    public Book(int id, String title, int qty, double price, double discount, int publisherId, int authorId) {
        this.id = id;
        this.title = title;
        this.qty = qty;
        this.price = price;
        this.discount = discount;
        this.publisherId = publisherId;
        this.authorId = authorId;
    }

    public Book(int id, String title, int qty, double price, double discount, int publisherId, int authorId, int categoryId) {
        this.id = id;
        this.title = title;
        this.qty = qty;
        this.price = price;
        this.discount = discount;
        this.publisherId = publisherId;
        this.authorId = authorId;
        this.categoryId = categoryId;
    }

    public Book(String title, int qty, double price, double discount, int publisherId, int authorId, int categoryId) {
        this.title = title;
        this.qty = qty;
        this.price = price;
        this.discount = discount;
        this.publisherId = publisherId;
        this.authorId = authorId;
        this.categoryId = categoryId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setPublisherId(int id) {
        this.publisherId = id;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    
}
