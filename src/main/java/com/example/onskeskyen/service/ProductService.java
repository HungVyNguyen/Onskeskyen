package com.example.onskeskyen.service;

import com.example.onskeskyen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.onskeskyen.models.Product;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(int wishlist_id) {
        return productRepository.getAllProducts(wishlist_id);
    }

    public Product getProduct(int product_id) {
        return productRepository.getProduct(product_id);
    }

    public void insert(Product product) {
        productRepository.insert(product);
    }

    public void delete(int product_id) {
        productRepository.delete(product_id);
    }

    public void update(Product product) {
        productRepository.update(product);
    }
/*
    public void update(int product_id, String name, String description, double price, int amount, String imagepath, int wishlist_id) {
        productRepository.update(product_id, name, description, price, amount, imagepath, wishlist_id);
    }

    public void delete(int product_id) {
        productRepository.delete(product_id);
    }*/
}
