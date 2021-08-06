package com.example.demo.controller;

import com.example.demo.model.Products;
import com.example.demo.service.ListOfAllProductsService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Api
@RestController
@RequestMapping("/list-all-products")
public class ListAllProductsController {
    ListOfAllProductsService listOfAllProductsService;

    public ListAllProductsController(ListOfAllProductsService listOfAllProductsService) {
        this.listOfAllProductsService = listOfAllProductsService;
    }

    @GetMapping("")
    public ResponseEntity<List<Products>> getAllProducts( @RequestParam("page-number") @Min(0) int pageNumber,
                                                          @RequestParam("page-size") @Min(1) int pageSize) {

            Page<Products> pageableProducts = listOfAllProductsService.findAll(pageNumber, pageSize);
            Iterator<Products> iterator = pageableProducts.stream().iterator();
            List<Products> products = new ArrayList<>();
            iterator.forEachRemaining(products::add);
            return new  ResponseEntity<>(products, HttpStatus.OK);

    }
}

