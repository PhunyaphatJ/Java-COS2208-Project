CREATE TABLE order_details (
    id SERIAL PRIMARY KEY,
    order_id INT REFERENCES orders(id) ON DELETE CASCADE,
    book_id INT REFERENCES books(id) ON DELETE CASCADE,
    qty INT NOT NULL CHECK (qty > 0),
    price DECIMAL(10,2) NOT NULL
);
