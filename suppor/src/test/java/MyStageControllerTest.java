import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.suppor.p4_group_8_repo.application.suppor.controller.MyStageController;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStageControllerTest extends ApplicationTest {

    private Pane root;

    @Override
    public void start(Stage stage) {
        root = new Pane();
        stage.setScene(new Scene(root));
        stage.show();
    }


    @Test
    void testSetNumberDisplaysCorrectDigits() {
        MyStageController controller = new MyStageController();
        controller.setNumber(123);

        long digitCount = root.getChildren().stream()
                .filter(node -> node instanceof Node) // Replace Node with your specific type, e.g., Label or Digit
                .count();

        assertEquals(3, digitCount, "The number of digits should be 3.");
    }
}
