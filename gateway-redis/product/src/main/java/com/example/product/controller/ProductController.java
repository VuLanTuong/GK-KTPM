package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getAll")
    public List<Product> getAll(){
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Product findById(@PathVariable Long id){
        return productRepository.findById(id).get();
    }

    @PostMapping("/save")
    public String addProduct(@RequestBody  Product product){
        productRepository.save(product);
        return "save product success";
    }


}
