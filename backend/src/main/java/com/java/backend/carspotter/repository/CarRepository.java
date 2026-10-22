package com.java.backend.carspotter.repository;

import com.java.backend.carspotter.domain.Car;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CarRepository extends ReactiveCrudRepository<Car, Long> {
}