package com.task19.jxmall.controller;

import com.task19.jxmall.entity.Inventory;
import com.task19.jxmall.entity.Product;
import com.task19.jxmall.respository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "products")
public class PrductController {

  @Autowired
  ProductRepository productRepository;

  @PostMapping
  public ResponseEntity createProduct(@RequestBody Product product) {
    Inventory inventory = new Inventory(0,0);
    product.setInventory(inventory);
    Product createdProduct = productRepository.save(product);
    return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity updateProduct(@PathVariable int id, @RequestBody Product input) {
    Product oldProduct = productRepository.findById(id);
    if(oldProduct==null){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    oldProduct.setDescription(input.getDescription());
    oldProduct.setName(input.getName());
    oldProduct.setPrice(input.getPrice());

    productRepository.save(oldProduct);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping(value = "")
  public ResponseEntity<List<Product>> getProducts() {
    return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Object> getProductById(@PathVariable int id) {
    Product product = productRepository.findById(id);
    return product != null ? new ResponseEntity<Object>(product, HttpStatus.OK)
        : new ResponseEntity<Object>("没找到！", HttpStatus.NOT_FOUND);
  }


}
