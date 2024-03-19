package com.example.bb.utils;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.nio.charset.Charset;

/**
 * @classname: com.example.bb.utils
 * @author: wn
 * @date: 20:18
 * @describe:
 */
public class ArgonUtil {
    private volatile static Argon2 argon2;

    private ArgonUtil() {}

    public static Argon2 getArgon2() {
        if (argon2 == null) {
            synchronized (ArgonUtil.class) {
                if (argon2 == null) {
                    argon2 = Argon2Factory.create();
                }
            }
        }
        return argon2;
    }

    public static String encode(String origin) {
        return encode(10, 65536, 1, origin, Charset.defaultCharset());
    }

    public static String encode(int iterations, int memory, int parallelism, String origin, Charset charset) {
        return getArgon2().hash(iterations, memory, parallelism, origin.toCharArray(), charset);
    }

    public static boolean verify(String input, String hashed) {
        return getArgon2().verify(hashed, input.toCharArray());
    }
}
