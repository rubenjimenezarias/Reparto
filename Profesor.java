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
    /**
    * Repartir de clase
    */
    public void repartirClase()
        // OTRA SOLUCION
    {
        int cantidadEvaluadores = evaluadores.size();
        int cantidadPropuestas = propuestas.size();
        int minimoPropuestas = 3;
        
        int contador = 0;
        while (contador < (minimoPropuestas * cantidadEvaluadores)) {
            
            if (contador < cantidadPropuestas) {
                // Si estamos considerando una propuesta aun
                // sin asignar se la asignamos al evaluador que toque           
                Evaluador persona = evaluadores.get(contador%cantidadEvaluadores);
                String propuesta = propuestas.get(contador);
                persona.asignarPropuesta(propuesta);
            }
            else {
                // Ya no hay propuestas sin asignar, por lo que
                // elegimos una al azar y se la damos al evaluador que toque
                Random aleatorio = new Random();
                int indicePropuestaAleatoria = aleatorio.nextInt(cantidadPropuestas);
                String propuesta = propuestas.get(indicePropuestaAleatoria);
                Evaluador persona = evaluadores.get(contador%cantidadEvaluadores);
                persona.asignarPropuesta(propuesta);        
            }               
            contador++;
        }
            // Si aun quedan propuestas sin asignar entonces las recorremos
            // todas y las asignamos a los evaluadores segun vaya tocando
        while (contador < cantidadPropuestas) {
            String propuesta = propuestas.get(contador);
            Evaluador persona = evaluadores.get(contador%cantidadEvaluadores);
            persona.asignarPropuesta(propuesta);
            contador++;
        }
    }
    /**
     * Emparejar de dos en dos.
     */
    public void emparejar()
    {
        int cantidadPropuestas = propuestas.size();
        int contador = 0;
        String propuestaAnterior = "";
        Collections.shuffle(propuestas);
        //SI ES PAR ENTRA EN EL PRIMER IF
        if (cantidadPropuestas%2 == 0)
        {
            for (String propuesta: propuestas)
            {
                //SI LA PROPUESTA ES PAR ABRIMOS UNA ELIMINATORIA Y AÑADIMOS UNA PROPUESTA
                if (contador%2 == 0)
                {
                    System.out.println("Eliminatoria ");
                    propuestaAnterior = propuesta;
                }
                //SI LA PROPUESTA ES IMPAR CERRAMOS LA ELIMINATORIA ABIERTA ANTERIOR SUMANDO UNA PROPUESTA RIVAL
                else
                {
                     System.out.println(propuestaAnterior + " VS " +  propuesta);
                }
                contador++;
            }
        }
        //SI NO ES PAR SALTA UN MENSAJE
        else
        {
            System.out.println("Las propuestas son impares.");
        }
    }
    /**
     * Emparejar con copia de arraylist.
     */
    public void emparejarConCopia()
    {
        ArrayList<String> copia = new ArrayList<>(); 
        copia = (ArrayList)propuestas.clone();
        
        int cantidadPropuestas = propuestas.size();
        int contador = 0;
        String propuestaAnterior = "";
        
        if (cantidadPropuestas%2 == 0)
        {
            while (contador < cantidadPropuestas)
            {
                //Eligo el numero aleatorio 
                Random aleatorio = new Random();
                int numeroAleatorio = aleatorio.nextInt(copia.size());
                //Cojo una propuesta al azar
                String propuesta = copia.get(numeroAleatorio);
                //Informa de la cancion que suena actualmente
                if(contador%2 == 0)
                {
                    System.out.println("Eliminatoria ");
                    propuestaAnterior = propuesta;
                }
                else
                {
                    System.out.println(propuestaAnterior + " VS " +  propuesta);
                }
                //Elimina la cancion de la lista
                copia.remove(numeroAleatorio);
                // sumamos la cuenta de canciones reproducidas
                contador++;
            }
        }
        else
        {
            System.out.println("Las propuestas son impares.");
        }
        
    }
    
    /**
     * Muestra el reparto por pantalla
     */
    public void mostrarReparto()
    {
        for (Evaluador evaluador : evaluadores)
        {
            evaluador.mostrarPropuestas();
        }
    }
    
}

