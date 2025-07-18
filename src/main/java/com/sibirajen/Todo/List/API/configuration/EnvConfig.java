package com.sibirajen.Todo.List.API.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

@Component
public class EnvConfig {
    private static final Dotenv dotenv = Dotenv.load();

    public static String get(String key) {
        return dotenv.get(key);
    }
}

