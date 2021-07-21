package logico;

import java.util.List;

public class SolicitudCompania {

	private String id;
	private Compania compania;
	private String tipo_de_empleado;
	private String habilidades_requeridas;
	private int cantidad;
	private float salario_minimo;
	private boolean estado;
	private List<String> lenguajes;
	private boolean disviajes;
	private boolean dismudarse;
	private boolean licencia;
	private int horas_de_trabajo;
	public static int cod = 0;
	
	
	private SolicitudCompania(String id, Compania compania, String tipo_de_empleado, String habilidades_requeridas,
			int cantidad, float salario_minimo, boolean estado, List<String> lenguajes, boolean disviajes,
			boolean dismudarse, boolean licencia, int horas_de_trabajo) {
		super();
		this.id = id;
		this.compania = compania;
		this.tipo_de_empleado = tipo_de_empleado;
		this.habilidades_requeridas = habilidades_requeridas;
		this.cantidad = cantidad;
		this.salario_minimo = salario_minimo;
		this.estado = estado;
		this.lenguajes = lenguajes;
		this.disviajes = disviajes;
		this.dismudarse = dismudarse;
		this.licencia = licencia;
		this.horas_de_trabajo = horas_de_trabajo;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Compania getCompania() {
		return compania;
	}


	public void setCompania(Compania compania) {
		this.compania = compania;
	}


	public String getTipo_de_empleado() {
		return tipo_de_empleado;
	}


	public void setTipo_de_empleado(String tipo_de_empleado) {
		this.tipo_de_empleado = tipo_de_empleado;
	}


	public String getHabilidades_requeridas() {
		return habilidades_requeridas;
	}


	public void setHabilidades_requeridas(String habilidades_requeridas) {
		this.habilidades_requeridas = habilidades_requeridas;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public float getSalario_minimo() {
		return salario_minimo;
	}


	public void setSalario_minimo(float salario_minimo) {
		this.salario_minimo = salario_minimo;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public List<String> getLenguajes() {
		return lenguajes;
	}


	public void setLenguajes(List<String> lenguajes) {
		this.lenguajes = lenguajes;
	}


	public boolean isDisviajes() {
		return disviajes;
	}


	public void setDisviajes(boolean disviajes) {
		this.disviajes = disviajes;
	}


	public boolean isDismudarse() {
		return dismudarse;
	}


	public void setDismudarse(boolean dismudarse) {
		this.dismudarse = dismudarse;
	}


	public boolean isLicencia() {
		return licencia;
	}


	public void setLicencia(boolean licencia) {
		this.licencia = licencia;
	}


	public int getHoras_de_trabajo() {
		return horas_de_trabajo;
	}


	public void setHoras_de_trabajo(int horas_de_trabajo) {
		this.horas_de_trabajo = horas_de_trabajo;
	}
	
	
	
	
	
	
}