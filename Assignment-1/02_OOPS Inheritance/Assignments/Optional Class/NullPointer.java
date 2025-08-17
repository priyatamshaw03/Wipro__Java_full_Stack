import java.util.Optional;

public class NullPointer {
    public static void main(String[] args) {
        String names[] = new String[5];
        names[0] = "Kaustubh";
        Optional<String> name = Optional.ofNullable(names[0]);
        int length = name.map(String::length).orElse(0);
        
        System.out.println(length);
    }
}