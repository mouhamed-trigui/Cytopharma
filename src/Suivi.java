import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;

public class Suivi extends JFrame {
	 // background
    ImageIcon img = new ImageIcon("src//image.png");
    JLabel background = new JLabel("", img, JLabel.CENTER);
    
    JButton suiviQte= new JButton("Suivi Fabrication");
	JButton suiviFab = new JButton("Saisir Quantité");
	JButton suiviST = new JButton("Suivi Sterilite ");
	JButton suiviM = new JButton("Suivi Mirage ");
	JButton suiviC = new JButton("Suivi Conditionneé ");
    
	Suivi(){
		
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
		
		
		
		
		 
		suiviQte.addActionListener(actionEvent-> new SuiviGte());
		suiviFab.addActionListener(actionEvent->new SuivieFab() );
		suiviST.addActionListener(actionEvent->new SuivieST() );
		suiviM.addActionListener(actionEvent->new SuivieM() );
		suiviC.addActionListener(actionEvent->new SuivieC() );
	
		
	 
	    setSize(850,250);
	    setVisible(true);
		setTitle("Planification");
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		
	}
}