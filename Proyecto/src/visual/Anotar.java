package visual;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Compania;
import logico.SolicitudCompania;
import logico.SolicitudEmpleado;
import logico.CentroDeTrabajo;
import logico.Persona;
import logico.Estudiante;
import logico.Tecnico;
import logico.Trabajador;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Anotar extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contenidopanel = new JPanel();
	private JTable tablaempresa;
	private JTable tablapersona;
	private List<Compania> micompanias;
	private List<SolicitudEmpleado> misolicitudemp;
	private List<SolicitudCompania> misolicitudcomp;
	private JRadioButton botontodos;
	private JRadioButton botonestudiante;
	private JRadioButton botontecnicos;
	private JRadioButton botontrabajadores;
	private List<Persona> listpersona=new ArrayList<>();
	private DefaultTableModel modelo;
	
	public Anotar(CentroDeTrabajo CentroDeTrabajo, int show) {
		setTitle("Anotar");
		this.listpersona=CentroDeTrabajo.getMipersona();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 746, 410);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contenidopanel.setBackground(Color.WHITE);
		contenidopanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contenidopanel, BorderLayout.CENTER);
		contenidopanel.setLayout(null);
		
		JPanel panelEmpresa = new JPanel();
		panelEmpresa.setBackground(Color.WHITE);
		panelEmpresa.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmpresa.setBounds(10, 10, 708, 342);
		contenidopanel.add(panelEmpresa);
		panelEmpresa.setLayout(null);
		
		JPanel panelPersona = new JPanel();
		panelPersona.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPersona.setBackground(Color.WHITE);
		panelPersona.setBounds(10, 10, 708, 342);
		contenidopanel.add(panelPersona);
		panelPersona.setLayout(null);
		
		JScrollPane scrollPaneEmpresa = new JScrollPane();
		scrollPaneEmpresa.setBounds(20, 75, 668, 171);
		panelEmpresa.add(scrollPaneEmpresa);
		
		tablaempresa = new JTable(){
			   public boolean isCellEditable(int row, int column){
			        return false;
			   }
			};
		tablaempresa.setBackground(Color.WHITE);
		tablaempresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPaneEmpresa.setViewportView(tablaempresa);
		
		if(show==0) {
			 modelo = new DefaultTableModel() {
				public Class<?> getColumnClass(int column){
					switch (column) {
					case 0:
						return String.class;
					case 1:
						return String.class;
					case 2:
						return String.class;
					case 3:
						return String.class;
					case 4:
						return String.class;
					default:
							return String.class;
					}
				}
			};
			
			tablaempresa.setModel(modelo);
			tablaempresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			modelo.addColumn("RNC");
			modelo.addColumn("Nombre");
			modelo.addColumn("Provincia");
			modelo.addColumn("Área");
			modelo.addColumn("Teléfono");
		}
		else if(show==2) {
			modelo = new DefaultTableModel() {
				public Class<?> getColumnClass(int column){
					switch (column) {
					case 0:
						return String.class;
					case 1:
						return String.class;
					case 2:
						return String.class;
					case 3:
						return String.class;
					case 4:
						return String.class;
					default:
							return String.class;
					}
				}
			};
			
			tablaempresa.setModel(modelo);
			tablaempresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			modelo.addColumn("ID Sol.");
			modelo.addColumn("RNC Empresa");
			modelo.addColumn("Habilidad");
			modelo.addColumn("Cantidad de Vacantes");
			modelo.addColumn("Estado");
		}
		else {
			modelo = new DefaultTableModel() {
				public Class<?> getColumnClass(int column){
					switch (column) {
					case 0:
						return String.class;
					case 1:
						return String.class;
					case 2:
						return String.class;
					case 3:
						return String.class;
					case 4:
						return String.class;
					default:
							return String.class;
					}
				}
			};
			
			tablaempresa.setModel(modelo);
			tablaempresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			modelo.addColumn("ID Solicitud");
			modelo.addColumn("Cédula de Persona");
			modelo.addColumn("Tipo de Persona");
			modelo.addColumn("Salario Mínimo");
			modelo.addColumn("Estado");
		}
		
		JLabel lblEmpresasReg = new JLabel("Tabla de Empresas Registradas");
		lblEmpresasReg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmpresasReg.setBounds(205, 21, 312, 28);
		panelEmpresa.add(lblEmpresasReg);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(311, 291, 99, 28);
		panelEmpresa.add(btnSalir);
		
		JLabel lblCantEmpresas = new JLabel("Cantidad de Empresas Registradas");
		lblCantEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantEmpresas.setBounds(20, 256, 390, 28);
		panelEmpresa.add(lblCantEmpresas);
		
		JScrollPane scrollPanelPersona = new JScrollPane();
		scrollPanelPersona.setBounds(20, 100, 668, 171);
		panelPersona.add(scrollPanelPersona);
		
		tablapersona= new JTable(){
			   public boolean isCellEditable(int row, int column){
			        return false;
			   }
			};
		tablapersona.setBackground(Color.WHITE);
		tablapersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPanelPersona.setViewportView(tablapersona);
		
		DefaultTableModel modelPersona = new DefaultTableModel() {
			public Class<?> getColumnClass(int column){
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
						return String.class;
				default:
						return String.class;
				}
			}
		};
		
		tablapersona.setModel(modelPersona);
		tablapersona.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelPersona.addColumn("Cédula");
		modelPersona.addColumn("Nombre");
		modelPersona.addColumn("Provincia");
		modelPersona.addColumn("Ciudad");
		modelPersona.addColumn("Profesión");
		modelPersona.addColumn("Estado");
		
		JLabel lblCantPersonas = new JLabel("Cantidad de Personas Registradas: "+String.valueOf(CentroDeTrabajo.getMipersona().size()));
		lblCantPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantPersonas.setBounds(20, 270, 271, 28);
		panelPersona.add(lblCantPersonas);
		
		botonestudiante = new JRadioButton("Estudiantes");
		botonestudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botontodos.setEnabled(true);
				botonestudiante.setEnabled(false);
				botontrabajadores.setEnabled(true);
				botontecnicos.setEnabled(true);
				botontrabajadores.setSelected(false);
				botontecnicos.setSelected(false);
				botontodos.setSelected(false);
				listpersona=CentroDeTrabajo.getEst();
				setTablePersona(listpersona,modelPersona);
				lblCantPersonas.setText("Cantidad de Estudiantes registrados: "+String.valueOf(listpersona.size()));
			}
		});
		botonestudiante.setBackground(Color.WHITE);
		botonestudiante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonestudiante.setBounds(20, 70, 103, 21);
		panelPersona.add(botonestudiante);
		
		botontecnicos = new JRadioButton("T\u00E9cnico");
		botontecnicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botontodos.setEnabled(true);
				botonestudiante.setEnabled(true);
				botontrabajadores.setEnabled(true);
				botontecnicos.setEnabled(false);
				botonestudiante.setSelected(false);
				botontrabajadores.setSelected(false);
				botontodos.setSelected(false);
				listpersona=CentroDeTrabajo.getTec();
				setTablePersona(listpersona,modelPersona);
				lblCantPersonas.setText("Cantidad de Técnicos registrados: "+String.valueOf(listpersona.size()));
			}
		});
		botontecnicos.setBackground(Color.WHITE);
		botontecnicos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botontecnicos.setBounds(250, 70, 103, 21);
		panelPersona.add(botontecnicos);
		
		botontrabajadores = new JRadioButton("Obrero");
		botontrabajadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botontodos.setEnabled(true);
				botonestudiante.setEnabled(true);
				botontrabajadores.setEnabled(false);
				botontecnicos.setEnabled(true);
				botonestudiante.setSelected(false);
				botontecnicos.setSelected(false);
				botontodos.setSelected(false);
				listpersona=CentroDeTrabajo.getTrabajadores();
				setTablePersona(listpersona,modelPersona);
				lblCantPersonas.setText("Cantidad de Obreros registrados: "+String.valueOf(listpersona.size()));
			}
		});
		botontrabajadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botontrabajadores.setBackground(Color.WHITE);
		botontrabajadores.setBounds(430, 70, 103, 21);
		panelPersona.add(botontrabajadores);
		
		botontodos = new JRadioButton("Todos");
		botontodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botontodos.setEnabled(false);
				botonestudiante.setEnabled(true);
				botontrabajadores.setEnabled(true);
				botontecnicos.setEnabled(true);
				botonestudiante.setSelected(false);
				botontecnicos.setSelected(false);
				botontrabajadores.setSelected(false);
				listpersona=CentroDeTrabajo.getMipersona();
				setTablePersona(listpersona,modelPersona);
				lblCantPersonas.setText("Cantidad de Personas registradas: "+String.valueOf(listpersona.size()));
			}
		});
		botontodos.setEnabled(false);
		botontodos.setSelected(true);
		botontodos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botontodos.setBackground(Color.WHITE);
		botontodos.setBounds(610, 70, 65, 21);
		panelPersona.add(botontodos);
		
		JLabel lblTablaDePersonas = new JLabel("Tabla de Personas Registradas");
		lblTablaDePersonas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTablaDePersonas.setBounds(210, 21, 262, 28);
		panelPersona.add(lblTablaDePersonas);
		
		JButton btnMasInfo = new JButton("M\u00E1s Informaci\u00F3n ");
		btnMasInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tablapersona.getSelectedRow()<0)
					JOptionPane.showMessageDialog(null, "Seleccione una persona", "Problema de selección", JOptionPane.CLOSED_OPTION);
				else {
					String cedula=(String) tablapersona.getValueAt(tablapersona.getSelectedRow(), 0);
					Persona Persona= CentroDeTrabajo.getInstance().buscarpersonaporid(cedula);
					InformacionPersonaV info=new InformacionPersonaV(Persona);
					info.setVisible(true);
				}
			}
		});
		btnMasInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMasInfo.setBounds(508, 291, 180, 28);
		panelPersona.add(btnMasInfo);
		
		JButton btnSalirPersona = new JButton("Salir");
		btnSalirPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalirPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalirPersona.setBounds(311, 291, 99, 28);
		panelPersona.add(btnSalirPersona);
		
		if(show==0) { //Anotar EMPRESA
			panelPersona.setVisible(false);
			setTitle("Anotar Empresa");
			this.micompanias=CentroDeTrabajo.getMicompania();
			setTableEmpresa(modelo,micompanias);
			lblCantEmpresas.setText("Cantidad de Empresas Registradas: "+ String.valueOf(micompanias.size()));
		}
		else if (show==1){ //Anotar PERSONA
			panelEmpresa.setVisible(false);
			setTitle("Anotar Persona");
			setTablePersona(listpersona,modelPersona);
		}
		else if(show==2) {
			panelPersona.setVisible(false);
			lblEmpresasReg.setText("Tabla de Solicitudes de Empresas");
			setTitle("Anotar Solicitud de Empresas");
			this.misolicitudcomp=CentroDeTrabajo.getMisolicitud_c();
			setTableEmpresaSolicitud(modelo,misolicitudcomp);
			lblCantEmpresas.setText("Cantidad de Solicitudes de Empresas Registradas: "+ String.valueOf(misolicitudcomp.size()));
		}
		else {
			panelPersona.setVisible(false);
			lblEmpresasReg.setText("Tabla de Solicitudes de Personas");
			setTitle("Anotar Solicitud de Personas");
			this.misolicitudemp=CentroDeTrabajo.getMisolicitud_e();
			setTablePersonaSolicitud(modelo,misolicitudemp);
			lblCantEmpresas.setText("Cantidad de Solicitudes de Personas Registradas: "+ String.valueOf(misolicitudemp.size()));
		}
	}

	private void setTablePersonaSolicitud(DefaultTableModel modelo, List<SolicitudEmpleado> list) {
		modelo.setRowCount(0);
		for(int b=0;b<list.size();b++) {
			modelo.addRow(new Object[0]);	
			modelo.setValueAt(list.get(b).getId(), b, 0);
			modelo.setValueAt(list.get(b).getAplicante().getId(), b, 1);
			if(list.get(b).getAplicante() instanceof Estudiante)
				modelo.setValueAt("Estudiante", b, 2);
			else if(list.get(b).getAplicante() instanceof Tecnico)
				modelo.setValueAt("Técnico", b, 2);
			else
				modelo.setValueAt("Obrero", b, 2);
			modelo.setValueAt(String.valueOf(String.valueOf(list.get(b).getSalariominimo())), b, 3);
			if(list.get(b).isestado()==true) 
				modelo.setValueAt("Activa", b, 4);
			else
				modelo.setValueAt("Inactiva", b, 4);
		}
	}

	private void setTableEmpresaSolicitud(DefaultTableModel modelo, List<SolicitudCompania> list) {
		modelo.setRowCount(0);
		for(int b=0;b<list.size();b++) {
			modelo.addRow(new Object[0]);	
			modelo.setValueAt(list.get(b).getId(), b, 0);
			modelo.setValueAt(list.get(b).getCompania().getRnc(), b, 1);
			modelo.setValueAt(list.get(b).getHabilidades_requeridas(), b, 2);
			modelo.setValueAt(String.valueOf(list.get(b).getCantidad()), b, 3);
			if(list.get(b).isEstado()==true) 
				modelo.setValueAt("Activa", b, 4);
			else
				modelo.setValueAt("Inactiva", b, 4);
		}
		
	}

	private void setTablePersona(List<Persona> list, DefaultTableModel modelPersona) {
		modelPersona.setRowCount(0);
		for(int b=0;b<list.size();b++) {
			modelPersona.addRow(new Object[0]);	
			modelPersona.setValueAt(list.get(b).getId(), b, 0);
			modelPersona.setValueAt(list.get(b).getNombre()+" "+list.get(b).getApellido(), b, 1);
			modelPersona.setValueAt(list.get(b).getProvincia(), b, 2);
			modelPersona.setValueAt(list.get(b).getCiudad(), b, 3);
			if(list.get(b) instanceof Estudiante)
				modelPersona.setValueAt("Estudiante", b, 4);
			else if(list.get(b) instanceof Tecnico)
				modelPersona.setValueAt("Técnico", b, 4);
			else
				modelPersona.setValueAt("Obrero", b, 4);
			if(list.get(b).getEstadotrabajo())
				modelPersona.setValueAt("Empleado", b, 5);
			else
				modelPersona.setValueAt("Desempleado", b, 5);
		}
	}

	private void setTableEmpresa(DefaultTableModel modelo, List<Compania> list) {
		modelo.setRowCount(0);
		for(int b=0;b<list.size();b++) {
			modelo.addRow(new Object[0]);	
			modelo.setValueAt(list.get(b).getRnc(), b, 0);
			modelo.setValueAt(list.get(b).getNombre(), b, 1);
			modelo.setValueAt(list.get(b).getProvincia(), b, 2);
			modelo.setValueAt(list.get(b).getLocalidad(), b, 3);
			modelo.setValueAt(list.get(b).getTelefono(), b, 4);
		}
		
	}
}
