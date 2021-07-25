package logico;

import java.util.Date;
import java.io.Serializable;

public class Estudiante extends Persona implements Serializable{

	
	private static final long serialVersionUID = 7926896254158755178L;
	private String universidad;
	private String carrera;



	

	public Estudiante(String id, String nombre, String apellido, String fecha, String direccion, String correo,
			String provincia, String ciudad, String genero, String estadocivil, String telefono, String estadotrabajo,
			String universidad, String carrera) {
		
		super(id, nombre, apellido, fecha, direccion, correo, provincia, ciudad, genero, estadocivil, telefono,
				estadotrabajo);
		this.universidad = universidad;
		this.carrera = carrera;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrerar(String carrera) {
		this.carrera = carrera;
	}
	
	

}
