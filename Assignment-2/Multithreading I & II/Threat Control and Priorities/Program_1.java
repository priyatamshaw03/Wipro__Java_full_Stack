public class Program_1 {

    public static void main(String[] args) {
        
        // Create a new thread using a lambda expression for simplicity
        Thread numberThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                
                // Check if the current number is 5
                if (i == 5) {
                    System.out.println("Delaying for 5000 milliseconds...");
                    try {
                        // Pause the thread for 5 seconds
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        
        // Start the thread
        numberThread.start();
    }
}