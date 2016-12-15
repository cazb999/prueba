import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class Leer
{
	public ArrayList<String[]> importarDatos(String nombreArchivo){ //Método
		ArrayList<String> datos = new ArrayList<String>(); //Atributo para datos 
		ArrayList<String[]> datosEx = new ArrayList<String[]>(); //Atributo de arreglo de datos
		String cadena; // Atributo para leer los datos

		try
		{
			FileReader f = new FileReader(nombreArchivo); // Lee el archivo
			BufferedReader b = new BufferedReader(f); // Almacena datos de lectura

			while((cadena = b.readLine())!= null) // Ciclo si la cadena de datos es =! a null 
			{
				datos.add(cadena); // Si es =! a null agrega la cadena
			}
			for (int i = 0; i < datos.size(); i++)  // Incremento de datos
			{
				datosEx.add(datos.get(i).split(";")); // Se define el signo con que los datos van separados
			} 
			b.close(); // Se cierra el buffer que está leyendo el archivo
		}
		catch(Exception e){ // Excepcion
		}
		return datosEx; // Se retorna el arreglo de datos
	}
}