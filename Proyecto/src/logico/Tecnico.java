package logico;


import java.util.Date;
import java.io.Serializable;


public class Tecnico extends Persona implements Serializable {

	
	private static final long serialVersionUID = -8025848557353984683L;
	private String area;
	private String institucion;
	private int anosdeexperiencia;
	
	
	public Tecnico(String id, String nombre, String apellido, String fecha, String direccion, String correo,
			String provincia, String ciudad, String genero, String estadocivil, String telefono, String estadotrabajo,
			String area, String institucion, int anosdeexperiencia) {
		
		super(id, nombre, apellido, fecha, direccion, correo, provincia, ciudad, genero, estadocivil, telefono,
				estadotrabajo);
		this.area = area;
		this.institucion = institucion;
		this.anosdeexperiencia = anosdeexperiencia;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getInstitucion() {
		return institucion;
	}
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
	public int getAnosdeexperiencia() {
		return anosdeexperiencia;
	}
	public void setAnosdeexperiencia(int anosdeexperiencia) {
		this.anosdeexperiencia = anosdeexperiencia;
	}
	
	
}
