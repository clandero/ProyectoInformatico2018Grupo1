/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;

/**
 *
 * @author arken
 */
public interface IDao<T> {
     
    Optional<T> get(long id);
     
    List<T> getAll();
     
    void save(T t);
     
    void update(T t, String[][] params);
     
    void delete(T t);
}
