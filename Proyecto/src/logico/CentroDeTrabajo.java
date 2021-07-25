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
	
	public void agregarcompania (Compania comp)
	{
		this.micompania.add(comp);
	}
	
	public void modifcompania (Compania aux, Compania modif)
	{
		int pos = micompania.indexOf(modif);
		micompania.add(pos, aux);
		micompania.remove(modif);
	}

	public void agregarpersona (Persona persona)
	{
		this.mipersona.add(persona);
	}
	
	public void agregarempleadosolic(SolicitudEmpleado s)
	{
		this.misolicitud_e.add(s);
	}
	
	public void agregarcompaniasolic(SolicitudCompania sc)
	{
		this.misolicitud_c.add(sc);
	}
	
	public Compania buscarcompaniaporid(String id)
	{
		for (Compania a : micompania)
		{
			if(a.getRnc().equalsIgnoreCase(id))
			{
				return a;
			}
		}
		return null;
	}
	
	public Persona buscarpersonaporid (String id)
	{
		for(Persona b : mipersona)
		{
			if (b.getId().equalsIgnoreCase(id))
			{
				return b;
		}
		}
		return null;
	}
	
	public SolicitudCompania buscarsolicitudcompID(String id)
	{
		for (SolicitudCompania c : misolicitud_c)
		{
			if(c.getId().equalsIgnoreCase(id))
			{
				return c;
			}
			}
		return null;
	}
	
	public SolicitudEmpleado buscarsolicitudempID(String id)
	{
		for(SolicitudEmpleado d : misolicitud_e)
		{
			if(d.getId().equalsIgnoreCase(id))
			{
				return d;
			}
			}
		return null;
	}
	
	public List<SolicitudCompania>getSolicitudCompania(Compania c)
	{
		List<SolicitudCompania>solicitud = new ArrayList<SolicitudCompania>();
		for(SolicitudCompania sc : misolicitud_c)
		{
			if(sc.getCompania() == c && sc.isEstado())
			{
				solicitud.add(sc);
			}
		}
		return solicitud;
	}
	
	public List<Persona> getEst()
	{
		List<Persona> allEst = new ArrayList<>();
		for (Persona e : mipersona)
		{
			if(e instanceof Estudiante)
			{
				allEst.add((Estudiante) e);
			}
		}
		return allEst;
	}
	
	public List<Persona> getTec()
	{
		List<Persona> allTec = new ArrayList<>();
		for (Persona f : mipersona)
		{
			if(f instanceof Tecnico)
			{
				allTec.add((Tecnico) f);
			}
		}
		return allTec;
	}
	
	
	
}
