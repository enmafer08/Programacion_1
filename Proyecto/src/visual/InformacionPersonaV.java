package visual;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import logico.Persona;
import logico.Estudiante;
import logico.Tecnico;
import logico.Trabajador;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class InformacionPersonaV extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea txtareaskills;
	private JTextArea txtareadireccion;
	private JTextField txtID;
	private JTextField txtnombre;
	private JTextField txtfechanacim;
	private JTextField txtprovincia;
	private JTextField txtciudad;
	private JTextField txtgenero;
	private JTextField txtestadocivil;
	private JTextField txttelefono;
	private JTextField txtEmail;
	private JTextField txtestadotrabajo;
	
	public InformacionPersonaV(Persona Persona) {
		setTitle("Datos");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 394, 497);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblDatosPersonales = new JLabel("Datos Personales");
			lblDatosPersonales.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblDatosPersonales.setBounds(133, 11, 144, 26);
			panel.add(lblDatosPersonales);
			
			JLabel lblID = new JLabel("C\u00E9dula:");
			lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblID.setBounds(26, 57, 93, 14);
			panel.add(lblID);
			
			JLabel lblName = new JLabel("Nombre:");
			lblName.setBackground(Color.WHITE);
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblName.setBounds(26, 82, 93, 14);
			panel.add(lblName);
			
			JLabel lblBirthDate = new JLabel("Fecha de nacimiento:");
			lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBirthDate.setBounds(26, 107, 135, 14);
			panel.add(lblBirthDate);
			
			JLabel lblProvince = new JLabel("Provincia:");
			lblProvince.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblProvince.setBounds(26, 132, 93, 14);
			panel.add(lblProvince);
			
			JLabel lblCity = new JLabel("Ciudad:");
			lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCity.setBounds(26, 157, 93, 14);
			panel.add(lblCity);
			
			JLabel lblAddress = new JLabel("Direcci\u00F3n:");
			lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAddress.setBounds(26, 182, 93, 14);
			panel.add(lblAddress);
			
			JLabel lblGender = new JLabel("G\u00E9nero:");
			lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblGender.setBounds(26, 246, 64, 14);
			panel.add(lblGender);
			
			JLabel lblPhone = new JLabel("Tel\u00E9fono:");
			lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPhone.setBounds(26, 271, 93, 14);
			panel.add(lblPhone);
			
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEmail.setBounds(26, 296, 93, 14);
			panel.add(lblEmail);
			
			JLabel lblSkills = new JLabel("Habilidad/es:");
			lblSkills.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSkills.setBounds(26, 321, 93, 14);
			panel.add(lblSkills);
			
			JLabel lblWorkingStatus = new JLabel("Estado laboral:");
			lblWorkingStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblWorkingStatus.setBounds(26, 391, 93, 14);
			panel.add(lblWorkingStatus);
			
			JLabel lblMaritalStatus = new JLabel("Estado civil:");
			lblMaritalStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMaritalStatus.setBounds(181, 246, 86, 14);
			panel.add(lblMaritalStatus);
			
			txtID = new JTextField();
			txtID.setEnabled(false);
			txtID.setDisabledTextColor(Color.GRAY);
			txtID.setBounds(114, 56, 234, 20);
			panel.add(txtID);
			txtID.setColumns(10);
			
			txtnombre = new JTextField();
			txtnombre.setEnabled(false);
			txtnombre.setDisabledTextColor(Color.GRAY);
			txtnombre.setBounds(114, 81, 234, 20);
			panel.add(txtnombre);
			txtnombre.setColumns(10);
			
			txtfechanacim = new JTextField();
			txtfechanacim.setEnabled(false);
			txtfechanacim.setDisabledTextColor(Color.GRAY);
			txtfechanacim.setBounds(171, 106, 177, 20);
			panel.add(txtfechanacim);
			txtfechanacim.setColumns(10);
			
			txtprovincia = new JTextField();
			txtprovincia.setEnabled(false);
			txtprovincia.setDisabledTextColor(Color.GRAY);
			txtprovincia.setBounds(114, 132, 234, 20);
			panel.add(txtprovincia);
			txtprovincia.setColumns(10);
			
			txtciudad = new JTextField();
			txtciudad.setEnabled(false);
			txtciudad.setDisabledTextColor(Color.GRAY);
			txtciudad.setColumns(10);
			txtciudad.setBounds(114, 156, 234, 20);
			panel.add(txtciudad);
			
			Border border = BorderFactory.createLineBorder(Color.GRAY);
			txtareadireccion = new JTextArea();
			txtareadireccion.setEnabled(false);
			txtareadireccion.setDisabledTextColor(Color.GRAY);
			txtareadireccion.setBounds(114, 182, 234, 55);
			panel.add(txtareadireccion);
			txtareadireccion.setBorder(BorderFactory.createCompoundBorder(border,
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
			txtareadireccion.setLineWrap(true);
			txtareadireccion.setWrapStyleWord(true);
			
			txtgenero = new JTextField();
			txtgenero.setEnabled(false);
			txtgenero.setDisabledTextColor(Color.GRAY);
			txtgenero.setBounds(114, 245, 64, 20);
			panel.add(txtgenero);
			txtgenero.setColumns(10);
			
			txtestadocivil = new JTextField();
			txtestadocivil.setEnabled(false);
			txtestadocivil.setDisabledTextColor(Color.GRAY);
			txtestadocivil.setBounds(262, 245, 86, 20);
			panel.add(txtestadocivil);
			txtestadocivil.setColumns(10);
			
			txttelefono = new JTextField();
			txttelefono.setEnabled(false);
			txttelefono.setDisabledTextColor(Color.GRAY);
			txttelefono.setBounds(114, 270, 234, 20);
			panel.add(txttelefono);
			txttelefono.setColumns(10);
			
			txtEmail = new JTextField();
			txtEmail.setEnabled(false);
			txtEmail.setDisabledTextColor(Color.GRAY);
			txtEmail.setBounds(114, 295, 234, 20);
			panel.add(txtEmail);
			txtEmail.setColumns(10);
			
			txtareaskills = new JTextArea();
			txtareaskills.setEnabled(false);
			txtareaskills.setDisabledTextColor(Color.GRAY);
			txtareaskills.setWrapStyleWord(true);
			txtareaskills.setLineWrap(true);
			txtareaskills.setBounds(114, 321, 234, 59);
			panel.add(txtareaskills);
			txtareaskills.setBorder(BorderFactory.createCompoundBorder(border,
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
			txtareaskills.setLineWrap(true);
			txtareaskills.setWrapStyleWord(true);
			
			txtestadotrabajo = new JTextField();
			txtestadotrabajo.setEnabled(false);
			txtestadotrabajo.setDisabledTextColor(Color.GRAY);
			txtestadotrabajo.setBounds(123, 390, 225, 20);
			panel.add(txtestadotrabajo);
			txtestadotrabajo.setColumns(10);
			
			JButton btnExit = new JButton("Salir");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnExit.setBounds(151, 429, 89, 23);
			panel.add(btnExit);
			
			setData(Persona);
			setBirthdate(Persona.getFecha());
			
		}
	}

	private void setBirthdate(Date birthDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(birthDate);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		txtfechanacim.setText("            "+String.valueOf(day)+ "   /   "+ String.valueOf(month+1)+ "   /   "+ String.valueOf(year));
	}

	private void setData(Persona Persona) {
		txtID.setText(Persona.getId());
		txtnombre.setText(Persona.getNombre()+" "+Persona.getApellido());
		txtprovincia.setText(Persona.getProvincia());
		txtciudad.setText(Persona.getCiudad());
		txtareadireccion.setText(Persona.getDireccion());
		txtgenero.setText(Persona.getGenero());
		txtestadocivil.setText(Persona.getEstadocivil());
		txtEmail.setText(Persona.getCorreo());
		txttelefono.setText(Persona.getTelefono());
		if(Persona.getEstadotrabajo())
			txtestadotrabajo.setText("Empleado");
		else
			txtestadotrabajo.setText("Desempleado");
		if(Persona instanceof Estudiante) {
			Estudiante Estudiante=(Estudiante)Persona;
			txtareaskills.setText(Estudiante.getCarrera());
		}
		else if(Persona instanceof Tecnico) {
			Tecnico tech=(Tecnico)Persona;
			txtareaskills.setText(tech.getArea());
		}
		else {
			Trabajador Trabajador=(Trabajador)Persona;
			String skills="";
			for(int i=0;i<Trabajador.getHabilidades().size();i++)
				skills= skills+", "+Trabajador.getHabilidades().get(i);
			txtareaskills.setText(skills);
			
		}
	}
}
