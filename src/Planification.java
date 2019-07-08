import java.awt.BorderLayout;

import javax.swing.*;

public class Planification extends JFrame  {
	 // background
    ImageIcon img = new ImageIcon("src//image.png");
    JLabel background = new JLabel("", img, JLabel.CENTER);
    
    JButton suivi= new JButton("Suivi la planification");
    JButton suiv= new JButton("Suivi la Realisation");
	JButton KPI = new JButton("KPI : Taux d’exécution PDP ");
	Planification(){
		setContentPane(background);
		
		suivi.setBounds(20, 20, 200, 40);
	    suiv.setBounds(230, 20, 200, 40);
	    KPI.setBounds(440, 20, 200, 40);
		
		add(suivi);
		add(suiv);
		add(KPI);
		
		
		
		
		
		suivi.addActionListener(actionEvent-> new Suivi());
		suiv.addActionListener(actionEvent-> new Suiv());
		KPI.addActionListener(actionEvent->new KPI() );
		
		
		
		
	   setSize(700,250);
	   setVisible(true);
	   setTitle("Planification");
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	       
		
		
		
	}

	

}
