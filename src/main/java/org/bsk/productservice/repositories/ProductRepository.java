package org.bsk.productservice.repositories;

import org.bsk.productservice.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductDTO, Long> {

    @Query("select distinct category from ProductDTO")
    List<String> findAllCategories();

    @Query(value = "select * from ProductDTO where category = ?1", nativeQuery = true)
    List<ProductDTO> findAllProductsByCategory(String category);
}
