package refactoring.certification.mommy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import refactoring.certification.ILoveMommy;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ILoveMommyTest {

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        Object[][] data = new Object[][] {
                {null, null},
                {"", ""},
                {"b", "b"},
                {"a", "mommy"},
                {"ab", "mommyb"},
                {"aba", "mommybmommy"},
                {"hard", "hard"},
                {"haa", "hmommy"},
                {"aeioubAEIOU", "mommybmommy"},
        };

        return Arrays.asList(data);
    }

    private String input;
    private String result;

    public ILoveMommyTest(String input, String result) {
        this.input = input;
        this.result = result;
    }

    @Test
    public void should_return_correct_result() {
        ILoveMommy ILoveMommy = new ILoveMommy();

        assertEquals(result, ILoveMommy.transform(input));
    }
}
