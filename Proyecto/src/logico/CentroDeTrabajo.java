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
	
	public List<Persona> getTrabajadores()
	{
		List<Persona> allTrabajadores = new ArrayList<>();
		for(Persona g :mipersona)
		{
			if(g instanceof Trabajador)
			{
				allTrabajadores.add((Trabajador) g);
			}
		}
		return allTrabajadores;
	}
	
	public void modifPerdona(Persona mod, Persona aux)
	{
		int indice = mipersona.indexOf(mod);
		mipersona.add(indice, aux);
		mipersona.remove(mod);
	}
	
	public int getsolicitudempleadocompletada()
	{
		int i=0;
		SolicitudEmpleado aux = null;
		for(SolicitudEmpleado se : misolicitud_e)
		{
			if(se.isestado() == false)
			{
				i++;
			}
		}
		return i;
	}
	
	public List<SolicitudEmpleado> getestudiante()
	{
		List<SolicitudEmpleado> solicitudestudiante = new ArrayList<>();
		for(SolicitudEmpleado h : misolicitud_e)
		{
			if(h.getAplicante() instanceof Estudiante & h.isestado())
			{
				solicitudestudiante.add(h);
			}
		}
		return solicitudestudiante;
	}
	
	public int getcantsolicestudianteporcompania()
	{
		int cant=0;
		for(SolicitudCompania i : misolicitud_c)
		{
			if (i.getTipo_de_empleado().equalsIgnoreCase("Universitario"))
			{
				cant++;
			}
		}
		return cant;
	}
	
}
