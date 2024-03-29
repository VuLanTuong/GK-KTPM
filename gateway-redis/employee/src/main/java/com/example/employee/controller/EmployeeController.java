package com.example.employee.controller;

import com.example.employee.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/products")
    public List<ProductDTO> getAllProduct(){
        ResponseEntity<ProductDTO[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8888/product/getAll",
                        ProductDTO[].class);
        ProductDTO[] productDTOS = response.getBody();
        assert productDTOS != null;
        return List.of(productDTOS);
    }

    @GetMapping("/product/{id}")
    public ProductDTO getProductById(@PathVariable(value = "id") Long id){
//        List<ProductDTO> list = restTemplate.getForObject("localhost:8888/product/findAllProduct", ProductDTO.class);

        ResponseEntity<ProductDTO> response =
                restTemplate.getForEntity(
                        "http://localhost:8888/product/findById/"+id,
                        ProductDTO.class);
        ProductDTO productDTOS = response.getBody();
        assert productDTOS != null;
        return productDTOS;
    }
}
