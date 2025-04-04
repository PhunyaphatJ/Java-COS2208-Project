CREATE TABLE members (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    member_start DATE NOT NULL,
    member_end DATE NOT NULL
);
