package by.salei.rental.service.api;

import by.salei.rental.entity.BaseEntity;

import java.util.Optional;

public interface BaseService <E extends BaseEntity> {

    Integer save(E entity);

    void delete(Integer id);

    void update (E entity);

    Optional<E> getById(Integer id);

    Iterable<E> getAll();
}
