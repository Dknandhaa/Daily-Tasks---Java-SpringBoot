CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(100),
    fullname VARCHAR(255)

);

CREATE TABLE dataset(
    id SERIAL PRIMARY KEY,
    pdfName VARCHAR(255) NOT NULL,
    description TEXT,
    pdfUrl VARCHAR(255) NOT NULL

);
