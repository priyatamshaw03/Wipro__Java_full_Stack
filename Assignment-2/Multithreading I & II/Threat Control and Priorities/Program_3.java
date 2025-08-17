public class Program_3{

    public static void main(String[] args) {

        // Runnable task to be executed by the threads
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is running: " + i);
                try {
                    Thread.sleep(100); // Small delay to make output observable
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Create the three threads
        Thread minPriorityThread = new Thread(task, "Min-Priority-Thread");
        Thread normPriorityThread = new Thread(task, "Norm-Priority-Thread");
        Thread maxPriorityThread = new Thread(task, "Max-Priority-Thread");

        // Set the priorities
        minPriorityThread.setPriority(Thread.MIN_PRIORITY);
        normPriorityThread.setPriority(Thread.NORM_PRIORITY);
        maxPriorityThread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Starting threads with different priorities...");
        
        // Start all threads simultaneously
        minPriorityThread.start();
        normPriorityThread.start();
        maxPriorityThread.start();
        
        // The main thread can wait for all of them to finish
        try {
            minPriorityThread.join();
            normPriorityThread.join();
            maxPriorityThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have completed execution.");
    }
}