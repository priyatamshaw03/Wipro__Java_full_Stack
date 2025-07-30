
/*
 * Q.2) Write a program to accept a string as a command line arugment and print a welcome message as given below
 * java Sample John 
 * Output: Welcome John
 */
class Solution2 {
    public static void main(String[] args) {
        String name = args[0];
        System.out.println("Welcome " + name );
    }
}
