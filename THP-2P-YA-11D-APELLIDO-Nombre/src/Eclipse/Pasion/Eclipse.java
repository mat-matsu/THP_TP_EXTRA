package Eclipse.Pasion;

import java.util.ArrayList;

public class Eclipse {
	ArrayList<Proyecto> proyectos;
	int consumidoRam;
	ArrayList<LogHistorico> logs;
	final int MAX_RAM = 50;
	
	
	public Eclipse() {
		this.consumidoRam = 0;
		this.proyectos = new ArrayList<Proyecto>();
		this.logs = new ArrayList<LogHistorico>();
	}
	
	public boolean agregarProyecto(String nombre) {
		boolean agrega = false;
		if(buscarProyecto(nombre) == null) {
			agrega = this.proyectos.add(new Proyecto(nombre));
		}
		return agrega;
	}
	
	public boolean agregarMetodo(String nombreProyecto, String metodo, int cantInstrucciones) {
		Proyecto proyecto = buscarProyecto(nombreProyecto);
		boolean agrego = false;
		if(proyecto != null) {
			agrego = proyecto.agregarMetodo(metodo, cantInstrucciones);
		}
		return agrego;
	}
	
	public boolean compilarProyecto(String nombre) {
		boolean compilo = false;
		Proyecto proyecto = buscarProyecto(nombre);
		if (proyecto != null) {
			Mensajes mensaje = proyecto.compilarProyecto();
			if(mensaje == null) {
				logs.add(proyecto.agregarLog(Mensajes.COMPILAR_OK));
				compilo = true;
			} else {
				logs.add(proyecto.agregarLog(mensaje));
			}
		} else {
			logs.add(new LogHistorico(nombre));
		}
		return compilo;
	}
	
	public boolean ejecutarProyecto(String nombre) {
		boolean ejecuto = false;
		Proyecto proyecto = buscarProyecto(nombre);
		if (proyecto != null) {
			Mensajes mensaje = proyecto.ejecutarProyecto(MAX_RAM - this.consumidoRam);
			if(mensaje == null) {
				this.consumidoRam += proyecto.consumoRam();
				logs.add(proyecto.agregarLog(Mensajes.EJECUTAR_OK));
				ejecuto = true;
			} else {
				logs.add(proyecto.agregarLog(mensaje));
			}
		} else {
			logs.add(new LogHistorico(nombre));
		}
		return ejecuto;
	}
	
	public boolean detenerProyecto(String nombre) {
		Proyecto proyecto = buscarProyecto(nombre);
		boolean detuvo = false;
		if(proyecto != null && proyecto.getEjecutando()) {
			this.consumidoRam -= proyecto.consumoRam();
			proyecto.detenerProyecto();
			detuvo = true;
		}
		return detuvo;
	}
	
	public boolean borrarProyecto(String nombre) {
		Proyecto proyecto = buscarProyecto(nombre);
		if(!proyecto.getEjecutando()) {
			this.proyectos.remove(proyecto);
			return true;
		}
		return false;
	}
	
	public void mostrarEnEjecucion() {
		for(Proyecto proyecto : this.proyectos) {
			proyecto.mostrarEnEjecucion();
		}
	}
	
	public ArrayList<Proyecto> obtenerMinCapacidad(){
		ArrayList<Proyecto> minProyecto = new ArrayList<Proyecto>();
		int min = Integer.MAX_VALUE;
		int consumoProyecto;
		
		for(Proyecto proyecto : this.proyectos) {
			consumoProyecto = proyecto.consumoRam();
			if (min > consumoProyecto) {
				min = consumoProyecto;
				minProyecto.clear();
				minProyecto.add(proyecto);
			} else if (min == consumoProyecto) {
				minProyecto.add(proyecto);
			}
		}
		return minProyecto;
	}
	
	public ArrayList<Proyecto> obtenerMaxMetodos(){
		ArrayList<Proyecto> maxProyecto = new ArrayList<Proyecto>();
		int max = Integer.MIN_VALUE;
		int cantMetodos;
		
		for(Proyecto proyecto : this.proyectos) {
			cantMetodos = proyecto.cantMetodos();
			if (max < cantMetodos) {
				max = cantMetodos;
				maxProyecto.clear();
				maxProyecto.add(proyecto);
			} else if (max == cantMetodos) {
				maxProyecto.add(proyecto);
			}
		}
		return maxProyecto;
	}
	
	public void mostrarEjecutables() {
		for(Proyecto proyecto : this.proyectos) {
			proyecto.mostrarEjecutables(MAX_RAM - this.consumidoRam);
		}
	}
	
	public void mostrarPorVersion(int version) {
		for(Proyecto proyecto : this.proyectos) {
			if(proyecto.mostrarPorVersion(version)) {
				System.out.println(proyecto);
			}
		}
	}
	
	public void mostrarLog() {
		System.out.println(logs);
	}
	
	private Proyecto buscarProyecto(String nombre) {
		Proyecto proyectoBuscado = null;
		int i = 0;
		
		while(i < this.proyectos.size() && proyectoBuscado == null) {
			proyectoBuscado = this.proyectos.get(i); 
			if(!proyectoBuscado.existeProyecto(nombre)) {
				proyectoBuscado = null;
				i++;
			} 
		}
		return proyectoBuscado;
	}
	
}
