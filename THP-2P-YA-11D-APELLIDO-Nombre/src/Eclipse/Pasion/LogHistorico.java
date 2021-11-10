package Eclipse.Pasion;

public class LogHistorico {
	String nombre;
	int version;
	boolean ejecuto;
	Mensajes mensaje;
	
	public LogHistorico(String nombre) {
		this.nombre = nombre;
		this.version = 0;
		this.ejecuto = false;
		this.mensaje = Mensajes.ERROR_INEXISTENTE;
	}
	
	public LogHistorico(String nombre, int version, boolean ejecuto, Mensajes mensaje) {
		this.nombre = nombre;
		this.version = version;
		this.ejecuto = ejecuto;
		this.mensaje = mensaje;
	}
	
	@Override
	public String toString() {
		return "LogHistorico [nombre=" + nombre + ", version=" + version + ", ejecuto=" + ejecuto + ", mensaje="
				+ mensaje + "]\n";
	}
	
	
}
