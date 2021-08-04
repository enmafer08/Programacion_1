package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.CentroDeTrabajo;
import logico.Persona;
import logico.Estudiante;
import logico.Tecnico;
import logico.Trabajador;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class RegistroEmpleado extends JDialog {

	
	
	private static final long serialVersionUID = 2748380688271625514L;
	private final JPanel PanelContenido = new JPanel();
	private JTextField Text_id;
	private JTextField Text_nombre;
	private JTextField Text_apellido;
	private JTextField Text_Direccion;
	private JTextField Text_ciudad;
	private JTextField Text_correo;
	private JTextField Text_telefono;
	private JPanel Panel_general;
	private JComboBox<String> combo_provincia;
	private JComboBox<String> combo_estadoCivil;
	private JComboBox<String> combo_genero;
	private JSpinner Spn_Fecha;
	private JPanel Panel_InformaciondeTrabajo;
	private JButton boton_term;
	private JButton boton_siguiente;
	private JButton boton_atras;
	private JTextField text_universidad;
	private JRadioButton Estudiante_rdb;
	private JRadioButton Trabajador_rdb;
	private JRadioButton tecnico_rdb;
	private JPanel Panel_Estudiante;
	private JPanel Panel_Tecnico;
	private JPanel Panel_Trabajador;
	private int elegir;
	private DefaultListModel<String> Habilidades;
	private JList<String> listaDeHabilidadesS;
	private ArrayList<String> HabilidadesS;
	private JButton boton_eliminarHabilidad;
	private JButton boton_anadirHabilidad;
	private JSpinner spn_experienciaporano;
	private JSpinner spn_anoExperiencia;
	private JTextField texto_institucion;
	private JComboBox<String> combo_habilidades;
	private JComboBox<String> combo_carrera;
	private JComboBox<String>  combo_Area;
	
	public RegistroEmpleado(Persona mod) {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroEmpleado.class.getResource("/logo.png")));
		elegir = -1;
		HabilidadesS = new ArrayList<String>();
		setTitle("Registar Empleado");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 678, 655);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		PanelContenido.setBackground(Color.WHITE);
		PanelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(PanelContenido, BorderLayout.CENTER);
		PanelContenido.setLayout(null);
		Habilidades = new DefaultListModel<>();
		
		Panel_InformaciondeTrabajo = new JPanel();
		Panel_InformaciondeTrabajo.setVisible(false);
		
		Panel_general = new JPanel();
		Panel_general.setLayout(null);
		Panel_general.setBorder(null);
		Panel_general.setBackground(Color.WHITE);
		Panel_general.setBounds(0,0,664,583);
		PanelContenido.add(Panel_general);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 35, 644, 2);
		Panel_general.add(separator_2);
		
		JLabel lblInformacinGeneral = new JLabel("Informaci\u00F3n general");
		lblInformacinGeneral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacinGeneral.setBounds(21, 11, 187, 21);
		Panel_general.add(lblInformacinGeneral);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCedula.setBounds(21, 61, 70, 27);
		Panel_general.add(lblCedula);
		
		JLabel label_3 = new JLabel("Nombres:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(21, 107, 70, 27);
		Panel_general.add(label_3);
		
		Text_id = new JTextField();
		Text_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Text_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')  || (Text_id.getText().length()==11)) {
                    e.consume();
                    
                }
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				updateNext();
			}
		});
		Text_id.setColumns(10);
		Text_id.setBounds(88, 62, 145, 28);
		Panel_general.add(Text_id);
		if(mod!=null)
			Text_id.setEnabled(false);;
		
		Text_nombre = new JTextField();
		Text_nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z'))
                        && (caracter != '\b') && (caracter!=32)) {
                    e.consume();
                }
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				updateNext();
			}
		});
		Text_nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Text_nombre.setColumns(10);
		Text_nombre.setBounds(111, 108, 191, 28);
		Panel_general.add(Text_nombre);
		
		JLabel label_4 = new JLabel("Apellidos:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(22, 158, 82, 27);
		Panel_general.add(label_4);
		
		Text_apellido = new JTextField();
		Text_apellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z'))
                        && (caracter != '\b') && (caracter!=32)) {
                    e.consume();
                }
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				updateNext();
			}
		});
		Text_apellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Text_apellido.setColumns(10);
		Text_apellido.setBounds(111, 157, 191, 28);
		Panel_general.add(Text_apellido);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccin.setBounds(21, 319, 89, 27);
		Panel_general.add(lblDireccin);
		
		Text_Direccion = new JTextField();
		Text_Direccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Text_Direccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				updateNext();
			}
		});
		Text_Direccion.setColumns(10);
		Text_Direccion.setBounds(111, 318, 494, 28);
		Panel_general.add(Text_Direccion);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 245, 644, 2);
		Panel_general.add(separator_3);
		
		JLabel lblInformacinDeUbicacin = new JLabel("Informaci\u00F3n de ubicaci\u00F3n");
		lblInformacinDeUbicacin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacinDeUbicacin.setBounds(21, 219, 202, 21);
		Panel_general.add(lblInformacinDeUbicacin);
		
		JLabel label_7 = new JLabel("Provincia:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(21, 271, 89, 27);
		Panel_general.add(label_7);
		
		combo_provincia = new JComboBox<String>();
		combo_provincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateNext();
			}
		});
		combo_provincia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combo_provincia.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", "Distrito Nacional", "Duarte", "El\u00EDas Pi\u00F1a", "El Seibo", "Espaillat", "Hato Mayor", "Hermanas Mirabal", "Independencia", "La Altagracia", "La Romana", "La Vega", "Mar\u00EDa Trinidad S\u00E1nchez", "Monse\u00F1or Nouel", "Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Saman\u00E1", "S\u00E1nchez Ram\u00EDrez", "San Crist\u00F3bal", "San Jos\u00E9 de Ocoa", "San Juan", "San Pedro de Macor\u00EDs", "Santiago", "Santiago Rodr\u00EDguez", "Santo Domingo", "Valverde"}));
		combo_provincia.setBounds(111, 271, 179, 27);
		Panel_general.add(combo_provincia);
		
		JLabel label_8 = new JLabel("Ciudad:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(328, 271, 70, 27);
		Panel_general.add(label_8);
		
		Text_ciudad = new JTextField();
		Text_ciudad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Text_ciudad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateNext();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z'))
                        && (caracter != '\b') && (caracter!=32)) {
                    e.consume();
                }
			}
		});
		Text_ciudad.setColumns(10);
		Text_ciudad.setBounds(401, 270, 145, 28);
		Panel_general.add(Text_ciudad);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstadoCivil.setBounds(327, 158, 94, 27);
		Panel_general.add(lblEstadoCivil);
		
		combo_estadoCivil = new JComboBox<String>();
		combo_estadoCivil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateNext();
			}
		});
		combo_estadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combo_estadoCivil.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Soltero ", "Casado", "Uni\u00F3n Libre", "Viudo"}));
		combo_estadoCivil.setBounds(431, 158, 179, 27);
		Panel_general.add(combo_estadoCivil);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSexo.setBounds(327, 107, 103, 27);
		Panel_general.add(lblSexo);
		
		combo_genero = new JComboBox<String>();
		combo_genero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateNext();
			}
		});
		combo_genero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combo_genero.setModel(new DefaultComboBoxModel<String>(new String[] {"<Sin especificar>", "Masculino", "Femenino"}));
		combo_genero.setBounds(391, 109, 145, 27);
		Panel_general.add(combo_genero);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaDeNacimiento.setBounds(285, 61, 160, 27);
		Panel_general.add(lblFechaDeNacimiento);
		
		Spn_Fecha = new JSpinner();
		Spn_Fecha.setModel(new SpinnerDateModel(new Date(1009857600000L), new Date(-1577906844000L), new Date(1072929600000L), Calendar.DAY_OF_YEAR));
		Spn_Fecha.setBounds(447, 61, 70, 27);
		Panel_general.add(Spn_Fecha);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 408, 644, 2);
		Panel_general.add(separator);
		
		JLabel lblInformacinDeContacto = new JLabel("Informaci\u00F3n de contacto");
		lblInformacinDeContacto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacinDeContacto.setBounds(21, 382, 202, 21);
		Panel_general.add(lblInformacinDeContacto);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreoElectronico.setBounds(21, 437, 145, 27);
		Panel_general.add(lblCorreoElectronico);
		
		Text_correo = new JTextField();
		Text_correo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateNext();
			}
		});
		Text_correo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Text_correo.setColumns(10);
		Text_correo.setBounds(176, 434, 311, 28);
		Panel_general.add(Text_correo);
		
		JLabel lblNmeroTelefnico = new JLabel("N\u00FAmero telef\u00F3nico:");
		lblNmeroTelefnico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmeroTelefnico.setBounds(21, 483, 145, 27);
		Panel_general.add(lblNmeroTelefnico);
		
		Text_telefono = new JTextField();
		Text_telefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Text_telefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				updateNext();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')  ) {
                    e.consume();
                    
                }
			}
		});
		Text_telefono.setColumns(10);
		Text_telefono.setBounds(176, 484, 145, 28);
		Panel_general.add(Text_telefono);
		Panel_InformaciondeTrabajo.setBackground(Color.WHITE);
		Panel_InformaciondeTrabajo.setBounds(0, 0, 664, 583);
		PanelContenido.add(Panel_InformaciondeTrabajo);
		Panel_InformaciondeTrabajo.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 35, 644, 2);
		Panel_InformaciondeTrabajo.add(separator_1);
		
		JLabel lblProfesion = new JLabel("Informaci\u00F3n laboral");
		lblProfesion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProfesion.setBounds(232, 11, 187, 21);
		Panel_InformaciondeTrabajo.add(lblProfesion);
		
		JLabel lblStudent = new JLabel("New label");
		//Image Estudiante = new ImageIcon(this.getClass().getResource("/Estudiante.png")).getImage();
		//lblStudent.setIcon(new ImageIcon(Estudiante));
		lblStudent.setBounds(20, 116, 161, 141);
		Panel_InformaciondeTrabajo.add(lblStudent);
		
		JLabel lblTech = new JLabel("");
		//Image tech = new ImageIcon(this.getClass().getResource("/Tecnico.png")).getImage();
		//lblTech.setIcon(new ImageIcon(tech));
		lblTech.setBounds(243, 116, 161, 141);
		Panel_InformaciondeTrabajo.add(lblTech);
		
		JLabel lblWorker = new JLabel("");
		//Image Trabajador = new ImageIcon(this.getClass().getResource("/Trabajador.png")).getImage();
		//lblWorker.setIcon(new ImageIcon(Trabajador));
		lblWorker.setBounds(470, 116, 161, 141);
		Panel_InformaciondeTrabajo.add(lblWorker);
		
		tecnico_rdb = new JRadioButton("T\u00E9cnico");
		tecnico_rdb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Estudiante_rdb.setSelected(false);
				Trabajador_rdb.setSelected(false);
				Panel_Estudiante.setVisible(false);
				Panel_Tecnico.setVisible(true);
				Panel_Trabajador.setVisible(false);
			}
		});
		tecnico_rdb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tecnico_rdb.setHorizontalAlignment(SwingConstants.CENTER);
		tecnico_rdb.setBackground(Color.WHITE);
		tecnico_rdb.setBounds(253, 86, 109, 23);
		Panel_InformaciondeTrabajo.add(tecnico_rdb);
		
		Trabajador_rdb = new JRadioButton("Obrero");
		Trabajador_rdb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tecnico_rdb.setSelected(false);
				Estudiante_rdb.setSelected(false);
				Panel_Estudiante.setVisible(false);
				Panel_Tecnico.setVisible(false);
				Panel_Trabajador.setVisible(true);
			}
		});
		Trabajador_rdb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Trabajador_rdb.setHorizontalAlignment(SwingConstants.CENTER);
		Trabajador_rdb.setBackground(Color.WHITE);
		Trabajador_rdb.setBounds(486, 86, 109, 23);
		Panel_InformaciondeTrabajo.add(Trabajador_rdb);
		
		JLabel lblProfesin_1 = new JLabel("Profesi\u00F3n:");
		lblProfesin_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProfesin_1.setBounds(20, 48, 224, 27);
		Panel_InformaciondeTrabajo.add(lblProfesin_1);
		
		Estudiante_rdb = new JRadioButton("Egresado");
		Estudiante_rdb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tecnico_rdb.setSelected(false);
				Trabajador_rdb.setSelected(false);
				Panel_Estudiante.setVisible(true);
				Panel_Tecnico.setVisible(false);
				Panel_Trabajador.setVisible(false);	
			}
		});
		Estudiante_rdb.setSelected(true);
		Estudiante_rdb.setHorizontalAlignment(SwingConstants.CENTER);
		Estudiante_rdb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Estudiante_rdb.setBackground(Color.WHITE);
		Estudiante_rdb.setBounds(44, 86, 109, 23);
		Panel_InformaciondeTrabajo.add(Estudiante_rdb);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 315, 644, 2);
		Panel_InformaciondeTrabajo.add(separator_4);
		
		JLabel lblExperienciaLaboral = new JLabel("Experiencia laboral");
		lblExperienciaLaboral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExperienciaLaboral.setBounds(232, 287, 187, 21);
		Panel_InformaciondeTrabajo.add(lblExperienciaLaboral);
		
		Panel_Estudiante =new JPanel();
		Panel_Estudiante.setBackground(Color.WHITE);
		Panel_Estudiante.setBounds(10, 328, 644, 242);
		Panel_InformaciondeTrabajo.add(Panel_Estudiante);
		Panel_Estudiante.setLayout(null);
		
		text_universidad = new JTextField();
		text_universidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_universidad.setColumns(10);
		text_universidad.setBounds(20, 51, 403, 28);
		Panel_Estudiante.add(text_universidad);
		
		JLabel lblUniversidad = new JLabel("Universidad:");
		lblUniversidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUniversidad.setBounds(20, 11, 161, 27);
		Panel_Estudiante.add(lblUniversidad);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCarrera.setBounds(20, 115, 161, 27);
		Panel_Estudiante.add(lblCarrera);
		
		combo_carrera = new JComboBox<String>();
		combo_carrera.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combo_carrera.setModel(new DefaultComboBoxModel<String>(new String[] {"<Selecci\u00F3n>", "Direcci\u00F3n Empresarial", "Administraci\u00F3n Hotelera", "Arquitectura", "Comunicaci\u00F3n Social", "Derecho", "Dise\u00F1o e Interiorismo", "\u200B\u200B\u200BEcolog\u00EDa y Gesti\u00F3n Ambiental", "Econom\u00EDa", "Educaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa", "Gesti\u00F3n Financiera y Auditor\u00EDa", "Ingenier\u00EDa Civil", "Ingenier\u00EDa Mec\u00E1nica", "Ingenier\u00EDa El\u00E9ctrica", "Ingenier\u00EDa Industrial y de Sistemas", "Ingenier\u00EDa en Mecatr\u00F3nica", "Ingenier\u00EDa de Sistemas y Computaci\u00F3n", "Ingenier\u00EDa Telem\u00E1tica", "Medicina", "Marketing", "Nutrici\u00F3n y Diet\u00E9tica\u200B", "Psicolog\u00EDa", "Terapia F\u00EDsica"}));
		combo_carrera.setBounds(20, 153, 346, 28);
		Panel_Estudiante.add(combo_carrera);
		
		Panel_Tecnico = new JPanel();
		Panel_Tecnico.setVisible(false);
		Panel_Tecnico.setIgnoreRepaint(true);
		Panel_Tecnico.setLayout(null);
		Panel_Tecnico.setBackground(Color.WHITE);
		Panel_Tecnico.setBounds(10, 328, 644, 242);
		Panel_InformaciondeTrabajo.add(Panel_Tecnico);
		
		JLabel lblAosDeExperiencia = new JLabel("A\u00F1os de experiencia");
		lblAosDeExperiencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblAosDeExperiencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAosDeExperiencia.setBounds(443, 73, 177, 27);
		Panel_Tecnico.add(lblAosDeExperiencia);
		
		spn_anoExperiencia = new JSpinner();
		spn_anoExperiencia.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spn_anoExperiencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spn_anoExperiencia.setBounds(506, 113, 63, 28);
		Panel_Tecnico.add(spn_anoExperiencia);
		
		JLabel lblTcnico = new JLabel("\u00C1rea:");
		lblTcnico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTcnico.setBounds(27, 11, 81, 27);
		Panel_Tecnico.add(lblTcnico);
		
		texto_institucion = new JTextField();
		texto_institucion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texto_institucion.setColumns(10);
		texto_institucion.setBounds(27, 162, 396, 28);
		Panel_Tecnico.add(texto_institucion);
		
		JLabel lblInstitucin = new JLabel("Instituci\u00F3n:");
		lblInstitucin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInstitucin.setBounds(27, 122, 104, 27);
		Panel_Tecnico.add(lblInstitucin);
		
		combo_Area = new JComboBox<String>();
		combo_Area.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combo_Area.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>","Informática","Electricidad","Contabilidad","Diseño Gráfico","Enfermería","Mercadeo","Administración","Publicidad"}));
		combo_Area.setBounds(27, 49, 287, 27);
		Panel_Tecnico.add(combo_Area);
		
		Panel_Trabajador = new JPanel();
		Panel_Trabajador.setVisible(false);
		Panel_Trabajador.setBackground(Color.WHITE);
		Panel_Trabajador.setBounds(10, 328, 644, 242);
		Panel_InformaciondeTrabajo.add(Panel_Trabajador);
		Panel_Trabajador.setLayout(null);
		
		JLabel label = new JLabel("A\u00F1os de experiencia");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(42, 139, 177, 27);
		Panel_Trabajador.add(label);
		
		spn_experienciaporano = new JSpinner();
		spn_experienciaporano.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spn_experienciaporano.setBounds(99, 177, 63, 28);
		Panel_Trabajador.add(spn_experienciaporano);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(394, 38, 225, 154);
		Panel_Trabajador.add(scrollPane_4);
		
		listaDeHabilidadesS = new JList<String>();
		listaDeHabilidadesS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				elegir = listaDeHabilidadesS.getSelectedIndex();
				if(elegir != -1) {
					boton_eliminarHabilidad.setEnabled(true);
				}else {
					boton_eliminarHabilidad.setEnabled(false);
				}
			}
		});
		listaDeHabilidadesS.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Habilidades = new DefaultListModel<String>();
		loadSkills();
		scrollPane_4.setViewportView(listaDeHabilidadesS);
		
		boton_anadirHabilidad = new JButton("A\u00F1adir >");
		boton_anadirHabilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!combo_habilidades.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")) {
					String selection = combo_habilidades.getSelectedItem().toString();
					HabilidadesS.add(selection);
					loadSkills();
					combo_habilidades.setSelectedIndex(0);
					boton_anadirHabilidad.setEnabled(false);
				}	
			}
		});
		boton_anadirHabilidad.setEnabled(false);
		boton_anadirHabilidad.setBounds(72, 76, 102, 23);
		Panel_Trabajador.add(boton_anadirHabilidad);
		
		boton_eliminarHabilidad = new JButton("^ Eliminar ^");
		boton_eliminarHabilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(elegir != -1) {
					String selection = Habilidades.get(elegir);
					HabilidadesS.remove(selection);
					loadSkills();
					listaDeHabilidadesS.setSelectedIndex(-1);
					boton_eliminarHabilidad.setEnabled(false);
				}	
			}
		});
		boton_eliminarHabilidad.setEnabled(false);
		boton_eliminarHabilidad.setBounds(453, 208, 102, 23);
		Panel_Trabajador.add(boton_eliminarHabilidad);
		
		JLabel lblTusHabilidades = new JLabel("Tus habilidades");
		lblTusHabilidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblTusHabilidades.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTusHabilidades.setBounds(424, 11, 161, 27);
		Panel_Trabajador.add(lblTusHabilidades);
		
		JLabel lblHabilidades = new JLabel("Habilidades");
		lblHabilidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabilidades.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHabilidades.setBounds(42, 11, 177, 27);
		Panel_Trabajador.add(lblHabilidades);
		
		combo_habilidades = new JComboBox<String>();
		combo_habilidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(combo_habilidades.getSelectedIndex() != 0) {
					boton_anadirHabilidad.setEnabled(true);
				}else {
					boton_anadirHabilidad.setEnabled(false);
				}
			}
		});
		combo_habilidades.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combo_habilidades.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>","Plomería","Ebanistería","Mecánica","Construcción","Pintura","Soldadura","Jardinería"}));
		combo_habilidades.setBounds(26, 38, 210, 27);
		Panel_Trabajador.add(combo_habilidades);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				boton_atras = new JButton("< Atr\u00E1s");
				boton_atras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boton_atras.setEnabled(false);
						Panel_InformaciondeTrabajo.setVisible(false);
						Panel_general.setVisible(true);
						boton_siguiente.setEnabled(true);
						boton_term.setEnabled(false);
					}
				});
				boton_atras.setEnabled(false);
				buttonPane.add(boton_atras);
			}
			{
				boton_siguiente = new JButton("Siguiente >");
				boton_siguiente.setEnabled(false);
				boton_siguiente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Panel_general.setVisible(false);
						Panel_InformaciondeTrabajo.setVisible(true);
						boton_siguiente.setEnabled(false);
						boton_atras.setEnabled(true);
						boton_term.setEnabled(true);
					}
				});
				boton_siguiente.setActionCommand("OK");
				buttonPane.add(boton_siguiente);
				getRootPane().setDefaultButton(boton_siguiente);
			}
			
			boton_term = new JButton("Finalizar");
			boton_term.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						Persona aux = null;
						if(Estudiante_rdb.isSelected()) {
							aux = new Estudiante(Text_id.getText(), Text_nombre.getText(), Text_apellido.getText(), (Date) Spn_Fecha.getValue(), Text_Direccion.getText(),
							Text_correo.getText(), combo_provincia.getSelectedItem().toString(),Text_ciudad.getText(),combo_genero.getSelectedItem().toString(),
							combo_estadoCivil.getSelectedItem().toString(), Text_telefono.getText(),text_universidad.getText(),combo_carrera.getSelectedItem().toString());
						}
						if(tecnico_rdb.isSelected()) {
							aux = new Tecnico(Text_id.getText(), Text_nombre.getText(), Text_apellido.getText(), (Date) Spn_Fecha.getValue(), Text_Direccion.getText(),
							Text_correo.getText(), combo_provincia.getSelectedItem().toString(),Text_ciudad.getText(),combo_genero.getSelectedItem().toString(),
							combo_estadoCivil.getSelectedItem().toString(), Text_telefono.getText(),Integer.valueOf(spn_anoExperiencia.getValue().toString()), combo_Area.getSelectedItem().toString(), texto_institucion.getText());
						}
						if(Trabajador_rdb.isSelected()) {
							aux = new Trabajador(Text_id.getText(), Text_nombre.getText(), Text_apellido.getText(), (Date) Spn_Fecha.getValue(), Text_Direccion.getText(),
							Text_correo.getText(), combo_provincia.getSelectedItem().toString(),Text_ciudad.getText(),combo_genero.getSelectedItem().toString(),
							combo_estadoCivil.getSelectedItem().toString(), Text_telefono.getText(),Integer.valueOf(spn_experienciaporano.getValue().toString()),HabilidadesS);
						}
						if(mod == null) {
							CentroDeTrabajo.getInstance().agregarpersona(aux);
							JOptionPane.showMessageDialog(null, "El registro fue completado con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}else {
							CentroDeTrabajo.getInstance().modificarPersona(mod,aux);
							JOptionPane.showMessageDialog(null, "Se modificó con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
				}
			});
			boton_term.setEnabled(false);
			buttonPane.add(boton_term);
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
		if(mod != null) {
			loadData(mod);
		}
	}
	
	private void loadData(Persona mod) {
		Text_id.setText(mod.getId());
		Text_nombre.setText(mod.getNombre());
		Text_apellido.setText(mod.getApellido());
		Spn_Fecha.setValue(mod.getFecha());
		Text_Direccion.setText(mod.getDireccion());
		Text_correo.setText(mod.getCorreo());
		combo_provincia.setSelectedItem(mod.getProvincia());
		Text_ciudad.setText(mod.getCiudad());
		combo_genero.setSelectedItem(mod.getGenero());
		combo_estadoCivil.setSelectedItem(mod.getEstadocivil());
		Text_telefono.setText(mod.getTelefono());
		if(mod instanceof Estudiante) {
			text_universidad.setText(((Estudiante) mod).getUniversidad());
			combo_carrera.setSelectedItem(((Estudiante) mod).getCarrera());
			Estudiante_rdb.setSelected(true);
			tecnico_rdb.setSelected(false);
			Trabajador_rdb.setSelected(false);
			Panel_Estudiante.setVisible(true);
			Panel_Tecnico.setVisible(false);
			Panel_Trabajador.setVisible(false);
		}
		if(mod instanceof Tecnico) {
			texto_institucion.setText(((Tecnico) mod).getInstitucion());
			combo_Area.setSelectedItem(((Tecnico) mod).getArea());
			spn_anoExperiencia.setValue(Integer.valueOf(((Tecnico) mod).getAnosdeexperiencia()));	
			Estudiante_rdb.setSelected(false);
			tecnico_rdb.setSelected(true);
			Trabajador_rdb.setSelected(false);
			Panel_Estudiante.setVisible(false);
			Panel_Tecnico.setVisible(true);
			Panel_Trabajador.setVisible(false);
		}
		if(mod instanceof Trabajador) {
			HabilidadesS = ((ArrayList<String>)((Trabajador) mod).getHabilidades());
			loadSkills();
			spn_experienciaporano.setValue(Integer.valueOf(((Trabajador) mod).getExperiencia()));
			Estudiante_rdb.setSelected(false);
			tecnico_rdb.setSelected(false);
			Trabajador_rdb.setSelected(true);
			Panel_Estudiante.setVisible(false);
			Panel_Tecnico.setVisible(false);
			Panel_Trabajador.setVisible(true);
		}
		boton_siguiente.setEnabled(true);
		
	}

	private void updateNext() {
		if(!Text_id.getText().isEmpty() && !Text_nombre.getText().isEmpty() && !Text_apellido.getText().isEmpty() && !Text_telefono.getText().isEmpty() &&
			!Text_Direccion.getText().isEmpty() && !Text_ciudad.getText().isEmpty() && !Text_correo.getText().isEmpty()
			&& combo_estadoCivil.getSelectedIndex() != 0 && combo_provincia.getSelectedIndex() != 0) {
			
			boton_siguiente.setEnabled(true);	
		}else {
			boton_siguiente.setEnabled(false);
		}
	}
	
	private void loadSkills() {
		Habilidades.clear();
		for (String string : HabilidadesS) {
			Habilidades.addElement(string);
		}
		listaDeHabilidadesS.setModel(Habilidades);
		
	}
}
