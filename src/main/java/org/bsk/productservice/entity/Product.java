package org.bsk.productservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.bsk.productservice.dto.ProductDTO;
import org.bsk.productservice.dto.RatingDTO;


@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    public ProductDTO toProductDto() {
        RatingDTO ratingObj = new RatingDTO(rating.getId(),rating.getRate(),rating.getCount());
        ProductDTO product = new ProductDTO();
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setCategory(category);
        product.setImage(image);
        product.setRating(ratingObj);
        return product;
    }
}
