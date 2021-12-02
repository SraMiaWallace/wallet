package com.walletLu.walletLuapiRest.domain.services.interfaces;

import java.util.List;

public interface BaseService<T, id> {

    List<T> getAll();

    T getById(id identifier);

    T create(T object);

    T update(T object);

    Boolean delete(id identifier);
}
