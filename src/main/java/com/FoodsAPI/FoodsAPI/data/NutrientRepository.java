package com.FoodsAPI.FoodsAPI.data;

import com.FoodsAPI.FoodsAPI.models.Foods;
import com.FoodsAPI.FoodsAPI.models.Nutrients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutrientRepository extends JpaRepository<Nutrients, Long> {

}
