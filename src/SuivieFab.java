import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.regex.PatternSyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


public class SuivieFab {
	 // background
    ImageIcon img = new ImageIcon("src//image.png");
    JLabel background = new JLabel("", img, JLabel.CENTER);
 // create JFrame and JTable
    JFrame frame = new JFrame();
    JTable table = new JTable(); 
    JTextField rech = new JTextField();
    
    // create a table model and set a Column Identifiers to this model 
    Object[] columns = {"id","Semaine","PF","N°LOT","Quantité Planifiée"};
    DefaultTableModel model = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    
	SuivieFab(){
		 
        model.setColumnIdentifiers(columns);
        
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        frame.setContentPane(background);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,15);
        table.setFont(font);
        table.setRowHeight(30);
        
        JLabel semaine = new JLabel("Semaine:") ;
        JLabel PF = new JLabel("PF:") ;
        JLabel Nlot = new JLabel("NLot:") ;
        JLabel QteP = new JLabel("Quantité Planifiée:") ;
        JLabel QteR= new JLabel("Quantité Realisée:") ;
        
        
        // create JTextFields
        
        String[]fill = {"S1","S2","S3","S4","S5","S6","S7","S8","S9","S10","S11","S12","S13","S14","S15","S16","S17","S18","S19","S20","S21","S22","S23","S24","S25","S26","S27","S28","S29","S30","S31","S32","S33","S34","S35","S36","S37","S38","S39","S40","S41","S42","S43","S44","S45","S46","S47","S48","S49","S50","S51","S52"};
        JComboBox tsemaine = new JComboBox(fill);
        tsemaine.setSelectedIndex(1);
        tsemaine.addActionListener(tsemaine);
        
        
       

        String names[] = {"PF 01 : CYTOFLU 250mg/5mL","PF 02 : CYTOTERE 20mg/1mL","PF 03 : CYTOTERE 80mg/4mL", "PF 04 : CYTOFLU 1g/20mL","PF 05 : CYTOXALINE 50mg/10mL", "PF 06 : CYTOXALINE 100mg/20mL","PF 08 : CYTOBICINE 10mg/5mL ", "PF 09 : CYTOBICINE 50mg/25mL","PF 10 : CYTOPAXEL 30mg/5mL","PF 11 : CYTOPAXEL 100mg/16.7mL"};
        JComboBox places = new JComboBox(names) ;                    // creating JList object; pass the array as parameter
        places.setSelectedIndex(1); 
        places.addActionListener(places);
        
        
    	
      
        
        

       
        
        
        
        JTextField tqteP = new JTextField();
        
        JTextField tlot = new JTextField();
        
        
        
        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update"); 
        JButton btnrech = new JButton("Recherche");
        
        semaine.setBounds(20, 220, 100, 25);
        tsemaine.setBounds(120, 220, 200, 25);
        
        PF.setBounds(20, 250, 100, 25);
        places.setBounds(120, 250, 200, 25);
        
        
        Nlot.setBounds(20, 280, 100, 25);
        tlot.setBounds(120, 280, 200, 25);
        QteP.setBounds(20, 310, 125, 25);
        tqteP.setBounds(120, 310, 200, 25);
      
        
       
        
        btnAdd.setBounds(450, 220, 150, 25);
        btnUpdate.setBounds(450, 265, 150, 25);
        btnDelete.setBounds(450, 310, 150, 25);
        btnrech.setBounds(450, 355, 150, 25);
        rech.setBounds(620, 355, 150, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        table.setRowSorter(sorter);
        refresh();
        pane.setBounds(0, 0, 880, 200);
        
        frame.setLayout(null);
        
        frame.add(pane);
        
        // add JTextFields to the jframe
        frame.add(semaine);
        frame.add(tsemaine);
        frame.add(PF);
        frame.add(places);
        frame.add(Nlot);
        frame.add(tlot);
       
        frame.add(tqteP);
        frame.add(QteP);
        frame.add(rech);
      
        
        
    
        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnrech);
        
        // create an array of objects to set the row data
        Object[] row = new Object[5];
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                row[1] = tsemaine.getSelectedItem();
                row[2] = places.getSelectedItem();
                row[3] = tlot.getText();
                row[4] = tqteP.getText();
                
              
                
                // add row to the model
                model.addRow(row);
                
                String b =row[1].toString() ;
                String c =row[2].toString() ;
                String d =row[3].toString() ;
                String ea =row[4].toString() ;
               
