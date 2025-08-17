import java.util.Random;

public class Program_2 implements Runnable {

    // Define the color array
    private static final String[] colours = {"white", "blue", "black", "green", "red", "yellow"};

    @Override
    public void run() {
        Random random = new Random();
        boolean stop = false;

        while (!stop) {
            // Generate a random index
            int randomIndex = random.nextInt(colours.length);
            
            // Get the color at the random index
            String selectedColour = colours[randomIndex];

            System.out.println(Thread.currentThread().getName() + " is displaying color: " + selectedColour);

            // Check if the selected color is "red"
            if (selectedColour.equals("red")) {
                System.out.println(Thread.currentThread().getName() + " found 'red'. Stopping the display.");
                stop = true;
            }

            // Pause the thread for a moment
            try {
                Thread.sleep(500); // Wait for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Create a new thread by passing an instance of RandomColorDisplay (which is a Runnable)
        Thread colorThread = new Thread(new Program_2(), "Color-Picker-Thread");
        
        // Start the thread
        colorThread.start();
        
        System.out.println("Main thread is finished. The color thread is running.");
    }
}