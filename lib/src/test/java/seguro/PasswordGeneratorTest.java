package seguro;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


class PasswordGeneratorTest {

    private PasswordGenerator passwordGenerator;

    @BeforeEach
    public void setup() {
        passwordGenerator = new PasswordGenerator();
    }
    
    @Test
    public void testPasswordGenerator() {
        String password = passwordGenerator.generate(20);


        assert password != null;
        assert password.length() == 20;
    }
}
