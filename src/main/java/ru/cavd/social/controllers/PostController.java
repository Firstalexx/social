package ru.cavd.social.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cavd.social.models.Post;
import ru.cavd.social.services.PostService;

import java.util.Optional;

@RestController
@RequestMapping(path="/post")
public class PostController {

  //  @Autowired
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    public PostService postService;

    @PostMapping(path="/add")
    public @ResponseBody Post addNewUser (@RequestBody Post post) {
        return postService.savePost(post);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Post> getAllPosts() {
        return postService.findAllPosts();
    }

//    @GetMapping(path="/{id}", produces = "application/json")
//    public @ResponseBody Optional<Post> getPost(@PathVariable long id) {
//        return postService.findByIdPost(id);
//    }
    @GetMapping(path="/{authorUserId}/all", produces = "application/json")
    public @ResponseBody Iterable<Post> getAllPostsById(@PathVariable long authorUserId) {
    return postService.findAllPostsByAuthorUserId(authorUserId);
}

    @GetMapping(path="/{id}", produces = "application/json")
    public @ResponseBody Optional<Post> getPost(@PathVariable long id) {
    return postService.findByIdPost(id);
}

}