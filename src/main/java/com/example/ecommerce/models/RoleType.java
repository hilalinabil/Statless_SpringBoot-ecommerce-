package com.example.ecommerce.models;

public enum RoleType {
    ADMIN("Full system access"),
    USER("Standard user access"),
    MODERATOR("Moderation privileges"),
    GUEST("Limited access");
    private final String description;
    RoleType(String description) {
        this.description = description;
    }

}
