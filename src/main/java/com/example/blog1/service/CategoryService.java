package com.example.blog1.service;

import com.example.blog1.model.Category;
import com.example.blog1.model.Post;
import com.example.blog1.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    ICategoryRepository categoryRepository;
    public Iterable<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
