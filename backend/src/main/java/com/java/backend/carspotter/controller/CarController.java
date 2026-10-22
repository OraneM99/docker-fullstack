package com.java.backend.carspotter.controller;

import com.java.backend.carspotter.domain.Car;
import com.java.backend.carspotter.repository.CarRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "*")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public Flux<Car> getAll() {
        return carRepository.findAll();
    }

    @PostMapping
    public Mono<Car> create(@RequestBody Car car) {
        return carRepository.save(car);
    }
}