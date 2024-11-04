package com.webservices.Model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(unique = true, nullable = false, name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, name="name")
    private String name;
    private String email;
    private String phone;
    private String password;
}
