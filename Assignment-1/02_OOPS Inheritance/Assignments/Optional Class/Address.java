import java.util.Optional;
public class Address {
    public static void main(String[] args) {
        String address = "Mumbai";  

        String result = Optional.ofNullable(address).orElse("India");
        System.out.println(result);
    }
}