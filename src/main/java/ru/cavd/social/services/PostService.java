package ru.cavd.social.services;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.cavd.social.models.Post;
import ru.cavd.social.repositories.PostRepository;
import ru.cavd.social.repositories.UserRepository;

import java.util.Optional;

@Service
public class PostService {
    PostRepository postRepository;
    UserRepository userRepository;
//    @Autowired
//    EntityManager entityManager;


    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

//    public Post savePost (Long authorUserId, String header, String text, byte[] image) {
//        //TODO: 404 for null user
//        var authorUser = userRepository.findById(authorUserId).get();
//        return savePost(new Post(authorUser,header, text, image));
//    }
    public Post savePost(Post post) {
        var authorUser = userRepository.findById(post.getAuthorUser().getId()).get();
        post.setAuthorUser(authorUser);
        return postRepository.save(post);
    }


    //TODO: tests  findAllPosts WITH PAGINATION !!!
    public Iterable<Post> findAllPosts(int pageNo, int pageSize) {
        //Pageable pageable = new Pageable();
        // Page page = postRepository.findAll(pageable);
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("dateTime").descending());
        Slice<Post> slicedResult = postRepository.findAll(pageable);

        return slicedResult.getContent();
       // return postRepository.findAll(pageable);
    }

    public Optional<Post> findByIdPost(long id) {
        return postRepository.findById(id);
    }
    public void deleteByIdPost(long id) {
        postRepository.delete(postRepository.findById(id).get());
    }

    public Iterable<Post> findAllPostsByAuthorUserId(long authorUserId) {
        return postRepository.findByAuthorUserIdEquals(authorUserId);
    }
}
