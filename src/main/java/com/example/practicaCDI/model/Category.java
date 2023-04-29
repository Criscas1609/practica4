package com.example.practicaCDI.model;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.SessionScoped;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@SessionScoped
public class Category implements Serializable {

    private Long id;
    private String name;

}
