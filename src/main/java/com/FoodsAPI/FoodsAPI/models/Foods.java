package com.FoodsAPI.FoodsAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Entity
public class Foods {

    private  @Id
    @GeneratedValue Long id;
    private String name;
    private Map<String, Double> nutrients = new HashMap<>();

    public Foods() {}

    public Foods(Long id, String name, Map<String, Double> nutrients) {
        this.id = id;
        this.name = name;
        this.nutrients = nutrients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getNutrients() {
        return nutrients;
    }

    public void setNutrients(Map<String, Double> nutrients) {
        this.nutrients = nutrients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Foods foods))
            return false;
        Foods foods1= (Foods) o;
        return Objects.equals(this.id, foods.id) && Objects.equals(this.name, foods.name)
                && Objects.equals(this.nutrients, foods.nutrients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getNutrients());
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + this.id + ", name='" + this.name + '\'' + ", nutrients='" + this.nutrients + '\'' + '}';
    }
}
