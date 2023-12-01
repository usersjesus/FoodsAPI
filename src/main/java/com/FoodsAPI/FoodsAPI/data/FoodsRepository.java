package com.FoodsAPI.FoodsAPI.data;

import com.FoodsAPI.FoodsAPI.models.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FoodsRepository extends JpaRepository<Foods, Long> {
}
