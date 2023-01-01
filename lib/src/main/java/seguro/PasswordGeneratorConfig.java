package seguro;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import seguro.policies.GeneratorPolicy;


@Getter
public class PasswordGeneratorConfig {

    private List<GeneratorPolicy> policyList;

    public PasswordGeneratorConfig() {
        policyList = new ArrayList<>();
    }

    public PasswordGeneratorConfig withPolicy(GeneratorPolicy policy) {
        policyList.add(policy);
        return this;
    }

}
