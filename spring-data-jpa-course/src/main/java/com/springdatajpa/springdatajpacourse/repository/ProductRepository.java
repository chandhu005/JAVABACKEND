package com.springdatajpa.springdatajpacourse.repository;

import com.springdatajpa.springdatajpacourse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product,Long> {
    public  Product findByName(String name);
    public Optional<Product> findById(Long id);
    List<Product> findByNameOrDescription(String name, String Description);
    List<Product> findByNameAndDescription(String name, String Description);
    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByNameContaining(String name);

    List<Product> findByNameLike(String name);
    List<Product>  findByPriceBetween(BigDecimal startPrice,BigDecimal endPrice);
    List<Product> findByDateCreatedBetween(LocalDateTime startDate,LocalDateTime endDate);
    List <Product> findByNameIn(List<String> name);
    List<Product> findFirst2ByOrderByNameAsc();
    
}
