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
	
	
	private CentroDeTrabajo() {
		super();
		this.micompania = new ArrayList<Compania>();
		this.mipersona = new ArrayList<Persona>();
		this.misolicitud_e = new ArrayList<SolicitudEmpleado>();
		this.misolicitud_c = new ArrayList<SolicitudCompania>();
	}
	
	public static CentroDeTrabajo getInstance() {
		if(centrodetrabajo == null) {
			centrodetrabajo = new CentroDeTrabajo();
		}
		return centrodetrabajo;
	}

	public static void setInstance(CentroDeTrabajo centrodetrabajo) {
		CentroDeTrabajo.centrodetrabajo = centrodetrabajo;
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
	
	public void modifcompania (Compania aux, 	Compania modif)
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
	
	public void modifPersona(Persona mod, Persona aux)
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
	
	public void modificarPersona(Persona mod, Persona aux) {
		int index = mipersona.indexOf(mod);
		mipersona.add(index, aux);
		mipersona.remove(mod);
	}
	
	public SolicitudEmpleado buscarEmpleadoreqPorPersona(Persona person1) {
		SolicitudEmpleado ok=null;
		for(SolicitudEmpleado er: misolicitud_e) {
			if(er.getAplicante().getId().equalsIgnoreCase(person1.getId())) {
				ok=er;
				break;
			}
		}
		return ok;
	}
	
	public int getSolicitudDeEmpleadoLog() {
		int cant=0;
		SolicitudEmpleado aux=null;
		for(SolicitudEmpleado er: misolicitud_e) {
			if(er.isestado()==false)
				cant++;
				
		}
		return cant;
	}
	
	public List<SolicitudEmpleado> getSolicitudesdeEstudiantes(){
		List<SolicitudEmpleado> SolicitudEstudiante = new ArrayList<>();
		for(SolicitudEmpleado e : misolicitud_e) {
			if(e.getAplicante() instanceof Estudiante & e.isestado())
				SolicitudEstudiante.add(e);
		} 
		return SolicitudEstudiante;
	}
	
	public int getCantSolicitudesDeEstudiantePorCompania(){
		int cant=0;
		for(SolicitudCompania e : misolicitud_c) {
			if(e.getTipo_de_empleado().equalsIgnoreCase("Universitario") )
				cant++;
		} 
		return cant;
	}
	
	public int  getCantSolicitudesDeTrabajadoresPorCompania(){
		int cant =0;
		for(SolicitudCompania e : misolicitud_c) {
			if(e.getTipo_de_empleado().equalsIgnoreCase("Obrero") )
				cant++;
		} 
		return cant;
	}
	
	public int  getCantSolicitudesDeTecnicosPorCompania(){
		int cant = 0;
		for(SolicitudCompania e : misolicitud_c) {
			if(e.getTipo_de_empleado().equalsIgnoreCase("Técnico") )
				cant++;
		} 
		return cant;
	}
	
	public List<SolicitudEmpleado> getSolicitudesDeTecnicos(){
		List<SolicitudEmpleado> SolicitudesTecnicos = new ArrayList<>();
		for(SolicitudEmpleado e : misolicitud_e) {
			if(e.getAplicante() instanceof Tecnico && e.isestado())
				SolicitudesTecnicos.add(e);
		} 
		return SolicitudesTecnicos;
	}
	
	public List<SolicitudEmpleado> getSolicitudesDeTrabajadores(){
		List<SolicitudEmpleado> SolicitudTrabajador=new ArrayList<>();
		for(SolicitudEmpleado e : misolicitud_e) {
			if(e.getAplicante() instanceof Trabajador && e.isestado())
				SolicitudTrabajador.add(e);
		} 
		return SolicitudTrabajador;
	}
	
	public List<SolicitudEmpleado> Emparejamiento(SolicitudCompania ReqCompania){
		List<SolicitudEmpleado> misEmpleados=new ArrayList<>();
		List<SolicitudEmpleado> EmpleadosAplicantes=new ArrayList<>();
		if(ReqCompania.getTipo_de_empleado().equalsIgnoreCase("Universitario")) 
			misEmpleados=this.getSolicitudesdeEstudiantes();
		else if(ReqCompania.getTipo_de_empleado().equalsIgnoreCase("T\u00E9cnico"))
			misEmpleados=this.getSolicitudesDeTecnicos();
		else
			misEmpleados=this.getSolicitudesDeTrabajadores();
		
		for(SolicitudEmpleado e: misEmpleados) {
			if(getEmparejamientoPorcent(e,ReqCompania)>60) {
				EmpleadosAplicantes.add(e);
			}
		}
		
		return EmpleadosAplicantes;
		
	}
	
	public float getEmparejamientoPorcent(SolicitudEmpleado ReqEmpleado, SolicitudCompania ReqCompania) {
		float porcentaje=0;
		float constante=ReqCompania.getLenguajes().size()/12;
		if(ReqEmpleado.HabilidadesEx(ReqCompania.getHabilidades_requeridas())==true)
			porcentaje+=19;
		else
			return 0;
		if((ReqEmpleado.isDispmudarse()==true && ReqCompania.isDismudarse()==true) || ReqCompania.isDismudarse()==false)
			porcentaje+=14;
		if(ReqEmpleado.getAplicante().getProvincia().equalsIgnoreCase(ReqCompania.getCompania().getProvincia()) 
				|| (ReqEmpleado.isDispmudarse() &&ReqEmpleado.getAplicante().getProvincia().equalsIgnoreCase(ReqCompania.getCompania().getProvincia())==false))
			porcentaje+=13;
		if((ReqEmpleado.isLicencia() && ReqCompania.isLicencia()) || ReqCompania.isLicencia()==false)
			porcentaje+=12;
		if((ReqEmpleado.isDispviajar() && ReqCompania.isDisviajes())|| ReqCompania.isDisviajes()==false)
			porcentaje+=8;
		if(ReqEmpleado.getSalariominimo()<=ReqCompania.getSalario_minimo())
			porcentaje+=14;
		if(ReqEmpleado.getHrsdetrabajo()>=ReqCompania.getHoras_de_trabajo())
			porcentaje+=8;
		porcentaje+=constante*CantidadDeLenguajesEq(ReqCompania.getLenguajes(),ReqEmpleado.getLenguajes());
		return porcentaje;
	}
	
	public float CantidadDeLenguajesEq(List<String> LengCompania, List<String> LengPersona) {
		float cant=0;
		for(String comp: LengCompania) {
			for(String per: LengPersona) {
				if (per.equalsIgnoreCase(comp))
					cant++;
			}
		}
		return cant;
	}
	
	
	public void EliminarTodasLasSolicitudesActP(Persona personaEliminada) {
		Boolean ok=true;
		int ind=0;
		SolicitudEmpleado aux = null;
		while(ok==true) {
			for(SolicitudEmpleado er: CentroDeTrabajo.getInstance().getMisolicitud_e()) {
				if(er.getAplicante().getId().equalsIgnoreCase(personaEliminada.getId()) && er.isestado()==true) {
					aux=er;
					ind++;
					break;
				}
			}
			if(ind==0)
				ok=false;
			else {
				CentroDeTrabajo.getInstance().getMisolicitud_e().remove(aux);
				ind=0;
			}
		}
	}
	
	public void EliminarTodasLasSolicitudesActC(Compania companiaEliminada) {
		Boolean ok=true;
		int ind=0;
		SolicitudCompania aux = null;
		while(ok==true) {
			for(SolicitudCompania er: CentroDeTrabajo.getInstance().getMisolicitud_c()) {
				if(er.getCompania().getRnc().equalsIgnoreCase(companiaEliminada.getRnc()) && er.isEstado()==true) {
					aux=er;
					ind++;
					break;
				}
			}
			if(ind==0)
				ok=false;
			else {
				CentroDeTrabajo.getInstance().getMisolicitud_c().remove(aux);
				ind=0;
			}
		}
	}
	
	public List<SolicitudCompania> getSolicitudesCompaniaPorId(Compania comp) {
		List<SolicitudCompania> TSC = new ArrayList<>();
		for(SolicitudCompania SoliC : misolicitud_c) {
			if(SoliC.getCompania().getRnc().equalsIgnoreCase(comp.getRnc()) && SoliC.isEstado()==true) {
				TSC.add(SoliC);
			}
		}
		return TSC;
	}
	public List<SolicitudEmpleado> getSolicitudesEmpleadosPorId(Persona Persona) {
		List<SolicitudEmpleado> TSE=new ArrayList<>();
		for(SolicitudEmpleado SoliE : misolicitud_e) {
			if(SoliE.getAplicante().getId().equalsIgnoreCase(Persona.getId()) && SoliE.isestado()==true) {
				TSE.add(SoliE);
			}
		}
		return TSE;
	}

	public int CantDeCompaniaporArea(String area) {
		int cant=0;
		for(Compania comp: micompania) {
			if(comp.getLocalidad().equalsIgnoreCase(area))
				cant++;
		}
		return cant;
	}
	
	
	
	
}
