package com.auth.libs;

import org.mindrot.jbcrypt.BCrypt;

public class PassHash {
  public static String hash(String password, String salt) {
    return BCrypt.hashpw(password, salt);
  }

  public static boolean isEqual(String hash, String password) {
    return BCrypt.checkpw(hash, password);
  }
}
