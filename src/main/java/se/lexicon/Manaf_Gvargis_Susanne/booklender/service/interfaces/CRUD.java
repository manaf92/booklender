package se.lexicon.Manaf_Gvargis_Susanne.booklender.service.interfaces;

import java.util.List;

public interface CRUD<T,ID> {
    T create(T t);
    T findById (ID id);
    List<T> findAll();
    T update(T t);
    boolean delete(ID id);
}
