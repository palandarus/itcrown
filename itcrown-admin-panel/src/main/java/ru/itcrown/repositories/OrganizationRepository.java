package ru.itcrown.repositories;

import ru.itcrown.models.Organization;

import java.util.Map;

public interface OrganizationRepository {
    Map<Long, Organization> findAll();

    void save(Organization organization);

    Organization findByName(String name);

    void removeById(Long id);
}
