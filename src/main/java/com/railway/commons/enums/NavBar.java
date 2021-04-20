package com.railway.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NavBar {
    HOME("Home"),
    REGISTER("Register"),
    LOGIN("Login");

    private final String name;
}
