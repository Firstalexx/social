package ru.cavd.social.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cavd.social.models.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAuthorUserIdEquals(long authorUserId);
}
  
