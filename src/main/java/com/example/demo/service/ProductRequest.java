package com.example.demo.service;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ProductRequest {
    @NotBlank
    @NotEmpty
    @Size(min = 2,max = 32)
    private String name;
    @Min(0)
    private double price;

}
