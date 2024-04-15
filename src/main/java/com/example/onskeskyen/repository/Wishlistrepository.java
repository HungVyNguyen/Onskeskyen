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
}
