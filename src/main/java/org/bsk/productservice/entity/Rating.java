package org.bsk.productservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Rating {
    private Long id;
    private double rate;
    private int count;

    public Rating(Long id, double rate, int count) {
        this.id = id;
        this.rate = rate;
        this.count = count;
    }
}
