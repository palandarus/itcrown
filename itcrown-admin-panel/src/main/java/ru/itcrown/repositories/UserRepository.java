package ru.itcrown.repositories;

import ru.itcrown.models.User;

import java.util.Map;

public interface UserRepository {
    User findByUsername(String username);

    void remove(Long id);

    void save(User user);

    Map<Long, User> findAll();

    User findByEmail(String email);

    User findById(Long id);
}
