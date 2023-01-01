package seguro.policies;

import java.security.SecureRandom;

public class LowerCaseAllowed implements GeneratorPolicy {

    SecureRandom random = new SecureRandom();

    final static char[] charSet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @Override
    public char[] getCharSet() {
        return charSet;
    }

    @Override
    public char getRandomChar() {
       return charSet[random.nextInt(charSet.length)];
    }
    
}
