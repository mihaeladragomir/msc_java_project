package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 *
 * @author Michael Kolling
 * @version 1.0 (Jan 2003)
 */
public class UserInterface extends JFrame implements ActionListener{

    private GameEngine engine;
    private JTextArea textArea;
    private JPanel top, middle, bottom, right;
	private JButton button1, button2, button3;
	private JLabel mainLabel, titleLabel, timeDisplay;
	//private JTextField timeDisplay;
	private ImageIcon image;
	private Font titleFont=new Font("Brush Script MT", Font.BOLD, 40);
	private Font myFont1=new Font("Courier New", Font.PLAIN, 20);
	private Font myFont2=new Font("Brush Script MT", Font.PLAIN, 20);

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     *
     * @param gameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface(GameEngine gameEngine){
        engine = gameEngine;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Holy Grail Game");
        setLocation(0,0);
        setVisible(true);
        layoutComponents();
        this.pack();
        //Make JFrame center  
        setLocationRelativeTo(null);
    }

    
    private void layoutComponents() {
    	top=topLayout();
    	this.add(top, BorderLayout.NORTH);
    	
    	bottom=bottomLayout();
    	this.add(bottom, BorderLayout.SOUTH);
    	
    	middle = middleLayout();
    	this.add(middle, BorderLayout.CENTER);
		
    	right = rightLayout();
    	this.add(right, BorderLayout.EAST);
		
	}

    private JPanel topLayout(){
    	JPanel panel = new JPanel();
    	timeDisplay=new JLabel("05:00");
    	//timeDisplay = new JTextField("05:00");
    	timeDisplay.setFont(myFont1);
    	//timeDisplay.setEditable(false);
    	timeDisplay.setHorizontalAlignment(JLabel.LEFT);
    	timeDisplay.setVisible(false);
    	
    	titleLabel = new JLabel("       Welcome to Holy Grail!");
    	titleLabel.setFont(titleFont);
    	panel.add(timeDisplay);
    	panel.add(titleLabel);
      	return panel;
    	
    }
    
    private JPanel directionsLayout(){
    	JPanel goPanel = new JPanel();
    	goPanel.setLayout( new BorderLayout());
    	
    	JButton button1 = new JButton();
    	button1.setPreferredSize(new Dimension(60, 60));
   
    	JButton button2 = new JButton("NORTH");
    	button2.setPreferredSize(new Dimension(40, 40));
    	
       	JButton button4 = new JButton("SOUTH");
       	button4.setPreferredSize(new Dimension(40, 40));
       	
    	JButton button6 = new JButton("WEST");
    	button6.setPreferredSize(new Dimension(50, 50));
    	
    	JButton button8 = new JButton("EAST");
    	button8.setPreferredSize(new Dimension(50, 50));
    	
    	goPanel.add(button1, BorderLayout.CENTER);
    	goPanel.add(button2, BorderLayout.NORTH);
    	goPanel.add(button4, BorderLayout.SOUTH);
    	goPanel.add(button6, BorderLayout.WEST);
    	goPanel.add(button8, BorderLayout.EAST);
    	    	
    	
    	return goPanel;
    }
    
    
    
    private JPanel bottomLayout(){
    	JPanel panel = new JPanel();
    	
    	button1 = new JButton("START GAME");
    	button2 = new JButton("HELP");
    	button3 = new JButton("QUIT");
    	    	
    	button1.addActionListener(this);
    	button2.addActionListener(this);
    	button3.addActionListener(this);
    	
    	panel.add(button1);
    	panel.add(button2);
    	panel.add(button3);
    	
    	return panel;
    	
    }
    
