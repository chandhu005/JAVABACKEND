package net.chandraguides.SpringBootSearchrestapi.repositroy;

import net.chandraguides.SpringBootSearchrestapi.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT  p FROM Product p WHERE "+"p.name LIKE CONCAT('%',:query,'%')"+" or p.description LIKE CONCAT('%',:query,'%')")
    List<Product> searchProducts(String  query);
    @Query(value = "SELECT * FROM products p WHERE"+"p.name LIKE CONCAT('%',:query,'%')"+" or p.description LIKE CONCAT('%',:query,'%')",nativeQuery = true)
    List<Product> searchProductsQL(String  query);
}
