

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

public class Gestion{
	 // background
    ImageIcon img = new ImageIcon("src//image.png");
    JLabel background = new JLabel("", img, JLabel.CENTER);
 // create JFrame and JTable
    JFrame frame = new JFrame();
    JTable table = new JTable(); 
    JTextField rech = new JTextField();
    
    // create a table model and set a Column Identifiers to this model 
    Object[] columns = {"id","Reference","Désignation","Quantité(g)","Besoin Moy Mois(g)","Couverture Stock","Mois"};
    DefaultTableModel model = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    
		
    Gestion(){
        
        
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
        JLabel ref = new JLabel("Référence:") ;
        JLabel mois = new JLabel("choisissez un mois") ;
        JLabel qte = new JLabel("Quntité:") ;
        JLabel bmai = new JLabel("Besoin Moy Mois:") ;
        
       
        
        
        JTextField tdes = new JTextField();
        JTextField tqte= new JTextField();
        JTextField tbessoin = new JTextField();
        JTextField tcouver = new JTextField() ;
       
        
       
        
        
        String[]fil = {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Nouvembre","Decembre"};
        JComboBox tmois = new JComboBox(fil);
        tmois.setSelectedIndex(11);
        tmois.addActionListener(tmois);
        
        
      
        String[]fill = {"PA0001","PA0002","PA0003","PA0004","PA0005","EX0001","EX0002","EX0005","EX0006","EX0007","EX0008","EX0009"};
        JComboBox tref = new JComboBox(fill);
        tref.setSelectedIndex(11);
        tref.addActionListener(tref);
    	
    	
    	
        



        
        
        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update"); 
        JButton btnrech = new JButton("Recherche");
        
        
        
        
        mois.setBounds(20, 320, 150, 25);
        tmois.setBounds(175, 320, 150, 25);
        ref.setBounds(20, 350, 150, 25);
        tref.setBounds(175, 350, 150, 25);
        qte.setBounds(20, 380, 150, 25);
        tqte.setBounds(175, 380, 150, 25);
        
       
        
        btnAdd.setBounds(350, 320, 200, 50);
        btnUpdate.setBounds(350, 375, 200, 50);
        btnDelete.setBounds(350, 430, 200, 50);
        btnrech.setBounds(350, 485, 200, 50);
        rech.setBounds(555, 485, 200, 50);
        
        
        
        
       
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        table.setRowSorter(sorter);
        refresh();
        pane.setBounds(0, 0, 880, 230);
        
        frame.setLayout(null);
        
        frame.add(pane);
        
        
        
        // add JTextFields to the jframe
        frame.add(ref);
        frame.add(tref);
        
        frame.add(mois);
    frame.add(tmois);
        
        frame.add(qte);
        frame.add(tqte);
        frame.add(rech);
        
        
        
       
    
        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnrech);
       
        
        // create an array of objects to set the row data
        Object[] row = new Object[7];
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                row[1] = tref.getSelectedItem();
                if (tref.getSelectedItem().toString().equals("PA0001")) {row[2]="FLUOROURACILE";}
                if (tref.getSelectedItem().toString().equals("PA0002")) {row[2]="DOCETAXEL ANYDRE";}
                if (tref.getSelectedItem().toString().equals("PA0003")) {row[2]="OXALIPLATINE";}
                if (tref.getSelectedItem().toString().equals("PA0004")) {row[2]="CHLORHYDRATE D'EPIRUBICINE";}
                if (tref.getSelectedItem().toString().equals("PA0005")) {row[2]="PACLITAXEL";}
                if (tref.getSelectedItem().toString().equals("EX0001")) {row[2]="HYDROXYDE DE SODIUM";}
                if (tref.getSelectedItem().toString().equals("EX0002")) {row[2]="ACIDE CHLORHYDRIQUE";}
                if (tref.getSelectedItem().toString().equals("EX0005")) {row[2]="POLYSORBATE 80";}
                if (tref.getSelectedItem().toString().equals("EX0006")) {row[2]="ETHANOL ANHYDRE";}
                if (tref.getSelectedItem().toString().equals("EX0007")) {row[2]="ACIDE CITRIQUE ANHYDRE";}
                if (tref.getSelectedItem().toString().equals("EX0008")) {row[2]="CHLORURE DE SODIUM";}
                if (tref.getSelectedItem().toString().equals("EX0009")) {row[2]="MACROGOLGLYCEROL RICINOLEATE PEG35";}
                
                row[3] = tqte.getText();
                
                
                if (tref.getSelectedItem().toString().equals("PA0001"))   {	if(tmois.getSelectedItem().toString().equals("Fevrier")) { row[4] = "0";row[5] = "0";}
                															if(tmois.getSelectedItem().toString().equals("Mars")) { row[4] = "0";row[5] = "0";}
                															if(tmois.getSelectedItem().toString().equals("Avril")) { row[4] = "0";row[5] = "0";}
                															if(tmois.getSelectedItem().toString().equals("Mai")) { row[4] = "0";row[5] = "0";}
                															if(tmois.getSelectedItem().toString().equals("Juin")) { row[4] = "9000";row[5] = Integer.parseInt(tqte.getText())/9000;}
                															if(tmois.getSelectedItem().toString().equals("Juillet")) { row[4] = "9000";row[5] = Integer.parseInt(tqte.getText())/9000;}
                															if(tmois.getSelectedItem().toString().equals("Aout")) { row[4] = "0";row[5] = "0";}
                															if(tmois.getSelectedItem().toString().equals("Septembre")) { row[4] = "9000";row[5] = Integer.parseInt(tqte.getText())/9000;}
                															if(tmois.getSelectedItem().toString().equals("Octobre")) { row[4] = "13500";row[5] = Integer.parseInt(tqte.getText())/13500;}
                															if(tmois.getSelectedItem().toString().equals("Nouvembre")) { row[4] = "27000";row[5] = Integer.parseInt(tqte.getText())/27000;}
                															if(tmois.getSelectedItem().toString().equals("Decembre")) { row[4] = "13500";row[5] = Integer.parseInt(tqte.getText())/13500;}
                															}
                														 
                															
                
                if (tref.getSelectedItem().toString().equals("PA0002")) {  	if(tmois.getSelectedItem().toString().equals("Fevrier")) { row[4] = "0";row[5] = "0";}
                															if(tmois.getSelectedItem().toString().equals("Mars")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Avril")) { row[4] = "0";row[5] = "0";}
                															if(tmois.getSelectedItem().toString().equals("Mai")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Juin")) { row[4] = "600"; row[5] = Integer.parseInt(tqte.getText())/600;}
                															if(tmois.getSelectedItem().toString().equals("Juillet")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Aout")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Septembre")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Octobre")) { row[4] = "600";row[5] = Integer.parseInt(tqte.getText())/ 600;}
                															if(tmois.getSelectedItem().toString().equals("Nouvembre")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Decembre")) { row[4] = "0";row[5] ="0";}																		
																			}
                															
                
                
                if (tref.getSelectedItem().toString().equals("PA0003")) {  	if(tmois.getSelectedItem().toString().equals("Fevrier")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Mars")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Avril")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Mai")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Juin")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Juillet")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Aout")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Septembre")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Octobre")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Nouvembre")) { row[4] = "300"; row[5] = Integer.parseInt(tqte.getText())/ 300;}
                															if(tmois.getSelectedItem().toString().equals("Decembre")) { row[4] = "0";row[5] =0;} 																			
																			}
                
                
                if (tref.getSelectedItem().toString().equals("PA0004")) {  	if(tmois.getSelectedItem().toString().equals("Fevrier")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Mars")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Avril")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Mai")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Juin")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Juillet")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Aout")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Septembre")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Octobre")) { row[4] = "1260";row[5] = Integer.parseInt(tqte.getText())/ 1260;}
                															if(tmois.getSelectedItem().toString().equals("Nouvembre")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Decembre")) { row[4] = "0";row[5] =0;}}
                
                
                
                if (tref.getSelectedItem().toString().equals("PA0005")) {   if(tmois.getSelectedItem().toString().equals("Fevrier")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Mars")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Avril")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Mai")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Juin")) { row[4] = "720";row[5] = Integer.parseInt(tqte.getText())/ 720;}
                															if(tmois.getSelectedItem().toString().equals("Juillet")) { row[4] = "540";row[5] = Integer.parseInt(tqte.getText())/ 540;}
                															if(tmois.getSelectedItem().toString().equals("Aout")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Septembre")) { row[4] = "900";row[5] = Integer.parseInt(tqte.getText())/ 900;}
                															if(tmois.getSelectedItem().toString().equals("Octobre")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Nouvembre")) { row[4] = "0";row[5] =0;}
                															if(tmois.getSelectedItem().toString().equals("Decembre")) { row[4] = "0";row[5] =0;}}
                
                
                if (tref.getSelectedItem().toString().equals("EX0001")) {   if(tmois.getSelectedItem().toString().equals("Fevrier")) { row[4] = "0";row[5] =0;}
																			if(tmois.getSelectedItem().toString().equals("Mars")) { row[4] = "0";row[5] =0;}
																			if(tmois.getSelectedItem().toString().equals("Avril")) { row[4] = "0";row[5] =0;}
																			if(tmois.getSelectedItem().toString().equals("Mai")) { row[4] = "0";row[5] =0;}
																			if(tmois.getSelectedItem().toString().equals("Juin")) { row[4] = "2800";row[5] = Integer.parseInt(tqte.getText())/ 2800;}
																			if(tmois.getSelectedItem().toString().equals("Juillet")) { row[4] = "2800";row[5] = Integer.parseInt(tqte.getText())/ 2800;}
																			if(tmois.getSelectedItem().toString().equals("Aout")) { row[4] = "0";row[5] =0;}
																			if(tmois.getSelectedItem().toString().equals("Septembre")) { row[4] = "2800";row[5] = Integer.parseInt(tqte.getText())/ 2800;}
																			if(tmois.getSelectedItem().toString().equals("Octobre")) { row[4] = "4200";row[5] = Integer.parseInt(tqte.getText())/ 4200;}
																			if(tmois.getSelectedItem().toString().equals("Nouvembre")) { row[4] = "8400";row[5] = Integer.parseInt(tqte.getText())/ 8400;}
																			if(tmois.getSelectedItem().toString().equals("Decembre")) { row[4] = "4200";row[5] = Integer.parseInt(tqte.getText())/ 4200;}}
                
                if (tref.getSelectedItem().toString().equals("EX0002")) {   if(tmois.getSelectedItem().toString().equals("Fevrier")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Mars")) { row[4] = "0";row[5] =0;}
																			if(tmois.getSelectedItem().toString().equals("Avril")) { row[4] = "0";row[5] =0;}
																			if(tmois.getSelectedItem().toString().equals("Mai")) { row[4] = "0";row[5] =0;}
																			if(tmois.getSelectedItem().toString().equals("Juin")) { row[4] = "103";row[5] = Integer.parseInt(tqte.getText())/ 103;}
																			if(tmois.getSelectedItem().toString().equals("Juillet")) { row[4] = "103";row[5] = Integer.parseInt(tqte.getText())/ 103;}
																			if(tmois.getSelectedItem().toString().equals("Aout")) { row[4] = "0";row[5] =0;}
																			if(tmois.getSelectedItem().toString().equals("Septembre")) { row[4] = "103";row[5] = Integer.parseInt(tqte.getText())/ 103;}
																			if(tmois.getSelectedItem().toString().equals("Octobre")) { row[4] = "618";row[5] = Integer.parseInt(tqte.getText())/ 618;}
																			if(tmois.getSelectedItem().toString().equals("Nouvembre")) { row[4] = "309";row[5] = Integer.parseInt(tqte.getText())/ 309;}
																			if(tmois.getSelectedItem().toString().equals("Decembre")) { row[4] = "155";row[5] = Integer.parseInt(tqte.getText())/ 155 ;}}
                
                if (tref.getSelectedItem().toString().equals("EX0005")) {  if(tmois.getSelectedItem().toString().equals("Fevrier")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Mars")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Avril")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Mai")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Juin")) { row[4] = "15540";row[5] = Integer.parseInt(tqte.getText())/ 15540 ;}
																			if(tmois.getSelectedItem().toString().equals("Juillet")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Aout")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Septembre")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Octobre")) { row[4] = "15540";row[5] = Integer.parseInt(tqte.getText())/ 15540 ;}
																			if(tmois.getSelectedItem().toString().equals("Nouvembre")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Decembre")) { row[4] = "0";row[5] ="0";}}
                
                if (tref.getSelectedItem().toString().equals("EX0006")) {  if(tmois.getSelectedItem().toString().equals("Fevrier")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Mars")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Avril")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Mai")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Juin")) { row[4] = "59180";row[5] = Integer.parseInt(tqte.getText())/ 59180;}
																			if(tmois.getSelectedItem().toString().equals("Juillet")) { row[4] = "35520";row[5] = Integer.parseInt(tqte.getText())/ 35520;}
																			if(tmois.getSelectedItem().toString().equals("Aout")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Septembre")) { row[4] = "59200";row[5] = Integer.parseInt(tqte.getText())/ 59180;}
																			if(tmois.getSelectedItem().toString().equals("Octobre")) { row[4] = "11820";row[5] = Integer.parseInt(tqte.getText())/ 11820;}
																			if(tmois.getSelectedItem().toString().equals("Nouvembre")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Decembre")) { row[4] = "0";}row[5] ="0";}
                

                if (tref.getSelectedItem().toString().equals("EX0007")) {  if(tmois.getSelectedItem().toString().equals("Fevrier")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Mars")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Avril")) { row[4] = "1700";row[5] = Integer.parseInt(tqte.getText())/ 1700;}
                															if(tmois.getSelectedItem().toString().equals("Mai")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Juin")) { row[4] = "420";row[5] = Integer.parseInt(tqte.getText())/ 420;}
                															if(tmois.getSelectedItem().toString().equals("Juillet")) { row[4] = "180";row[5] = Integer.parseInt(tqte.getText())/ 180;}
                															if(tmois.getSelectedItem().toString().equals("Aout")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Septembre")) { row[4] = "300";row[5] = Integer.parseInt(tqte.getText())/ 300;}
                															if(tmois.getSelectedItem().toString().equals("Octobre")) { row[4] = "180";row[5] = Integer.parseInt(tqte.getText())/ 180;}
                															if(tmois.getSelectedItem().toString().equals("Nouvembre")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Decembre")) { row[4] = "0";row[5] ="0";}}
                
                if (tref.getSelectedItem().toString().equals("EX0008")) {   if(tmois.getSelectedItem().toString().equals("Fevrier")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Mars")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Avril")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Mai")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Juin")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Juillet")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Aout")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Septembre")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Octobre")) { row[4] = "5670";row[5] = Integer.parseInt(tqte.getText())/ 5670;}
                															if(tmois.getSelectedItem().toString().equals("Nouvembre")) { row[4] = "0";row[5] ="0";}
                															if(tmois.getSelectedItem().toString().equals("Decembre")) { row[4] = "0";row[5] ="0";}}
                
                if (tref.getSelectedItem().toString().equals("EX0009")) {   if(tmois.getSelectedItem().toString().equals("Fevrier")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Mars")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Avril")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Mai")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Juin")) { row[4] = "63280";row[5] = Integer.parseInt(tqte.getText())/ 63280;}
																			if(tmois.getSelectedItem().toString().equals("Juillet")) { row[4] = "47520";row[5] = Integer.parseInt(tqte.getText())/ 47520;}
																			if(tmois.getSelectedItem().toString().equals("Aout")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Septembre")) { row[4] = "79200";row[5] = Integer.parseInt(tqte.getText())/ 79200;}
																			if(tmois.getSelectedItem().toString().equals("Octobre")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Nouvembre")) { row[4] = "0";row[5] ="0";}
																			if(tmois.getSelectedItem().toString().equals("Decembre")) { row[4] = "0";row[5] ="0";}}
                
                
              
              
               
               row[6] = tmois.getSelectedItem();
               
               
                
                
                // add row to the model
                model.addRow(row);
                
                String a = row[1].toString() ;
                String b =row[2].toString() ;
                String c =row[3].toString() ;
                String d =row[4].toString() ;
                String ea =row[5].toString() ;
                String f =row[6].toString() ;
                ajouter(a,b,c,d,ea,f);
            }
          
        } );
        
        
        
       
     
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
            
            tref.setSelectedItem(model.getValueAt(i, 1).toString());
            tdes.setText(model.getValueAt(i, 2).toString());
            tqte.setText(model.getValueAt(i, 3).toString());
            tbessoin.setText(model.getValueAt(i, 4).toString());
            tcouver.setText(model.getValueAt(i, 5).toString());
            tmois.setSelectedItem(model.getValueAt(i, 6));
            
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
                	model.setValueAt(tref.getSelectedItem(), i, 1);
                	
                	if (tref.getSelectedItem().toString().equals("PA0001")) {model.setValueAt("FLUOROURACILE", i, 2);}
                	if (tref.getSelectedItem().toString().equals("PA0002")) {model.setValueAt("DOCETAXEL ANYDRE", i, 2);}
                	if (tref.getSelectedItem().toString().equals("PA0003")) {model.setValueAt("OXALIPLATINE", i, 2);}
                	if (tref.getSelectedItem().toString().equals("PA0004")) {model.setValueAt("CHLORHYDRATE D'EPIRUBICINE", i, 2);}
                	if (tref.getSelectedItem().toString().equals("PA0005")) {model.setValueAt("PACLITAXEL", i, 2);}
                	if (tref.getSelectedItem().toString().equals("EX0001")) {model.setValueAt("HYDROXYDE DE SODIUM", i, 2);}
                	if (tref.getSelectedItem().toString().equals("EX0002")) {model.setValueAt("ACIDE CHLORHYDRIQUE", i, 2);}
                	if (tref.getSelectedItem().toString().equals("EX0005")) {model.setValueAt("POLYSORBATE 80", i, 2);}
                	if (tref.getSelectedItem().toString().equals("EX0006")) {model.setValueAt("ETHANOL ANHYDRE", i, 2);}
                	if (tref.getSelectedItem().toString().equals("EX0007")) {model.setValueAt("ACIDE CITRIQUE ANHYDRE", i, 2);}
                	if (tref.getSelectedItem().toString().equals("EX0008")) {model.setValueAt("CHLORURE DE SODIUM", i, 2);}
                	if (tref.getSelectedItem().toString().equals("EX0009")) {model.setValueAt("MACROGOLGLYCEROL RICINOLEATE PEG35", i, 2);}
                	
                   model.setValueAt(tqte.getText(), i, 3);
                   
                   
                  
                   
                   if (tref.getSelectedItem().toString().equals("PA0001"))   {	if(tmois.getSelectedItem().toString().equals("Fevrier")) {  model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");tcouver.setText("0");}
                   																if(tmois.getSelectedItem().toString().equals("Mars")) { model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");tcouver.setText("0");}
                   																if(tmois.getSelectedItem().toString().equals("Avril")) {  model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");tcouver.setText("0");}
                   																if(tmois.getSelectedItem().toString().equals("Mai")) {  model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");tcouver.setText("0");}
                   																if(tmois.getSelectedItem().toString().equals("Juin")) {  model.setValueAt("9000", i, 4);model.setValueAt(Integer.parseInt(tqte.getText())/9000, i, 5);tbessoin.setText("9000");}
                   																if(tmois.getSelectedItem().toString().equals("Juillet")) {  model.setValueAt("9000", i, 4);model.setValueAt(Integer.parseInt(tqte.getText())/9000, i, 5);tbessoin.setText("9000");}
                   																if(tmois.getSelectedItem().toString().equals("Aout")) {  model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");}
                   																if(tmois.getSelectedItem().toString().equals("Septembre")) {  model.setValueAt("9000", i, 4);model.setValueAt(Integer.parseInt(tqte.getText())/9000, i, 5);tbessoin.setText("9000");}
                   																if(tmois.getSelectedItem().toString().equals("Octobre")) {  model.setValueAt("13500", i, 4);model.setValueAt(Integer.parseInt(tqte.getText())/13500, i, 5);tbessoin.setText("13500");}
                   																if(tmois.getSelectedItem().toString().equals("Nouvembre")) {  model.setValueAt("27000", i, 4);model.setValueAt(Integer.parseInt(tqte.getText())/27000, i, 5);tbessoin.setText("27000");}
                   																if(tmois.getSelectedItem().toString().equals("Decembre")) {  model.setValueAt("13500", i, 4);model.setValueAt(Integer.parseInt(tqte.getText())/13500, i, 5);tbessoin.setText("13500");}
                  																}
                   if (tref.getSelectedItem().toString().equals("PA0002"))   {	if(tmois.getSelectedItem().toString().equals("Fevrier")) {  model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");}
																				if(tmois.getSelectedItem().toString().equals("Mars")) { model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");}
																				if(tmois.getSelectedItem().toString().equals("Avril")) {  model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");}
																				if(tmois.getSelectedItem().toString().equals("Mai")) {  model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");}
																				if(tmois.getSelectedItem().toString().equals("Juin")) {  model.setValueAt("600", i, 4);model.setValueAt(Integer.parseInt(tqte.getText())/600, i, 5);tbessoin.setText("600");}
																				if(tmois.getSelectedItem().toString().equals("Juillet")) { model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");}
																				if(tmois.getSelectedItem().toString().equals("Aout")) {  model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");}
																				if(tmois.getSelectedItem().toString().equals("Septembre")) {  model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");}
																				if(tmois.getSelectedItem().toString().equals("Octobre")) {  model.setValueAt("600", i, 4);model.setValueAt(Integer.parseInt(tqte.getText())/600, i, 5);tbessoin.setText("600");}
																				if(tmois.getSelectedItem().toString().equals("Nouvembre")) { model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");}
																				if(tmois.getSelectedItem().toString().equals("Decembre")) {  model.setValueAt("0", i, 4);model.setValueAt("0", i, 5);tbessoin.setText("0");}
                   																}
                   
                   
                   
                   
                   
                
                   
                   model.setValueAt(tmois.getSelectedItem(), i, 6);
                   
                   
                   
                   
                   
                   
                  
                   String a =tref.getSelectedItem().toString() ;
                   String b = tdes.getText() ;
                   String c =tqte.getText();
                   String d =tbessoin.getText();
                   String ea =tcouver.getText();
                   String f =tmois.getSelectedItem().toString() ;
                   
                   int s = Integer.parseInt(model.getValueAt(i, 0).toString());
                   update(s,a,b,c,d,ea,f);
                
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
        ajouterTableau();
        frame.setSize(900,650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Gestion Du Stock");
        
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

	private void JScrollpane(JList<String> tref) {
		// TODO Auto-generated method stub
		
	}
	
	static Connection connect() throws SQLException, ClassNotFoundException {
        String strClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/appges";
        String login = "root";
        String pwd = "";

        Class.forName(strClassName);
        return DriverManager.getConnection(url, login, pwd);
        
        
    }

    private void ajouter(String ref, String desig, String quantite, String besoin ,String couverture, String mois) {
        try {
            Connection cnx = connect();
           
           String a = ref ; 
           String b = desig ;
           String c = quantite ; 
           String d = besoin ;
           String e = couverture;
           String f = mois ;
           
           
           
           String req = "INSERT INTO gestion (reference,designation,quantite,besoin,couverture,mois) VALUES ('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"')";
           PreparedStatement stat = cnx.prepareStatement(req);
           
           stat.executeUpdate(req);
            
            
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void ajouterTableau() {
        try {
        	Connection cnx = connect();
        	
        	String req = ("SELECT id,reference,designation,quantite,besoin,couverture,mois FROM gestion");
        	 PreparedStatement stat = cnx.prepareStatement(req); 
        	 ResultSet res = stat.executeQuery();
        	 
        	

           while (res.next()){
                String[] row = {
                	res.getString("id"),
                	res.getString("reference"),
                    res.getString("designation"),
                    res.getString("quantite"),
                    res.getString("besoin"),
                    res.getString("couverture"),
                    res.getString("mois"),
                    
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
              
             
              
              
              
              String req = "DELETE FROM gestion WHERE id = ?";
              PreparedStatement stat = cnx.prepareStatement(req);
              stat.setInt(1,id);
              stat.executeUpdate();
               
               
               
              
           } catch (Exception e) {
               e.printStackTrace();
           }
      	
      	
      }
      private void update(int id,String reference, String designation, String quantite, String besoin ,String couverture, String mois) {
     	 try {
              Connection cnx = connect();
             
            
             
             
             
             String req = "update gestion set reference= ?,designation= ?,quantite= ?,besoin= ?,couverture= ?,mois= ? where id = ?";
             PreparedStatement stat = cnx.prepareStatement(req);
             stat.setInt(7,id);
             stat.setString(1, reference);
             stat.setString(2, designation);
             stat.setString(3, quantite);
             stat.setString(4, besoin);
             stat.setString(5, couverture);
             stat.setString(6, mois);
            
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