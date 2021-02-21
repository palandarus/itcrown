package ru.itcrown.repositories;

import org.springframework.stereotype.Component;
import ru.itcrown.models.User;

@Component
public class UserRepositoryDaoImpl extends DefaultDaoRepository implements UserRepository{

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
