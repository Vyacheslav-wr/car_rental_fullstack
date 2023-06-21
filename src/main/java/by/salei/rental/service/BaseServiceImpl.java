package by.salei.rental.service;

import by.salei.rental.entity.BaseEntity;
import by.salei.rental.service.api.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class BaseServiceImpl <E extends BaseEntity, R extends CrudRepository<E, Integer>> implements BaseService<E> {

    @Override
    public Integer save(E entity) {
        return getDefaultRepo().save(entity).getId();
    }

    @Override
    public void delete(Integer id) {
        getDefaultRepo().deleteById(id);
    }

    @Override
    public void update(E entity) {
        getDefaultRepo().save(entity);
    }

    @Override
    public Optional<E> getById(Integer id) {
        return getDefaultRepo().findById(id);
    }

    @Override
    public Iterable<E> getAll() {
        return getDefaultRepo().findAll();
    }

    public abstract R getDefaultRepo();
}
