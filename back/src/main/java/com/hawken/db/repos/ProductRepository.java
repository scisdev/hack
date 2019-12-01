package com.hawken.db.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hawken.db.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
