
/*
 * Q.2) Write a program to check if a given integer number is odd or even
 */
public class Solution2 {
    public static void main(String[] args) {
        
        int a = Integer.parseInt(args[0]);

        if (a % 2 == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
        
    }
}