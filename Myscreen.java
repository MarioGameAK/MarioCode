//import someone else's code 
import javax.swing.JFrame;   
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
//extends allows you to inherit from existing class 
//declare a public class and give it some functionality from another class, JFrame 

public class Myscreen extends JFrame {  //Constructor method - runs first when class template is instanciated 	
	
	public Myscreen() { 		
		this.setSize(1000,900); 		
		this.setTitle("Shrimad Needs Help"); 		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 		
		this.setVisible(true); 	
		this.setFocusable(true);
}  	
	//makes class runable/executable 	
	public static void main(String[] args) {  		

	//instance being created/instanciated 		
		Myscreen screen = new Myscreen(); 		
		Mycanvas canvas = new Mycanvas();
		screen.getContentPane().add(canvas);
	}
}