package com.springdatajpa.springdatajpacourse.repository;

import com.springdatajpa.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    public ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product3");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDateCreated());

    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(452L).get();
        System.out.println(product.getId());
        System.out.println(product.getPrice());
        System.out.println(product.getLastUpdated());
    }

    @Test
    void FindByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription("product4", "product4 description");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void FindByNameAndDescriptionMethod() {
        List<Product> products = productRepository.findByNameAndDescription("product4", "product4 description");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("product3");
        System.out.println(product.getId());
        System.out.println(product.getPrice());
        System.out.println(product.getLastUpdated());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(120));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });

    }
@Test
    void findByPriceLessThanMethod() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(140));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findByNameContainingMethod(){
        List<Product> products=productRepository.findByNameContaining("product4");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findByNameLike(){
        List<Product> products=productRepository.findByNameLike("product3");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findByPriceBetweenMethod(){
        List<Product> products=productRepository.findByPriceBetween(new BigDecimal(121),new BigDecimal(140));
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findByDateCreatedBetweenMethod(){
        LocalDateTime startDate=LocalDateTime.of(2023,05,9,8,32,16);
        LocalDateTime endDate=LocalDateTime.of(2023,05,9,8,37,23);
        List<Product> products=productRepository.findByDateCreatedBetween(startDate,endDate);
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void FindByNameInMethod(){
        List<Product> products=productRepository.findByNameIn(List.of("product4","product3","product5"));
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findFirst2ByOrderByNameAsc(){
        List<Product> products=productRepository.findFirst2ByOrderByNameAsc();
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

}
