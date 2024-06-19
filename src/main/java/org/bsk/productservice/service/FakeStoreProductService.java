package org.bsk.productservice.service;

import org.bsk.productservice.dto.ProductDTO;
import org.bsk.productservice.entity.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Objects;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String baseUrl = "https://fakestoreapi.com/products/";


    @Override
    public List<ProductDTO> getAllProducts(String sort, Long limit) {
        return List.of(Objects.requireNonNull(restTemplate.getForObject(baseUrl+"?sort="+sort+"&limit="+limit, ProductDTO[].class)));
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return restTemplate.getForObject(baseUrl + id, ProductDTO.class);
    }

    @Override
    public ProductDTO addProduct(ProductDTO product) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ProductDTO> request = new HttpEntity<>(product);
        return restTemplate.exchange(baseUrl, HttpMethod.POST, request, ProductDTO.class).getBody();
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO product) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<ProductDTO> requestUpdate = new HttpEntity<>(product, headers);
        return restTemplate.exchange(baseUrl + id, HttpMethod.PUT, requestUpdate, ProductDTO.class).getBody();
    }

    @Override
    public void deleteProduct(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        restTemplate.exchange(baseUrl + id, HttpMethod.DELETE, new HttpEntity<>(null, headers), ProductDTO.class).getBody();
    }

    @Override
    public List<String> getAllCategories() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Product> requestUpdate = new HttpEntity<>(null, headers);
        return List.of(Objects.requireNonNull(restTemplate.exchange(baseUrl + "categories", HttpMethod.GET, requestUpdate, String[].class).getBody()));
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String categoryName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Product> requestUpdate = new HttpEntity<>(null, headers);
        return List.of(Objects.requireNonNull(restTemplate.exchange(baseUrl + "category"+"/"+categoryName, HttpMethod.GET, requestUpdate, ProductDTO[].class).getBody()));
    }
}
