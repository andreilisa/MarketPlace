package com.example.demo.controller;

import com.example.demo.dao.ProductsRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Products;
import com.example.demo.model.User;
import com.example.demo.service.ProductRequest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Api
@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductController {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private UserRepository userRepository;


    public User getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(authentication.getName());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-product")
    public Products create(@RequestBody @Valid ProductRequest productRequest) {
        Products products = new Products();
        products.setName(productRequest.getName());
        products.setPrice(productRequest.getPrice());
        products.setUser(getCurrentUserId());
        productsRepository.save(products);
        return products;

    }

    @PutMapping("/update{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestBody  ProductRequest products1, @RequestParam Long id) throws Exception {
        Products products = productsRepository.findById(id).get();
        if (getCurrentUserId() == products.getUser()) {
            products.setName(products1.getName());
            products.setPrice(products1.getPrice());
            productsRepository.save(products);
            return HttpStatus.OK + " \n Product Update with success";
        } else throw new Exception( HttpStatus.BAD_REQUEST + " Not found");


    }

    @DeleteMapping("/delete{id}")
    public String delete(@PathVariable Long id) {
        Products products = productsRepository.findById(id).get();
        if (getCurrentUserId() == products.getUser()) {
            productsRepository.deleteById(id);
            return  (HttpStatus.OK ) + "\n Object is deleted";
        } else
            return (HttpStatus.BAD_REQUEST) + "\n Product not found";
    }

    @GetMapping("/all-products")
    public List<Products> products() {
        return productsRepository.findAllByUser(getCurrentUserId());
    }

    @GetMapping("/product-by-id")
    public Object product(@RequestParam Long id) {
        Products products = productsRepository.findById(id).get();
        if (getCurrentUserId() == products.getUser()) {
            return productsRepository.findById(id);
        } else
            return HttpStatus.OK + "\nProducts not found ";

    }
}








