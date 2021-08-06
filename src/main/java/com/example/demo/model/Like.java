package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "rating")
@Table(schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    @JsonIgnore
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productid")
    @JsonIgnore
    private Products prodId;

    @Column(name = "isliked")
    private boolean isLiked;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Like(User userId, Products prodId, boolean isLiked) {
        this.userId = userId;
        this.prodId = prodId;
        this.isLiked = isLiked;
    }

}
