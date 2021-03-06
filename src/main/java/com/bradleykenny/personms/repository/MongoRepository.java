package com.bradleykenny.personms.repository;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class MongoRepository<T> implements CrudRepository<T, String> {

    @Autowired
    Datastore datastore;

    private final Class<T> genericClassType;

    public MongoRepository() {
        this.genericClassType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), MongoRepository.class);
    }

    @Override
    public <S extends T> S save(S entity) {
        datastore.save(entity);
        return entity;
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        datastore.save(entities);
        return entities;
    }

    @Override
    public Optional<T> findById(String s) {
        T queryResult = datastore.find(this.genericClassType).field("_id").equal(s).get();
        if (queryResult == null) {
            return Optional.empty();
        } return Optional.of(queryResult);
    }

    @Override
    public boolean existsById(String s) {
        Query queryResult = datastore.find(this.genericClassType).field("_id").equal(s);
        return queryResult.count() != 0 ? true : false;
    }

    @Override
    public Iterable<T> findAll() {
        return null;
    }

    @Override
    public Iterable<T> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
