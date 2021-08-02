package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Compania;
import logico.SolicitudCompania;
import logico.SolicitudEmpleado;
import logico.CentroDeTrabajo;
import logico.Persona;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmparejamientoEmpleado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelcontenido = new JPanel();
	private JTextField textodeRNC;
	private JTextField textodenombre;
	private JTable tabla;
	private JComboBox<String> cbxdesolicitud;
	private Compania c;
	private DefaultTableModel modelo;
	@SuppressWarnings("unused")
	private int selecciones[];
	private JButton botoncontratar;
	private JButton botoninfo;
	private JButton botontrabajo;
	private List<SolicitudCompania> solicitudes;

	/**
	 * Create the dialog.
	 */
	public EmparejamientoEmpleado() {
		solicitudes = new ArrayList<SolicitudCompania>();
		selecciones = null;
		c = null;
		setIconImage(Toolkit.getDefaultToolkit().getImage(EmparejamientoEmpleado.class.getResource("/logo.png")));
		setBounds(100, 100, 981, 650);
		getContentPane().setLayout(new BorderLayout());
		panelcontenido.setBackground(Color.WHITE);
		panelcontenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelcontenido, BorderLayout.CENTER);
		panelcontenido.setLayout(null);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmpresa.setBounds(298, 13, 79, 27);
		panelcontenido.add(lblEmpresa);
		
		cbxdesolicitud = new JComboBox<String>();
		cbxdesolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!cbxdesolicitud.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")) {
					load(solicitudes);
					tabla.setModel(modelo);
				}else {
					modelo.setRowCount(0);
					tabla.setModel(modelo);
				}
			}
		});
		cbxdesolicitud.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxdesolicitud.setModel(new DefaultComboBoxModel<String>(new String[] {" Ingrese RNC"}));
		cbxdesolicitud.setEnabled(false);
		cbxdesolicitud.setBounds(494, 71, 310, 27);
		panelcontenido.add(cbxdesolicitud);
		
		textodeRNC = new JTextField();
		textodeRNC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(caracter != '-') {
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')  ) {
	                    e.consume();
	                }					
				}
			}		
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(!(textodeRNC.getText().equalsIgnoreCase(""))) {
					modelo.setRowCount(0);
					tabla.setModel(modelo);
					c = CentroDeTrabajo.getInstance().buscarcompaniaporid(textodeRNC.getText());
					if(c != null) {
						textodenombre.setText(" "+c.getNombre());
						solicitudes = CentroDeTrabajo.getInstance().getSolicitudCompania(c);
						updateCbx(solicitudes);
						cbxdesolicitud.setEnabled(true);
					}else {
						textodenombre.setText("");
						cbxdesolicitud.setModel(new DefaultComboBoxModel<String>(new String[] {" Ingrese RNC Valido"}));
						cbxdesolicitud.setEnabled(false);
						modelo.setRowCount(0);
						botoninfo.setEnabled(false);
						botontrabajo.setEnabled(false);
						botoncontratar.setEnabled(false);
					}
				}else {
					c = null;
					textodenombre.setText(" Ingrese RNC");
					cbxdesolicitud.setModel(new DefaultComboBoxModel<String>(new String[] {" Ingrese RNC"}));
					cbxdesolicitud.setEnabled(false);
					modelo.setRowCount(0);
					botoninfo.setEnabled(false);
					botontrabajo.setEnabled(false);
					botoncontratar.setEnabled(false);
				}
			}
		});
		textodeRNC.setBounds(80, 13, 136, 27);
		panelcontenido.add(textodeRNC);
		textodeRNC.setColumns(10);
		
		JLabel lblRnc = new JLabel("RNC:");
		lblRnc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRnc.setBounds(26, 13, 51, 27);
		panelcontenido.add(lblRnc);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 945, 8);
		panelcontenido.add(separator);
		
		JLabel lblEmpleadosConPorcentaje = new JLabel("Empleados con porcentaje de emparejamiento para la solicitud:");
		lblEmpleadosConPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmpleadosConPorcentaje.setBounds(26, 70, 458, 29);
		panelcontenido.add(lblEmpleadosConPorcentaje);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 945, 450);
		panelcontenido.add(scrollPane);
		
		String[] colums = {"Solicitud No.","Cédula", "Nombre", "Sexo","Salario Mín","Horas de trabajo","Porcentaje de enlace"};
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(colums);
		
		tabla = new JTable();
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(tabla.getSelectedRows().length > 1) {
					selecciones = tabla.getSelectedRows();
					botoninfo.setEnabled(false);
					botontrabajo.setEnabled(false);
					botoncontratar.setEnabled(true);
					
				}if(tabla.getSelectedRows().length == 1) {
					selecciones = tabla.getSelectedRows();
					botoninfo.setEnabled(true);
					botontrabajo.setEnabled(true);
					botoncontratar.setEnabled(true);
				}
				if(tabla.getSelectedRows().length<1) {
					selecciones = null;
					botoninfo.setEnabled(false);
					botontrabajo.setEnabled(false);
					botoncontratar.setEnabled(false);
				}
			}
		});
		tabla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabla.setModel(modelo);
		scrollPane.setViewportView(tabla);
		
		textodenombre = new JTextField();
		textodenombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textodenombre.setText(" Ingrese RNC");
		textodenombre.setEditable(false);
		textodenombre.setColumns(10);
		textodenombre.setBounds(387, 13, 554, 27);
		panelcontenido.add(textodenombre);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			botoninfo = new JButton("Informaci\u00F3n Personal");
			botoninfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Persona aux = CentroDeTrabajo.getInstance().buscarsolicitudempID((String)modelo.getValueAt(selecciones[0], 0)).getAplicante();
					InformacionPersonaV info = new InformacionPersonaV(aux);
					info.setLocationRelativeTo(null);
					info.setVisible(true);
				}
			});
			botoninfo.setEnabled(false);
			buttonPane.add(botoninfo);
			
			botontrabajo = new JButton("Informaci\u00F3n Laboral");
			botontrabajo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SolicitudEmpleado aux = CentroDeTrabajo.getInstance().buscarsolicitudempID((String)modelo.getValueAt(selecciones[0], 0));
					InfoSolicitudTrabajo info = new InfoSolicitudTrabajo(aux);
					info.setLocationRelativeTo(null);
					info.setVisible(true);
				}
			});
			botontrabajo.setEnabled(false);
			buttonPane.add(botontrabajo);
			
			JLabel label = new JLabel("                                                                                                                                                  ");
			buttonPane.add(label);
			{
				botoncontratar = new JButton("Contratar");
				botoncontratar.setEnabled(false);
				botoncontratar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(selecciones.length > 0) {
							int position = cbxdesolicitud.getSelectedIndex();
							SolicitudCompania selected = solicitudes.get(position-1);
							List<SolicitudEmpleado> requestsSelected = new ArrayList<SolicitudEmpleado>();
							for (int i : selecciones) {
								requestsSelected.add(CentroDeTrabajo.getInstance().buscarsolicitudempID((String) modelo.getValueAt(selecciones[i], 0)));			
							}
							
							for (SolicitudEmpleado r : requestsSelected) {
								r.getAplicante().setEstadotrabajo(true);
								r.setestado(false);	
							}
							int amount = selected.getCantidad();
							selected.setCantidad(--amount);
							if(selected.getCantidad() == 0) {
								selected.setEstado(false);
							}
							clear();
							
						}	
						dispose();
					}
				});
				botoncontratar.setActionCommand("OK");
				buttonPane.add(botoncontratar);
				getRootPane().setDefaultButton(botoncontratar);
			}
			{
				JButton btnCancel = new JButton("Cancelar");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
	private void updateCbx(List<SolicitudCompania> solicitudes) {
		DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>();
		if(solicitudes.size()>=1) {
			model1.addElement("<Seleccione>");
			for (SolicitudCompania cr : solicitudes) {
				model1.addElement("Solicitud > "+cr.getTipo_de_empleado()+" Cantidad: "+cr.getCantidad());
			}
			cbxdesolicitud.setModel(model1);	
		}else {
			model1.addElement("<No existe solicitud>");
		}
		cbxdesolicitud.setModel(model1);
	}	
	
	private void load(List<SolicitudCompania> solicitudes) {
		modelo.setRowCount(0);
		Object[] row = new Object[modelo.getColumnCount()];
		int position = cbxdesolicitud.getSelectedIndex();
		SolicitudCompania selected = solicitudes.get(position-1);
		List<SolicitudEmpleado> req_persons = CentroDeTrabajo.getInstance().Emparejamiento(selected);
		for (SolicitudEmpleado er : req_persons) {
			row[0] = er.getId();
			row[1] = er.getAplicante().getId();
			row[2] = er.getAplicante().getNombre()+" "+er.getAplicante().getApellido();
			row[3] = er.getAplicante().getGenero();
			row[4] = ""+er.getSalariominimo();
			row[5] = ""+er.getHrsdetrabajo();
			row[6] = ""+CentroDeTrabajo.getInstance().getEmparejamientoPorcent(er, selected)+" %";
			modelo.addRow(row);
		}	
	}
	
	private void clear() {
		textodeRNC.setText("");
		textodenombre.setText(" Ingrese RNC");
		cbxdesolicitud.setModel(new DefaultComboBoxModel<String>(new String[] {" Ingrese RNC"}));
		cbxdesolicitud.setEnabled(false);
		modelo.setRowCount(0);
		botoninfo.setEnabled(false);
		botontrabajo.setEnabled(false);
		botoncontratar.setEnabled(false);
	}
}
