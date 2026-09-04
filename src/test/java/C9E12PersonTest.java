import io.github.bgptii.ch9inheritance.exercises.E9_12Instructor;
import io.github.bgptii.ch9inheritance.exercises.E9_12Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C9E12PersonTest {

    @Test
    void testStudentToString() {
        E9_12Student student = new E9_12Student("Rinkledink", 1875, "Runecraft");
        assertEquals("Student[name=Rinkledink, yearOfBirth=1875, major=Runecraft]", student.toString());
    }

    @Test
    void testInstructorToString() {
        E9_12Instructor instructor = new E9_12Instructor("Oueh", 1800, 9999999);
        assertEquals("Instructor[name=Oueh, yearOfBirth=1800, salary=9999999.0]", instructor.toString());
    }

}
