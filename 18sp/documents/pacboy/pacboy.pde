import shiffman.box2d.*;
// ^^This might be useful for collisions, might also be overkill

// Global variables
Boy player;
int WHITE = 255;

void setup() {
  size(1080, 720);
  player = new Boy(50, 100, 0, 0);
  imageMode(CENTER);
}

void draw() {
  //clear background using global variable
  background(WHITE);
  player.move();
  player.display();
}

void keyPressed() {
  player.setMovement(keyCode, true);
}

void keyReleased() {
  player.setMovement(keyCode, false);
}

/* Laundry List
Draw rect
Input
Inverted y axis
stop movement abruptly stops y movement
Sticky input, use pressed and release
http://studio.processingtogether.com/sp/pad/export/ro.91tcpPtI9LrXp
https://processing.org/examples/animatedsprite.html
*/
