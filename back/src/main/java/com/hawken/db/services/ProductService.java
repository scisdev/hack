package com.hawken.db.services;

import java.util.ArrayList;

import com.hawken.db.Product;

public interface ProductService {
	public abstract void createProduct(Product product);
	public abstract void updateProduct(Product product);
	public abstract void deleteProduct(Integer id);
	public abstract ArrayList<Product> getAllProducts();
	public abstract Product findProdById(Integer id);
}
