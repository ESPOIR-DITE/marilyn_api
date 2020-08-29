package com.example.marilyn_api.service;

import java.io.IOException;
import java.util.List;

public interface Iservice <T,t>{
    T create(T t) throws IOException;
    T update(T t) throws IOException;
    T read(String id);
    Boolean delete(String id);
    List<T> readAll();
    T get(String id);
    List<T> readAllOf(String id);
}
