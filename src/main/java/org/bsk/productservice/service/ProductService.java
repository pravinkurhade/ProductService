package org.bsk.productservice.service;

import org.bsk.productservice.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts(String sort, Long limit);
    ProductDTO getProductById(Long id);
    ProductDTO addProduct(ProductDTO product);
    ProductDTO updateProduct(Long id, ProductDTO product);
    void deleteProduct(Long id);
    List<String> getAllCategories();
    List<ProductDTO> getProductsByCategory(String categoryName);
}
