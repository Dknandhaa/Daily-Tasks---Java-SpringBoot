--CREATE TABLE quotesRepo (
--    id INT AUTO_INCREMENT,
--    quoteId VARCHAR(20),
--    author VARCHAR(20),
--    content VARCHAR(255),
--    dateAdded VARCHAR(20),
--    dateModified VARCHAR(20),
--    PRIMARY KEY (id),
--);
CREATE TABLE quotesRepo (
    id SERIAL PRIMARY KEY,
    quoteId VARCHAR(20),
    author VARCHAR(20),
    content VARCHAR(255),
    dateAdded VARCHAR(20),
    dateModified VARCHAR(20)
);
