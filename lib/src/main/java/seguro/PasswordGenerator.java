package seguro;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.ArrayUtils;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PasswordGenerator {

    private final static char[] lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final static char[] uppercase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
    private final static char[] numbers = "0123456789".toCharArray();
    private final static char[] symbols = "$?!@#%&".toCharArray();

    private PasswordGeneratorConfig generatorConfiguration;
    private char[] charSet;
    private Random random;

    /**
     * Create an instance with all security policies enabled
     */
    public PasswordGenerator() {
        this(PasswordGeneratorConfig.all());
    }

    public PasswordGenerator(PasswordGeneratorConfig configuration) {
        random = new SecureRandom();
        this.generatorConfiguration = configuration;

        if (generatorConfiguration.getLowerCase()) {
            charSet = ArrayUtils.addAll(charSet, lowercase);
        }

        if (generatorConfiguration.getUpperCase()) {
            charSet = ArrayUtils.addAll(charSet, uppercase);
        }

        if (generatorConfiguration.getNumbers()) {
            charSet = ArrayUtils.addAll(charSet, numbers);
        }

        if (generatorConfiguration.getSymbols()) {
            charSet = ArrayUtils.addAll(charSet, symbols);
        }
    }

    public String generate(int length) {
        assert length > 0 : "Password length must be > 0";
        assert charSet.length > 0 : "Char set must be non empty. Did you provide a valid configuration?";

        // Generate a random string
        StringBuilder password = new StringBuilder();
        
        password.append(RandomStringUtils.random(
                length, 0, charSet.length - 1,
                true, true, charSet,
                random));

        StringBuilder builder = new StringBuilder();

        if (generatorConfiguration.getLowerCase()) {
            builder.append(lowercase[random.nextInt(lowercase.length)]);
        }

        if (generatorConfiguration.getUpperCase()) {
            builder.append(uppercase[random.nextInt(uppercase.length)]);
        }

        if (generatorConfiguration.getNumbers()) {
            builder.append(numbers[random.nextInt(numbers.length)]);
        }

        if (generatorConfiguration.getSymbols()) {
            builder.append(symbols[random.nextInt(symbols.length)]);
        }

        // choice builder.length numbers from password.length
        List<Integer> positions = IntStream.rangeClosed(0, password.length() - 1).boxed().collect(Collectors.toList());
        Collections.shuffle(positions, random);
        
        for (int i = 0; i < builder.toString().length(); i++) {
            password.setCharAt(positions.get(i), builder.charAt(i));
        }

        return password.toString();
    }

}
