import org.junit.jupiter.api.Test;
import org.suppor.p4_group_8_repo.application.suppor.controller.MyStageController;
import org.suppor.p4_group_8_repo.application.suppor.view.Digit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStageControllerTest {


    @Test
    void testSetNumberDisplaysCorrectDigits() {
        MyStageController controller = new MyStageController();

        // Set a number
        controller.setNumber(50);

        // Check if the digits are added correctly
        long digitCount = controller.getChildren().stream()
                .filter(node -> node instanceof Digit)
                .count();

        // Verify there are 3 digits (1, 2, 3)
        assertEquals(3, digitCount, "The number of digits should be 3.");
    }
}
