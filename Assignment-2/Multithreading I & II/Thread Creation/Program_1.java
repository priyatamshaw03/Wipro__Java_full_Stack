public class Program_1 {
    public static void main(String[] args) {
        
        // Create the first thread and assign the name "Scooby"
        Thread t1 = new Thread("Scooby") {
            @Override
            public void run() {
                System.out.println("Thread 1 is running. Name: " + Thread.currentThread().getName());
            }
        };

        // Create the second thread and assign the name "Shaggy"
        Thread t2 = new Thread("Shaggy") {
            @Override
            public void run() {
                System.out.println("Thread 2 is running. Name: " + Thread.currentThread().getName());
            }
        };
        
        // Start both threads
        t1.start();
        t2.start();
        
        // Wait for the threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // You can also display the names from the main thread
        System.out.println("Main thread is done.");
    }
}