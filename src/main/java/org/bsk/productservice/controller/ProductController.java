package org.bsk.productservice.controller;

import org.bsk.productservice.dto.ProductDTO;
import org.bsk.productservice.entity.Product;
import org.bsk.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(@RequestParam(required = false) String sort, @RequestParam(required = false) Long limit) {
        return productService.getAllProducts(sort,limit).stream().map(ProductDTO::toProduct).toList();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.getProductById(id).toProduct(), HttpStatus.OK);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product).toProduct();
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product).toProduct();
    }

    @DeleteMapping("/products/{id}")
    public ProductDTO deleteProduct(@PathVariable("id") Long id){
      return  productService.deleteProduct(id);
    }

    @GetMapping("/products/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category) {
        return productService.getProductsByCategory(category).stream().map(ProductDTO::toProduct).toList();
    }

    @GetMapping("/products/categories")
    public List<String> getAllCategories(){
        return productService.getAllCategories();
    }

}
