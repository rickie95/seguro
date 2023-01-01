package seguro;

import org.apache.commons.lang3.RandomStringUtils;

import seguro.policies.GeneratorPolicy;

import org.apache.commons.lang3.ArrayUtils;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PasswordGenerator {

    private PasswordGeneratorConfig generatorConfiguration;
    private char[] charSet;
    private Random random;

    public PasswordGenerator(PasswordGeneratorConfig configuration) {
        random = new SecureRandom();
        this.generatorConfiguration = configuration;

        for (GeneratorPolicy p : configuration.getPolicyList()) {
            charSet = ArrayUtils.addAll(charSet, p.getCharSet());
        }

    }

    public String generate(int length) {
        assert length > 0 : "Password length must be > 0";
        assert charSet != null : "Char set not available, add at least one policy in your configuration.";
        assert charSet.length > 0 : "Char set must be non empty. Did you provide a valid configuration?";

        // Generate a random string
        StringBuilder password = new StringBuilder();
        
        password.append(RandomStringUtils.random(
                length, 0, charSet.length - 1,
                true, true, charSet,
                random));

        StringBuilder builder = new StringBuilder();

        for (GeneratorPolicy p : generatorConfiguration.getPolicyList()){
            builder.append(p.getRandomChar());
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
