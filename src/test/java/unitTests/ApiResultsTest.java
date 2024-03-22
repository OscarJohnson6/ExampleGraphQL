package unitTests;

import example.graphql.api.AdvExerciseFinder;
import org.testng.annotations.Test;
import example.graphql.pojo.AdvExerciseResult;
import example.graphql.pojo.Data;
import example.graphql.pojo.ExercisesItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Api results test.
 */
public class ApiResultsTest {

    /**
     *
     */
    @Test
    void testAPIResults() {
        AdvExerciseFinder advExerciseApi = new AdvExerciseFinder();
        AdvExerciseResult results = advExerciseApi.createApiResponse();

        assertNotNull(results);

        Data data = results.getData();
        List<ExercisesItem> resultItems = data.getExercises();

        // Exercise list tests
        assertNotNull(resultItems);
        assertFalse(resultItems.isEmpty());
        assertEquals(12, resultItems.size());

        // Exercise values/object test
        ExercisesItem exercise0 = resultItems.get(0);

        assertEquals("cable crunch", exercise0.getName());
        assertEquals("dynamic", exercise0.getMovement());
        assertEquals("pull", exercise0.getForce());
        assertEquals("isolation", exercise0.getType());

        String instructions = "Set up underneath a high cable with a rope attachment. "
                            + "Hold the rope attachment either beside your neck, or "
                            + "diretly over your head. Assume a kneeling position, "
                            + "facing away from the cable machine. Start with your "
                            + "torso upright, and crunch your torso downwards as much "
                            + "as possible, making sure you do not move the cable attachment. "
                            + "Return your torso position to its starting upright position.";
        assertEquals(instructions, exercise0.getInstructions());

        List<String> primaryMuscles = new ArrayList<>();
        primaryMuscles.add("rectus abdominis");
        assertEquals(primaryMuscles, exercise0.getPrimaryMuscles());
    }
}
