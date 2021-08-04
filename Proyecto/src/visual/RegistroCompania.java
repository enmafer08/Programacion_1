package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import logico.Compania;
import logico.CentroDeTrabajo;

import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroCompania extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2840434116876409078L;	
	private final JPanel PanelContenido = new JPanel();
	private JTextField Text_nombre;
	private JTextField Text_Ciudad;
	private JTextField Text_Correo;
	private JTextField Text_telefono;
	private JComboBox<String> Combox_Area;
	private JTextArea Text_Direccion;
	private JComboBox<String> Combox_Provincia;
	private JTextField Text_Rnc;
  private int modificarEstado;

	public RegistroCompania(Compania Compania) {
		if(Compania.getRnc().equalsIgnoreCase(""))
			this.modificarEstado=0;
		setTitle("Registrar Empresa");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 581, 581);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		PanelContenido.setBackground(Color.WHITE);
		PanelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(PanelContenido, BorderLayout.CENTER);
		PanelContenido.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		PanelContenido.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblInformacionGeneral = new JLabel("Informaci\u00F3n general");
		lblInformacionGeneral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacionGeneral.setBounds(10, 10, 187, 21);
		panel.add(lblInformacionGeneral);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 38, 525, 2);
		panel.add(separator_2);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(10, 97, 70, 27);
		panel.add(lblNombre);
		
		Text_nombre = new JTextField();
		Text_nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Text_nombre.setColumns(10);
		Text_nombre.setBounds(100, 98, 435, 28);
		panel.add(Text_nombre);
		
		JLabel lblArea = new JLabel("\u00C1rea:");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArea.setBounds(10, 144, 70, 27);
		panel.add(lblArea);
		
		Combox_Area = new JComboBox<String>();
		Combox_Area.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Combox_Area.setModel(new DefaultComboBoxModel(new String[] {"<Sin especificar>", "Turismo", "Salud", "Educaci\u00F3n", "Tecnolog\u00EDa", "Construcci\u00F3n", "Venta de veh\u00EDculos"}));
		Combox_Area.setBounds(100, 143, 181, 27);
		panel.add(Combox_Area);
		
		JLabel lblInformacionContacto = new JLabel("Informaci\u00F3n de contacto");
		lblInformacionContacto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacionContacto.setBounds(10, 188, 227, 21);
		panel.add(lblInformacionContacto);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(10, 216, 523, 2);
		panel.add(separator_2_1);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccin.setBounds(10, 276, 89, 27);
		panel.add(lblDireccin);
		
		JLabel label_7 = new JLabel("Provincia:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(10, 231, 89, 27);
		panel.add(label_7);
		
		Combox_Provincia = new JComboBox<String>();
		Combox_Provincia.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", "Distrito Nacional", "Duarte", "El\u00EDas Pi\u00F1a", "El Seibo", "Espaillat", "Hato Mayor", "Hermanas Mirabal", "Independencia", "La Altagracia", "La Romana", "La Vega", "Mar\u00EDa Trinidad S\u00E1nchez", "Monse\u00F1or Nouel", "Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Saman\u00E1", "S\u00E1nchez Ram\u00EDrez", "San Crist\u00F3bal", "San Jos\u00E9 de Ocoa", "San Juan", "San Pedro de Macor\u00EDs", "Santiago", "Santiago Rodr\u00EDguez", "Santo Domingo", "Valverde"}));
		Combox_Provincia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Combox_Provincia.setBounds(100, 231, 179, 27);
		panel.add(Combox_Provincia);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCiudad.setBounds(317, 231, 89, 27);
		panel.add(lblCiudad);
		
		Text_Ciudad = new JTextField();
		Text_Ciudad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z'))
                        && (caracter != '\b') && (caracter!=32)) {
                    e.consume();
                }
			}
		});
		Text_Ciudad.setColumns(10);
		Text_Ciudad.setBounds(390, 230, 145, 28);
		panel.add(Text_Ciudad);
		
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		
		Text_Rnc = new JTextField();
		Text_Rnc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b') ) {
                    e.consume();
                }
			}
		});
		Text_Rnc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Text_Rnc.setColumns(10);
		Text_Rnc.setBounds(100, 54, 435, 28);
		panel.add(Text_Rnc);
		
		Text_Direccion = new JTextArea();
		Text_Direccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Text_Direccion.setBounds(100, 273, 435, 58);
		panel.add(Text_Direccion);
		Text_Direccion.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		Text_Direccion.setLineWrap(true);
		Text_Direccion.setWrapStyleWord(true);

		
		JLabel lblInformacionContacto_1 = new JLabel("Informaci\u00F3n de contacto");
		lblInformacionContacto_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformacionContacto_1.setBounds(10, 351, 227, 21);
		panel.add(lblInformacionContacto_1);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setBounds(10, 379, 523, 2);
		panel.add(separator_2_1_1);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electr\u00F3nico ");
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreoElectronico.setBounds(10, 394, 145, 27);
		panel.add(lblCorreoElectronico);
		
		Text_Correo = new JTextField();
		Text_Correo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Text_Correo.setColumns(10);
		Text_Correo.setBounds(165, 391, 311, 28);
		panel.add(Text_Correo);
		
		JLabel lblNmeroTelefnico = new JLabel("N\u00FAmero telef\u00F3nico:");
		lblNmeroTelefnico.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmeroTelefnico.setBounds(10, 440, 145, 27);
		panel.add(lblNmeroTelefnico);
		
		Text_telefono = new JTextField();
		Text_telefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b') ) {
                    e.consume();
                }
			}
		});
		Text_telefono.setColumns(10);
		Text_telefono.setBounds(165, 441, 145, 28);
		panel.add(Text_telefono);
		
		JLabel lblRnc = new JLabel("RNC:");
		lblRnc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRnc.setBounds(10, 53, 70, 27);
		panel.add(lblRnc);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(300, 495, 106, 27);
		panel.add(btnCancelar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkAllTextBox()==false) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
				else if(CentroDeTrabajo.getInstance().buscarcompaniaporid(Text_Rnc.getText())!=null) {
					JOptionPane.showMessageDialog(null, "Esta empresa ya existe.", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Compania.setDireccion(Text_Direccion.getText());
					Compania.setCiudad(Text_Ciudad.getText());
					Compania.setCorreo(Text_Correo.getText());
					Compania.setNombre(Text_nombre.getText());
					Compania.setTelefono(Text_telefono.getText());
					Compania.setProvincia((String) Combox_Provincia.getSelectedItem());
					Compania.setRnc(Text_Rnc.getText());
					Compania.setLocalidad((String) Combox_Area.getSelectedItem());
					if(modificarEstado==0)
						CentroDeTrabajo.getInstance().agregarcompania(Compania);
					dispose();
				}
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(175, 495, 106, 26);
		panel.add(btnRegistrar);
		
		
  if(Compania.getRnc().equals("")==false ) {
			setCompanyValuesToModify(Compania);
			btnRegistrar.setText("Modificar");
		}
	}


	private void setCompanyValuesToModify(Compania Compania) {
		Text_nombre.setText(Compania.getNombre());
		Text_Ciudad.setText(Compania.getCiudad());
		Text_Correo.setText(Compania.getCorreo());
		Text_telefono.setText(Compania.getTelefono());
		Combox_Provincia.setSelectedItem(Compania.getProvincia());
		Combox_Area.setSelectedItem(Compania.getLocalidad());
		Text_Direccion.setText(Compania.getDireccion());
		Text_Rnc.setEnabled(false);
		Text_Rnc.setText(Compania.getRnc());
	}

	protected boolean checkAllTextBox() {
		Boolean check=true;
		if(Text_nombre.getText().equals("")|| Text_Ciudad.getText().equals("") || Text_Correo.getText().equals("")
				|| Text_telefono.getText().equals("")|| Combox_Area.getSelectedIndex()==-1 || Text_Direccion.getText().equals("")
				|| Combox_Provincia.getSelectedIndex()==-1 || Text_Rnc.getText().equals("")) {
			check=false;
		}
		return check;
	}
}