                ajouter(b,c,d,ea);
            }
        });
      //button rechercher
        btnrech.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				recherche();
				
			}});
        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                	 int s = Integer.parseInt(model.getValueAt(i, 0).toString());
                     delete(s);
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
        
        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            tsemaine.setSelectedItem(model.getValueAt(i, 1).toString());
            places.setSelectedItem(model.getValueAt(i, 2).toString());
            tlot.setText(model.getValueAt(i, 3).toString());
            tqteP.setText(model.getValueAt(i, 4).toString());
           
            
        }
        });
        
        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                // i = the index of the selected row
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                {
                	model.setValueAt(tsemaine.getSelectedItem(), i, 1);
                	model.setValueAt(places.getSelectedItem(), i, 2);
                	model.setValueAt(tlot.getText(), i, 3);
                	model.setValueAt(tqteP.getText(), i, 4);  	
                	
                	
                	String a =tsemaine.getSelectedItem().toString() ;
                    String b =places.getSelectedItem().toString() ;
                    String c =tlot.getText() ;
                    String d =tqteP.getText();
                   
                    int s = Integer.parseInt(model.getValueAt(i, 0).toString());
                    update(s,a,b,c,d);
                	
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
        ajouterTableau();
        frame.setSize(900,700);
        frame.setTitle("Suivie Quantité Planifiée");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	private void refresh() {
		rech.getDocument().addDocumentListener(
	            new DocumentListener() {
	               
					@Override
					public void changedUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						recherche();
					}
					@Override
					public void insertUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						recherche();
					}
					@Override
					public void removeUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						recherche();
					}
	            });
		
		
	}
	
	static Connection connect() throws SQLException, ClassNotFoundException {
        String strClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/appges";
        String login = "root";
        String pwd = "";

        Class.forName(strClassName);
        return DriverManager.getConnection(url, login, pwd);
        
        
    }

	 private void ajouter(String semaine, String pf, String nlot, String qplanifiee ) {
	        try {
	            Connection cnx = connect();
	           
	           String a = semaine ; 
	           String b = pf ;
	           String c = nlot ; 
	           String d = qplanifiee ;
	          
	          
	           
	           
	           
	           
	           String req = "INSERT INTO basetotal (semaine,pf,nlot,qplanifiee) VALUES ('"+a+"','"+b+"','"+c+"','"+d+"')";
	        //   String req1 = "INSERT INTO suivieqp (qplanifiee) VALUES ('"+d+"')";
	           PreparedStatement stat = cnx.prepareStatement(req);
	          // PreparedStatement stat1 = cnx.prepareStatement(req1);
	           
	           stat.executeUpdate(req);
	         //  stat1.executeUpdate(req1);
	            
	            
	            
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
    private void ajouterTableau() {
        try {
        	Connection cnx = connect();
        	
        	String req = ("SELECT id,semaine,pf,nlot,qplanifiee FROM basetotal");
        	//String req1 = ("SELECT qplanifiee FROM suivieqp");
        	 PreparedStatement stat = cnx.prepareStatement(req);
        	// PreparedStatement stat1 = cnx.prepareStatement(req1);
        	 
        	 ResultSet res = stat.executeQuery();
        	// ResultSet res1 = stat1.executeQuery();
        	 
        	

           while (res.next() ){
                String[] row = {
                	res.getString("id"),
                    res.getString("semaine"),
                    res.getString("pf"),
                    res.getString("nlot"),
                    res.getString("qplanifiee"),
                   
                    
                };
                
                
                model.addRow(row);
                
            }
           
          
            model.fireTableDataChanged();
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
    private void delete(int id) {
   	 try {
            Connection cnx = connect();
           
          
           
           
           
           String req = "DELETE FROM basetotal WHERE id = ?";
           PreparedStatement stat = cnx.prepareStatement(req);
           stat.setInt(1,id);
           stat.executeUpdate();
            
            
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
   	
   	
   }
   private void update(int id, String semaine, String pf, String nlot, String qplanifiee) {
  	 try {
           Connection cnx = connect();
          
         
          
          
          
          String req = "update basetotal set semaine = ?,pf = ?,nlot = ?,qplanifiee = ? where id = ?";
          PreparedStatement stat = cnx.prepareStatement(req);
          stat.setInt(5,id);
          stat.setString(1, semaine);
          stat.setString(2, pf);
          stat.setString(3, nlot);
          stat.setString(4, qplanifiee);
         
          stat.executeUpdate();
           
           
           
          
       } catch (Exception e) {
           e.printStackTrace();
       }
  	
  	
  }
   
   private void recherche() {
       try {
           sorter.setRowFilter(RowFilter.regexFilter(rech.getText()));
       } catch (PatternSyntaxException e) {
           e.printStackTrace();
       }
   }
}
