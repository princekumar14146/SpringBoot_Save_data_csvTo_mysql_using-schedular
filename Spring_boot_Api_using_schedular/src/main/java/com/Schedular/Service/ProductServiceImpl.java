package com.Schedular.Service;

import com.Schedular.Entity.Product;
import com.Schedular.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<String> saveProduct(Product product) {
        productRepository.save(product);

        return ResponseEntity.status(HttpStatus.OK).body("Data saved successfully");

    }
}
