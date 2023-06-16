package com.example.blog1.service;

import com.example.blog1.model.Category;
import com.example.blog1.model.Post;
import com.example.blog1.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private IPostRepository postRepository;

    public Iterable<Post> findAll(){
        return postRepository.findAll();
    }

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public Post save(Post post) {
      return   postRepository.save(post);
    }

    public void remove(Long id) {
        postRepository.deleteById(id);
    }

    public Iterable<Post> findByProvince(Category category) {
        return postRepository.findAllByCategory(category);
    }


}
