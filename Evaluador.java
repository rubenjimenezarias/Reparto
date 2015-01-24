import java.util.ArrayList;
/**
 * Write a description of class Evaluador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Evaluador
{
	private String nombre;
	private ArrayList<String> propuestasAsignadas;
	
	public Evaluador(String nombre)
	{
		this.nombre = nombre;
		propuestasAsignadas = new ArrayList<String>();

	}
	
	public void asignarPropuesta(String nombre)
	{
		propuestasAsignadas.add(nombre);
	}
	
	public void mostrarPropuestas()
	{
		System.out.println("Propuestas asignadas al evaluador " + nombre + ":"); 
		for( String propuesta: propuestasAsignadas)
		{
			System.out.println("- " + propuesta);
		}
	}
	
}
