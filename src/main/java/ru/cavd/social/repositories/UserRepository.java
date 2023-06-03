package ru.cavd.social.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cavd.social.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
}