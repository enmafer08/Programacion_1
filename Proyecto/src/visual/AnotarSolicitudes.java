package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Compania;
import logico.SolicitudCompania;
import logico.SolicitudEmpleado;
import logico.CentroDeTrabajo;
import logico.Persona;
import logico.Estudiante;
import logico.Tecnico;
import logico.Trabajador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AnotarSolicitudes extends JDialog {

	private final JPanel panelcontenido = new JPanel();
	private JTable tablasolicitud;
	private List<SolicitudEmpleado> solicitudempleado;
	private List<SolicitudCompania> solicitudcomp;

	public AnotarSolicitudes(Boolean status,String id) {
		//False=companyReq, TRUE=employeeReq
		setIconImage(Toolkit.getDefaultToolkit().getImage(AnotarSolicitudes.class.getResource("/logo.png")));
		setBounds(100, 100, 718, 343);
		setResizable(false);
		setLocationRelativeTo(null);
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(new BorderLayout());
		panelcontenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelcontenido, BorderLayout.CENTER);
		panelcontenido.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panelcontenido.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JScrollPane scrollPaneEmpresa = new JScrollPane();
			scrollPaneEmpresa.setBounds(10, 75, 671, 171);
			panel.add(scrollPaneEmpresa);
			
			tablasolicitud = new JTable(){
				   public boolean isCellEditable(int row, int column){
				        return false;
				   }
				};
			tablasolicitud.setBackground(Color.WHITE);
			tablasolicitud.setFont(new Font("Tahoma", Font.PLAIN, 12));
			scrollPaneEmpresa.setViewportView(tablasolicitud);
			
			DefaultTableModel model = new DefaultTableModel() {
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
							return Float.class;
					}
				}
			};
			
			tablasolicitud.setModel(model);
			tablasolicitud.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			JLabel lblNewLabel = new JLabel("Solitictudes de vacantes habilitadas:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(139, 27, 513, 24);
			panel.add(lblNewLabel);
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(tablasolicitud.getSelectedRow()>=0) {
						if(status==false) {
							int result = JOptionPane.showConfirmDialog((Component) null, "¿Seguro que desea eliminar la solicitud No. "+tablasolicitud.getValueAt(tablasolicitud.getSelectedRow(), 1)+"?",
							        "alert", JOptionPane.OK_CANCEL_OPTION);
							if(result==JOptionPane.OK_OPTION) {
								SolicitudCompania companyReToEliminate=CentroDeTrabajo.getInstance().buscarsolicitudcompID((String) tablasolicitud.getValueAt(tablasolicitud.getSelectedRow(), 1));
								CentroDeTrabajo.getInstance().getMisolicitud_c().remove(companyReToEliminate);
								solicitudcomp=CentroDeTrabajo.getInstance().getSolicitudesCompaniaPorId(CentroDeTrabajo.getInstance().buscarcompaniaporid(id));
								setTableCompany(model,solicitudcomp);
							}
						}
						else {
							int result = JOptionPane.showConfirmDialog((Component) null, "¿Seguro que desea eliminar la solicitud No. "+tablasolicitud.getValueAt(tablasolicitud.getSelectedRow(), 1)+"?",
							        "alert", JOptionPane.OK_CANCEL_OPTION);
							if(result==JOptionPane.OK_OPTION) {
								SolicitudEmpleado employeeReToEliminate=CentroDeTrabajo.getInstance().buscarsolicitudempID((String) tablasolicitud.getValueAt(tablasolicitud.getSelectedRow(), 1));
								CentroDeTrabajo.getInstance().getMisolicitud_e().remove(employeeReToEliminate);
								solicitudempleado=CentroDeTrabajo.getInstance().getSolicitudesEmpleadosPorId(CentroDeTrabajo.getInstance().buscarpersonaporid(id));
								setTablePerson(model,solicitudempleado);
							}
						}
					}
					else {
						if(status==false)
							JOptionPane.showMessageDialog(null, "Seleccione una solicitud de empresa", "Problema de selección", JOptionPane.CLOSED_OPTION);
						else
							JOptionPane.showMessageDialog(null, "Seleccione una solicitud de persona", "Problema de selección", JOptionPane.CLOSED_OPTION);
					}
				}
			});
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnEliminar.setBounds(217, 257, 96, 24);
			panel.add(btnEliminar);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnSalir.setBounds(372, 257, 96, 24);
			panel.add(btnSalir);
			if(status==false) {
				setTitle("Eliminar Solicitudes");
				Compania comp=CentroDeTrabajo.getInstance().buscarcompaniaporid(id);
				lblNewLabel.setText("Solicitudes de vacantes habilitadas de la empresa "+comp.getNombre());
				model.addColumn("RNC");
				model.addColumn("No. Solicitud");
				model.addColumn("Tipo de Vacante");
				model.addColumn("Habilidad/Carrera");
				model.addColumn("Cant. Vacantes");
				model.addColumn("Salario mínimo");
				solicitudcomp=CentroDeTrabajo.getInstance().getSolicitudesCompaniaPorId(comp);
				setTableCompany(model,solicitudcomp);
			}
			else {
				setTitle("Eliminar Solicitudes");
				Persona Persona=CentroDeTrabajo.getInstance().buscarpersonaporid(id);
				lblNewLabel.setText("Solicitudes de vacantes habilitadas de la persona ");
				model.addColumn("Cédula");
				model.addColumn("No. Solicitud");
				model.addColumn("Tipo de persona");
				model.addColumn("Habilidad/Carrera");
				model.addColumn("Horas de trabajo");
				model.addColumn("Salario mínimo");
				solicitudempleado=CentroDeTrabajo.getInstance().getSolicitudesEmpleadosPorId(Persona);
				setTablePerson(model,solicitudempleado);
			}
			
		}
	}

	private void setTablePerson(DefaultTableModel model, List<SolicitudEmpleado> SolicitudEmpleado) {
		model.setRowCount(0);
		for(int b=0;b<SolicitudEmpleado.size();b++) {
			model.addRow(new Object[0]);	
			model.setValueAt(SolicitudEmpleado.get(b).getAplicante().getId(), b, 0);
			model.setValueAt(SolicitudEmpleado.get(b).getId(), b, 1);
			if(SolicitudEmpleado.get(b).getAplicante() instanceof Estudiante) {
				model.setValueAt("Estudiante", b, 2);
				Estudiante Estudiante=(Estudiante) SolicitudEmpleado.get(b).getAplicante();
				model.setValueAt(Estudiante.getCarrera(), b, 3);
			}
			else if(SolicitudEmpleado.get(b).getAplicante() instanceof Tecnico) {
				model.setValueAt("Técnico", b, 2);
				Tecnico tech=(Tecnico) SolicitudEmpleado.get(b).getAplicante();
				model.setValueAt(tech.getArea(), b, 3);
			}
			else {
				model.setValueAt("Obrero", b, 2);
				Trabajador Trabajador=(Trabajador) SolicitudEmpleado.get(b).getAplicante();
				model.setValueAt(Trabajador.getHabilidades(), b, 3);
			}
			//model.setValueAt(SolicitudEmpleado.get(b).ge, b, 3);
			model.setValueAt(String.valueOf(SolicitudEmpleado.get(b).getHrsdetrabajo()), b, 4);
			model.setValueAt(SolicitudEmpleado.get(b).getSalariominimo(), b, 5);
			
		}
	}

	private void setTableCompany(DefaultTableModel model, List<SolicitudCompania> solicitudcomp) {
		model.setRowCount(0);
		for(int b=0;b<solicitudcomp.size();b++) {
			model.addRow(new Object[0]);	
			model.setValueAt(solicitudcomp.get(b).getCompania().getRnc(), b, 0);
			model.setValueAt(solicitudcomp.get(b).getId(), b, 1);
			model.setValueAt(solicitudcomp.get(b).getTipo_de_empleado(), b, 2);
			model.setValueAt(solicitudcomp.get(b).getHabilidades_requeridas(), b, 3);
			model.setValueAt(solicitudcomp.get(b).getCantidad(), b, 4);
			model.setValueAt(solicitudcomp.get(b).getSalario_minimo(), b, 5);
			
		}
	}
}
