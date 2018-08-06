package pruebalf;

public class main {

	public static void main(String[] args) {
		
		//Variables
		String ancho = "";
		String alto = "";
		int n = 0;
		int m = 0;
		int x = 0;
		int y = 0;
		String comando = "";
		
		
		
		System.out.println("Vehiculo a control remoto (exit para salir)");
		
	// Paso 1, solicitar dimensiones de tablero, se valida que sea numerico
		
		System.out.print("Ingresar ancho:");
		ancho = System.console().readLine();		
		ancho = validardato(ancho,"ancho","([0-9])+");
			
				
		System.out.print("Ingresar alto:");
		alto = System.console().readLine();
		alto = validardato(alto,"alto","([0-9])+");
		
		
	// Paso 2, establecer posicion inicial
		
		n = Integer.parseInt(ancho);
		m = Integer.parseInt(alto);
		Tablero tab = new Tablero();
		Vehiculo veh = new Vehiculo();
		tab.setAncho(n);
		tab.setAlto(m);	
		veh.setPosx(x);
		veh.setPosy(y);
		tab.dibujar(veh);	
		
	// Paso 3, insertar comandos, ejecuta la serie y dibuja el tablero con la posicion del vehiculo	
				
		System.out.println("posicion actual: ("+x+","+y+")");
		
		while (!comando.equals("exit"))
		{										
			System.out.print("Ingresar comando:");
			comando = System.console().readLine();
			comando = validardato(comando,"comando","([0-9])+,([SNEOsneo])(;([0-9])+,([SNEOsneo]))*");			
			veh.mover(comando,tab);			
			tab.dibujar(veh);
			
		}	
			
		

			
	}						
		
	
	
// Metodo para validar datos (no supe como hacer lo del exit un poco mas decente)
// Recibe el dato, el titulo para personalizar el mensaje, y la expresion regular contra la cual comparar	
	
	public static String validardato(String dato,String titulo,String regex)
	{
		while (!dato.matches(regex))
		{ 
			if (dato.equalsIgnoreCase("exit"))
			{
				System.exit(0);		
			}
			else
			{
				System.out.println("Error en formato de "+titulo);	
				System.out.print("Ingresar "+titulo+":");
				dato = System.console().readLine();
			}
		}	
		return dato;
	}
	
	
	

}
