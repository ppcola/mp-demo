package com.example.mp.entity;

import lombok.Data;

/**
 * @author xi
 * @create 2024/4/2 12:15
 */
@Data
public class ProductVo {
    private Integer category;
    private Integer count;
    private String description;
    private Integer userId;
    private String name;
}
