package logico;

import java.util.Date;
import java.io.Serializable;

public abstract class Persona implements Serializable{
	
	
	private static final long serialVersionUID = 2059286461337519208L;
	protected String id;
	protected String nombre;
	protected String apellido;
	protected Date fecha;
	protected String direccion;
	protected String correo;
	protected String provincia;
	protected String ciudad;
	protected String genero;
	protected String estadocivil;
	protected String telefono;
	protected boolean estadotrabajo;
	

	
	public Persona(String id, String nombre, String apellido, Date fecha, String direccion, String correo,
			String provincia, String ciudad, String genero, String estadocivil, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha = fecha;
		this.direccion = direccion;
		this.correo = correo;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.genero = genero;
		this.estadocivil = estadocivil;
		this.telefono = telefono;
		this.estadotrabajo = false;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEstadocivil() {
		return estadocivil;
	}
	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean getEstadotrabajo() {
		return estadotrabajo;
	}
	public void setEstadotrabajo(boolean estadotrabajo) {
		this.estadotrabajo = estadotrabajo;
	}
	
	

}
