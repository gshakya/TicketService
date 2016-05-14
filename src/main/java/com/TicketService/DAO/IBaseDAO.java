package com.TicketService.DAO;

public interface IBaseDAO<T> {
	T add(T t);
	T update(T t);
	boolean delete(int id);
	T get(int id);
}
