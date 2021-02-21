package ru.itcrown.repositories;

import ru.itcrown.models.User;

public interface UserRepository {
    public User findByUsername(String username);
}
