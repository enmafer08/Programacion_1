package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Compania;
import logico.SolicitudCompania;
import logico.SolicitudEmpleado;
import logico.CentroDeTrabajo;
import logico.Persona;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class CentroDeTrabajoV extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private JPanel panel_1;
	private DefaultCategoryDataset datasetSols;
	private JFreeChart chartSols;
	private ChartPanel chartPanelAreas;
	private ChartPanel chartPanelSols;
	private ChartPanel chartPanelType;
	private JFreeChart chartAreas;
	private DefaultCategoryDataset datasetAreas;
	private DefaultPieDataset dataSetType;
	private JFreeChart pieChart;
	private CategoryPlot pSols;
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CentroDeTrabajoV frame = new CentroDeTrabajoV();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CentroDeTrabajoV() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileInputStream fileJobCenterIn = new FileInputStream("JobCenterFile.dat");
					ObjectInputStream streamJobCenterIn = new ObjectInputStream(fileJobCenterIn);
					CentroDeTrabajo.setInstance((CentroDeTrabajo) streamJobCenterIn.readObject());
					SolicitudEmpleado.cod = streamJobCenterIn.readInt();
					SolicitudCompania.cod = streamJobCenterIn.readInt();
					fileJobCenterIn.close();
				} catch (IOException | ClassNotFoundException e1) {
					
				}
				updateGraph();
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				try {
					FileOutputStream fileJobCenterOut = new FileOutputStream("JobCenterFile.dat");
					ObjectOutputStream streamJobCenterOut = new ObjectOutputStream(fileJobCenterOut);
					streamJobCenterOut.writeObject(CentroDeTrabajo.getInstance());
					streamJobCenterOut.flush();
					streamJobCenterOut.writeInt(SolicitudEmpleado.cod);
					streamJobCenterOut.flush();
					streamJobCenterOut.writeInt(SolicitudCompania.cod);
					fileJobCenterOut.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			}
		});
		
		setTitle("Bolsa de Trabajo Dominicana");
		setBounds(100, 100, 638, 306);
		dim = getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setToolTipText("Anotar");
			panel.add(menuBar, BorderLayout.NORTH);
			
			JMenu mnnmRegistrar = new JMenu("Registrar");
			mnnmRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnnmRegistrar);
			
			JMenuItem mntmPersona = new JMenuItem("Persona");
			mntmPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Persona employee = null;
					RegistroEmpleado newEmployee=new RegistroEmpleado(employee);
					newEmployee.setVisible(true);
				}
			});
			mntmPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmRegistrar.add(mntmPersona);
			
			JMenuItem mntmEmpresa = new JMenuItem("Empresa");
			mntmEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Compania Compania= new Compania("", "", "", "", "", "", "", "");
					RegistroCompania newCompany=new RegistroCompania(Compania);
					newCompany.setVisible(true);
        	updateGraph();

				}
			});
			mntmEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmRegistrar.add(mntmEmpresa);
			
			JMenu mnnmEliminar = new JMenu("Eliminar");
			mnnmEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnnmEliminar);
			
			JMenuItem mntmElimPersona = new JMenuItem("Persona");
			mntmElimPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String cedula="";
					BuscarIdV findPersona=new BuscarIdV(cedula,CentroDeTrabajo.getInstance(),1);
					findPersona.setVisible(true);
					cedula=findPersona.getID();
					if(cedula.equalsIgnoreCase("")==false) {
						Persona personToEliminate=CentroDeTrabajo.getInstance().buscarpersonaporid(cedula);
						int result = JOptionPane.showConfirmDialog((Component) null, "¿Seguro que desea eliminar la persona "+personToEliminate.getNombre()+
								" "+personToEliminate.getApellido()+", y todas las solicitudes que creó?",
						        "alert", JOptionPane.OK_CANCEL_OPTION);
						
						if(result==JOptionPane.OK_OPTION) {
							CentroDeTrabajo.getInstance().getMipersona().remove(personToEliminate);
							CentroDeTrabajo.getInstance().EliminarTodasLasSolicitudesActP(personToEliminate);
							JOptionPane.showMessageDialog(null, "La persona ha sido eliminada con éxito", "Persona Eliminada", JOptionPane.CLOSED_OPTION);
						}
					}
				}
			});
			mntmElimPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEliminar.add(mntmElimPersona);
			
			JMenuItem mntmElimEmpresa = new JMenuItem("Empresa");
			mntmElimEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String RNC="";
					BuscarIdV findCompany=new BuscarIdV(RNC,CentroDeTrabajo.getInstance(),0);
					findCompany.setVisible(true);
					RNC=findCompany.getID();
					if(RNC.equalsIgnoreCase("")==false) {
						Compania companyToEliminate=CentroDeTrabajo.getInstance().buscarcompaniaporid(RNC);
						int result = JOptionPane.showConfirmDialog((Component) null, "¿Seguro que desea eliminar la empresa "+companyToEliminate.getNombre()+
								", y todas las solicitudes que creó?",
						        "alert", JOptionPane.OK_CANCEL_OPTION);
						if(result==JOptionPane.OK_OPTION) {
							CentroDeTrabajo.getInstance().getMicompania().remove(companyToEliminate);
							CentroDeTrabajo.getInstance().EliminarTodasLasSolicitudesActC(companyToEliminate);
							JOptionPane.showMessageDialog(null, "La empresa ha sido eliminada con éxito", "Empresa Eliminada", JOptionPane.CLOSED_OPTION);
						}	
					}
					updateGraph();
				}
			});
			mntmElimEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEliminar.add(mntmElimEmpresa);
			
			JMenu mnnmEliminarSol = new JMenu("Solicitud");
			mnnmEliminarSol.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEliminar.add(mnnmEliminarSol);
			
			JMenuItem mntmElimCompanyReq = new JMenuItem("Empresa");
			mntmElimCompanyReq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String RNC="";
					BuscarIdV findCompany=new BuscarIdV(RNC,CentroDeTrabajo.getInstance(),2);
					findCompany.setVisible(true);
					RNC=findCompany.getID();
					if(RNC.equalsIgnoreCase("")==false) {
						AnotarSolicitudes deleteCompanyRequest=new AnotarSolicitudes(false, RNC);
						deleteCompanyRequest.setVisible(true);
					}
					updateGraph();
				}
			});
			mntmElimCompanyReq.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEliminarSol.add(mntmElimCompanyReq);
			
			JMenuItem mntmElimPersonReq = new JMenuItem("Persona");
			mntmElimPersonReq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cedula="";
					BuscarIdV findPersona=new BuscarIdV(cedula,CentroDeTrabajo.getInstance(),3);
					findPersona.setVisible(true);
					cedula=findPersona.getID();
					if(cedula.equalsIgnoreCase("")==false) {
						AnotarSolicitudes deletePersonRequest=new AnotarSolicitudes(true, cedula);
						deletePersonRequest.setVisible(true);
					}
					updateGraph();
				}
			});
			mntmElimPersonReq.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmEliminarSol.add(mntmElimPersonReq);
			
			JMenu mnnmModificar = new JMenu("Modificar");
			mnnmModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnnmModificar);
			
			JMenuItem mntmModPersona = new JMenuItem("Persona");
			mntmModPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String cedula="";
					BuscarIdV findPersona=new BuscarIdV(cedula,CentroDeTrabajo.getInstance(),4);
					findPersona.setVisible(true);
					cedula=findPersona.getID();
					if(cedula.equalsIgnoreCase("")==false) {
						Persona personToModify=CentroDeTrabajo.getInstance().buscarpersonaporid(cedula);
						RegistroEmpleado newEmployee=new RegistroEmpleado(personToModify);
						newEmployee.setVisible(true);
					}
				}
			});
			mntmModPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmModificar.add(mntmModPersona);
			
			JMenuItem mntmModEmpresa = new JMenuItem("Empresa");
			mntmModEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String RNC="";
					BuscarIdV findCompany=new BuscarIdV(RNC,CentroDeTrabajo.getInstance(),5);
					findCompany.setVisible(true);
					RNC=findCompany.getID();
					if(RNC.equalsIgnoreCase("")==false) {
						Compania companyToModify=CentroDeTrabajo.getInstance().buscarcompaniaporid(RNC);
						RegistroCompania newComp=new RegistroCompania(companyToModify);
						newComp.setVisible(true);
					}
					updateGraph();
				}
			});
			mntmModEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmModificar.add(mntmModEmpresa);
			
			JMenu mnnmSolicitud = new JMenu("Solicitud");
			mnnmSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnnmSolicitud);
			
			JMenuItem mntmSolEmpleo = new JMenuItem("Solicitud de empleo");
			mntmSolEmpleo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						RegistroSolicitudDeEmpleado RegistroSolicitudDeEmpleado= new RegistroSolicitudDeEmpleado(null);
						RegistroSolicitudDeEmpleado.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					updateGraph();
				}
			});
			mntmSolEmpleo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmSolicitud.add(mntmSolEmpleo);
			
			JMenuItem mntmSolVacante = new JMenuItem("Solicitud de vacante");
			mntmSolVacante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						RegistroSolicitudDeCompania RegistroSolicitudDeCompania = new RegistroSolicitudDeCompania(null);
						RegistroSolicitudDeCompania.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					updateGraph();
				}
			});
			mntmSolVacante.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmSolicitud.add(mntmSolVacante);
			
			JMenu mnNewMenu = new JMenu("Match");
			mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnNewMenu);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("Contratar");
			mntmNewMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						EmparejamientoEmpleado match = new EmparejamientoEmpleado();
						match.setLocationRelativeTo(null);
						match.setVisible(true);
					} catch (Exception ex) {
							ex.printStackTrace();
					}
					updateGraph();
					//dispose();
				}
			});
			mnNewMenu.add(mntmNewMenuItem);
			
			JMenu mnnmListar = new JMenu("Anotar");
			mnnmListar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			menuBar.add(mnnmListar);
			
			JMenuItem mntmListPersona = new JMenuItem("Persona");
			mntmListPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Anotar listPerson=new Anotar(CentroDeTrabajo.getInstance(),1);
					listPerson.setVisible(true);
				}
			});
			mntmListPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmListar.add(mntmListPersona);
			
			JMenuItem mntmListEmpresa = new JMenuItem("Empresa");
			mntmListEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Anotar listCompany=new Anotar(CentroDeTrabajo.getInstance(),0);
					listCompany.setVisible(true);
				}
			});
			mntmListEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmListar.add(mntmListEmpresa);
			
			JMenuItem mntmListarSolEmpresa = new JMenuItem("Solicitudes de Empresas");
			mntmListarSolEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Anotar listCompanySol=new Anotar(CentroDeTrabajo.getInstance(),2);
					listCompanySol.setVisible(true);
				}
			});
			mntmListarSolEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmListar.add(mntmListarSolEmpresa);
			
			JMenuItem mntmListarSolPersona = new JMenuItem("Solicitudes de Personas");
			mntmListarSolPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Anotar listEmployeeSol=new Anotar(CentroDeTrabajo.getInstance(),3);
					listEmployeeSol.setVisible(true);
				}
			});
			mntmListarSolPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
			mnnmListar.add(mntmListarSolPersona);
			
		}
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		btnUpdate = new JButton("Actualizar Información");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(1039, 643, 200, 30);
		panel_1.add(btnUpdate);
		
		setGraph();
	}
	
	private void setGraph() {
		
			datasetSols = new DefaultCategoryDataset();
	        datasetSols.setValue(CentroDeTrabajo.getInstance().getMisolicitud_e().size(), "Solicitudes de empleo", "Solicitudes de empleo");
	        datasetSols.setValue(CentroDeTrabajo.getInstance().getsolicitudempleadocompletada(), "Solicitudes satisfechas", "Solicitudes satisfechas"); 
	       
	        chartSols = ChartFactory.createBarChart3D
	        ("Solicitudes de Personas satisfechas","Área", "Cant. Solicitudes", 
	        datasetSols, PlotOrientation.VERTICAL, true,true, false);
	        chartSols.setBackgroundPaint(Color.LIGHT_GRAY);
	        chartSols.getTitle().setPaint(Color.black); 
	        pSols = chartSols.getCategoryPlot(); 
	        pSols.setRangeGridlinePaint(Color.red); 
	        chartPanelSols = new ChartPanel(chartSols);
	        chartPanelSols.setBounds(dim.width/12, dim.height/8, (int)(dim.width/3), (int)(dim.height/3));
	        chartPanelSols.setVisible(true);
	        panel_1.setLayout(null);
	        panel_1.add(chartPanelSols);
	        
	        
	        datasetAreas = new DefaultCategoryDataset();
	        datasetAreas.setValue(CentroDeTrabajo.getInstance().CantDeCompaniaporArea("Turismo"), "Turismo", "");
	        datasetAreas.setValue(CentroDeTrabajo.getInstance().CantDeCompaniaporArea("Salud"), "Salud", "");
	        datasetAreas.setValue(CentroDeTrabajo.getInstance().CantDeCompaniaporArea("Educación"), "Educación", "");
	        datasetAreas.setValue(CentroDeTrabajo.getInstance().CantDeCompaniaporArea("Tecnología"), "Tecnología", "");
	        datasetAreas.setValue(CentroDeTrabajo.getInstance().CantDeCompaniaporArea("Construcción"), "Construcción", "");
	        datasetAreas.setValue(CentroDeTrabajo.getInstance().CantDeCompaniaporArea("Venta de vehículos"), "Venta de vehículos", "");
	       
	        chartAreas = ChartFactory.createBarChart3D
	        ("Cantidad de empresas por Área ","Área", "Cant. Empresas", 
	        datasetAreas, PlotOrientation.VERTICAL, true,true, false);
	        chartAreas.setBackgroundPaint(Color.LIGHT_GRAY);
	        chartAreas.getTitle().setPaint(Color.black);
	        CategoryPlot pAreas = chartAreas.getCategoryPlot();
	        pAreas = chartAreas.getCategoryPlot(); 
	        pAreas.setRangeGridlinePaint(Color.red); 
	        chartPanelAreas = new ChartPanel(chartAreas);
	        chartPanelAreas.setBounds(dim.width/2, dim.height/8, dim.width/3, dim.height/3);
	        chartPanelAreas.setVisible(true);
	        panel_1.setLayout(null);
	        panel_1.add(chartPanelAreas);
	        
	        
	        dataSetType = new DefaultPieDataset();
	        dataSetType.setValue("Universitario", new Integer(CentroDeTrabajo.getInstance().getCantSolicitudesDeEstudiantePorCompania()));
			dataSetType.setValue("Técnico", new Integer(CentroDeTrabajo.getInstance().getCantSolicitudesDeTecnicosPorCompania()));
			dataSetType.setValue("Obrero", new Integer(CentroDeTrabajo.getInstance().getCantSolicitudesDeTrabajadoresPorCompania()));
			
			pieChart = ChartFactory.createPieChart("Datos sobre los tipo de empleados mas solicitados por empresas", dataSetType,true, true, true);
			PiePlot p = (PiePlot)pieChart.getPlot();
			chartPanelType = new ChartPanel(pieChart);
			chartPanelType.setBounds((int)(dim.width/3.5), dim.height/2, (int)(dim.width/3), (int)(dim.height/3));
			p.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} {2}"));
			chartPanelType.setVisible(true);
			panel_1.setLayout(null);
			panel_1.add(chartPanelType);
			
			
	}
	
	private void updateGraph() {
		datasetSols.clear();
		datasetSols.setValue(CentroDeTrabajo.getInstance().getMisolicitud_e().size(), "Solicitudes de empleo", "Solicitudes de empleo");
        datasetSols.setValue(CentroDeTrabajo.getInstance().getsolicitudempleadocompletada(), "Solicitudes satisfechas", "Solicitudes satisfechas");
        
        datasetAreas.clear();
        datasetAreas.setValue(CentroDeTrabajo.getInstance().CantDeCompaniaporArea("Turismo"), "Turismo", "");
       datasetAreas.setValue(CentroDeTrabajo.getInstance().CantDeCompaniaporArea("Salud"), "Salud", "");

        datasetAreas.setValue(CentroDeTrabajo.getInstance().CantDeCompaniaporArea("Educación"), "Educación", "");
        datasetAreas.setValue(CentroDeTrabajo.getInstance().CantDeCompaniaporArea("Tecnología"), "Tecnología", "");
        datasetAreas.setValue(CentroDeTrabajo.getInstance().CantDeCompaniaporArea("Construcción"), "Construcción", "");
        datasetAreas.setValue(CentroDeTrabajo.getInstance().CantDeCompaniaporArea("Venta de Vehículos"), "Venta de Vehículos", "");
        
        dataSetType.clear();
        dataSetType.setValue("Universitario", new Integer(CentroDeTrabajo.getInstance().getCantSolicitudesDeEstudiantePorCompania()));
		dataSetType.setValue("Técnico", new Integer(CentroDeTrabajo.getInstance().getCantSolicitudesDeTecnicosPorCompania()));
		dataSetType.setValue("Obrero", new Integer(CentroDeTrabajo.getInstance().getCantSolicitudesDeTrabajadoresPorCompania()));
	}
}
