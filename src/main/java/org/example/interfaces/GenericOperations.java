package org.example.interfaces;

import java.util.List;

/*
 * T - Type (pode ser qualquer coisa.... pessoa, aluno, geralmente camada model)
 * N - Number (Integer, Double, erc;)
 */

public interface GenericOperations<T, N> {

    public T create(T entity);

    public T get(N id);

    public List<T> get();

    public T update(N id, T entity);

    public void delete(N id);
}