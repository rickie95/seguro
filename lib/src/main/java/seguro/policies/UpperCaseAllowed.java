package seguro.policies;

import java.security.SecureRandom;

public class UpperCaseAllowed implements GeneratorPolicy {

    SecureRandom random = new SecureRandom();

    private final static char[] charSet = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();

    @Override
    public char[] getCharSet() {
        return charSet;
    }

    @Override
    public char getRandomChar() {
        return charSet[random.nextInt(charSet.length)];
    }
    
}
