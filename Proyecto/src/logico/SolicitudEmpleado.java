package logico;

import java.util.List;
import java.io.Serializable;

public class SolicitudEmpleado implements Serializable {

	private static final long serialVersionUID = 9172098800438365223L;
	private String id;
	private Persona aplicante;
	private boolean estado;
	private float salariominimo;
	private List<String> lenguajes;
	private int hrsdetrabajo;
	private boolean dispviajar;
	private boolean dispmudarse;
	private boolean licencia;
	public static int cod = 0;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Persona getAplicante() {
		return aplicante;
	}

	public void setAplicante(Persona aplicante) {
		this.aplicante = aplicante;
	}

	public boolean isestado() {
		return estado;
	}

	public void setestado(boolean estado) {
		this.estado = estado;
	}

	public float getSalariominimo() {
		return salariominimo;
	}

	public void setSalariominimo(float salariominimo) {
		this.salariominimo = salariominimo;
	}

	public List<String> getLenguajes() {
		return lenguajes;
	}

	public void setLenguajes(List<String> lenguajes) {
		this.lenguajes = lenguajes;
	}

	public int getHrsdetrabajo() {
		return hrsdetrabajo;
	}

	public void setHrsdetrabajo(int hrsdetrabajo) {
		this.hrsdetrabajo = hrsdetrabajo;
	}

	public boolean isDispviajar() {
		return dispviajar;
	}

	public void setDispviajar(boolean dispviajar) {
		this.dispviajar = dispviajar;
	}

	public boolean isDispmudarse() {
		return dispmudarse;
	}

	public void setDispmudarse(boolean dispmudarse) {
		this.dispmudarse = dispmudarse;
	}

	public boolean isLicencia() {
		return licencia;
	}

	public void setLicencia(boolean licencia) {
		this.licencia = licencia;
	}

	public static int getCod() {
		return cod;
	}

	public static void setCod(int cod) {
		SolicitudEmpleado.cod = cod;
	}

	private SolicitudEmpleado(String id, Persona aplicante, boolean estado, float salariominimo,
			List<String> lenguajes, int hrsdetrabajo, boolean dispviajar, boolean dispmudarse, boolean licencia) {
		super();
		this.id = id;
		this.aplicante = aplicante;
		this.estado = estado;
		this.salariominimo = salariominimo;
		this.lenguajes = lenguajes;
		this.hrsdetrabajo = hrsdetrabajo;
		this.dispviajar = dispviajar;
		this.dispmudarse = dispmudarse;
		this.licencia = licencia;
	}

}
