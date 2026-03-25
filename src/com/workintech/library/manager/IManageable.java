package com.workintech.library.manager;

public interface IManageable<T> {
    void add(T item);
    void remove(long id);
    T findById(long id);
    void listAll();
}