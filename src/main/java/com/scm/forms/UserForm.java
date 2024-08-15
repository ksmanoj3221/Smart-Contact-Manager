package com.scm.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserForm {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String about;

    @Override
    public String toString() {
    return "UserForm{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", about='" + about + '\'' +
            '}';
    }

}
