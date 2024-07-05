package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "list", name = "t_users")
@NamedQueries(
        @NamedQuery(
                name = "User.FindUser",
                query = "SELECT u FROM User u WHERE u.name like :name"
        )
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(nullable = false, name = "c_name")
    String name;
    @Column(name = "c_email")
    String email;
    @Column(name = "c_age")
    Integer age;
}
