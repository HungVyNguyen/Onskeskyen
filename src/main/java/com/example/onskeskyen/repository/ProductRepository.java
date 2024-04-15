package com.example.onskeskyen.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(String name, String description, double price, int amount, String imagepath, int wishlist_id) {
        String query = "INSERT INTO product(name, description, price, amount, imagepath, wishlist_id) "
            + "VALUES (?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(query, name, description, price, amount, imagepath, wishlist_id);
    }

    public void update(int product_id, String name, String description, double price, int amount, String imagepath, int wishlist_id) {
        String query = "UPDATE products SET "
                + "name = ?, "
                + "description = ?, "
                + "price = ?, "
                + "amount = ?, "
                + "imagepath = ?, "
                + "wishlist_id = ? "
                + "WHERE product_id = ?;";
        jdbcTemplate.update(query, name, description, price, amount, imagepath, wishlist_id, product_id);
    }

    public void delete(int product_id) {
        String query = "DELETE FROM products WHERE product_id = ?;";
        jdbcTemplate.update(query, product_id);
    }
}
