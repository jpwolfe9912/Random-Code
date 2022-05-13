import java.awt.*;
import javax.swing.*;
public class HelloWorld extends JApplet {
String message; //declare string greeting here so that it has scope to be used for both init() and paint() methods
    public void init() { //automatically called when applet is started.
    message = "Hello World!"; //set text of String message
    }
    public void paint (Graphics screen) { //called automatically by init() to draw graphical elements on the screen
        Graphics2D screen2D = (Graphics2D) screen; //explained below code
        screen2D.drawString(message, 25, 50); //explained below code
    }
}
