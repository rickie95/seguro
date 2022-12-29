package seguro;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.ArrayUtils;
import java.security.SecureRandom;
import java.util.Random;

import java.io.*;

public class PasswordGenerator {

    private final static char[] lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final static char[] uppercase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
    private final static char[] numbers = "0123456789".toCharArray();
    private final static char[] symbols = "$?!@#%&".toCharArray();

    private final static char[] charSet = ArrayUtils.addAll(lowercase, uppercase);

    private static Random random;

    public PasswordGenerator() {
        random = new SecureRandom();
    }

    public String generate(int length) {

        assert length > 0 : "Passoword length must be > 0";

        // Generate a random string
        String password = RandomStringUtils.random(length, 0, charSet.length - 1, true, true, charSet, random);
        
        System.out.println("Password: " + password);
        return password;
    }

}
