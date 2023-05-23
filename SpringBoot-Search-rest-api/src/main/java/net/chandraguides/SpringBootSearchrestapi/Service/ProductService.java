package net.chandraguides.SpringBootSearchrestapi.Service;

import net.chandraguides.SpringBootSearchrestapi.Entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
