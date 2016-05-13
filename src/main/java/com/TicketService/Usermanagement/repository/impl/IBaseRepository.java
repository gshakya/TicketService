package com.TicketService.Usermanagement.repository.impl;

public interface IBaseRepository<T> {
	T add(T t);
	T update(T t);
	boolean delete(int id);
	T get(int id);
}
