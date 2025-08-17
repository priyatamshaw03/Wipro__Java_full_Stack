import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import java.util.Arrays;

public class TestCheckPresence {

    // Method to sort values
    public int[] sortValues(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        return sorted;
    }

    // Method to check if a value is present
    public boolean isValuePresent(int[] arr, int value) {
        for (int num : arr) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testValuePresence() {
        int[] sortedArray = sortValues(new int[]{5, 3, 8, 1, 2});

        assertTrue(isValuePresent(sortedArray, 3));   // Should be true
        assertFalse(isValuePresent(sortedArray, 10)); // Should be false
    }
}
