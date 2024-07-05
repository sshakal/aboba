package com.example.demo.Entity.Payloads;


import jakarta.validation.constraints.*;

public record UserPayload(
        @NotNull(message = "qwewe")
        @Size(min = 2, max = 50, message = "{errors.create.name_null}")
        String name,
        @NotEmpty(message = "dfghjk")
        @Email(message = "{errors.create.email_null}")
        @Size(min = 5, max = 100, message = "Email must be between 5 and 50 characters")
        String email,
        @NotNull(message = "Age is null")
        @Min(value = 18, message = "Age must be greater than 18 ")
        Integer age) {
}
