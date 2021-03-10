package ru.itcrown.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class Usluga extends AbstractModel{

    private String name;
    private BigDecimal price;

    public Usluga(Long id, String name, BigDecimal price) {
        setId(id);
        this.name = name;
        this.price = price;
    }
}
