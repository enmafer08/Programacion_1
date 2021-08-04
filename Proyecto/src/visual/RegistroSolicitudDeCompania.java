package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import logico.CentroDeTrabajo;
import logico.Persona;
import logico.Estudiante;
import logico.Tecnico;
import logico.Trabajador;
import logico.Compania;
import logico.SolicitudCompania;
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

public class RegistroSolicitudDeCompania extends JDialog {


	private static final long serialVersionUID = -6422328856908306488L;
	private final JPanel PanelContenido = new JPanel();
	private JSeparator Separador;
	private JLabel label_id;
	private JTextField text_id;
	private JLabel label_leng;
	private JCheckBox checkbox_disMudarse;
	private JLabel lblInfLaboral;
	private JSeparator separador1;
	private JLabel label_Salariomin;
	private JSpinner spn_salarioMax;
	private JLabel label_horasdetrabajo;
	private JSpinner spn_horasdetrabajo;
	private JComboBox combo_lenguajes;
	private JButton boton_registrar;
	private JButton boton_AnadirLeng;
	private JScrollPane scrollPane;
	private JList<String> lista_lenguajes;
	private DefaultListModel<String> LenguajesModel;
	private JLabel Label_LenguajeSelec;
	private JButton btn_eliminarLeng;
	private JCheckBox check_licencia;
	private JLabel label_tipo;
	private JComboBox combo_tipo;
	private JLabel label_cantidad;
	private JCheckBox check_Viajedis;
	private JSpinner spn_cantidad;
	private JLabel Label_habilidades;
	private JComboBox combo_habilidad;

