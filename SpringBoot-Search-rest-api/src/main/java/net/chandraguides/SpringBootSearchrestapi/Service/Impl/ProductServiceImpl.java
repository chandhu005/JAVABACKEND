package net.chandraguides.SpringBootSearchrestapi.Service.Impl;

import net.chandraguides.SpringBootSearchrestapi.Entity.Product;
import net.chandraguides.SpringBootSearchrestapi.Service.ProductService;
import net.chandraguides.SpringBootSearchrestapi.repositroy.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchProducts(String query) {
      List<Product> products=  productRepository.searchProducts(query);
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
