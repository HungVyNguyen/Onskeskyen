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
        RowMapper rowMapper = new BeanPropertyRowMapper<>(User.class); //Jeg har slettet <User> da jeg ikke tror, at der er behov for det
        return jdbcTemplate.query(quary,rowMapper);
    }

    public void createUser(String username, String password, String imagepath){
        String query = "insert into users (username, password, imagepath)" + "values(?, ?, ?);";
        jdbcTemplate.update(query, username, password, imagepath);
    }
}

