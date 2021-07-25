package logico;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class CentroDeTrabajo implements Serializable {

	
	private static final long serialVersionUID = -141755586509459357L;
	private List<Compania> micompania;
	private List<Persona> mipersona;
	private List<SolicitudEmpleado> misolicitud_e;
	private List<SolicitudCompania> misolicitud_c;
	private static CentroDeTrabajo centrodetrabajo = null;
	
	
	private CentroDeTrabajo(List<Compania> micompania, List<Persona> mipersona, List<SolicitudEmpleado> misolicitud_e,
			List<SolicitudCompania> misolicitud_c) {
		super();
		this.micompania = micompania;
		this.mipersona = mipersona;
		this.misolicitud_e = misolicitud_e;
		this.misolicitud_c = misolicitud_c;
	}


	public List<Compania> getMicompania() {
		return micompania;
	}


	public void setMicompania(List<Compania> micompania) {
		this.micompania = micompania;
	}


	public List<Persona> getMipersona() {
		return mipersona;
	}


	public void setMipersona(List<Persona> mipersona) {
		this.mipersona = mipersona;
	}


	public List<SolicitudEmpleado> getMisolicitud_e() {
		return misolicitud_e;
	}


	public void setMisolicitud_e(List<SolicitudEmpleado> misolicitud_e) {
		this.misolicitud_e = misolicitud_e;
	}


	public List<SolicitudCompania> getMisolicitud_c() {
		return misolicitud_c;
	}


	public void setMisolicitud_c(List<SolicitudCompania> misolicitud_c) {
		this.misolicitud_c = misolicitud_c;
	}


	public static CentroDeTrabajo getCentrodetrabajo() {
		return centrodetrabajo;
	}


	public static void setCentrodetrabajo(CentroDeTrabajo centrodetrabajo) {
		CentroDeTrabajo.centrodetrabajo = centrodetrabajo;
	}
	
	
	
}
