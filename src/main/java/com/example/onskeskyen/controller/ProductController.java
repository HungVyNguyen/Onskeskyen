package com.example.onskeskyen.controller;

import com.example.onskeskyen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/insertprodukt")
    public String insert(@RequestParam String name, @RequestParam String description, @RequestParam double price, @RequestParam int amount, @RequestParam String imagepath, @RequestParam int wishlist_id) {
        productService.insert(name, description, price, amount, imagepath, wishlist_id);
        return "home/index";
    }

    @PostMapping("/update")
    public String update(@RequestParam int product_id, @RequestParam String name, @RequestParam String description, @RequestParam double price, @RequestParam int amount, @RequestParam String imagepath, @RequestParam int wishlist_id) {
        productService.update(product_id, name, description, price, amount, imagepath, wishlist_id);
        return "home/index";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int product_id) {
        productService.delete(product_id);
        return "home/index";
    }
}
