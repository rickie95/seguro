package seguro;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import seguro.policies.LowerCaseAllowed;

import org.junit.jupiter.api.BeforeEach;


class PasswordGeneratorTest {

    private PasswordGenerator passwordGenerator;

    @BeforeEach
    public void setup() {
        passwordGenerator = new PasswordGenerator(
            new PasswordGeneratorConfig()
                .withPolicy(new LowerCaseAllowed())
            );
    }

    @Test
    public void GeneratePasswordWithLengthZero_ShouldThrowAssertionException() {
        assertThatThrownBy(() -> passwordGenerator.generate(0)).isInstanceOf(AssertionError.class);
    }

    @Test
    public void GeneratePasswordWithAnEmptyConfiguration_ShouldThrowAssertionException() {
        passwordGenerator = new PasswordGenerator(new PasswordGeneratorConfig());
        assertThatThrownBy(() -> passwordGenerator.generate(30)).isInstanceOf(AssertionError.class);
    }
    
    @Test
    public void GeneratePassword_ShouldProduceAValidPassword() {
        String password = passwordGenerator.generate(20);

        assertThat(password).isNotNull();
        assertThat(password.length()).isEqualTo(20);
    }
}
