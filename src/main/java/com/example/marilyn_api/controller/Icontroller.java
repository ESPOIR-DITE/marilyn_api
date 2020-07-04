package com.example.marilyn_api.controller;

import java.util.List;

public interface Icontroller<T,t>{
    T create(T t);
    T read(String id);
    T update(T t);
    Boolean delete(String id);
    List<T> readALl();
    List<T> readALlOff(String id);
}
