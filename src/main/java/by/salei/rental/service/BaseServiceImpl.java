package by.salei.rental.service;

import by.salei.rental.entity.BaseEntity;
import by.salei.rental.service.api.BaseService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BaseServiceImpl <E extends BaseEntity, R extends CrudRepository> implements BaseService<E> {

    private R repository;

    @Override
    public Integer save(E entity) {
        return ((BaseEntity) repository.save(entity)).getId();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void update(E entity) {
        repository.save(entity);
    }

    @Override
    public Optional<E> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<E> getAll() {
        return repository.findAll();
    }
}
