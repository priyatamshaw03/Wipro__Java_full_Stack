
/*
 * Q.1) A] Write a program to check if a given integer number is positive,
 * negative, or zero.   
 */
class Solution1A {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n > 0) {
            System.out.println("Positive number");
        } else if (n < 0) {
            System.out.println("Negative number");
        } else {
            System.out.println("Zero");
        }
        
    }

}

/*
 * Q.1) B] Given two non-negative int values , print true if they have the same
 * last digit, such as with 27 and 57
 */
class Solution1B {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        if (x%10 == y%10){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
}
