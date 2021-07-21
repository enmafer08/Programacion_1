package logico;

import java.util.List;

public class SolicitudEmpleado {

	private String id;
	private Persona aplicante;
	private boolean estadocivil;
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

	public person getAplicante() {
		return aplicante;
	}

	public void setAplicante(person aplicante) {
		this.aplicante = aplicante;
	}

	public boolean isEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(boolean estadocivil) {
		this.estadocivil = estadocivil;
	}

	public float getSalariominimo() {
		return salariominimo;
	}

	public void setSalariominimo(float salariominimo) {
		this.salariominimo = salariominimo;
	}

	public list<string> getLenguajes() {
		return lenguajes;
	}

	public void setLenguajes(list<string> lenguajes) {
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

	private SolicitudEmpleado(String id, Persona aplicante, boolean estadocivil, float salariominimo,
			List<String> lenguajes, int hrsdetrabajo, boolean dispviajar, boolean dispmudarse, boolean licencia) {
		super();
		this.id = id;
		this.aplicante = aplicante;
		this.estadocivil = estadocivil;
		this.salariominimo = salariominimo;
		this.lenguajes = lenguajes;
		this.hrsdetrabajo = hrsdetrabajo;
		this.dispviajar = dispviajar;
		this.dispmudarse = dispmudarse;
		this.licencia = licencia;
	}

}
