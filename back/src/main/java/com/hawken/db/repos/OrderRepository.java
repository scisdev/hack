package com.hawken.db.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hawken.db.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

}
