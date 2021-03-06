package com.example.demo.controller;

import com.example.demo.service.LikeService;
import io.swagger.annotations.Api;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@RequestMapping("/api/v1/liked")
public class LikeController {
    @Autowired
    LikeService likeService;

    @RequestMapping(value = "/like", method = RequestMethod.PATCH)
    public String likeProduct(@RequestParam Long id) throws NotFound {

        return likeService.likeProducts(id);

    }

    @RequestMapping(value = "/dislike", method = RequestMethod.PATCH)

    public String dislikeProduct(@RequestParam Long id) throws NotFound {

        return likeService.dislikeProduct(id);
    }
}
