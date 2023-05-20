package com.springdatajpa.springdatajpacourse.repository;

import com.springdatajpa.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest

class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //create Product
        Product product = new Product();
        product.setName("product2");
        product.setDescription("product1 description");
        product.setSku("1000BcS");
        product.setPrice(new BigDecimal(100));
        product.setImageUrl("product.png");
        Product savedObject = productRepository.save(product);
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        //find or reterive an entity by id
        Long id = 152L;
        Product product = productRepository.findById(id).get();
        product.setName("updatedproduct1");
        product.setDescription("update the product1");
        productRepository.save(product);
        //update entity information
        //save update
    }

    @Test
    void findByIdMethod() {
        Long id = 152l;
        Product product = productRepository.findById(id).get();

    }
@Test
    void saveAllMethod() {
        Product product = new Product();
        product.setName("product3");
        product.setDescription("product3 description");
        product.setSku("1000ABsext");
        product.setPrice(new BigDecimal(120));
        product.setImageUrl("product3.png");

        Product product1 = new Product();
        product1.setName("product4");
        product1.setDescription("product4 description");
        product1.setSku("1000ABed");
        product1.setPrice(new BigDecimal(130));
        product1.setImageUrl("product3.png");

        Product product2 = new Product();
        product2.setName("product5");
        product2.setDescription("product5 description");
        product2.setSku("1000ABl");
        product2.setPrice(new BigDecimal(140));
        product2.setImageUrl("product3.png");
        productRepository.saveAll(List.of(product1,product,product2));
    }
    @Test
    void findAllMethod(){
        List<Product> products=productRepository.findAll();
        products.forEach((p) ->{
            System.out.println(p.getId());
        } );
    }
    @Test
    void deleteByIdMethod(){
      Long id=353L;
      productRepository.deleteById(id);
    }
    @Test
    void deleteMethod(){
        Long id=252L;
        Product product=productRepository.findById(id).get();
        productRepository.delete(product);
    }
    @Test
    void deleteAll(){
        productRepository.deleteAll();
    }
    @Test
    void deleteAllMethod(){
        Product product=productRepository.findById(402L).get();
        Product product2=productRepository.findById(403L).get();
        productRepository.deleteAll(List.of(product,product2));

    }
    @Test
    void countMethod(){
      Long count=  productRepository.count();
      System.out.println(count);
    }
    @Test
    void ExistByIdMethod(){
        Long id=1L;
        boolean results=productRepository.existsById(id);
        System.out.println(results);
    }
}