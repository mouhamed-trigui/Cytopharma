




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Identifiant extends JFrame {
	  // background
    ImageIcon img = new ImageIcon("src//image.png");
    JLabel background = new JLabel("", img, JLabel.CENTER);
    
    JButton submit= new JButton("Login");
    
    JLabel user = new JLabel("UserName:") ;
    JLabel pass = new JLabel("Password :") ;
    JTextField tuser = new JTextField() ;
    JPasswordField tpass = new JPasswordField() ;
    
    
	Identifiant(){
		
		
		
	    setContentPane(background);
	    submit.setBounds(260, 150, 200, 40);
	    user.setBounds(170, 20,90 , 20);
	    tuser.setBounds(260, 20,200,20);
	    pass.setBounds(170, 50,90 , 20);
	    tpass.setBounds(260, 50,200,20);
	    
		add(submit);
		add(user);
		add(tuser);
		add(pass);
		add(tpass);
		
		
      
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,250);
		
		setVisible(true);
		setTitle("GestionApp");
		
		 submit.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String st = tpass.getText();
	            	if(st.equals("haytham")) {submit s = new submit();}
	            	else { JFrame frame = new JFrame();
	            		JOptionPane.showMessageDialog(frame, "Invalid User or Password");}
	            	
	            	
	            	
	            }
	            
	        });
	        
		
		
	
	}

	public static void main(String[] args) {
		Identifiant id = new Identifiant() ;
	

	}

}
