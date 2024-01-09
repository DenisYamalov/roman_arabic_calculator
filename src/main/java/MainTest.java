import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    @DisplayName("Check operations")
    void calc() {
        assertEquals("3", Main.calc("1+2"));
        assertEquals("II", Main.calc("VI / III"));
        assertEquals("3", Main.calc("7 / 2"));
        assertEquals("-3", Main.calc("1 - 4"));
        assertEquals("0", Main.calc("1 - 1"));
    }

    @Test
    @DisplayName("Check exceptions")
    void checkExceptions() {
        Assertions.assertThrows(CalulatorException.class, () -> {
            Main.calc("I - II");
        });

        Assertions.assertThrows(CalulatorException.class, () -> {
            Main.calc("I + 1");
        });

        Assertions.assertThrows(CalulatorException.class, () -> {
            Main.calc("1");
        });

        Assertions.assertThrows(CalulatorException.class, () -> {
            Main.calc("1 + 2 + 3");
        });

        Assertions.assertThrows(CalulatorException.class, () -> {
            Main.calc("1 + 2.3");
        });

        Assertions.assertThrows(CalulatorException.class, () -> {
            Main.calc("I - I");
        });

    }
}