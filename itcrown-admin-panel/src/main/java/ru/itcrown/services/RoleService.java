package ru.itcrown.services;

import ru.itcrown.models.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role getRoleById(Long id);

    void deleteRoleById(Long id);

    void saveOrUpdate(Role role);

}
