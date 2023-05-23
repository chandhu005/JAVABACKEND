package net.chandraguides.SpringBootSearchrestapi.Controller;

import net.chandraguides.SpringBootSearchrestapi.Entity.Product;
import net.chandraguides.SpringBootSearchrestapi.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class productController {
    private ProductService productService;

    public productController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query){
        return ResponseEntity.ok(productService.searchProducts(query));
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
