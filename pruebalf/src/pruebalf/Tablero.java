package pruebalf;

public class Tablero {
	// Escenario por donde se mueve el auto
	// Atributos, dimensiones de ancho y alto
	
	private int ancho;
	private int alto;
	
	
	
	public Tablero ()
	{
		
	}
	
	
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	
	//Metodo, dibujar el tablero en consola con caracteres como _ y | para formar los cuadros. recibe el vehiculo para poder marcar la posicion actual con x
	
	public void dibujar(Vehiculo v)
	{
		
				
		char [][] tabla = new char [alto+1][(2*ancho)+1];
		
		
		
		for (int i=0;i<2*ancho+1;i++ )
		{
			if (i%2==0)
			{
				tabla [0][i] = ' ';						
			}
			else
			{
				tabla [0][i] = '_';	
			}
		}
		

		
		
		for (int j=1;j<alto+1;j++ )
		{
			tabla [j][0] = '|';						
			
			for (int k=1;k<2*ancho+1;k++ )
			{
				
				if (k%2==0)
				{
					tabla [j][k] = '|';				
				}
				else
				{
					tabla [j][k] = '_';
				}		
				
			}	
		}
		
		tabla [alto-v.getPosy()][2*v.getPosx()+1]= 'x';
		
		for (int i=0;i<alto+1;i++ )
		{
			for (int j=0;j<2*ancho+1;j++ )
			{
				System.out.print(tabla[i][j]);
							
			}	
			System.out.println();
		}
		
		System.out.println();
				
		
		
	}


	
	
	
	
	
}
