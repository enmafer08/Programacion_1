package logico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

public class Trabajador extends Persona implements Serializable{

	
	private static final long serialVersionUID = 4934211553153055338L;
	private List<String> habilidades;
	private int experiencia;
	
	
	public Trabajador(String id, String nombre, String apellido, Date fecha, String direccion, String correo,
			String provincia, String ciudad, String genero, String estadocivil, String telefono,int experiencia,
			List<String> habilidades) {
		super(id, nombre, apellido, fecha, direccion, correo, provincia, ciudad, genero, estadocivil, telefono);
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

	public boolean hablidadesExist(String habilidad) {
		boolean Encontrado=false;
		for(int i=0;i<habilidades.size();i++) {
			if(habilidades.get(i).equalsIgnoreCase(habilidad)) {
				Encontrado=true;
				break;
			}
		}
		return Encontrado;
	}	
	
}
