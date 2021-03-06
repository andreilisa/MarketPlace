package com.example.demo.service;

import com.example.demo.dao.LikeRepository;
import com.example.demo.dao.ProductsRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Like;
import com.example.demo.model.Products;
import com.example.demo.model.User;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private UserRepository userRepository;

    public User getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(authentication.getName());
    }

    @Transactional
    public String likeProducts(Long id) throws Exception {
        Optional<Products> product = productsRepository.findById(id);
        User user = getCurrentUserId();

        if (product.isPresent()) {

            if (product.get().getUser().getId().equals(user.getId())) {
                return  HttpStatus.OK + " \n it is not possible to like your own product!";
            }

            Optional<Like> like = likeRepository.findByUserIdAndProdId(user, product.get());
            if (like.isPresent()) {
                if (like.get().isLiked()) {
                    likeRepository.deleteById(like.get().getId());
                } else {
                    likeRepository.likeProduct(product.get().getId(), user.getId());

                }
            } else {
                likeRepository.save(new Like(user, product.get(), true));
            }
            return (HttpStatus.OK ) + "\n product is liked";
        } else {
            throw new Exception("Product Not Found");
        }
    }

    @Transactional
    public String dislikeProduct(Long id) throws Exception {
        Optional<Products> product = productsRepository.findById(id);
        User user = getCurrentUserId();

        if (product.isPresent()) {


            if (product.get().getUser().getId().equals(user.getId())) {
                return  HttpStatus.OK + " \nit is not possible to unlike your own product!";
            }


            Optional<Like> like = likeRepository.findByUserIdAndProdId(user, product.get());
            if (like.isPresent()) {

                if (!like.get().isLiked()) {
                    likeRepository.deleteById(like.get().getId());
                } else {
                    likeRepository.dislikeProduct(product.get().getId(), user.getId());
                }
            } else {
                likeRepository.save(new Like(user, product.get(), false));
            }
            return  (HttpStatus.OK ) + "\n product is unliked";
        } else {
            throw new Exception("Product Not Found");
        }
    }

}
