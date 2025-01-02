import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.suppor.p4_group_8_repo.application.suppor.model.Animal;
import org.suppor.p4_group_8_repo.application.suppor.model.Obstacle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalTest {
    private Animal animal;
    private Obstacle obstacle;

    @BeforeEach
    void setUp() {
        animal = new Animal("/images/frogger/froggerUp.png");
        obstacle = new Obstacle("/images/car/cardeath1.png", 100, 200, 60, 40,120);
    }

    @Test
    void testDetectCollision() {
        // Position the obstacle to collide with the animal
        animal.setX(100);
        animal.setY(200);
        obstacle.setX(100);
        obstacle.setY(200);

        // Expect a collision
        assertTrue(animal.detectCollision(obstacle), "Animal should collide with the obstacle");

        // Move obstacle away from the animal
        obstacle.setX(300);
        obstacle.setY(400);

        // Expect no collision
        assertFalse(animal.detectCollision(obstacle), "Animal should not collide with the obstacle");
    }

}
