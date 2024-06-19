package org.bsk.productservice.controller;

import org.bsk.productservice.dto.ProductDTO;
import org.bsk.productservice.entity.Product;
import org.bsk.productservice.exceptions.entity_exception.ApiResponseExceptionHandler;
import org.bsk.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public HttpEntity<List<Product>> getAllProducts(@RequestParam(required = false) String sort, @RequestParam(required = false) Long limit) {
        List<Product> products = productService.getAllProducts(sort, limit).stream().map(ProductDTO::toProduct).toList();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
           Optional<ProductDTO> product = Optional.ofNullable(productService.getProductById(id));
        return product.map(productDTO -> new ResponseEntity<>(productDTO.toProduct(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try {
            productService.addProduct(product.toProductDto()).toProduct();
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        Optional<ProductDTO> product1 = Optional.ofNullable(productService.getProductById(id));
        if(product1.isPresent()) {
            try {
                productService.updateProduct(id, product.toProductDto()).toProduct();
            }catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
        Optional<ProductDTO> product1 = Optional.ofNullable(productService.getProductById(id));
        if(product1.isPresent()) {
            try {
                productService.deleteProduct(id);
            }catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/products/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") String category) {
        List<Product> products = productService.getProductsByCategory(category).stream().map(ProductDTO::toProduct).toList();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/categories")
    public ResponseEntity<List<String>> getAllCategories() {
        List<String> products = productService.getAllCategories();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
