import javafx.application.Platform;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.suppor.p4_group_8_repo.application.suppor.controller.MyStageController;
import org.suppor.p4_group_8_repo.application.suppor.view.Digit;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTestControllerTest{

    @BeforeAll
    static void initJavaFX() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Platform.startup(latch::countDown);
        latch.await();
    }

    @Test
    void testSetNumberDisplaysCorrectDigits() {
        MyStageController controller = new MyStageController();

        // Use the rootPane directly for testing
        Pane pane = controller.getRootPane();
        controller.setNumber(123);

        long digitCount = pane.getChildren().stream()
                .filter(node -> node instanceof Digit)
                .count();

        assertEquals(3, digitCount, "The number of digits should be 3.");
    }
}
