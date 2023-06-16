package com.example.blog1.repository;

import com.example.blog1.model.Category;
import com.example.blog1.model.Post;
import javafx.geometry.Pos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Optional;
@Repository
@Transactional
public interface IPostRepository extends JpaRepository<Post, Long> {
    Iterable<Post> findAllByCategory(Category category);

//    @Query(value = "select post.id,post.content,post.name_book, post.title, category.name  from post " +
//            "join category on post.category_id = category.id" +
//            " where post.id =:id",nativeQuery = true)
//    Optional<Post> findByIdButTheCateShowOnlyName(Long id);
}
