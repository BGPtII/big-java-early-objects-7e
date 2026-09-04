import io.github.bgptii.ch9inheritance.exercises.E9_1Manager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C9E1ManagerTest {

    @Test
    void testManagerSalaryIncludesBonus() {
        E9_1Manager manager = new E9_1Manager("Bingledorf", 32000, 3500);
        assertEquals(35500, manager.getSalary());
    }

    @Test
    void testManagerName() {
        E9_1Manager manager = new E9_1Manager("Finkle", 999999, 1);
        assertEquals("Finkle", manager.getName());
    }

}
