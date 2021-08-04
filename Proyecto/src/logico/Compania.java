package logico;
import java.io.Serializable;


public class Compania implements Serializable{
    
    
    
    private static final long serialVersionUID = 5580731429904371715L;
    private String rnc;
    private String nombre;
    private String localidad;
    private String direccion;
    private String provincia;
    private String ciudad;
    private String telefono;
    private String correo;
    
    
    public Compania(String nombre, String localidad, String direccion, String provincia, String ciudad, String telefono,
            String correo, String rnc) {
        super();
        this.nombre = nombre;
        this.localidad = localidad;
        this.direccion = direccion;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.correo = correo;
        this.rnc = rnc;
    }


    public String getRnc() {
        return rnc;
    }


    public void setRnc(String rnc) {
        this.rnc = rnc;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getLocalidad() {
        return localidad;
    }


    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
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


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    

}