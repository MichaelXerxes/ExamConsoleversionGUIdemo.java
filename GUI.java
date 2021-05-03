package Assignment2OOP;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class GUI extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JFrame frame;
    private JPanel panel,panel2,panel3;
    private JProgressBar bar;
    private JButton button,button2;
    private JLabel label,label2;
    private TextField textfield;

    private String text;//String to store value from textfield - example
    public GUI() {
        //       creating objects
        panel=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        label=new JLabel("I`m Label :) ");
        label2=new JLabel("And I`m too :)");
        bar=new JProgressBar();
        textArea = new JTextArea();
        textfield=new TextField();
        button=new JButton("Click Me Last !!");
        button2=new JButton("Click to Exit !!");

        //   object definition methods
        getTextArea();
        getBar();
        getPanels();
        getButton();
        getLabel();
        getTextField();
        //    frame definition
        frame = new JFrame("GUI Example");//create frame with title
        frame.setBounds(0, 0, 764, 807);//set size of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close program when click x on frame
        frame.setLayout(null);// default
        frame.setResizable(false);// make frame cannot to change

        //   order of additional objects
        panel.add(textArea, BorderLayout.CENTER);
        panel2.add("Panel 2 !!",bar);
        panel2.add(button);
        panel2.add(textfield);
        panel3.add(label);
        panel3.add(label2);
        panel3.add(button2);
        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);

        frame.setLocationRelativeTo(null);// this allow frame to appear  in middle of screen
    }

    public void getPanels(){
        panel.setLayout(new GridLayout());//set layout
        panel.setBackground(Color.BLACK);// set background color
        //panel.setFont(new Font("Consolas", Font.PLAIN, 25));//set font and size
        panel.setBorder(BorderFactory.createLineBorder(Color.RED,5));//ser border color and thickness
        panel.setBounds(0,0,750,600);//set location and size


        panel2.setLayout(null);// no layout
        panel2.setBackground(Color.pink);
        panel2.setBorder(BorderFactory.createLineBorder(Color.magenta,5));//ser border color and thickness
        panel2.setBounds(0,600,750,170);//set location and size

        panel3.setLayout(null);
        panel3.setBackground(Color.yellow);
       // panel3.setFont(new Font("Consolas", Font.PLAIN, 25));//set font and size
        panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));//ser border color and thickness
        panel3.setBounds(0,600,750,170);//set location and size
    }
    public void getTextArea(){
        textArea.setFont(new Font("Consolas", Font.PLAIN, 15));//set font and size
        textArea.setSize(new Dimension(400,500));//set size
        textArea.setBackground(Color.cyan);// set background color
    }
    public void getBar(){
        bar.setValue(0);//start number
        bar.setBounds(5,5,740,50);//set location and size
        //bar.setSize(new Dimension(420,50));
        bar.setStringPainted(true);//bar render a string
        bar.setFont(new Font("MV Boli",Font.ITALIC,25));//set font and size of STring sinde bar
        bar.setForeground(Color.magenta);// changing color
        bar.setBackground(Color.black);//background color
    }
    public void getButton(){
        button.addActionListener(this);// this add action to button ( when user click button)
        button.setBounds(5,60,150,50);//set location and size
        button.setEnabled(false);//set button enabled
        button2.addActionListener(this);// this add action to button ( when user click button)
        button2.setBounds(450,20,150,50);//set location and size
        button2.setEnabled(true);//set button enabled
        button2.setVisible(false);// set invisible
    }
    public void getLabel(){
        label.setBounds(50,40,300,50);//set location and size
        label.setBackground(Color.GREEN);
        label.setFont(new Font("MV Boli",Font.ROMAN_BASELINE,25));//set font and size
        label.setBorder(BorderFactory.createLineBorder(Color.lightGray,5));
        label.setOpaque(true);
        label.setHorizontalTextPosition(JLabel.CENTER);

        label2.setBounds(300,100,300,50);//set location and size
        label2.setBackground(Color.red);
        label2.setFont(new Font("MV Boli",Font.ROMAN_BASELINE,25));//set font and size
        label2.setBorder(BorderFactory.createLineBorder(Color.lightGray,5));
        label2.setOpaque(true);
        label2.setHorizontalTextPosition(JLabel.CENTER);

    }
    public void getTextField(){
        textfield.setText("Write something :)");//set text
        textfield.setBounds(200,60,350,50);//set location and size
        textfield.setBackground(Color.black);
        textfield.setForeground(new Color(0x00FF00));
        textfield.setFont(new Font("Consolas",Font.PLAIN,35));// change font   is changing size of text
    }
    public void setText(String text) {
        this.text = text;
    }// set method for String text
    public String getText() {
        return text;
    }//get method for String text
    public String toString() {return this.text;}//to String method
    @Override
    public void actionPerformed(ActionEvent e) {//implemented method
        if(e.getSource()==button){//if statement after clicking on the button
           while (textfield!=null){//while loop to check if is not null
                System.out.println("\nText you typed!  "+textfield.getText());//output text on console
               textfield.setEnabled(false);//set text field enabled
               break;// exit loop
           }
            panel2.setVisible(false);//make the panel invisible
            panel3.setVisible(true);//make the panel visible
            button2.setVisible(true);//set visible
        }
        if(e.getSource()==button2){//set conditions for button2
            {
                System. out. println("Great job! String is acceptable");
                System. exit(0);//exit program !!!!
            }
        }
    }

    public  void fill()  {//method to fill bar up to 100
        int count=0;// local variable

        while ((count <= 100)) {//while loop to fill the bar

            bar.setValue(count);//set method
            try {
                Thread.sleep(50);//Suspends the current thread for the specified amount of time.
            }catch ( InterruptedException exception){
            }
            count+=1;
        }
        bar.setString("Done !!!.Thank you for waiting :) :)");//output on bar
        button.setEnabled(true);//set button enabled after bar is fill
    }

    public void start() {// start method to start frame
        frame.setVisible(true);//make frame visible
        fill();//call  method
    }// method make frame visible and its a place to future solution

    public void appendText(String text) {//method to call text from the console on the panel screen
        textArea.append(text);
    }
}//end class