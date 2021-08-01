package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.CentroDeTrabajo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarIdV extends JDialog {

	private final JPanel panelcontenido = new JPanel();
	private JTextField textodeID;
	private JLabel lbl_titulo;
	private JButton botoneliminar;
	private String mi_Id;
	private int miestado;


	public BuscarIdV(String id,CentroDeTrabajo CentroDeTrabajo,int status) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarIdV.class.getResource("/logo.png")));
		this.mi_Id=id;
		this.miestado=status;
		setTitle("Eliminar");
		setBounds(100, 100, 445, 198);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		panelcontenido.setBackground(Color.WHITE);
		panelcontenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelcontenido, BorderLayout.CENTER);
		panelcontenido.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBackground(Color.WHITE);
			panelcontenido.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				lbl_titulo = new JLabel("Introduzca el RNC de la Empresa a eliminar:");
				lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lbl_titulo.setBounds(68, 22, 315, 14);
				panel.add(lbl_titulo);
			}
			
			
			textodeID = new JTextField();
			textodeID.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textodeID.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if(miestado==1 || miestado==4 || miestado ==3) {
						char caracter = e.getKeyChar();
		                if (((caracter < '0') || (caracter > '9'))
		                        && (caracter != '\b')  || (textodeID.getText().length()==11)) {
		                    e.consume();
		                    
		                }
					}
					else {
					char caracter = e.getKeyChar();
	                	if (((caracter < '0') || (caracter > '9'))
	                			&& (caracter != '\b') ) {
	                		e.consume();
	                	}
	                }
				}
			});
			textodeID.setBounds(78, 47, 262, 31);
			panel.add(textodeID);
			textodeID.setColumns(10);
			
			botoneliminar = new JButton("Eliminar");
			botoneliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mi_Id=textodeID.getText();
					if(textodeID.getText().equalsIgnoreCase(""))
						JOptionPane.showMessageDialog(null, "No deje el campo vacío", "Problema de búsqueda", JOptionPane.CLOSED_OPTION);	
					else if(CentroDeTrabajo.buscarcompaniaporid(mi_Id)==null && (status==0 || status==2 || status==5))
						JOptionPane.showMessageDialog(null, "Esta empresa no existe", "Empresa no encontrada", JOptionPane.CLOSED_OPTION);
					else if(CentroDeTrabajo.buscarpersonaporid(mi_Id)==null && (status==1||status==3 || status==4))
						JOptionPane.showMessageDialog(null, "Esta persona no existe", "Persona no encontrada", JOptionPane.CLOSED_OPTION);
					else 
						dispose();
					
					
				}
			});
			botoneliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			botoneliminar.setBounds(78, 103, 101, 31);
			panel.add(botoneliminar);
			
			setTitleAndLabel(status);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mi_Id="";
					dispose();
				}
			});
			btnSalir.setBounds(239, 103, 101, 31);
			panel.add(btnSalir);
		}
	}
	
	public String getID() {
		return this.mi_Id;
	}

	private void setTitleAndLabel(int status) {
		if(status==0) {
			this.setTitle("Eliminar Empresa");
			this.lbl_titulo.setText("Introduzca el RNC:");
		}
		else if (status==1) {
			this.setTitle("Eliminar Persona");
			this.lbl_titulo.setText("Introduzca la cédula:");
		}
		else if(status==2) {
			this.setTitle("Eliminar Solicitud de Empresa");
			this.lbl_titulo.setText("Introduzca el RNC de la Empresa:");
			this.botoneliminar.setText("Acceder");
		}
		else if(status==3){
			this.setTitle("Eliminar Solicitud de Persona");
			this.lbl_titulo.setText("Introduzca la cédula de la Persona:");
			this.botoneliminar.setText("Acceder");
		}
		else if(status==4) {
			this.setTitle("Modificar Persona");
			this.lbl_titulo.setText("Introduzca la cédula de la Persona:");
			this.botoneliminar.setText("Acceder");
		}
		else  {
			this.setTitle("Modificar Empresa");
			this.lbl_titulo.setText("Introduzca el RNC de la Empresa:");
			this.botoneliminar.setText("Acceder");
		}
		
	}
}
