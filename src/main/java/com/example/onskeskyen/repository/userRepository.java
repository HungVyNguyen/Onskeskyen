package com.example.onskeskyen.repository;

import com.example.onskeskyen.models.User;
import com.example.onskeskyen.models.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class userRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getuserlist() {
        String quary = "select * from users;";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.query(quary,rowMapper);
    }

    public void createUser(String username, String password, String imagepath){
        String query = "insert into users (username, password, imagepath)" + "values(?, ?, ?);";
        jdbcTemplate.update(query, username, password, imagepath);
    }
    public int getUserIdForWishlist(int wishlistId) {
        String query = "SELECT user_id FROM wishlists WHERE wishlist_id = ?";
        return jdbcTemplate.queryForObject(query, Integer.class, wishlistId);
    }

}

