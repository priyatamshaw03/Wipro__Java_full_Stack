public class Pr {

    public static void main(String[] args) {

        // Thread to display even numbers
        Thread evenThread = new Thread(() -> {
            System.out.println("Even Numbers:");
            for (int i = 2; i <= 20; i += 2) {
                System.out.print(i + " ");
            }
            System.out.println();
        });

        // Thread to display odd numbers
        Thread oddThread = new Thread(() -> {
            System.out.println("Odd Numbers:");
            for (int i = 1; i <= 19; i += 2) {
                System.out.print(i + " ");
            }
            System.out.println();
        });
        
        // Start the even thread first
        evenThread.start();
        
        // Use join() to wait for the even thread to finish
        try {
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start the odd thread after the even thread has completed
        oddThread.start();
    }
}