import java.util.HashMap;
HashMap<Integer, Boolean> dirMap = new HashMap<Integer, Boolean>();
public class Boy {
  private int x, y;
  private int w, h;
  private int dx, dy;
  private final int xspeed = 5;
  private final int yspeed = -5; //Note negative speed
  private final int ddy = 1;
  private final color ORANGE = color(204, 102, 0);
  private PImage[] sprites;
  private int frameNo, hzperframe;

  public Boy(int w, int h, int x, int y) {
    this.w = w;
    this.h = h;
    this.x = x;
    this.y = y;
    dirMap = new HashMap<Integer, Boolean>();
    // Initialize keys
    dirMap.put(RIGHT, false);
    dirMap.put(LEFT, false);
    dirMap.put(UP, false);
    dirMap.put(DOWN, false);
    
    this.sprites = new PImage[2];
    this.sprites[0] = loadImage("pacman0.png");
    this.sprites[1] = loadImage("pacman1.png");
    this.frameNo = 0;
    this.hzperframe = 20;
  }

  public void setMovement(int k, boolean b) {
    dirMap.put(k, b);
  }

  public void move() {
    this.dx = this.dy = 0;
    this.dx += dirMap.get(RIGHT) ? xspeed : 0;
    this.dx += dirMap.get(LEFT) ? -xspeed : 0;
    this.dy += dirMap.get(UP) ? yspeed : 0;
    this.dy += dirMap.get(DOWN) ? -yspeed : 0;

    this.x += this.dx;
    this.y += this.dy;
  }

  public void display() {
    //fill(this.ORANGE);
    //rect(x, y, w, h);
    this.frameNo = (this.frameNo + 1)%(this.sprites.length*this.hzperframe); //Careful about the modulo
    translate(x, y);
    rotate(PI);
    image(this.sprites[this.frameNo / this.hzperframe], 0, 0);
  }
}
