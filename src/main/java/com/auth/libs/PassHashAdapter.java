package com.auth.libs;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PassHashAdapter {
  public static String hash(String password) {
    String hash = BCrypt.withDefaults().hashToString(12, password.toCharArray());
    return hash;
  }

  public static boolean isEqual(String hash, String password) {
    BCrypt.Result isEqual = BCrypt.verifyer().verify(password.toCharArray(), hash);
    return isEqual.verified;
  }
}
