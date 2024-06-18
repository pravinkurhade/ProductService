package org.bsk.productservice.service;

import org.bsk.productservice.dto.ProductDTO;
import org.bsk.productservice.entity.Product;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts(String sort, Long limit);
    ProductDTO getProductById(Long id);
    ProductDTO addProduct(Product product);
    ProductDTO updateProduct(Long id, Product product);
    ProductDTO deleteProduct(Long id);
    List<String> getAllCategories();
    List<ProductDTO> getProductsByCategory(String categoryName);
}
