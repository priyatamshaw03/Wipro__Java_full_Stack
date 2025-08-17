
/*
 * Q.3) Write a program to accept two integers as command line 
 * arguements and print sum of 2 numbers 
 */
class Solution3 {
    public static void main(String[] args) {
       
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int sum = a + b;
        System.out.println("The sum of " + a + " and " + b + " is " + sum);
    }
}