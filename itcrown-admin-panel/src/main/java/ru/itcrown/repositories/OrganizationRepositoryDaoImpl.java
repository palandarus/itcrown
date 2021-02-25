package ru.itcrown.repositories;

import org.springframework.stereotype.Component;
import ru.itcrown.models.Organization;

import java.util.Map;

@Component
public class OrganizationRepositoryDaoImpl extends DefaultDaoRepository implements OrganizationRepository {


    @Override
    public Map<Long, Organization> findAll() {
        return null;
    }

    @Override
    public void save(Organization organization) {

    }

    @Override
    public Organization findByName(String name) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }
}
