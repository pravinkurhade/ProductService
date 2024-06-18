package org.bsk.productservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.bsk.productservice.entity.Product;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private RatingDTO rating;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setCategory(category);
        product.setImage(image);
        product.setRating(rating);
        return product;
    }
}
