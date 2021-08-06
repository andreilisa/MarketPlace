package com.example.demo.dao;

import com.example.demo.model.Products;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>, PagingAndSortingRepository<Products, Long> {
    List<Products> findAllByUser(User user);


    List<Products> findById(User user);
}