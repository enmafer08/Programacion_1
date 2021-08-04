package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import logico.CentroDeTrabajo;
import logico.Persona;
import logico.Estudiante;
import logico.Tecnico;
import logico.Trabajador;
import logico.SolicitudEmpleado;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class RegistroSolicitudDeEmpleado extends JDialog {

	private final JPanel Panel_contenido = new JPanel();
	private JSeparator separador;
	private JLabel label_ced;
	private JTextField text_ced;
	private JLabel label_leng;
	private JCheckBox checkbox_disMudarse;
	private JLabel label_laboralinf;
	private JSeparator separador1;
	private JLabel Label_SalarioMin;
	private JSpinner Spn_SalarioMin;
	private JLabel Label_horasdeTrabajo;
	private JSpinner Spn_HoradeTrabajo;
	private JComboBox cbx_lenguajes;
	private JButton boton_registrar;
	private JButton boton_anadirLeng;
	private JScrollPane scrollPane;
	private JList<String> list_lenguajes;
	private DefaultListModel<String> LenguajesModel;
	private JLabel label_selecLenguaje;
	private JButton Boton_quitarLeng;
	private JCheckBox check_Licencia;
	private JCheckBox check_disViajar;

	/**
	  Create the dialog.
	 */
	public RegistroSolicitudDeEmpleado(SolicitudEmpleado req) {
		LenguajesModel = new DefaultListModel<String>();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setTitle("Solicitar empleo");
		setBounds(100, 100, 680, 680);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		Panel_contenido.setBackground(Color.WHITE);
		Panel_contenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(Panel_contenido, BorderLayout.CENTER);
		Panel_contenido.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlGeneral = new JPanel();
			pnlGeneral.setBackground(Color.WHITE);
			pnlGeneral.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			Panel_contenido.add(pnlGeneral, BorderLayout.CENTER);
			pnlGeneral.setLayout(null);
			{
				JLabel lblInfGen = new JLabel("Informaci\u00F3n general");
				lblInfGen.setFont(new Font("Tahoma", Font.PLAIN, 19));
				lblInfGen.setBounds(20, 15, 180, 23);
				pnlGeneral.add(lblInfGen);
			}
			
			separador = new JSeparator();
			separador.setBounds(10, 45, 640, 2);
			pnlGeneral.add(separador);
			
			label_ced = new JLabel("N\u00FAmero de c\u00E9dula:");
			label_ced.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label_ced.setBounds(20, 75, 140, 23);
			pnlGeneral.add(label_ced);
			
			text_ced = new JTextField();
			text_ced.setBounds(175, 74, 400, 29);
			pnlGeneral.add(text_ced);
			text_ced.setColumns(10);
			text_ced.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')  || (text_ced.getText().length()==11)) {
	                    e.consume();
	                }
				}
				@Override
				public void keyReleased(KeyEvent arg0) {
					updateFin();
				}
			});
			
			label_leng = new JLabel("Idiomas:");
			label_leng.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label_leng.setBounds(20, 260, 70, 23);
			pnlGeneral.add(label_leng);
			
			checkbox_disMudarse = new JCheckBox(" Disponibilidad para mudarse");
			checkbox_disMudarse.setBackground(Color.WHITE);
			checkbox_disMudarse.setFont(new Font("Tahoma", Font.PLAIN, 16));
			checkbox_disMudarse.setBounds(20, 120, 240, 31);
			pnlGeneral.add(checkbox_disMudarse);
			
			check_Licencia = new JCheckBox(" Licencia de conducir");
			check_Licencia.setBackground(Color.WHITE);
			check_Licencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
			check_Licencia.setBounds(20, 210, 180, 31);
			pnlGeneral.add(check_Licencia);
			
			label_laboralinf = new JLabel("Informaci\u00F3n laboral");
			label_laboralinf.setFont(new Font("Tahoma", Font.PLAIN, 19));
			label_laboralinf.setBounds(20, 410, 170, 23);
			pnlGeneral.add(label_laboralinf);
			
			separador1 = new JSeparator();
			separador1.setBounds(10, 440, 640, 2);
			pnlGeneral.add(separador1);
			
			Label_SalarioMin = new JLabel("Salario m\u00EDnimo demandado:");
			Label_SalarioMin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			Label_SalarioMin.setBounds(20, 475, 210, 23);
			pnlGeneral.add(Label_SalarioMin);
			
			Spn_SalarioMin = new JSpinner();
			Spn_SalarioMin.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			Spn_SalarioMin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			Spn_SalarioMin.setBounds(245, 474, 100, 30);
			pnlGeneral.add(Spn_SalarioMin);
			
			Label_horasdeTrabajo = new JLabel("Horas de trabajo semanales");
			Label_horasdeTrabajo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			Label_horasdeTrabajo.setBounds(20, 530, 235, 23);
			pnlGeneral.add(Label_horasdeTrabajo);
			
			Spn_HoradeTrabajo = new JSpinner();
			Spn_HoradeTrabajo.setModel(new SpinnerNumberModel(1, 1, 60, 1));
			Spn_HoradeTrabajo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			Spn_HoradeTrabajo.setBounds(245, 526, 100, 30);
			pnlGeneral.add(Spn_HoradeTrabajo);
			
			cbx_lenguajes = new JComboBox();
			cbx_lenguajes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbx_lenguajes.getSelectedIndex()>0) {
						boton_anadirLeng.setEnabled(true);
					}
					else {
						boton_anadirLeng.setEnabled(false);
					}
				}
			});
			cbx_lenguajes.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbx_lenguajes.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Alem\u00E1n", "Chino", "Coreano", "Espa\u00F1ol", "Franc\u00E9s", "Ingl\u00E9s", "Italiano", "Japon\u00E9s", "Portugu\u00E9s"}));
			cbx_lenguajes.setBounds(105, 259, 150, 29);
			pnlGeneral.add(cbx_lenguajes);
			
			boton_anadirLeng = new JButton("A\u00F1adir >>");
			boton_anadirLeng.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!LenguajesModel.contains(cbx_lenguajes.getSelectedItem().toString())) {
						LenguajesModel.addElement(cbx_lenguajes.getSelectedItem().toString());
						list_lenguajes.setModel(LenguajesModel);	
					}
					cbx_lenguajes.setSelectedIndex(0);
					Boton_quitarLeng.setEnabled(false);
					updateFin();
				}
			});
			boton_anadirLeng.setEnabled(false);
			boton_anadirLeng.setFont(new Font("Tahoma", Font.PLAIN, 16));
			boton_anadirLeng.setBounds(115, 310, 130, 31);
			pnlGeneral.add(boton_anadirLeng);
			
			scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(380, 200, 200, 160);
			pnlGeneral.add(scrollPane);
			
			list_lenguajes = new JList<String>();
			list_lenguajes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(list_lenguajes.getSelectedIndex() != -1) {
						Boton_quitarLeng.setEnabled(true);
					}
					else {
						Boton_quitarLeng.setEnabled(false);
					}
				}
			});
			scrollPane.setViewportView(list_lenguajes);
			
			label_selecLenguaje = new JLabel("Idiomas dominados:");
			label_selecLenguaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label_selecLenguaje.setBounds(385, 165, 150, 23);
			pnlGeneral.add(label_selecLenguaje);
			
			Boton_quitarLeng = new JButton("Quitar");
			Boton_quitarLeng.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LenguajesModel.removeElement(list_lenguajes.getSelectedValue());
					list_lenguajes.setModel(LenguajesModel);	
					cbx_lenguajes.setSelectedIndex(0);
					Boton_quitarLeng.setEnabled(false);
					updateFin();
				}
			});
			Boton_quitarLeng.setFont(new Font("Tahoma", Font.PLAIN, 16));
			Boton_quitarLeng.setEnabled(false);
			Boton_quitarLeng.setBounds(417, 370, 130, 31);
			pnlGeneral.add(Boton_quitarLeng);
			
			check_disViajar = new JCheckBox(" Disponibilidad para viajar");
			check_disViajar.setBackground(Color.WHITE);
			check_disViajar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			check_disViajar.setBounds(20, 165, 220, 31);
			pnlGeneral.add(check_disViajar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				boton_registrar = new JButton("Solicitar");
				boton_registrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int reply = 0, reply1=0;
						
						if(CentroDeTrabajo.getInstance().buscarpersonaporid(text_ced.getText()) != null) {
							Persona person1=CentroDeTrabajo.getInstance().buscarpersonaporid(text_ced.getText());
							if(person1.getEstadotrabajo()==true) {
								 reply = JOptionPane.showConfirmDialog(null, "Su estado laboral es empleado. Debe de cambiarlo para realizar una solicitud. ¿Desea hacerlo?", "Conflicto con estado laboral", JOptionPane.YES_NO_OPTION);
								if (reply == JOptionPane.NO_OPTION) {
								    dispose();
								}
								
							}
							SolicitudEmpleado aux=CentroDeTrabajo.getInstance().buscarEmpleadoreqPorPersona(person1);
							if(aux!=null && aux.isestado()==true) {
								reply1 = JOptionPane.showConfirmDialog(null, "Usted ya tiene una solicitud activa. ¿Desea desactivarla para poder realizar otra solicitud?", "Conflicto con solicitud", JOptionPane.YES_NO_OPTION);
								if (reply1 == JOptionPane.NO_OPTION) {
									dispose();
								}
								else {
									aux.setestado(false);
								}
							}
							if((person1.getEstadotrabajo()==false || reply == JOptionPane.YES_OPTION) && (aux==null ||reply1 == JOptionPane.YES_OPTION)) {
								person1.setEstadotrabajo(false);
								List<String> langs = new ArrayList<String>();
								for(int i = 0; i<LenguajesModel.getSize(); i++) {
									langs.add(LenguajesModel.getElementAt(i));
								}
								
								
								if(req == null) {
									String id = ""+SolicitudEmpleado.cod++;	
									SolicitudEmpleado request = new SolicitudEmpleado(id, person1, (float) Spn_SalarioMin.getValue(), 
											langs, (int) Spn_HoradeTrabajo.getValue(), check_disViajar.isSelected(), checkbox_disMudarse.isSelected(), check_Licencia.isSelected());
									CentroDeTrabajo.getInstance().agregarempleadosolic(request);
									
								}
								else {
									req.setAplicante(CentroDeTrabajo.getInstance().buscarpersonaporid(text_ced.getText()));
									req.setestado(true);
									req.setSalariominimo((float) Spn_SalarioMin.getValue());
									req.setLenguajes(langs);
									req.setHrsdetrabajo((int) Spn_HoradeTrabajo.getValue());
									req.setDispviajar(check_disViajar.isSelected());
									req.setDispmudarse(checkbox_disMudarse.isSelected());
									req.setLicencia(check_Licencia.isSelected());
								}
								
								JOptionPane.showMessageDialog(null, "El registro fue completado con éxito.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "No se pudo crear la solicitud. Cédula incorrecta o inexistente.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				boton_registrar.setEnabled(false);
				buttonPane.add(boton_registrar);
				getRootPane().setDefaultButton(boton_registrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void updateFin() {
		if(!text_ced.getText().isEmpty() && !LenguajesModel.isEmpty()) {
			boton_registrar.setEnabled(true);
		}else {
			boton_registrar.setEnabled(false);
		}
	}
}
