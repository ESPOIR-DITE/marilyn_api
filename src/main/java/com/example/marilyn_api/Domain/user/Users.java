package com.example.marilyn_api.Domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Users {
    @Id
    private String email;
    private String name;
    private String surname;
    private Date dateOfBirth;

    private Users() {
    }
    public  Users(Builder builder) {
        this.email=builder.email;
        this.name = builder.name;
        this.dateOfBirth = builder.dateOfBirth;
        this.surname = builder.surname;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public static class Builder {
        private String email;
        private String name;
        private String surname;
        private Date dateOfBirth;
        public Builder(String email){
            this.email = email;
        }
        public Builder buildName(String name){
            this.name = name;
            return this;
        }
        public Builder buildSurname(String surname){
            this.surname = surname;
            return this;
        }
        public Builder buildDateOfBirth(Date dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
        }
        public Users build(){
            return new Users(this);
        }
    }
}
