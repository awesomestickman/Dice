import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {


Die [] dice;
int flip=0;

int swidth=500;
int sheight=500;
public void setup()
{
  
  background(225);
  noStroke();
  noLoop();
  size(swidth,sheight);
  dicecreate();
}
public void draw()
{
  background(225);
int allroll =0;
  for(int i=0;i<dice.length;i++){
    if(dice[i] != null){
    dice[i].roll();
    dice[i].show();
    allroll+=dice[i].display;
    }
  }
  
  fill(0);
  text("total roll: " + allroll,200,15);
  
}
public void mousePressed()
{
  redraw();
}
public void dicecreate(){
  dice = new Die[(int)(swidth/7)*(int)(sheight/7)];
  int diecounter = 0;
  for(int p=3;p<(int)(sheight/7);p++){
   /*if(flip==0){
      flip=1;
    }
    else{
      flip=0;
    }*/
  for(int i=0;i<(int)(swidth/7);i++){
    if(flip==0){
      flip=1;
    }
    else{
      flip=0;
    }
    dice[diecounter]=new Die(i*7,p*7,flip);
    diecounter++;
    
  }
  }
}
class Die //models one single dice cube
{
  
  //variable declarations here
  int x,y,display,rpaint,bpaint;
  Die(int x, int y, int paint) //constructor
  {
    this.x=x;
    this.y=y;
    if(paint==0){
    this.rpaint =225;
    }
    else{
    this.bpaint = 225;
    }
  }
  
  Die(int x, int y, int paint, int display) //constructor
  {
    this.x=x;
    this.y=y;
    if(paint==0){
    this.rpaint =225;
    }
    else{
    this.bpaint = 225;
    }
    this.display=display;
  }
  public void roll()
  {
    this.display = (int)(Math.random()*6)+1;
  }
  public void show()
  {
    noStroke();
    fill(this.rpaint,0,this.bpaint);
    if(this.display==1){
      rect(this.x,this.y,7,7);
      stroke(this.bpaint,0,this.rpaint);
      point(this.x+3,this.y+3);
      
    }
    if(this.display==2){
      rect(this.x,this.y,7,7);
      stroke(this.bpaint,0,this.rpaint);
      point(this.x+2,this.y+2);
      point(this.x+5,this.y+5);
    }
    if(this.display==3){
      rect(this.x,this.y,7,7);
      stroke(this.bpaint,0,this.rpaint);
      point(this.x+1,this.y+1);
      point(this.x+3,this.y+3);
      point(this.x+5,this.y+5);
    }
    if(this.display==4){
      rect(this.x,this.y,7,7);
      stroke(this.bpaint,0,this.rpaint);
      point(this.x+2,this.y+2);
      point(this.x+5,this.y+2);
      point(this.x+2,this.y+5);
      point(this.x+5,this.y+5);
    }
    if(this.display==5){
      rect(this.x,this.y,7,7);
      stroke(this.bpaint,0,this.rpaint);
      point(this.x+1,this.y+1);
      point(this.x+5,this.y+1);
      point(this.x+3,this.y+3);
      point(this.x+1,this.y+5);
      point(this.x+5,this.y+5);
      
    }
    if(this.display==6){
      rect(this.x,this.y,7,7);
      stroke(this.bpaint,0,this.rpaint);
      point(this.x+1,this.y+1);
      point(this.x+5,this.y+1);
      point(this.x+1,this.y+3);
      point(this.x+5,this.y+3);
      point(this.x+1,this.y+5);
      point(this.x+5,this.y+5);
      
    }
    
      
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
