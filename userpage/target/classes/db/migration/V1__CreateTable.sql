CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(100),
    fullname VARCHAR(255)

);

--private Long id;
--    // @Column(unique = true)
--    private String username;
--    private String password;
--    private String fullname;