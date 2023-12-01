package com.FoodsAPI.FoodsAPI;

public class FoodsNotFoundException extends RuntimeException{

    public FoodsNotFoundException (Long id) {
        super("Could not find food " + id);
    }
}
