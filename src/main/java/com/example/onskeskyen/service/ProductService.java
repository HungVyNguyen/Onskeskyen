package com.example.onskeskyen.service;

import com.example.onskeskyen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void insert(String name, String description, double price, int amount, String imagepath, int wishlist_id) {
        productRepository.insert(name, description, price, amount, imagepath, wishlist_id);
    }

    public void update(int product_id, String name, String description, double price, int amount, String imagepath, int wishlist_id) {
        productRepository.update(product_id, name, description, price, amount, imagepath, wishlist_id);
    }

    public void delete(int product_id) {
        productRepository.delete(product_id);
    }
}
