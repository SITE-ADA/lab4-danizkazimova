package az.edu.ada.wm2.lab4.controller;

import az.edu.ada.wm2.lab4.model.Product;
import az.edu.ada.wm2.lab4.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {

        try {
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable UUID id,
            @RequestBody Product product) {

        try {
            Product updatedProduct = productService.updateProduct(id, product);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {

        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/filter/expiring")
    public ResponseEntity<List<Product>> getProductsExpiringBefore(
            @RequestParam LocalDate date) {

        List<Product> products = productService.getProductsExpiringBefore(date);
        return ResponseEntity.ok(products);
    }


    @GetMapping("/filter/price")
    public ResponseEntity<List<Product>> getProductsByPriceRange(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {

        List<Product> products = productService.getProductsByPriceRange(min, max);
        return ResponseEntity.ok(products);
    }
}