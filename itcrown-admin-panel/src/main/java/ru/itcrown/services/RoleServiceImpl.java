package ru.itcrown.services;

import org.springframework.stereotype.Service;
import ru.itcrown.models.Role;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role getRoleById(Long id) {
        return null;
    }

    @Override
    public void deleteRoleById(Long id) {

    }

    @Override
    public void saveOrUpdate(Role role) {

    }
}
