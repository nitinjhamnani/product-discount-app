package com.product.app.manger;

public interface DataManager<T> {
	T save(T data);
	T getById(String id);
}
