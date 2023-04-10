package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import com.springboot.blog.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/post")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPost() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@RequestParam long id) {
        return ResponseEntity.ok(postService.getPosyById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, long id) {
        PostDto postResponse = postService.updatePost(postDto,id);

        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }
}
