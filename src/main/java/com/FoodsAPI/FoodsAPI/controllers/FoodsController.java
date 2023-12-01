package com.FoodsAPI.FoodsAPI.controllers;

import java.util.List;

import com.FoodsAPI.FoodsAPI.FoodsNotFoundException;
import com.FoodsAPI.FoodsAPI.data.FoodsRepository;
import com.FoodsAPI.FoodsAPI.models.Foods;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class FoodsController {

    private final FoodsRepository repository;

    FoodsController(FoodsRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/foods")
    List<Foods> all() {
        return repository.findAll();
    }


    @PostMapping("/foods")
    Foods newFoods(@RequestBody Foods newFoods) {
        return repository.save(newFoods);
    }


    @GetMapping("/foods/{id}")
    Foods one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new FoodsNotFoundException(id));
    }

    @PutMapping("/foods/{id}")
    Foods replaceFoods(@RequestBody Foods newFoods, @PathVariable Long id) {

        return repository.findById(id)
                .map(food -> {
                    food.setName(newFoods.getName());
                    food.setNutrients(newFoods.getNutrients());
                    return repository.save(food);
                })
                .orElseGet(() -> {
                    newFoods.setId(id);
                    return repository.save(newFoods);
                });
    }

    @DeleteMapping("/foods/{id}")
    void deleteFoods(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

