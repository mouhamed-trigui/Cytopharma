




import javax.swing.*;
import java.awt.*;


public class submit extends JFrame {
	  // background
    ImageIcon img = new ImageIcon("src//image.png");
    JLabel background = new JLabel("", img, JLabel.CENTER);
    
    JButton Achat= new JButton("Achat étranger");
	JButton Gestion = new JButton("Gestion de stock ");
	JButton Planification = new JButton("Planification et Realisation");
    
    
	submit(){
		
		
		
	    setContentPane(background);
	    Achat.setBounds(20, 20, 200, 40);
	    Gestion.setBounds(230, 20, 200, 40);
	    Planification.setBounds(440, 20, 200, 40);
		add(Achat);
		add(Gestion);
		add(Planification);
		
		
      
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,250);
		
		setVisible(true);
		setTitle("GestionApp");
		Achat.addActionListener(actionEvent-> new Achat() );
		Gestion.addActionListener(actionEvent-> new Gestion());
		Planification.addActionListener(actionEvent -> new Planification());
		
	
	
	

	}

}
