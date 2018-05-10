import java.util.Random;
import java.math.BigInteger;

public class MessagePasser {
  public static void main(String[] args) throws InterruptedException {
    // Start the child thread
    IntMessage message = new IntMessage(-1);
    Child childThread = new Child(message);
    childThread.start();
    
    int i = 0;
    while(message.i < 0 && i < lorem_ipsum.length()) {
      synchronized(message) {
        message.wait(10);
      }
      System.out.print(lorem_ipsum.charAt(i));
      i++;
    }
    
    // Print from the parent
    System.out.println("\nChild process finished and sent message: "+message.i);
  }
  
  public static class Child extends Thread {
    private IntMessage message;
    public Child(IntMessage message) {
      this.message = message;
    }
    
    /*THIS IS THE SPECIAL METHOD*/
    public void run() {
      // Print our message 
      System.out.println("Child is busy working...");
      
      try{
        for(int i=0;i<500;i++)
          (new BigInteger("359334085968622831041960188598043661065388726959079837")).isProbablePrime(99999999);
      } catch (Exception e) {
        System.out.println("\n\nWhy?");
      }
      
      Random r = new Random();
      message.i = r.nextInt(100);
      
      System.out.println("\nWork done! Message set to " + message.i);
      synchronized(message) {
        message.notify();
      }
    }
  }
  
  public static class IntMessage {
    public int i;
    public IntMessage(int j){ i = j; }
  }
  
  static String lorem_ipsum =  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec tortor eu arcu ornare sodales. Ut auctor ex vitae pretium aliquet. Etiam ac nulla ut sem placerat fermentum commodo quis enim. Cras egestas, mauris sed convallis egestas, tellus lectus viverra lorem, sed aliquam leo arcu at nisl. Donec non turpis nec tellus egestas vehicula nec ut arcu. Vivamus in mattis justo. Nunc massa mauris, consequat at risus at, tincidunt commodo arcu. Phasellus molestie lacus quis lacus convallis condimentum. Sed dictum tellus nec orci fermentum, vitae laoreet dui malesuada. Etiam lorem leo, ultricies eget ultricies sed, ultricies in mi. Nam sed pharetra massa, et aliquet dolor. Vivamus tortor risus, pharetra et mollis vel, molestie eu ante. Donec rutrum elementum libero, eget aliquam purus dictum eget. Ut id bibendum nisl.\n" +
"Nunc maximus odio sit amet mauris aliquet semper. Aenean in arcu eget nisl iaculis viverra. Vestibulum sed ullamcorper quam. Fusce elementum est in congue dictum. In sit amet velit odio. Duis elementum nisi ac pulvinar commodo. Integer molestie velit sed nisl semper ultricies. Nunc nulla massa, fringilla ac mi a, facilisis porta urna. Maecenas condimentum elementum lacus non laoreet. Interdum et malesuada fames ac ante ipsum primis in faucibus. Suspendisse lectus dui, auctor id dolor tempus, efficitur hendrerit nisi. Aliquam id quam quis turpis accumsan accumsan interdum vulputate metus. Vestibulum scelerisque ligula in sapien tristique lacinia ac et sem.\n" +
"Integer et tincidunt dui. Aenean consequat eu mi sed viverra. Morbi auctor laoreet luctus. Vestibulum ac lacus tellus. Mauris pulvinar augue purus, ac convallis est gravida ut. Sed lacus felis, vulputate eget auctor ut, feugiat sit amet nisl. Integer varius elementum velit feugiat tincidunt. Mauris dictum mi et mi mollis, iaculis fringilla nisi interdum. Pellentesque et tortor interdum, blandit dolor vel, efficitur orci. Ut fermentum sed nulla quis rhoncus. Aenean ullamcorper sed lorem nec dignissim. Vestibulum sed nulla sed sapien pellentesque aliquet vel eu quam. Sed sed ipsum velit.\n" +
"Maecenas fermentum dolor vehicula gravida varius. Fusce nisi lectus, faucibus a velit eu, finibus lacinia nunc. Curabitur varius vel ligula et pulvinar. Integer mollis imperdiet metus nec luctus. Sed porttitor libero quis fermentum imperdiet. Cras ultrices lectus eu dui blandit, vehicula vehicula urna auctor. Aenean commodo et sem id mollis. Nulla pulvinar metus justo, quis dictum quam tempus non. Nulla pellentesque, mauris sed sollicitudin bibendum, elit elit luctus ante, ac facilisis tortor elit nec eros. Ut congue tempus justo ut luctus. Phasellus et enim porttitor, pulvinar ligula id, rhoncus magna. Aenean placerat nisi lectus, ut congue mauris molestie ac. Quisque id velit finibus, sagittis nulla eget, cursus arcu.\n" +
"Vestibulum aliquam velit maximus, semper neque eget, lobortis turpis. Vestibulum cursus gravida aliquam. Donec at leo sodales elit scelerisque dapibus. Duis auctor lectus non ex pulvinar finibus. Nulla consequat ipsum eget turpis commodo lacinia. Etiam non venenatis ligula. Maecenas laoreet semper imperdiet. Donec elementum volutpat aliquam. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec semper in quam ac rhoncus. Nulla facilisi. \n";
}