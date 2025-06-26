package com.sibirajen.Todo.List.API.util;

import org.mindrot.jbcrypt.BCrypt;

public class Hash {
    public static String generate(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public static boolean checkPassword(String password, String storedPassword){
        return BCrypt.checkpw(password, storedPassword);
    }
}
