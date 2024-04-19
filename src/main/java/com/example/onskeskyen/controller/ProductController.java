package com.example.onskeskyen.controller;

import com.example.onskeskyen.service.ProductService;
import com.example.onskeskyen.service.Wishlistservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.onskeskyen.models.Product;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private Wishlistservice wishlistService;

    @GetMapping("/showProducts")
    public String index(Model model, @RequestParam int wishlist_id) {
        model.addAttribute("products", productService.getAllProducts(wishlist_id));
        model.addAttribute("wishlist", wishlistService.getspicifikwishlist(wishlist_id));
        return "home/showProducts";
    }

    @GetMapping("/newProduct")
    public String configureNew(Model model, @RequestParam int wishlist_id) {
        model.addAttribute("product", new Product(wishlist_id));
        return "home/newProduct";
    }

    @PostMapping("/insertProduct")
    public String insert(@ModelAttribute Product product) {
        productService.insert(product);
        return "redirect:/showProducts?wishlist_id=" + product.getWishlist_id();
    }

    @GetMapping("/productDetails")
    public String viewProductDetails(Model model, @RequestParam int product_id) {
        model.addAttribute("product", productService.getProduct(product_id));
        return "home/productDetails";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam int product_id, @RequestParam int wishlist_id) {
        productService.delete(product_id);
        return "redirect:/showProducts?wishlist_id=" + wishlist_id;
    }

    @GetMapping("/editProduct")
    public String editProduct(Model model, @RequestParam int product_id) {
        model.addAttribute("product", productService.getProduct(product_id));
        return "home/editProduct";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product product) {
        productService.update(product);
        return "redirect:/productDetails?product_id=" + product.getProduct_id();
    }

}
