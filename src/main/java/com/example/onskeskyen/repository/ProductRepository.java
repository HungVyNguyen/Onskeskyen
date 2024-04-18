package com.example.onskeskyen.repository;

import com.example.onskeskyen.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAllProducts(int wishlist_id) {
        String query = "SELECT * FROM products WHERE wishlist_id = ?;";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return jdbcTemplate.query(query, rowMapper, wishlist_id);
    }

    public Product getProduct(int product_id) {
        String query = "SELECT * FROM products WHERE product_id = ?;";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return jdbcTemplate.queryForObject(query, rowMapper, product_id);
    }

    public void insert(Product product) {
        String query = "INSERT INTO products(name, description, price, amount, imagepath, wishlist_id) "
            + "VALUES (?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(query, product.getName(), product.getDescription(), product.getPrice(), product.getAmount(),
                product.getImagepath(), product.getWishlist_id());
    }

    public void delete(int product_id) {
        String query = "DELETE FROM products WHERE product_id = ?;";
        jdbcTemplate.update(query, product_id);
    }

    public void update(Product product) {
        String query = "UPDATE products "
                + "SET name = ?, description = ?, price = ?, amount = ?, imagepath = ?, wishlist_id = ? "
                + "WHERE product_id = ?;";
        jdbcTemplate.update(query, product.getName(), product.getDescription(), product.getPrice(), product.getAmount(),
                product.getImagepath(), product.getWishlist_id(), product.getProduct_id());
    }

/*
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
    }*/
}
