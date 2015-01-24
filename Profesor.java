import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
/**
 * Write a description of class Profesor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Profesor
{
    private ArrayList<Evaluador> evaluadores;
    private ArrayList<String> propuestas;

    public Profesor()
    {
        evaluadores = new ArrayList<>();
        propuestas = new ArrayList<>();
    }
         
    public void registrarEvaluador(String nombre)
    {
        Evaluador nuevoEvaluador = new Evaluador(nombre);   
        evaluadores.add(nuevoEvaluador);
    }

    public void registrarPropuesta(String nombre)
    {
        propuestas.add(nombre);
    }
    
    public void repartir()
    {
        int cantidadEvaluadores = evaluadores.size();
        int cantidadPropuestas = propuestas.size();
        int minimoPropuestas = 3;
        
        int contador = 0;
        
        Collections.shuffle(propuestas);
            //Ponemos 3 propuestas obligatorias a cada evaluador
        while (contador < (minimoPropuestas * cantidadEvaluadores)) {
            for(Evaluador persona : evaluadores)
            {
                String propuesta;
                if (contador < cantidadPropuestas)
                //Asignamos por orden
                {
                    propuesta = propuestas.get(contador);
                }
                else
                //Asignamos al azar
                {
                    Random aleatorio = new Random();
                    propuesta = propuestas.get(aleatorio.nextInt(propuestas.size()));
                }
                persona.asignarPropuesta(propuesta);
                contador++;
            }
             // Si aun quedan propuestas sin asignar entonces las recorremos
             // todas y las asignamos a los evaluadores segun vaya tocando
            while (contador < cantidadPropuestas)
            {
                for (Evaluador persona : evaluadores)
                {
                    if (contador < cantidadPropuestas)
                    {
                        String propuesta = propuestas.get(contador);
                        persona.asignarPropuesta(propuesta);
                    }
                    contador++;
                }
                
            }
        }
    }
    
    public void mostrarReparto()
    {
        for (Evaluador evaluador : evaluadores)
        {
            evaluador.mostrarPropuestas();
        }
    }
    
}

