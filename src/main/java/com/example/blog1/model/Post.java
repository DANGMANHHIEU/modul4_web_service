package com.example.blog1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
@Data
@ToString
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameBook;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id")

    private Category category;

    public Post(String nameBook, String title, String content, Category category) {
        this.nameBook = nameBook;
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public Post() {
    }
}
