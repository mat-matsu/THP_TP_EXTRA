package Eclipse.Pasion;

import java.util.ArrayList;

public class Proyecto {
	String nombre;
	ArrayList<Metodo> metodos;
	int version;
	boolean compilado;
	boolean ejecutando;
	final String MAIN = "main";
	
	public Proyecto(String nombre) {
		this.nombre = nombre;
		this.metodos = new ArrayList<Metodo>();
		this.version = 0;
		this.compilado = false;
		this.ejecutando = false;
	}
	
	public boolean getEjecutando() {
		return this.ejecutando;
	}
	
	public void detenerProyecto() {
		this.ejecutando = false;
	}
	
	public boolean existeProyecto(String nombre) {
		return this.nombre.equalsIgnoreCase(nombre);
	}
	
	public void mostrarEnEjecucion() {
		if(this.ejecutando) {
			System.out.println(this.nombre);
		}
	}
	
	public int cantMetodos() {
		return this.metodos.size();
	}
	
	public void mostrarEjecutables(int ram) {
		if(this.compilado && ram >= this.consumoRam() && !this.ejecutando) {
			System.out.println(this.nombre);
		}
	}
	
	public boolean mostrarPorVersion(int version) {
		if(this.version == version) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Proyecto [nombre=" + nombre + ", metodos=" + metodos + ", version=" + version + ", compilado="
				+ compilado + ", ejecutando=" + ejecutando + "]";
	}

	public boolean agregarMetodo(String nombre, int cantInstrucciones) {
		boolean agrega = false;
		if(buscarMetodo(nombre) == null) {
			agrega = metodos.add(new Metodo(nombre, cantInstrucciones));
			this.ejecutando = false; // Si tengo que volver a compilar, debo detener la ejecución?
			this.compilado = false;
		}
		return agrega;
	}
	
	public Mensajes compilarProyecto() {
		Mensajes mensaje = Mensajes.ERROR_NO_COMPILA;
		if(cantMetodos() > 0) {
			this.version++;
			this.compilado = true;
			mensaje = null;
		}
		return mensaje;
	}
	
	public Mensajes ejecutarProyecto(int disponibleRam) {
		Mensajes mensaje = null;
		
		if(!this.ejecutando) {
			if(!this.compilado) {
				mensaje = compilarProyecto();
			}
			if(mensaje == null) {
				if (buscarMetodo(MAIN) == null) {
					mensaje = Mensajes.ERROR_NO_HAY_MAIN;
				} else {
					if(consumoRam() > disponibleRam) {
						mensaje = Mensajes.ERROR_NO_HAY_RAM;
					} else {
						this.ejecutando = true;
					}
				}
			}
		} else {
			mensaje = Mensajes.ERROR_EN_EJECUCION;
		}
		return mensaje;
	}
	
	public int consumoRam() {
		int consumo = 0;
		for(Metodo met : this.metodos) {
			consumo += met.consumoRam();
		}
		return consumo;
	}
	
	public LogHistorico agregarLog(Mensajes mensaje) {
		return new LogHistorico(this.nombre, this.version, this.ejecutando, mensaje);
	}
	
	private Metodo buscarMetodo(String nombre) {
		Metodo metodoBuscado = null;
		boolean existe = false;
		int i = 0;
		
		while(i < this.metodos.size() && !existe) {
			metodoBuscado = this.metodos.get(i); 
			if(metodoBuscado.getNombre().equalsIgnoreCase(nombre)) {
				existe = true;
			} else {
				metodoBuscado = null;
				i++;
			}
		}
		return metodoBuscado;
	}
	
}