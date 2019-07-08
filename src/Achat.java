

import java.awt.Color;
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
import java.util.regex.PatternSyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Achat {
	 // background
    ImageIcon img = new ImageIcon("src//image.png");
    JLabel background = new JLabel("", img, JLabel.CENTER);
 // create JFrame and JTable
    JFrame frame = new JFrame();
    JTable table = new JTable(); 
    JTextField rech = new JTextField();
    
    // create a table model and set a Column Identifiers to this model 
    Object[] columns = {"id","N° BC","Fournisseur","Transitaire","Banque","DEVISE","Valeur Facture"};
    DefaultTableModel model = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    
		
    Achat(){
        
        
        model.setColumnIdentifiers(columns);
        
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        frame.setContentPane(background);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        // create JTextFields
        JLabel nbc = new JLabel("N° BC") ;
        JLabel forni = new JLabel("Fournisseur") ;
        JLabel Transite = new JLabel("Transitaire") ;
        JLabel Banque = new JLabel("Banque") ;
        JLabel Device = new JLabel("DEVISE") ;
        JLabel Valeur = new JLabel("Valeur Facture") ;
        
        JTextField tnbc = new JTextField();
        JTextField tforni = new JTextField();
        JTextField tTransite= new JTextField();
        JTextField tBanque = new JTextField();
        
        
        
        
      
        String[]fill = {"EUR","USD"};
        JComboBox tDevise = new JComboBox(fill);
        tDevise.setSelectedIndex(1);
        tDevise.addActionListener(tDevise);
    	
        
    	JTextField tValeur = new JTextField();
    	JTextField tEUR = new JTextField();
    	JTextField tUSD = new JTextField();


        
        
        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");  
        JButton btnEUR = new JButton("Calculer Valeur Achats(EUR)");
        JButton btnUSD = new JButton("Calculer Valeur Achats(USD)");
        JButton btnrech = new JButton("Recherche");
        
        nbc.setBounds(20, 320, 100, 25);
        tnbc.setBounds(120, 320, 100, 25);
        forni.setBounds(20, 350, 100, 25);
        tforni.setBounds(120, 350, 100, 25);
        Transite.setBounds(20, 380, 100, 25);
        tTransite.setBounds(120, 380, 100, 25);
        Banque.setBounds(20, 410, 100, 25);
        tBanque.setBounds(120, 410, 100, 25);
        Device.setBounds(20, 440, 100, 25);
        tDevise.setBounds(120, 440, 100, 25);
        Valeur.setBounds(20, 480, 100, 25);
        tValeur.setBounds(120, 480, 100, 25);
        
        btnAdd.setBounds(350, 320, 100, 25);
        btnUpdate.setBounds(350, 365, 100, 25);
        btnDelete.setBounds(350, 410, 100, 25);
        
        btnEUR.setBounds(350, 450, 300, 25);
        tEUR.setBounds(670, 450, 100, 25);
        
        btnUSD.setBounds(350, 480, 300, 25);
        tUSD.setBounds(670, 480, 100, 25);
        
        btnrech.setBounds(350, 510, 300, 25);
        rech.setBounds(670, 510, 100, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        table.setRowSorter(sorter);
        refresh();
        pane.setBounds(0, 0, 880, 230);
        
        frame.setLayout(null);
        
        frame.add(pane);
        
        // add JTextFields to the jframe
        frame.add(nbc);
        frame.add(tnbc);
        
        frame.add(forni);
        frame.add(tforni);
        
        frame.add(Transite);
        frame.add(tTransite);
        
        frame.add(Device);
        frame.add(tDevise);
        
        frame.add(Valeur);
        frame.add(tValeur);
        frame.add(rech);
        
        frame.add(Banque);
        frame.add(tBanque);
        
        frame.add(tEUR);
        frame.add(tUSD);
       
    
        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnUSD);
        frame.add(btnEUR);
        frame.add(btnrech);
        
        // create an array of objects to set the row data
        Object[] row = new Object[7];
        
        
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
            	
            	
             
                row[1] = tnbc.getText();
                row[2] = tforni.getText();
                row[3] = tTransite.getText();
                row[4] = tBanque.getText();
                row[5] = tDevise.getSelectedItem();
                row[6] = tValeur.getText();
                String a = tnbc.getText();
                String b = tforni.getText();
                String c = tTransite.getText();
                String d= tBanque.getText();
                String ea = tDevise.getSelectedItem().toString();
                String f= tValeur.getText();
                
                ajouter(a,b,c,d,ea,f );
                String msg = "achat ajouté avec succès!";
                
              
                
               
               
                
                
                // add row to the model
                model.addRow(row);
            }
            
        });
        
        //button rechercher
        btnrech.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				recherche();
				
			}});
        
        
        
        //button calculer USD 
        btnUSD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double s=0;
				int rowcount =model.getRowCount();
				for(int i = 0; i < rowcount; i++) {
					System.out.println(model.getValueAt(i,5));
					if (model.getValueAt(i,5).equals("USD") ) {
						s= Double.parseDouble(model.getValueAt(i,6).toString())+s;
						tUSD.setText(String.valueOf(s));
						System.out.println(s);
					}
					else {System.out.println("erreu");}
				
					
				}
				      
				
			}
        	
        });
      //button calculer EUR 
        btnEUR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double s=0;
				int rowcount =model.getRowCount();
				for(int i = 0; i < rowcount; i++) {
					System.out.println(model.getValueAt(i,5));
					if (model.getValueAt(i,5).equals("EUR") ) {
						s= Double.parseDouble(model.getValueAt(i,6).toString())+s;
						tEUR.setText(String.valueOf(s));
						System.out.println(s);
					}
					else {System.out.println("erreu");}
				
					
				}
				      
				
			}
        	
        });
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
            
            tnbc.setText(model.getValueAt(i, 1).toString());
            tforni.setText(model.getValueAt(i, 2).toString());
            tTransite.setText(model.getValueAt(i, 3).toString());
            tBanque.setText(model.getValueAt(i, 4).toString());
            tDevise.setSelectedItem(model.getValueAt(i, 5).toString());
            tValeur.setText(model.getValueAt(i, 6).toString());
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
                   model.setValueAt(tnbc.getText(), i, 1);
                   model.setValueAt(tforni.getText(), i, 2);
                   model.setValueAt(tTransite.getText(), i, 3);
                   model.setValueAt(tBanque.getText(), i, 4);
                   model.setValueAt(tDevise.getSelectedItem(), i, 5);
                   model.setValueAt(tValeur.getText(), i, 6);
                   
                   String a =tnbc.getText() ;
                   String b =tforni.getText();
                   String c =tTransite.getText() ;
                   String d =tBanque.getText();
                   String ea =tDevise.getSelectedItem().toString() ;
                   String f =tValeur.getText() ;
                   int s = Integer.parseInt(model.getValueAt(i, 0).toString());
                   update(s,a,b,c,d,ea,f);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
        ajouterTableau() ;
        frame.setSize(900,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Achat Etranger");
        
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

    private void ajouter(String nbc, String fourni, String transite, String banque, String devise ,String valeur) {
        try {
            Connection cnx = connect();
           
           String a = nbc ; 
           String b = fourni ;
           String c = transite ; 
           String d = banque ;
           String e = devise;
           String f = valeur ;
           
           
           
           String req = "INSERT INTO achat (nbc,fournisseur,transitaire,banque,devise,facture) VALUES ('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"')";
           PreparedStatement stat = cnx.prepareStatement(req);
           
           stat.executeUpdate(req);
            
            
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void ajouterTableau() {
        try {
        	Connection cnx = connect();
        	
        	String req = ("SELECT id,nbc,fournisseur,transitaire,banque,devise,facture FROM achat");
        	 PreparedStatement stat = cnx.prepareStatement(req); 
        	 ResultSet res = stat.executeQuery();
        	 
        	

           while (res.next()){
                String[] row = {
                	res.getString("id"),
                    res.getString("nbc"),
                    res.getString("fournisseur"),
                    res.getString("transitaire"),
                    res.getString("banque"),
                    res.getString("devise"),
                    res.getString("facture"),
                    
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
              
             
              
              
              
              String req = "DELETE FROM achat WHERE id = ?";
              PreparedStatement stat = cnx.prepareStatement(req);
              stat.setInt(1,id);
              stat.executeUpdate();
               
               
               
              
           } catch (Exception e) {
               e.printStackTrace();
           }
      	
      	
      }
    
    private void update(int id,String nbc, String fourni, String transite, String banque, String devise ,String valeur) {
     	 try {
              Connection cnx = connect();
             
            
             
             
             
             String req = "update achat set nbc= ?,fournisseur= ?,transitaire= ?,banque= ?,devise= ?,facture= ? where id = ?";
             PreparedStatement stat = cnx.prepareStatement(req);
             stat.setInt(7,id);
             stat.setString(1, nbc);
             stat.setString(2, fourni);
             stat.setString(3, transite);
             stat.setString(4, banque);
             stat.setString(5, devise);
             stat.setString(6, valeur);
            
            
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