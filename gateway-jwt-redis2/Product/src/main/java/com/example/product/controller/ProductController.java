package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/save")
    public String addProduct(@RequestBody Product product){
        productRepository.save(product);
        return "add product success";
    }

    @GetMapping("/getAllProduct")
    public List<Product> getAll(){
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("/findProductById/{id}")
    public Product getProductById(@PathVariable Long id){
        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()){
            Product product1 = product.get();
                    return product1;
        }
        else return null;
    }


}
