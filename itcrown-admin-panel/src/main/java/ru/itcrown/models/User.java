package ru.itcrown.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User extends AbstractModel{

    private String username;

    private boolean enabled;

    private String password;

    private Date birthday;

    private String address;

    private String description;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private Collection<Role> roles = new ArrayList<>();

}