	/* Create the dialog.
	 */
	public RegistroSolicitudDeCompania(SolicitudCompania req) {
		LenguajesModel = new DefaultListModel<String>();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setTitle("Solicitar empleados");
		setBounds(100, 100, 680, 735);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		PanelContenido.setBackground(Color.WHITE);
		PanelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(PanelContenido, BorderLayout.CENTER);
		PanelContenido.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlGeneral = new JPanel();
			pnlGeneral.setBackground(Color.WHITE);
			pnlGeneral.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			PanelContenido.add(pnlGeneral, BorderLayout.CENTER);
			pnlGeneral.setLayout(null);
			{
				JLabel lblInfGen = new JLabel("Informaci\u00F3n general");
				lblInfGen.setFont(new Font("Tahoma", Font.PLAIN, 19));
				lblInfGen.setBounds(20, 15, 180, 23);
				pnlGeneral.add(lblInfGen);
			}
			
			Separador = new JSeparator();
			Separador.setBounds(10, 45, 640, 2);
			pnlGeneral.add(Separador);
			
			label_id = new JLabel("RNC de la compa\u00F1\u00EDa:");
			label_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label_id.setBounds(20, 75, 150, 23);
			pnlGeneral.add(label_id);
			
			text_id = new JTextField();
			text_id.setBounds(185, 74, 400, 29);
			pnlGeneral.add(text_id);
			text_id.setColumns(10);
			text_id.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')  || (text_id.getText().length()==11)) {
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
			
			checkbox_disMudarse = new JCheckBox(" Disponibilidad para mudarse requerida");
			checkbox_disMudarse.setBackground(Color.WHITE);
			checkbox_disMudarse.setFont(new Font("Tahoma", Font.PLAIN, 16));
			checkbox_disMudarse.setBounds(20, 120, 315, 31);
			pnlGeneral.add(checkbox_disMudarse);
			
			check_licencia = new JCheckBox(" Licencia de conducir requerida");
			check_licencia.setBackground(Color.WHITE);
			check_licencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
			check_licencia.setBounds(20, 210, 260, 31);
			pnlGeneral.add(check_licencia);
			
			lblInfLaboral = new JLabel("Informaci\u00F3n laboral");
			lblInfLaboral.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblInfLaboral.setBounds(20, 495, 170, 23);
			pnlGeneral.add(lblInfLaboral);
			
			separador1 = new JSeparator();
			separador1.setBounds(10, 525, 640, 2);
			pnlGeneral.add(separador1);
			
			label_Salariomin = new JLabel("Salario m\u00EDnimo ofrecido:");
			label_Salariomin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label_Salariomin.setBounds(20, 555, 180, 23);
			pnlGeneral.add(label_Salariomin);
			
			spn_salarioMax = new JSpinner();
			spn_salarioMax.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spn_salarioMax.setFont(new Font("Tahoma", Font.PLAIN, 16));
			spn_salarioMax.setBounds(210, 554, 100, 30);
			pnlGeneral.add(spn_salarioMax);
			
			label_horasdetrabajo = new JLabel("Horas de trabajo requeridas:");
			label_horasdetrabajo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label_horasdetrabajo.setBounds(340, 555, 210, 23);
			pnlGeneral.add(label_horasdetrabajo);
			
			spn_horasdetrabajo = new JSpinner();
    	spn_horasdetrabajo.setModel(new SpinnerNumberModel(1, 1, 60, 1));
			spn_horasdetrabajo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			spn_horasdetrabajo.setBounds(553, 554, 84, 30);
			pnlGeneral.add(spn_horasdetrabajo);
			
			combo_lenguajes = new JComboBox();
			combo_lenguajes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(combo_lenguajes.getSelectedIndex()>0) {
						boton_AnadirLeng.setEnabled(true);
					}
					else {
						boton_AnadirLeng.setEnabled(false);
					}
				}
			});
			combo_lenguajes.setFont(new Font("Tahoma", Font.PLAIN, 16));
			combo_lenguajes.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Alem\u00E1n", "Chino", "Coreano", "Espa\u00F1ol", "Franc\u00E9s", "Ingl\u00E9s", "Italiano", "Japon\u00E9s", "Portugu\u00E9s"}));
			combo_lenguajes.setBounds(105, 259, 150, 29);
			pnlGeneral.add(combo_lenguajes);
			
			boton_AnadirLeng = new JButton("A\u00F1adir >>");
			boton_AnadirLeng.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!LenguajesModel.contains(combo_lenguajes.getSelectedItem().toString())) {
						LenguajesModel.addElement(combo_lenguajes.getSelectedItem().toString());
						lista_lenguajes.setModel(LenguajesModel);	
					}
					combo_lenguajes.setSelectedIndex(0);
					btn_eliminarLeng.setEnabled(false);
					updateFin();
				}
			});
			boton_AnadirLeng.setEnabled(false);
			boton_AnadirLeng.setFont(new Font("Tahoma", Font.PLAIN, 16));
			boton_AnadirLeng.setBounds(110, 310, 130, 31);
			pnlGeneral.add(boton_AnadirLeng);
			
			scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(380, 200, 200, 160);
			pnlGeneral.add(scrollPane);
			
			lista_lenguajes = new JList<String>();
			lista_lenguajes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(lista_lenguajes.getSelectedIndex() != -1) {
						btn_eliminarLeng.setEnabled(true);
					}
					else {
						btn_eliminarLeng.setEnabled(false);
					}
				}
			});
			scrollPane.setViewportView(lista_lenguajes);
			
			Label_LenguajeSelec = new JLabel("Idiomas requeridos:");
			Label_LenguajeSelec.setFont(new Font("Tahoma", Font.PLAIN, 16));
			Label_LenguajeSelec.setBounds(385, 165, 150, 23);
			pnlGeneral.add(Label_LenguajeSelec);
			
			btn_eliminarLeng = new JButton("Quitar");
			btn_eliminarLeng.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LenguajesModel.removeElement(lista_lenguajes.getSelectedValue());
					lista_lenguajes.setModel(LenguajesModel);	
					combo_lenguajes.setSelectedIndex(0);
					btn_eliminarLeng.setEnabled(false);
					updateFin();
				}
			});
			btn_eliminarLeng.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btn_eliminarLeng.setEnabled(false);
			btn_eliminarLeng.setBounds(417, 370, 130, 31);
			pnlGeneral.add(btn_eliminarLeng);
			
			label_tipo = new JLabel("Tipo de empleado:");
			label_tipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label_tipo.setBounds(20, 395, 150, 23);
			pnlGeneral.add(label_tipo);
			
			combo_tipo = new JComboBox();
			combo_tipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					skillUpdate();
					updateFin();
				}
			});
			combo_tipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Universitario", "T\u00E9cnico", "Obrero"}));
			combo_tipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			combo_tipo.setBounds(165, 394, 130, 29);
			pnlGeneral.add(combo_tipo);
			
			label_cantidad = new JLabel("Cantidad de empleados a solicitar: ");
			label_cantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label_cantidad.setBounds(20, 440, 250, 23);
			pnlGeneral.add(label_cantidad);
			
			check_Viajedis = new JCheckBox(" Disponibilidad para viajar requerida");
			check_Viajedis.setBackground(Color.WHITE);
			check_Viajedis.setFont(new Font("Tahoma", Font.PLAIN, 16));
			check_Viajedis.setBounds(20, 165, 290, 31);
			pnlGeneral.add(check_Viajedis);
			
			spn_cantidad = new JSpinner();
			spn_cantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spn_cantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
			spn_cantidad.setBounds(285, 439, 70, 30);
			pnlGeneral.add(spn_cantidad);
			
			Label_habilidades = new JLabel("Area de especialidad requerida:");
			Label_habilidades.setFont(new Font("Tahoma", Font.PLAIN, 16));
			Label_habilidades.setBounds(20, 605, 225, 23);
			pnlGeneral.add(Label_habilidades);
			
			combo_habilidad = new JComboBox();
			combo_habilidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateFin();
				}
			});
			combo_habilidad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
			combo_habilidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
			combo_habilidad.setBounds(265, 604, 290, 29);
			pnlGeneral.add(combo_habilidad);
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
						if(CentroDeTrabajo.getInstance().buscarcompaniaporid(text_id.getText()) != null) {
							List<String> langs = new ArrayList<String>();
							for(int i = 0; i<LenguajesModel.getSize(); i++) {
								langs.add(LenguajesModel.getElementAt(i));
							}
							
							if(req == null) {
								String id = ""+SolicitudCompania.cod++;	
								SolicitudCompania request = new SolicitudCompania(id, CentroDeTrabajo.getInstance().buscarcompaniaporid(text_id.getText()), combo_tipo.getSelectedItem().toString(), 
										combo_habilidad.getSelectedItem().toString(), (int) spn_cantidad.getValue(), (float) spn_salarioMax.getValue(), langs, check_Viajedis.isSelected(),
										checkbox_disMudarse.isSelected(), check_licencia.isSelected(), (int) spn_horasdetrabajo.getValue());
								CentroDeTrabajo.getInstance().agregarcompaniasolic(request);
							}
							else {
								req.setCompania(CentroDeTrabajo.getInstance().buscarcompaniaporid(text_id.getText()));
								req.setEstado(true);
								req.setSalario_minimo((float) spn_salarioMax.getValue());
								req.setLenguajes(langs);
								req.setHoras_de_trabajo((int) spn_horasdetrabajo.getValue());
								req.setDisviajes(check_Viajedis.isSelected());
								req.setDismudarse(checkbox_disMudarse.isSelected());
								req.setLicencia(check_licencia.isSelected());
								req.setCantidad((int) spn_cantidad.getValue());
								req.setTipo_de_empleado(combo_tipo.getSelectedItem().toString());
								req.setHabilidades_requeridas(combo_habilidad.getSelectedItem().toString());
							}
							
							JOptionPane.showMessageDialog(null, "El registro fue completado con éxito.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
							dispose();
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
		if(!text_id.getText().isEmpty() && !LenguajesModel.isEmpty() && combo_tipo.getSelectedIndex()>0 && combo_habilidad.getSelectedIndex()>0) {
			boton_registrar.setEnabled(true);
		}else {
			boton_registrar.setEnabled(false);
		}
	}
	
	private void skillUpdate() {
		
		if(combo_tipo.getSelectedIndex() == 1) {
			combo_habilidad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Direcci\u00F3n Empresarial", "Administraci\u00F3n Hotelera", "Arquitectura", "Comunicaci\u00F3n Social", "Derecho", "Dise\u00F1o e Interiorismo", "\u200B\u200B\u200BEcolog\u00EDa y Gesti\u00F3n Ambiental", "Econom\u00EDa", "Educaci\u00F3n", "Estomatolog\u00EDa", "Filosof\u00EDa", "Gesti\u00F3n Financiera y Auditor\u00EDa", "Ingenier\u00EDa Civil", "Ingenier\u00EDa Mec\u00E1nica", "Ingenier\u00EDa El\u00E9ctrica", "Ingenier\u00EDa Industrial y de Sistemas", "Ingenier\u00EDa en Mecatr\u00F3nica", "Ingenier\u00EDa de Sistemas y Computaci\u00F3n", "Ingenier\u00EDa Telem\u00E1tica", "Medicina", "Marketing", "Nutrici\u00F3n y Diet\u00E9tica\u200B", "Psicolog\u00EDa", "Terapia F\u00EDsica"}));
		}
		else if(combo_tipo.getSelectedIndex() == 2) {
			combo_habilidad.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>","Informática","Electricidad","Contabilidad","Diseño Gráfico","Enfermería","Mercadeo","Administración","Publicidad"}));
		}
		else if(combo_tipo.getSelectedIndex() == 3){
			combo_habilidad.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>","Plomería","Ebanistería","Mecánica","Construcción","Pintura","Soldadura","Jardinería"}));
		}
		else {
			combo_habilidad.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
		}
		
		
	}
}
