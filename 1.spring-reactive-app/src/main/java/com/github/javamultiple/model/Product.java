package com.github.javamultiple.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * @author Rohit Agarwal on 24/04/22 10:20 PM
 * @copyright github.com/javamultiplex
 */
@Getter
@Setter
public class Product {
    @Id
    private int id;
    private String name;
}
