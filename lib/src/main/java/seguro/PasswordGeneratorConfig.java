package seguro;

import org.lombok.Getters;

@Getters
public class PasswordGeneratorConfig {
    
    private Boolean lowerCase;
    private Boolean upperCase;
    private Boolean symbols;
    private Boolean numbers;

    public static PasswordGeneratorConfig builder() {
        return PasswordGeneratorConfig();
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
