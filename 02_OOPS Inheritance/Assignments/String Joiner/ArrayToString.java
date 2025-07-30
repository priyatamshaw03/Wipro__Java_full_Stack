import java.util.ArrayList;
import java.util.StringJoiner;

public class ArrayToString {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        StringJoiner joiner = new StringJoiner(",", "{", "}");
        for (String name : names) {
            joiner.add(name);
        }

        System.out.println(joiner);
    }
}