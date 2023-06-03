package ru.cavd.social.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cavd.social.models.User;
import ru.cavd.social.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser (String name, String email, String password) {
        return saveUser(new User(name, email, password));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findByIdUser(long id) {
        return userRepository.findById(id);
    }

}
