package com.springframework.petclinic.services.map;

import com.springframework.petclinic.model.BaseEntity;
import com.springframework.petclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T object) {
        if (object == null){
            throw new RuntimeException("Object can't be null");
        }
        if (object.getId() == null){
            object.setId(getNextId());
        }
        map.put(object.getId(), object);
        return object;
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry-> entry.getValue().equals(object));
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId(){
        Set<Long> keys = map.keySet();
        return keys.size() > 0 ? Collections.max(keys) + 1L : 1L;
    }
}
