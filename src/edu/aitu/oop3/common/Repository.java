package edu.aitu.oop3.common;

import java.util.List;

public interface Repository<T, ID> {
    T findById(ID id);
    List<T> findAll();
}