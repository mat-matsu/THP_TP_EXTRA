package Eclipse.Pasion;

public class Test {

	public static void main(String[] args) {
		Eclipse ide = new Eclipse();
		System.out.println("Agregar proyecto");
		ide.agregarProyecto("proyecto1");
		ide.agregarProyecto("proyecto2");
		ide.agregarProyecto("proyecto3");
		ide.agregarProyecto("proyecto1");
		ide.agregarProyecto("proyecto5");
		ide.agregarProyecto("proyecto6");
		ide.agregarProyecto("proyecto7");
		System.out.println("Agregar Metodo");
		ide.agregarMetodo("proyecto1", "main", 2);
		ide.agregarMetodo("proyecto1", "noMain", 4);
		ide.agregarMetodo("proyecto2", "noMain", 2);
		ide.agregarMetodo("proyecto2", "noMain", 6);
		ide.agregarMetodo("proyecto2", "algo", 5);
		ide.agregarMetodo("proyecto2", "otraCosa", 1);
		ide.agregarMetodo("proyecto3", "main", 4);
		ide.agregarMetodo("proyecto3", "noMain", 1);
		ide.agregarMetodo("proyecto3", "algo", 1);
		ide.agregarMetodo("proyecto3", "otraCosa", 15);
		ide.agregarMetodo("proyecto4", "main", 15);
		ide.agregarMetodo("proyecto5", "main", 2);
		ide.agregarMetodo("proyecto5", "noMain", 4);
		ide.agregarMetodo("proyecto6", "noMain", 2);
		ide.agregarMetodo("proyecto6", "noMain", 6);
		ide.agregarMetodo("proyecto6", "algo", 5);
		ide.agregarMetodo("proyecto6", "otraCosa", 1);
		System.out.println("Compilar");
		ide.compilarProyecto("proyecto1");
		ide.compilarProyecto("proyecto2");
		ide.compilarProyecto("proyecto3");
		ide.compilarProyecto("proyecto4");
		ide.compilarProyecto("proyecto5");
		ide.compilarProyecto("proyecto6");
		ide.compilarProyecto("proyecto7");
		System.out.println("Mostrar Ejecutables");
		ide.mostrarEjecutables();
		System.out.println("Mostrar Log");
		ide.mostrarLog();
		System.out.println("Ejecutar");
		ide.ejecutarProyecto("proyecto1");
		ide.ejecutarProyecto("proyecto2");
		ide.ejecutarProyecto("proyecto3");
		ide.ejecutarProyecto("proyecto1");
		System.out.println("Mostrar Ejecutables");
		ide.mostrarEjecutables();
		System.out.println("Mostrar en Ejecucion");
		ide.mostrarEnEjecucion();
		System.out.println("Mostrar Log");
		ide.mostrarLog();
		System.out.println("Mostrar version");
		ide.mostrarPorVersion(1);
		System.out.println("Borrar Proyectos");
		System.out.println(ide.borrarProyecto("proyecto1"));
		System.out.println(ide.borrarProyecto("proyecto3"));
		System.out.println(ide.borrarProyecto("proyecto6"));
		System.out.println("Mostrar Ejecutables");
		ide.mostrarEjecutables();
		System.out.println("Mostrar Log");
		ide.mostrarLog();
		System.out.println("Mostrar version");
		ide.mostrarPorVersion(1);
		System.out.println("Max Metodos");
		System.out.println(ide.obtenerMaxMetodos());
		System.out.println("Min Capacidad");
		System.out.println(ide.obtenerMinCapacidad());
		System.out.println("Detener Proyecto");
		System.out.println(ide.detenerProyecto("proyecto2"));
		System.out.println(ide.detenerProyecto("proyecto1"));
		System.out.println("Mostrar Ejecutables");
		ide.mostrarEjecutables();
	}

}
