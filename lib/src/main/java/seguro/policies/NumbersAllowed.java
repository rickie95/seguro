package seguro.policies;

import java.security.SecureRandom;

public class NumbersAllowed implements GeneratorPolicy {

    SecureRandom random = new SecureRandom();

    private final static char[] charSet = "0123456789".toCharArray();

    @Override
    public char[] getCharSet() {
        return charSet;
    }

    @Override
    public char getRandomChar() {
        return charSet[random.nextInt(charSet.length)];
    }
    
}