package com.example.practicaCDI.model;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@SessionScoped
public class Product implements Serializable {

    private Long id;
    private String name;
    private LocalDate registerDate;
    private Double price;

    private Category category;

}
