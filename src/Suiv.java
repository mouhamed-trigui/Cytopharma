import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;

public class Suiv extends JFrame {
	 // background
    ImageIcon img = new ImageIcon("src//image.png");
    JLabel background = new JLabel("", img, JLabel.CENTER);
    
    JButton suiviQte= new JButton("Suivi Fabrication");
	JButton suiviFab = new JButton("Suivi Quantité");
	JButton suiviST = new JButton("Suivi Sterilite ");
	JButton suiviM = new JButton("Suivi Mirage ");
	JButton suiviC = new JButton("Suivi Conditionnement ");
    
	Suiv(){
		
		setContentPane(background);
		
		suiviQte.setBounds(20, 20, 150, 40);
		suiviFab.setBounds(180, 20, 150, 40);
		suiviST.setBounds(340, 20, 150, 40);
		suiviM.setBounds(500, 20, 150, 40);
		suiviC.setBounds(660, 20, 150, 40);
		
		
		
		add(suiviQte);
		add(suiviFab);
		add(suiviST);
		add(suiviM);
		add(suiviC);
		
		
		
		
		 
		suiviQte.addActionListener(actionEvent-> new SuiviGteR());
		suiviFab.addActionListener(actionEvent->new SuivieFabR() );
		suiviST.addActionListener(actionEvent->new SuivieSTR() );
		suiviM.addActionListener(actionEvent->new SuivieMR() );
		suiviC.addActionListener(actionEvent->new SuivieCR() );
	
		
	 
	    setSize(850,250);
	    setVisible(true);
		setTitle("Realisation");
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		
	}
}