package ru.itcrown.services;

import ru.itcrown.models.Role;
import ru.itcrown.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void saveOrUpdate(User user);

    void removeById(Long id);

    User findByUsername(String username);

    User findByEmail(String email);

    void addRoleToUser(User user, Role role);

    void removeRoleFromUser(User user, Role role);

    User findById(Long id);
}
