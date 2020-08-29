package com.example.marilyn_api.controller;

import java.io.IOException;
import java.util.List;

public interface Icontroller<T,t>{
    T create(T t) throws IOException;
    T read(String id);
    T update(T t) throws IOException;
    Boolean delete(String id);
    List<T> readALl();
    List<T> readALlOff(String id);
}
