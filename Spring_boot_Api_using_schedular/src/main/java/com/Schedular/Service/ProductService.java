package com.Schedular.Service;

import com.Schedular.Entity.Product;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    public ResponseEntity<String> saveProduct(Product product);



}
