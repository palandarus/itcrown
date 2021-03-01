package ru.itcrown.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
public class Usluga extends AbstractModel{

    private String name;
    private BigDecimal price;

    public Usluga(Long id, String name, BigDecimal price) {
        setId(id);
        this.name = name;
        this.price = price;
    }
}
