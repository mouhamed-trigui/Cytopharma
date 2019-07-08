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
import java.text.DecimalFormat;
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
public class KPI {
	 // background
    ImageIcon img = new ImageIcon("src//image.png");
    JLabel background = new JLabel("", img, JLabel.CENTER);
 // create JFrame and JTable
    JFrame frame = new JFrame();
    JTable table = new JTable(); 
    JTextField rech = new JTextField();
    
    // create a table model and set a Column Identifiers to this model 
    Object[] columns = {"id","Mois","PF","Quantité Planifiée","Quantité Realisée","Taux Exécution PDP %"};
    DefaultTableModel model = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    
	KPI(){
		 
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
        
        JLabel semaine = new JLabel("Mois:") ;
        JLabel PF = new JLabel("PF:") ;
        
        JLabel QteP = new JLabel("Quantité Planifiée:") ;
        JLabel QteR= new JLabel("Quantité Realisée:") ;
        JLabel datefab = new JLabel("Taux:") ;
        
        
        // create JTextFields
        
        String[]fill = {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Nouvembre","Decembre"};
        JComboBox tsemaine = new JComboBox(fill);
        tsemaine.setSelectedIndex(1);
        tsemaine.addActionListener(tsemaine);
        
        
       

        String names[] = {"PF 01 : CYTOFLU 250mg/5mL","PF 02 : CYTOTERE 20mg/1mL","PF 03 : CYTOTERE 80mg/4mL", "PF 04 : CYTOFLU 1g/20mL","PF 05 : CYTOXALINE 50mg/10mL", "PF 06 : CYTOXALINE 100mg/20mL","PF 08 : CYTOBICINE 10mg/5mL ", "PF 09 : CYTOBICINE 50mg/25mL","PF 10 : CYTOPAXEL 30mg/5mL","PF 11 : CYTOPAXEL 100mg/16.7mL"};
        JComboBox places = new JComboBox(names) ;                    // creating JList object; pass the array as parameter
        places.setSelectedIndex(1); 
        places.addActionListener(places);
        
        
        JLabel moi = new JLabel("Choisir le Mois:") ;
        String[]fil = {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Nouvembre","Decembre"};
        JComboBox tmoi = new JComboBox(fill);
        tsemaine.setSelectedIndex(1);
        tsemaine.addActionListener(tmoi);
       
        
        
        

       
        
        
        
        JTextField tqteP = new JTextField();
        JTextField tqteR = new JTextField();
        JTextField taux = new JTextField();
        
        
        
        
        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");     
        JButton btnTaux = new JButton("Calculer Taux Execution PDP Par Mois");
        JButton btnrech = new JButton("Recherche");
        
        semaine.setBounds(20, 220, 100, 25);
        tsemaine.setBounds(120, 220, 200, 25);
        
        PF.setBounds(20, 250, 100, 25);
        places.setBounds(120, 250, 200, 25);
        
        
        
        QteP.setBounds(20, 280, 125, 25);
        tqteP.setBounds(120, 280, 200, 25);
        QteR.setBounds(20, 310, 125, 25);
        tqteR.setBounds(120, 310, 200, 25);
        
        
        btnAdd.setBounds(450, 220, 200, 40);
        btnUpdate.setBounds(450, 265, 200, 40);
        btnDelete.setBounds(450, 310, 200, 40);
        btnrech.setBounds(450, 355, 200, 40);
        rech.setBounds(660, 355, 200, 40);
        
        moi.setBounds(350, 450, 300, 25);
        tmoi.setBounds(670, 450, 100, 25);
        btnTaux.setBounds(350, 480, 300, 25);
        taux.setBounds(670, 480, 100, 25);
        
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
       
        frame.add(tqteR);
        frame.add(tqteP);
        frame.add(QteP);
        frame.add(QteR);
        frame.add(rech);
       
        
        
    
        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnTaux);
        frame.add(btnrech);
        frame.add(taux);
        frame.add(moi);
        frame.add(tmoi);
        
        // create an array of objects to set the row data
        Object[] row = new Object[6];
        
        
        //button calculer Taux 
        btnTaux.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double s=0;
				int r =0 ;
				int rowcount =model.getRowCount();
				for(int i = 0; i < rowcount; i++) {
					System.out.println(model.getValueAt(i,5));
					String val = tmoi.getSelectedItem().toString();
					if (model.getValueAt(i,1).equals(val) ) {
						s= Double.parseDouble(model.getValueAt(i,5).toString()) + s;
						 r = r+1;
					
					}
					else {System.out.println("erreu");}
				
					
				}
				
				double z= s/(r) ; DecimalFormat df = new DecimalFormat("0.00");
                String k= df.format(z);
				taux.setText(String.valueOf(k));
				System.out.println(k);      
				
			}
        	
        });
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                row[1] = tsemaine.getSelectedItem();
                row[2] = places.getSelectedItem();
               
                row[3] = tqteP.getText();
                row[4] = tqteR.getText();
                double p = (Double.parseDouble(tqteR.getText())/Double.parseDouble(tqteP.getText()))*100;
               
             	
                row[5]= p;
                
                
                // add row to the model
                model.addRow(row);
                String a = row[1].toString() ;
                String b =row[2].toString() ;
                String c =row[3].toString() ;
                String d =row[4].toString() ;
                String ea =row[5].toString() ;
                
                ajouter(a,b,c,d,ea);
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
            
            tqteP.setText(model.getValueAt(i, 3).toString());
            tqteR.setText(model.getValueAt(i, 4).toString());
            
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
                	
                	model.setValueAt(tqteP.getText(), i, 3);
                	model.setValueAt(tqteR.getText(), i, 4);
                	double p = Double.parseDouble(tqteP.getText());
                	double r = Double.parseDouble(tqteR.getText());
                	double T = (r/p)*100 ;
                	
                	model.setValueAt(T, i, 5);
                	
                	
                	String a =tsemaine.getSelectedItem().toString() ;
                    String b =places.getSelectedItem().toString() ;
                    String c =tqteP.getText() ;
                    String d =tqteR.getText();
                    String z = Double.toString(T);
                   
                    int s = Integer.parseInt(model.getValueAt(i, 0).toString());
                    update(s,a,b,c,d,z);
                	
                	
                	
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
        ajouterTableau();
        frame.setSize(900,700);
        frame.setTitle("KPI");
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

    private void ajouter(String semaine, String pf, String ddplanifiee, String ddrealisee ,String Taux) {
        try {
            Connection cnx = connect();
           
           String a = semaine ; 
           String b = pf ;
           
           String c = ddplanifiee ;
           String d = ddrealisee;
           String e = Taux  ;
           
           
           
           
           
           String req = "INSERT INTO kpi (mois,pf,qteplanifiee,qterealisee,taux) VALUES ('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"')";
           PreparedStatement stat = cnx.prepareStatement(req);
           
           stat.executeUpdate(req);
            
            
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void ajouterTableau() {
        try {
        	Connection cnx = connect();
        	
        	String req = ("SELECT id,mois,pf,qteplanifiee,qterealisee,taux FROM kpi");
        	 PreparedStatement stat = cnx.prepareStatement(req); 
        	 ResultSet res = stat.executeQuery();
        	 
        	

           while (res.next()){
                String[] row = {
                	res.getString("id"),
                	res.getString("mois"),
                    res.getString("pf"),
                    res.getString("qteplanifiee"),
                    res.getString("qterealisee"),
                    res.getString("taux"),
                    
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
              
             
              
              
              
              String req = "DELETE FROM kpi WHERE id = ?";
              PreparedStatement stat = cnx.prepareStatement(req);
              stat.setInt(1,id);
              stat.executeUpdate();
               
               
               
              
           } catch (Exception e) {
               e.printStackTrace();
           }
      	
      	
      }
      private void update(int id, String semaine, String pf, String qteplanifiee, String qterealisee, String taux ) {
     	 try {
              Connection cnx = connect();
             
            
             
             
             
             String req = "update kpi set mois = ?,pf = ?,qteplanifiee = ?,qterealisee = ?,taux = ? where id = ?";
             PreparedStatement stat = cnx.prepareStatement(req);
             stat.setInt(6,id);
             stat.setString(1, semaine);
             stat.setString(2, pf);
             stat.setString(3, qteplanifiee);
             stat.setString(4, qterealisee);
             stat.setString(5, taux);
            
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
