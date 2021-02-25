package ru.itcrown.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Role extends AbstractModel{

    private String name;
    private String description;

    public Role(long id, String name, String description) {
        setId(id);
        this.name=name;
        this.description=description;
    }
}
