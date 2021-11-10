package Eclipse.Pasion;

public class Metodo {
	String nombre;
	int cantInstrucciones;
	
	public Metodo(String nombre, int cantInstrucciones) {
		this.nombre = nombre;
		this.cantInstrucciones = cantInstrucciones;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int consumoRam() {
		return this.cantInstrucciones * 4;
	}

	@Override
	public String toString() {
		return "Metodo [nombre=" + nombre + ", cantInstrucciones=" + cantInstrucciones + "]";
	}
	
}