    private JPanel middleLayout(){
    	JPanel panel = new JPanel();
    	
    	image=new ImageIcon("startImage.jpg");
    	mainLabel = new JLabel(image);
    	panel.add(mainLabel);
    	
    	return panel;
    	
    }
     
    
    private JPanel rightLayout(){
    	JPanel panel = new JPanel();
    	
    	textArea = new JTextArea(introText());
    	/*
    	textArea.setText("The Grail plays a different role everywhere it appears, but in most versions of the legend the hero must prove himself worthy to be in its presence. In the early tales, Percival's immaturity prevents him from fulfilling his destiny when he first encounters the Grail, and he must grow spiritually and mentally before he can locate it again. In later tellings the Grail is a symbol of God's grace, available to all but only fully realized by those who prepare themselves spiritually, like the saintly Galahad.");
    	// the lines will be wrapped if they are too long to fit within the allocated width
    	textArea.setLineWrap(true);
    	// the lines will be wrapped at word boundaries (whitespace) if they are too long to fit within the allocated width
    	textArea.setWrapStyleWord(true);*/
    	//the lines are centered
    	textArea.setAlignmentX(CENTER_ALIGNMENT);
       	textArea.setEditable(false);
    	textArea.setFont(myFont2);
    	
    	panel.add(textArea);
    	   	
    	return panel;
    }


    private String introText(){
    	String text = "";
    	text =text+"There was a lot of rumour lately"+'\n'
    		   +"around the existence and location"+'\n'
    		   +"of the Holy Grail. "+'\n' 
    		   +"Many legends try to explain its"+'\n'  
    		   +"origins and thousands of people"+'\n' 
    		   +"seek to bring to light this mystery."+'\n'  
    		   +"One of the various legends says"+'\n'   
    		   +"that the Holy Grail, the famous"+'\n'   
    		   +"philosophical stone, is an emerald"+'\n' 
    		   +"that Lucifer carried on his forehead."+'\n' 
    		   +"When Lucifer was demonized, the"+'\n' 
    		   +"emerald fell down on the earth. "+'\n'  
    		   +"Recently, a group of archaeologists"+'\n' 
    		   +"from Scotland discovered a document"+'\n'  
    		   +"which proves that the Holy Grail was"+'\n' 
    		   +"hidden somewhere around Edinburgh,"+'\n' 
    		   +"under the Rosslyn chapel."; 

    	return text;
    }

	/**
     * @param commandLine
     */
    public void println(String commandLine) {
        // TODO Auto-generated method stub
    	textArea.setText(commandLine);
    }
 /*   public JLabel getTimeLabel(){
    	return timeDisplay;
    }
    	*/
    public String startChronometer(){
		
		ChronometerDisplay cd=new ChronometerDisplay(5, 0);
		String time=cd.getTime();
		System.out.println(time);
		for (int i=0; i<300; i++){
			try{
			cd.sleep(1000);
			cd.timeTick();
			time=cd.getTime();
			
			}
			catch (Exception e){
				
			}
			
		}
		return time;
    }

    /*
     * */
    public void diplayNewImage(String imagePath){
    	
      	String newImage = imagePath;
	try {
		mainLabel.setIcon( new ImageIcon(ImageIO.read( new File(newImage) ) ) );
	} catch (IOException e1) {
		e1.printStackTrace();
		} 
    }
	
    /*
     * */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1){
			
			button1.setVisible(false);
			textArea.setText("");
			titleLabel.setVisible(false);
			timeDisplay.setVisible(true);
			String image = engine.getCurrentRoom().getImagePath();
			diplayNewImage(image);
			bottom.add(directionsLayout());
			//String time=startChronometer();
			//timeDisplay.setText(time);
			//System.out.println(time);
			
						
			
		}
		if(e.getSource()==button2){
			JOptionPane.showMessageDialog(null, "Help Help Help Help Help Help Help Help Help Help Help Help Help Help Help  !", "Help!",
					JOptionPane.ERROR_MESSAGE);
			//engine.interpretCommand("help");
		}
		if(e.getSource()==button3){
			engine.endGame();
			////call endGame()
			
		}
		
		
		
	}

}
