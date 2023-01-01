package seguro;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seguro.policies.GeneratorPolicy;
import seguro.policies.LowerCaseAllowed;

public class PasswordGeneratorConfigTest {

    PasswordGeneratorConfig config;

    @BeforeEach
    public void setup() {
        config = new PasswordGeneratorConfig();
    }

    // Constructor

    @Test
    public void Constructor_ShouldInitializePolicyListAsEmpty() {
        assertThat(config.getPolicyList()).isEmpty();
    }
    
    @Test
    public void AddPolicy_ShouldIncludeAPolicyInPoliciesList(){

        GeneratorPolicy policy = new LowerCaseAllowed();
        
        config.withPolicy(policy);

        List<GeneratorPolicy> policies = config.getPolicyList();

        assertThat(policies).containsOnly(policy);
    }

    @Test
    public void AddPolicy_ShouldReturnTheObjReference() {
        PasswordGeneratorConfig pc = config.withPolicy(new LowerCaseAllowed());

        assertThat(pc).isEqualTo(config);
    }

    
    public void AddPolicy_ShouldAddOnlyDistinctPolicies(){

        GeneratorPolicy policy = new LowerCaseAllowed();
        
        config.withPolicy(policy);
        config.withPolicy(new LowerCaseAllowed());

        List<GeneratorPolicy> policies = config.getPolicyList();

        assertThat(policies).hasSize(1);
    }

}
