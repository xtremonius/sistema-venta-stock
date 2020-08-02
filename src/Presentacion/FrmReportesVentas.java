package Presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class FrmReportesVentas extends JInternalFrame {
	
	
	public FrmReportesVentas() {
		pack();
		setResizable(true);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Reportes Ventas");
        
        setSize(800, 400);
     	try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        setVisible(true);
	}
	
	
	
	
	private JPanel _crearPCentro() {
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.add(new JLabel("Holaaa"));
		p.add(new JTextField(10));
		p.setBorder(BorderFactory.createEtchedBorder());
		
		//JPanel x = new JPanel(new GridBagLayout());
		//GridBagConstraints constraints = new GridBagConstraints();
		
		
		//TitledBorder titleBoder = BorderFactory.createTitledBorder(border);
		//x.setBorder(titleBoder);
		/*
		vlogin = new JLabel("Login");
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(vlogin, constraints);
		constraints.weighty = 0.0;
		
		
		txtlogin = new JTextField(10);
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(txtlogin, constraints);
		constraints.weighty = 0.0;
		
		
		vpassword = new JLabel("Password");
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(vpassword, constraints);
		constraints.weighty = 0.0;
		
		
		txtpassword = new JPasswordField(10);
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(txtpassword, constraints);
		constraints.weighty = 0.0;
		
		
		
		
		
		
		/*
		vpassword = new JLabel("Password");
		o.add(vpassword);
		txtpassword = new JPasswordField(8);
		o.add(txtpassword);
		
		p.add(o);*/

		
		return p; 
		
		
		
	}





}
