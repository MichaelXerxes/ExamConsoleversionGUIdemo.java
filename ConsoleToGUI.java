package Assignment2OOP;

import java.io.PrintStream;// import java IO

public class ConsoleToGUI {

    public ConsoleToGUI() {//class to start GUI
        GUI gui = new GUI();//creating object
        System.setOut(new PrintStream(new RedirectingOutputStream(gui), true));//Standard Output Stream to any user defined value
        gui.start();// call method
    }

    public void run() {// method that can be used for additional actions --example

    }
    // this method was used only to test GUI !!!
  /*  public static void main(String[] args) {
        ConsoleToGUI ctg = new ConsoleToGUI();
        ctg.run();
    }   */
}//end class
