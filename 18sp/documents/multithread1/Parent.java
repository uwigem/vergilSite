public class Parent {
  public static void main(String[] args) throws InterruptedException {
    // Create the message
    int message = 42;
    
    // Start the child thread
    Child childThread = new Child(message);
    childThread.start();
    
    // Twiddle our thumbs
    for(int i=0; i < 5000; i++) {
      if (i % 1000 == 0) System.out.println(i);
    }
    
    // Print from the parent
    System.out.println("Hello from the parent");
  }
  
  public static class Child extends Thread {
    private int message;
    public Child(int message) {
      this.message = message;
    }
    
    /*THIS IS THE SPECIAL METHOD*/
    public void run() {
      // Print our message 
      System.out.println("Hello from the child: " + this.message);
    }
  }
}