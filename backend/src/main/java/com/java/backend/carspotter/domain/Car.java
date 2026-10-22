package com.java.backend.carspotter.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("car")
public record Car(
        @Id Long id,
        String brand,
        String model
) {
}
