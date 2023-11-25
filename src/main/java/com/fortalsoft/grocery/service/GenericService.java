package com.fortalsoft.grocery.service;

import com.fortalsoft.grocery.dto.ProductDTO;
import com.fortalsoft.grocery.entity.Product;
import com.fortalsoft.grocery.exception.ControllerNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;
import java.util.stream.Collectors;

public abstract class GenericService<T, D> {

    public D findById(UUID id) {
        T entity = getEntity(id);
        return mapperEntityToDTO(entity);
    }

    //findAll
    //findById
    //save
    //update
    //delete

    public List<D> findAll() {
        var entities = getRepository().findAll();
        ArrayList<D> allEntities = new ArrayList<>();
        for(Object entity : entities){
            allEntities.add(mapperEntityToDTO((T) entity));
        }
        return allEntities;
    }

    public D save(D entityDTO) {
        T entity = createEntity();
        mapperDTOToEntity(entity, entityDTO);
        entity = (T) getRepository().save(entity);
        return mapperEntityToDTO(entity);
    }

    public D update(UUID id, D entityDTO){
        T entity = getEntity(id);
        mapperDTOToEntity(entity, entityDTO);
        entity = (T) getRepository().save(entity);
        return mapperEntityToDTO(entity);
    }

    public void delete(UUID id){
        T entity = getEntity(id);
        getRepository().delete(entity);
    }

    private T getEntity(UUID id) {
        Optional entity = getRepository().findById(id);
        if (entity.isPresent()) {
            return (T) entity.get();
        } else {
            throw new ControllerNotFoundException("entity not found");
        }
    }

    abstract D mapperEntityToDTO(T entity);

    abstract void mapperDTOToEntity(T entity, D entityDTO);

    abstract T createEntity();

    abstract JpaRepository getRepository();

}
