package jenkins.plugins.office365connector;

import java.util.List;

import jenkins.plugins.office365connector.model.Fact;
import org.assertj.core.api.Assertions;

/**
 * @author Damian Szczepanik (damianszczepanik@github)
 */
public class FactAssertion {

    private Fact fact;

    private FactAssertion(Fact fact) {
        this.fact = fact;
    }

    public static FactAssertion assertThat(FactsBuilder factsBuilder) {
        return assertThat(factsBuilder.collect());
    }

    public static FactAssertion assertThat(List<Fact> facts) {
        Assertions.assertThat(facts).hasSize(1);
        return new FactAssertion(facts.get(0));
    }

    public static FactAssertion assertThatLast(List<Fact> facts, int size) {
        Assertions.assertThat(facts).hasSize(size);
        return new FactAssertion(facts.get(size - 1));
    }

    public FactAssertion hasName(String name) {
        Assertions.assertThat(fact.getName()).isEqualTo(name);
        return this;
    }

    public FactAssertion hasValue(String value) {
        Assertions.assertThat(fact.getValue()).isEqualTo(value);
        return this;
    }
}
