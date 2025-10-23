package io.github.Mahjoubech.smartlogi.dao;

import java.util.List;

public interface Crud <T>{
    T create(T obj);
    void update(T obj);
    void delete(T obj);
    T findById(String id);
    List<T> getAll();
}
