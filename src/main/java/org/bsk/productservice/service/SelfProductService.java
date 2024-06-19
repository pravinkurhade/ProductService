package org.bsk.productservice.service;

import org.bsk.productservice.dto.ProductDTO;
import org.bsk.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private final ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<ProductDTO> getAllProducts(String sort, Long limit) {
        return productRepository.findAll();
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductDTO addProduct(ProductDTO product) {
        return productRepository.save(product);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<String> getAllCategories() {
        return productRepository.findAllCategories();
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String categoryName) {
        return productRepository.findAllProductsByCategory(categoryName);
    }
}
