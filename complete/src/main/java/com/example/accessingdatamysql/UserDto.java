package com.example.accessingdatamysql;

import java.io.Serializable;
import java.util.Objects;

public class UserDto implements Serializable {
    private final Integer id;
    private String name;
    private String email;

    public UserDto(Integer id){
        this.id = id;
    }

    public UserDto(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email= email;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.email, entity.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return String.format("%s(id = %d, name = %s, email = %s)", getClass().getSimpleName(), id, name, email);
    }
}
