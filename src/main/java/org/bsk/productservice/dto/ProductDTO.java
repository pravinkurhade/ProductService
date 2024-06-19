package org.bsk.productservice.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bsk.productservice.entity.Product;
import org.bsk.productservice.entity.Rating;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ProductDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    @ManyToOne(cascade = CascadeType.ALL)
    private RatingDTO rating;

    public Product toProduct() {
        Rating ratingObj = new Rating(rating.getId(),rating.getRate(),rating.getCount());
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setCategory(category);
        product.setImage(image);
        product.setRating(ratingObj);
        return product;
    }
}
