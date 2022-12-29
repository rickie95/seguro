package seguro;

import lombok.Getter;


@Getter
public class PasswordGeneratorConfig {
    
    private Boolean lowerCase;
    private Boolean upperCase;
    private Boolean symbols;
    private Boolean numbers;

    private PasswordGeneratorConfig() {}

    public static PasswordGeneratorConfig builder() {
        return new PasswordGeneratorConfig();
    }

    public static PasswordGeneratorConfig all() {
        return PasswordGeneratorConfig.builder()
        .allowLowerCase()
        .allowUpperCase()
        .allowNumbers()
        .allowSymbols();
    }

    public PasswordGeneratorConfig allowLowerCase() {
        lowerCase = true;
        return this;
    }

    public PasswordGeneratorConfig allowUpperCase() {
        upperCase = true;
        return this;
    }

    public PasswordGeneratorConfig allowNumbers() {
        numbers = true;
        return this;
    }

    public PasswordGeneratorConfig allowSymbols() {
        symbols = true;
        return this;
    }

}
