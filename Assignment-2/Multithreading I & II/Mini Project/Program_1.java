import java.util.concurrent.atomic.AtomicBoolean;

class Racer implements Runnable {
    private String name;
    // Using volatile to ensure visibility of changes across threads
    private volatile int distance;
    private final AtomicBoolean isInterrupted;

    public Racer(String name, AtomicBoolean isInterrupted) {
        this.name = name;
        this.distance = 0;
        this.isInterrupted = isInterrupted;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " has started the race!");
            
            // The race is 100 meters long
            while (distance < 100) {
                // Check if this thread has been interrupted by the winner
                if (isInterrupted.get()) {
                    System.out.println(name + " has been interrupted and stops.");
                    return;
                }

                distance++;
                System.out.println(name + " has run " + distance + " meters.");

                // Part c: Hare sleeps after 60 meters
                if (distance == 60 && name.equals("Hare")) {
                    System.out.println("Hare is taking a nap for 1000 milliseconds...");
                    Thread.sleep(1000);
                }

                // Simulate the speed. Hare is faster (no sleep or smaller sleep)
                // Tortoise is slower (longer sleep)
                if (name.equals("Tortoise")) {
                    Thread.sleep(50); // Tortoise runs slower
                } else {
                    Thread.sleep(10); // Hare runs faster
                }
            }
        } catch (InterruptedException e) {
            // This is how the thread gracefully handles the interrupt
            System.out.println(name + " was interrupted and stopped.");
        }
    }
}

public class Program_1 {

    public static void main(String[] args) {
        
        // This flag helps to coordinate the winner
        AtomicBoolean raceOver = new AtomicBoolean(false);
        
        // Create the runnable tasks for the two racers
        Racer hareRacer = new Racer("Hare", raceOver);
        Racer tortoiseRacer = new Racer("Tortoise", raceOver);

        // Create the threads
        Thread hareThread = new Thread(hareRacer);
        Thread tortoiseThread = new Thread(tortoiseRacer);

        // Part b: Set priorities
        hareThread.setPriority(Thread.MAX_PRIORITY);
        tortoiseThread.setPriority(Thread.MIN_PRIORITY);
        
        System.out.println("Starting the Hare and Tortoise Race!");
        System.out.println("Hare Priority: " + hareThread.getPriority());
        System.out.println("Tortoise Priority: " + tortoiseThread.getPriority());

        // Start both threads
        hareThread.start();
        tortoiseThread.start();

        // Main thread waits and checks for the winner
        while (true) {
            if (hareRacer.getDistance() >= 100) {
                System.out.println("The Hare wins the race!");
                raceOver.set(true); // Signal other threads to stop
                break;
            }
            if (tortoiseRacer.getDistance() >= 100) {
                System.out.println("The Tortoise wins the race!");
                raceOver.set(true); // Signal other threads to stop
                break;
            }
            
            // Wait for a short period to avoid busy-waiting
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Wait for the other thread to terminate gracefully
        try {
            hareThread.join();
            tortoiseThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("The race is over. Final distances:");
        System.out.println("Hare: " + hareRacer.getDistance() + " meters.");
        System.out.println("Tortoise: " + tortoiseRacer.getDistance() + " meters.");
    }
}