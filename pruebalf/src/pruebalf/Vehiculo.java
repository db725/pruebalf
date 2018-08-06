package pruebalf;

public class Vehiculo {
	
	// Lo que movemos a control remoto
	// Atributos = Posicion x y y
	
	private int posx;
	private int posy;
	
	
	
	public int getPosx() {
		return posx;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}
	
	
	
	//Métodos, mover, a partir del comando recibido y dentro de los límites del tablero
	
		
	public void mover(String comando, Tablero t)
	{
		
		
		// separadores por ; y , de acuerdo a formato
		comando = comando.trim()+";";				
		int sep1 = 0;
		int sep2 = 0;	
		int punto = 0;
		Boolean error = false;
		
		while (sep1>-1)
		{
			// Se identifica cantidad y direccion del movimiento
			
			sep1 = comando.indexOf(";",punto);
			sep2 = comando.indexOf(",",punto);				
			
			int cantidad = Integer.parseInt(comando.substring(punto,sep2));
		
			String direccion = comando.substring(sep2+1,sep1).toUpperCase();	
		
			// Se valida el movimiento
			
			switch (direccion)
			{			  
			 case "N": 					 
				 posy = posy + cantidad;
				 if (posy>=t.getAlto())
				 {
					 posy = posy-cantidad;
					 error=true;
				 }
				 
				 break;		
			 case "S":
				 posy = posy - cantidad;
				 if (posy<0)
				 {
					 posy = posy+cantidad;
					 error=true;
				 }
				 break;			 
			 case "O":
				 posx = posx - cantidad;	
				 if (posx<0)
				 {
					 posx = posx+cantidad;
					 error=true;
				 }
				  
				 break;	
			 case "E":
				 posx = posx + cantidad;
				 if (posx>=t.getAncho())
				 {
					 posx = posx+cantidad;
					 error=true;
				 }
				 break;	
				
			}				
				
			
			// Si hay error por limites no se hace nada, en caso contrario reporta el comando y avanza hasta completar todos los comandos de la serie
			
			if (error)
			{
				System.out.println("Se ha detenido el avance por salir de los limites");
				sep1 = -1;
			}
			else
			{
						
				System.out.println("Comando ejecutado: "+comando.substring(punto,sep1).toUpperCase());
				System.out.println("Posicion nueva: ("+posx+","+posy+")");					
				punto = sep1+1;
				sep1 = comando.indexOf(";",punto);
				
			}
			
		}
	
		
		
		
		
		
	}
	
}
