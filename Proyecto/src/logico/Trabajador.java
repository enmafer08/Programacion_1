package logico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

public class Trabajador extends Persona implements Serializable{

	
	private static final long serialVersionUID = 4934211553153055338L;
	private List<String> habilidades;
	private int experiencia;
	
	
	public Trabajador(String id, String nombre, String apellido, String fecha, String direccion, String correo,
			String provincia, String ciudad, String genero, String estadocivil, String telefono, String estadotrabajo,
			List<String> habilidades, int experiencia) {
		super(id, nombre, apellido, fecha, direccion, correo, provincia, ciudad, genero, estadocivil, telefono,
				estadotrabajo);
		this.habilidades = habilidades;
		this.experiencia = experiencia;
	}
	
	public List<String> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<String> habilidades) {
		this.habilidades = habilidades;
	}
	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	
	
}
