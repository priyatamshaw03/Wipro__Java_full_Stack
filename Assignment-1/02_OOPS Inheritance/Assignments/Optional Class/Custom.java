import java.util.Optional;

class InvalidEmployeeException extends Exception {
    public InvalidEmployeeException(String message) {
        super(message);
    }
}

class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }
}

public class Custom {
    public static void main(String[] args) {
        Employee emp = new Employee("Kaustubh"); 

        try {
            Optional.ofNullable(emp)
                    .orElseThrow(() -> new InvalidEmployeeException("Employee object is null!"));
            System.out.println("Employee is valid: " + emp.name);
        } catch (InvalidEmployeeException e) {
            System.out.println(e.getMessage());
        }
    }
}