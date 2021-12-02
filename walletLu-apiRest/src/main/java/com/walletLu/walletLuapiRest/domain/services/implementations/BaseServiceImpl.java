package com.walletLu.walletLuapiRest.domain.services.implementations;

import com.walletLu.walletLuapiRest.domain.services.interfaces.BaseService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<T, id extends Serializable> implements BaseService<T, id> {

    protected JpaRepository<T, id> repository;

    /**
     * Método genérico que sobreescribe a getAll de jpaRepository
     *
     * @return Retorna la lista de objetos encontrada
     */
    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    /**
     * Método genérico que sobreescribe a getById de jpaRepository
     *
     * @param identifier Identificador (id) del objeto a obtener
     * @return Retorna el objeto encontrado
     */
    @Override
    public T getById(id identifier) {
        try {
            return repository.findById(identifier).orElse(null);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método genérico que sobreescribe a create de jpaRepository
     *
     * @param object Objeto a crear en una entidad
     * @return Retorna el objeto creado
     */
    @Override
    public T create(T object) {
        try {
            return repository.save(object);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método genérico que sobreescribe a update de jpaRepository
     *
     * @param object Objeto a actualizar en una entidad
     * @return Retorna el objeto actualizado
     */
    @Override
    public T update(T object) {
        try {
            return repository.save(object);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método genérico que sobreescribe a delete de jpaRepository
     *
     * @param identifier Identificador (id) del objeto a borrar
     * @return Retorna true si es borrado correctamente
     */
    @Override
    public Boolean delete(id identifier) {
        try {
            repository.deleteById(identifier);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

}
