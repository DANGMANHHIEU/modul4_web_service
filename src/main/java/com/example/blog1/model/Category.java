package com.example.blog1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
   @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
   @JsonIgnore
   private List<Post> postList;

    public Category(String name, List<Post> postList) {
        this.name = name;
        this.postList = postList;
    }


    public Category() {

    }
}
