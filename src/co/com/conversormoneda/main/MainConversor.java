package co.com.conversormoneda.main;

import javax.swing.JOptionPane;

import co.com.conversormoneda.Conversor;
import co.com.conversormoneda.ListaConversores;
import co.com.conversormoneda.Unidad;


public class MainConversor {
	
	public static void main(String[] args) {

		// Creacion de un conversor de monedas a Pesos Colombianos
		Unidad[] monedasPesosUnidadesConversion = { new Unidad("Dolares", 4128.15), new Unidad("Euros", 4317.80),
				new Unidad("Libra Esterlina", 5029.95), new Unidad("Dolar Canadiense", 3156.92), new Unidad("Franco Suizo", 4268.01) };
		Conversor conversorMonedasPesos = new Conversor(" La moneda local es: Pesos Colombianos", monedasPesosUnidadesConversion,
				"Pesos Colombianos");
		
		// Creacion de conversor de medidas(unidad base Metro)
		Unidad[] medidasUnidadesConversion = { new Unidad("Milla", 1609.34), new Unidad("Yarda", 0.9144),
				new Unidad("Kilómetro", 1000), new Unidad("Pie", 0.3048), new Unidad("Pulgada", 0.0254) };
		Conversor conversorMedidas = new Conversor("Medida", medidasUnidadesConversion, "Metro");

		// Lista de todos los convertidores
		Conversor[] conversores = { conversorMonedasPesos, conversorMedidas };
		ListaConversores listaDeConversores = new ListaConversores(conversores);
		
		//Aqui se define si el programa termina
		boolean finDeEjecucion = false;
		
		//comienzo del programa
		do {

			boolean menuPrincipal = false;
			
			String conversorElegido = "";

			try {
				conversorElegido = JOptionPane.showInputDialog(null, "Que conversor deseas utilizar?",
						"Tipo de Conversiones", JOptionPane.QUESTION_MESSAGE, null, 
						listaDeConversores.getListaConversores(), "opcion 1").toString();
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Se cerro el programa");
				break;

			}
			
			//Conversor escogido
			Conversor conversor = listaDeConversores.getConversor(conversorElegido);
			
			
			//Variable para almacenar el tipo de conversion
			String stringConversion="";
			
			//Eleccion de que conversion se va a realizar
			if(!menuPrincipal) try {

				stringConversion = JOptionPane.showInputDialog(null, "Que moneda deseas realizar?",
						conversor.getNombre(), JOptionPane.QUESTION_MESSAGE, null, 
						conversor.getListaConversiones(), "opcion 1").toString();
				
			}catch (NullPointerException e) {
				menuPrincipal = true;
			}
			
			//Variable para almacenar el valor ingresado
			String valorIngresado= "";
			
			//Variable para castear el valor ingresado
			float valorIngresadoFloat=0;
			
			//Ingreso del valor a convertir
			if(!menuPrincipal) try {
				
				//variable para almacenar la exception que arroja el casteo a float
				String error="";
				
				//Ingreso del valor con validacion simple.
				//La validacion se hace a traves del casteo del string a float
				//usando la exception NumberFormatException como par�metro
				//para saber si el input es o no un numero valido
				do {
					try {
						valorIngresado = JOptionPane.showInputDialog("Ingresa valor a convertir a " + stringConversion + ":");
						valorIngresadoFloat = Float.parseFloat(valorIngresado);
						error = "";
					}catch(NumberFormatException e) {
						error = e.toString();
						JOptionPane.showMessageDialog(null, " Lo siento, no puedes ingresar carácteres, sólo puedes ingresar números ");
					}
				}while(error != "");
				
				
			}catch(NullPointerException e) {
				menuPrincipal = true;
			}
			
			
			//Muestra del resultado
			if(!menuPrincipal) JOptionPane.showMessageDialog(null,"Resultado en " + conversor.getNombreMoneda(stringConversion) + " es: "
					+ conversor.convertir(stringConversion, valorIngresadoFloat),
					stringConversion, JOptionPane.INFORMATION_MESSAGE, null);
			
			//Pregunta si se desea realizar otra conversion:
	//opcion 0 = si => vuelve al menú, opcion 1 = no => cierra el programa, opcion 2 = cancelar => cierra el programa
			int opcion = 0;
			if (!menuPrincipal) opcion = JOptionPane.showConfirmDialog(null, "Deseas realizar otra conversión?");
			if(opcion == 1 || opcion == 2) {
				JOptionPane.showMessageDialog(null, "Se cerró el programa");
				break;
			}
		} while (!finDeEjecucion);

	}
}
