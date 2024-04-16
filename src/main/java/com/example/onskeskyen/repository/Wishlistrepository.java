package com.example.onskeskyen.repository;

import com.example.onskeskyen.models.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Wishlistrepository {
     @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Wishlist> getWishlist() {
        String quary = "select * from wishlists;";
        RowMapper<Wishlist> rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        return jdbcTemplate.query(quary,rowMapper);
    }


    public List<Wishlist> getmylist(int id) {

        String quary = "select * from wishlists WHERE user_id = ?";
        RowMapper<Wishlist> rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        return jdbcTemplate.query(quary,rowMapper,id);
    }

    public void insert(String title, int userid) {
        String quary = "INSERT INTO wishlists(name,user_id)" + " VALUE(?,?)";
        jdbcTemplate.update(quary,title,userid);
    }

    public void delete(int id) {
        String query = "DELETE FROM products WHERE wishlist_id IN (SELECT wishlist_id FROM wishlists WHERE wishlist_id = ?);";
        jdbcTemplate.update(query, id); // Delete products related to the user

        query = "DELETE FROM wishlists WHERE wishlist_id = ?;";
        jdbcTemplate.update(query, id); // Delete wishlists of the user
    }

    public Wishlist getspecifikwishlist(int id) {
        String quary = "SELECT * FROM wishlists WHERE wishlist_id = ?";
        RowMapper<Wishlist> rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        return jdbcTemplate.queryForObject(quary,rowMapper,id);
    }

    public List<Wishlist> getall() {
        String quary = "select * from wishlists";
        RowMapper<Wishlist> rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        return jdbcTemplate.query(quary,rowMapper);
    }


}
