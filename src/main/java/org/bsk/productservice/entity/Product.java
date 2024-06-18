package org.bsk.productservice.entity;

import lombok.Getter;
import lombok.Setter;
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
    private RatingDTO rating;
}
