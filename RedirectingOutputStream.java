package Assignment2OOP;

import Assignment2OOP.GUI;

import java.io.IOException;
import java.io.OutputStream;

public class RedirectingOutputStream extends OutputStream {

    private GUI gui;// creating GUI object

    public RedirectingOutputStream(GUI gui) {//constructor with Gui parameter
        this.gui = gui;
    }// constructor

    @Override
    public void write(int b) throws IOException {
        gui.appendText(String.valueOf((char) b));//new text to appear on gui
    }//end method

}//end class