package visual;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.SolicitudEmpleado;
import logico.Persona;
import logico.Estudiante;
import logico.Tecnico;
import logico.Trabajador;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoSolicitudTrabajo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contenidopanel = new JPanel();
	private JTextField txtdesalariomin;
	private JTextField txthrs;
	private JPanel panelgeneral;
	private JCheckBox cb_licencia;
	private JCheckBox cb_traslado;
	private JCheckBox cb_viajar;
	private JTextField txtYear;
	private JLabel lbl_imagen;
	private JLabel lbl_persona;
	private JPanel paneltrabajador;
	private JList<String> listLan1;
	private JList<String> listadeskills;
	private JPanel pnlestudiantes;
	private JLabel label_3;
	private JScrollPane scrollPanel_2;
	private JLabel lblCarrera;
	private JTextField txtcarrera;
	private JLabel lbl_uni;
	private JList<String> listLan2;
	private JTextPane txtuni;
	private JPanel pnlTech;
	private JLabel label_4;
	private JScrollPane scrollPane_3;
	private JLabel label_5;
	private JTextField txtYear2;
	private JLabel lbl_institucion;
	private JTextField txtinstitucion;
	private JLabel lbl_area;
	private JTextPane txtarea;
	private JList<String> listLan3;
	private JButton btn_nuevobtn;
	
	public InfoSolicitudTrabajo(SolicitudEmpleado aux) {
		
		setTitle("Datos Laborales");
		setBounds(100, 100, 420, 546);
		getContentPane().setLayout(new BorderLayout());
		contenidopanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contenidopanel, BorderLayout.CENTER);
		contenidopanel.setLayout(null);

		Persona p = aux.getAplicante();
		
		panelgeneral = new JPanel();
		panelgeneral.setLayout(null);
		panelgeneral.setBackground(Color.WHITE);
		panelgeneral.setBounds(0, 0, 403, 507);
		contenidopanel.add(panelgeneral);
		
		lbl_imagen = new JLabel("");
		lbl_imagen.setBounds(24, 49, 161, 141);
		panelgeneral.add(lbl_imagen);
		
		lbl_persona = new JLabel("");
		lbl_persona.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_persona.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_persona.setBounds(24, 11, 135, 26);
		panelgeneral.add(lbl_persona);
		
		JLabel lblSalarioMinimo = new JLabel("Salario minimo:");
		lblSalarioMinimo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalarioMinimo.setBounds(195, 34, 93, 19);
		panelgeneral.add(lblSalarioMinimo);
		
		txtdesalariomin = new JTextField();
		txtdesalariomin.setText((String) null);
		txtdesalariomin.setEnabled(false);
		txtdesalariomin.setDisabledTextColor(Color.GRAY);
		txtdesalariomin.setColumns(10);
		txtdesalariomin.setBounds(298, 33, 83, 20);
		panelgeneral.add(txtdesalariomin);
		
		JLabel lblHorasDeTrabajo = new JLabel("Horas de trabajo:");
		lblHorasDeTrabajo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorasDeTrabajo.setBounds(195, 64, 121, 19);
		panelgeneral.add(lblHorasDeTrabajo);
		
		txthrs = new JTextField();
		txthrs.setText((String) null);
		txthrs.setEnabled(false);
		txthrs.setDisabledTextColor(Color.GRAY);
		txthrs.setColumns(10);
		txthrs.setBounds(326, 64, 42, 20);
		panelgeneral.add(txthrs);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad");
		lblDisponibilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisponibilidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisponibilidad.setBounds(236, 105, 93, 19);
		panelgeneral.add(lblDisponibilidad);
		
		cb_viajar = new JCheckBox("Viajar");
		cb_viajar.setBackground(Color.WHITE);
		cb_viajar.setBounds(201, 131, 59, 23);
		panelgeneral.add(cb_viajar);
		
		cb_traslado = new JCheckBox("Mudanza");
		cb_traslado.setHorizontalAlignment(SwingConstants.CENTER);
		cb_traslado.setBackground(Color.WHITE);
		cb_traslado.setBounds(284, 131, 97, 23);
		panelgeneral.add(cb_traslado);
		
		JLabel lblNewLabel = new JLabel("Licencia de conducir");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(223, 161, 121, 14);
		panelgeneral.add(lblNewLabel);
		
		cb_licencia = new JCheckBox("");
		cb_licencia.setBackground(Color.WHITE);
		cb_licencia.setBounds(267, 173, 21, 26);
		panelgeneral.add(cb_licencia);
		
		paneltrabajador = new JPanel();
		paneltrabajador.setBackground(Color.WHITE);
		paneltrabajador.setBounds(10, 199, 383, 255);
		panelgeneral.add(paneltrabajador);
		paneltrabajador.setLayout(null);
		
		JLabel label = new JLabel("Idiomas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(21, 60, 144, 26);
		paneltrabajador.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 170, 148);
		paneltrabajador.add(scrollPane);
		
		listLan1 = new JList<String>();
		scrollPane.setViewportView(listLan1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(196, 97, 171, 148);
		paneltrabajador.add(scrollPane_1);
		
		listadeskills = new JList<String>();
		scrollPane_1.setViewportView(listadeskills);
		
		JLabel label_1 = new JLabel("Habilidades");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(207, 60, 144, 26);
		paneltrabajador.add(label_1);
		
		JLabel label_2 = new JLabel("A\u00F1os de experiencia");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 0, 145, 19);
		paneltrabajador.add(label_2);
		
		txtYear = new JTextField();
		txtYear.setText((String) null);
		txtYear.setEnabled(false);
		txtYear.setDisabledTextColor(Color.GRAY);
		txtYear.setColumns(10);
		txtYear.setBounds(66, 23, 36, 19);
		paneltrabajador.add(txtYear);
		
		pnlestudiantes = new JPanel();
		pnlestudiantes.setBackground(Color.WHITE);
		pnlestudiantes.setBounds(10, 199, 383, 255);
		panelgeneral.add(pnlestudiantes);
		pnlestudiantes.setLayout(null);
		
		label_3 = new JLabel("Idiomas");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(21, 59, 144, 26);
		pnlestudiantes.add(label_3);
		
		scrollPanel_2 = new JScrollPane();
		scrollPanel_2.setBounds(10, 96, 170, 148);
		pnlestudiantes.add(scrollPanel_2);
		
		listLan2 = new JList<String>();
		scrollPanel_2.setViewportView(listLan2);
		
		lblCarrera = new JLabel("Carrera:");
		lblCarrera.setHorizontalAlignment(SwingConstants.LEFT);
		lblCarrera.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCarrera.setBounds(10, 11, 69, 26);
		pnlestudiantes.add(lblCarrera);
		
		txtcarrera = new JTextField();
		txtcarrera.setBounds(89, 11, 284, 26);
		pnlestudiantes.add(txtcarrera);
		txtcarrera.setColumns(10);
		
		lbl_uni = new JLabel("Universidad");
		lbl_uni.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_uni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_uni.setBounds(215, 96, 133, 26);
		pnlestudiantes.add(lbl_uni);
		
		txtuni = new JTextPane();
		txtuni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtuni.setBounds(203, 127, 170, 91);
		pnlestudiantes.add(txtuni);
		
		pnlTech = new JPanel();
		pnlTech.setBackground(Color.WHITE);
		pnlTech.setBounds(10, 199, 383, 255);
		panelgeneral.add(pnlTech);
		pnlTech.setLayout(null);
		
		label_4 = new JLabel("Idiomas");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(21, 59, 144, 26);
		pnlTech.add(label_4);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 96, 170, 148);
		pnlTech.add(scrollPane_3);
		
		listLan3 = new JList<String>();
		scrollPane_3.setViewportView(listLan3);
		
		label_5 = new JLabel("A\u00F1os de experiencia");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(20, 6, 145, 19);
		pnlTech.add(label_5);
		
		txtYear2 = new JTextField();
		txtYear2.setText((String) null);
		txtYear2.setEnabled(false);
		txtYear2.setDisabledTextColor(Color.GRAY);
		txtYear2.setColumns(10);
		txtYear2.setBounds(76, 29, 36, 19);
		pnlTech.add(txtYear2);
		
		lbl_institucion = new JLabel("Instituci\u00F3n");
		lbl_institucion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_institucion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_institucion.setBounds(226, 6, 128, 26);
		pnlTech.add(lbl_institucion);
		
		txtinstitucion = new JTextField();
		txtinstitucion.setText((String) null);
		txtinstitucion.setEnabled(false);
		txtinstitucion.setDisabledTextColor(Color.GRAY);
		txtinstitucion.setColumns(10);
		txtinstitucion.setBounds(209, 33, 164, 26);
		pnlTech.add(txtinstitucion);
		
		lbl_area = new JLabel("Area");
		lbl_area.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_area.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_area.setBounds(215, 109, 133, 26);
		pnlTech.add(lbl_area);
		
		txtarea = new JTextPane();
		txtarea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtarea.setBounds(203, 140, 170, 91);
		pnlTech.add(txtarea);
		
		load(aux);
		
		
		if(p instanceof Trabajador) {
			Image Trabajador = new ImageIcon(this.getClass().getResource("/Trabajador.png")).getImage();
			lbl_imagen.setIcon(new ImageIcon(Trabajador));
			lbl_persona.setText("Obrero");
			paneltrabajador.setVisible(true);
			pnlTech.setVisible(false);
			pnlestudiantes.setVisible(false);
			loadWorker(aux);
		}
		
		if(p instanceof Estudiante) {
			Image Estudiante = new ImageIcon(this.getClass().getResource("/Estudiante.png")).getImage();
			lbl_imagen.setIcon(new ImageIcon(Estudiante));
			lbl_persona.setText("Egresado");
			pnlestudiantes.setVisible(true);
			pnlTech.setVisible(false);
			paneltrabajador.setVisible(false);
			loadStudent(aux);
		}
		
		if(p instanceof Tecnico) {
			Image tech = new ImageIcon(this.getClass().getResource("/Tecnico.png")).getImage();
			lbl_imagen.setIcon(new ImageIcon(tech));
			lbl_persona.setText("Técnico");
			pnlTech.setVisible(true);
			pnlestudiantes.setVisible(false);
			paneltrabajador.setVisible(false);
			loadTechnician(aux);
		}
		
		
		
		btn_nuevobtn = new JButton("Salir");
		btn_nuevobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_nuevobtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_nuevobtn.setBounds(161, 473, 89, 23);
		panelgeneral.add(btn_nuevobtn);
	}

	private void load(SolicitudEmpleado aux) {
		txtdesalariomin.setText(""+aux.getSalariominimo());
		if(aux.isLicencia()) {
			cb_licencia.setSelected(true);
		}else {
			cb_licencia.setSelected(false);
		}
		if(aux.isDispmudarse()) {
			cb_traslado.setSelected(true);
		}else {
			cb_traslado.setSelected(false);
		}
		if(aux.isDispviajar()) {
			cb_viajar.setSelected(true);
		}else {
			cb_viajar.setSelected(false);
		}
		txthrs.setText(""+aux.getHrsdetrabajo());
		
	}

	private void loadTechnician(SolicitudEmpleado aux) {
		Tecnico t = (Tecnico) aux.getAplicante();
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (String l : aux.getLenguajes()) {
			model.addElement(l);
		}
		listLan3.setModel(model);
		txtYear2.setText(""+t.getAnosdeexperiencia());
		txtinstitucion.setText(t.getInstitucion());
		txtarea.setText(t.getArea());
	}

	private void loadStudent(SolicitudEmpleado aux) {
		Estudiante s = (Estudiante) aux.getAplicante();
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (String l : aux.getLenguajes()) {
			model.addElement(l);
		}
		listLan2.setModel(model);
		txtcarrera.setText(s.getCarrera());
		txtuni.setText(s.getUniversidad());	
	}

	private void loadWorker(SolicitudEmpleado aux) {
		Trabajador w = (Trabajador) aux.getAplicante();
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (String l : aux.getLenguajes()) {
			model.addElement(l);
		}
		listLan1.setModel(model);
		DefaultListModel<String> model1 = new DefaultListModel<String>();
		for (String s : w.getHabilidades()) {
			model1.addElement(s);
		}
		listadeskills.setModel(model1);
		txtYear.setText(""+w.getExperiencia());
	}
}