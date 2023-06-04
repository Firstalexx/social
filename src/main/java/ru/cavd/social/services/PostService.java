package ru.cavd.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cavd.social.models.Post;
import ru.cavd.social.repositories.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post savePost (Long authorUserId, String header, String text, byte[] image) {
        return savePost(new Post(authorUserId,header, text, image));
    }

    public Post savePost(Post user) {
        return postRepository.save(user);
    }


    //TODO: findAllPosts WITH PAGINATION !!!
    public Iterable<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> findByIdPost(long id) {
        return postRepository.findById(id);
    }

    public Iterable<Post> findAllPostsByAuthorUserId(long authorUserId) {
        return postRepository.findByAuthorUserIdEquals(authorUserId);
    }
}
