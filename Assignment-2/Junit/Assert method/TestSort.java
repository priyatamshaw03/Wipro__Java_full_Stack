import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.util.Arrays;

public class TestSort {

    // Method to sort values
    public int[] sortValues(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        return sorted;
    }

    @Test
    public void testSortValues() {
        int[] input = {5, 3, 8, 1, 2};
        int[] expected = {1, 2, 3, 5, 8};

        assertArrayEquals(expected, sortValues(input));
    }
}
