package com.task19.jxmall.respository;

import com.task19.jxmall.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findAll();

  Product findById(int id);

  Product save(Product product);

  List<Product> findByDescriptionContaining(String desc);

  List<Product> findByDescriptionContainingAndName(String desc, String name);

  List<Product> findByName(String name);
}