package ru.itcrown.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@Data
public class User extends AbstractModel{

    private String username;


    private String password;

    private Date birthday;

    private String address;

    private String description;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private Collection<Role> roles = new ArrayList<>();

    public User(Long id, String username, String password, Date birthday, String address, String description, String firstName, String lastName, String email, String phone) {
        setId(id);
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.address = address;
        this.description = description;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public void addRole(Role role) {
    }

    public void removeRole(Role role) {
    }
}
