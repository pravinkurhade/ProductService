package org.bsk.productservice.repositories;

import org.bsk.productservice.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductDTO, Long> {

    @Query("select distinct category from ProductDTO")
    List<String> findAllCategories();

    @Query("select P from ProductDTO P where P.category = :category")
    List<ProductDTO> findAllProductsByCategory(String category);
}
