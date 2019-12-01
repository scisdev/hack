package com.hawken.db.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hawken.db.Product;
import com.hawken.db.repos.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void createProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> res = new ArrayList<>();
		for (Product o : productRepository.findAll()) {
			res.add(o);
		}
		return res;
	}

	@Override
	public Product findProdById(Integer id) {
		Optional<Product> prod = productRepository.findById(id);
		return prod.get();
	}
}
