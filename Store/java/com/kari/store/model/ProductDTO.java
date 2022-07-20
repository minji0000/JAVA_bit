package com.kari.store.model;

import lombok.Data;

import java.util.Calendar;

@Data
public class ProductDTO {

    private int id;
    private int sellerId;
    private String name;
    private int kind;
    private int price;
    private String content;
    private String imageFileName;
    private Calendar regdate;

    public boolean equals(Object o) {
        if(o instanceof ProductDTO) {
            ProductDTO p = (ProductDTO) o;
            return id == p.id;
        }
        return false;
    }





}
