package com.example.ecommerce.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3-50 character")
    @Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "Username can only contain letters, numbers and underscores")
    private String username;

    @Column( nullable = false, unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @Column (nullable = false)
    private String password;

    @Column (name ="first_name", length = 50)
    private String firstName;

    @Column(name= "last_name", length = 50)
    private String lastName;

    @Column(name="profile_picture_url")
    private String profilePictureUrl;

    @Column(name= "phone_number", length = 30)
    private String phoneNumber;

    @Column(name = "is_enabeled", nullable = false)
    private Boolean enabled = true;


}
