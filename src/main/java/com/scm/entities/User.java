package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String userId;

    @Column(name="user_name", nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;
    private String password;

    @Column(length = 65535)
    private String about;

    @Column(length = 65535)
    private String profilePic;
    private String phoneNumber;
    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    //Signed up : self, google, github
    private Providers provider= Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();

    
}
