package com.example.blog1.controller;

import com.example.blog1.model.Post;
import com.example.blog1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping()
    public ResponseEntity<Iterable<Post>> findAll() {
        Iterable<Post> postList = postService.findAll();
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> findById(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (!post.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

     @PostMapping
    public ResponseEntity<Void> savePost(@RequestBody Post post){
         postService.save(post);
       return new ResponseEntity<>(HttpStatus.OK);
     }

      @PutMapping("/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable Long id,@RequestBody Post post){
        Optional<Post> post1 = postService.findById(id);
        if(!post1.isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        post.setId(post1.get().getId());
        postService.save(post);
        return new ResponseEntity<>(HttpStatus.OK);
      }

      @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id){
        postService.remove(id);
        return new ResponseEntity<>(postService.findAll(),HttpStatus.OK);
      }

}
