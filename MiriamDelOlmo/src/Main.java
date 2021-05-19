import java.util.*;
public class Main {
public static void main(String[]args) {
	
		Scanner sc = new Scanner (System.in);

		
		Tiempo[] semana = new Tiempo[7];
		
		//INTROCUCIR DATOS
		for (int i = 0; i<semana.length; i++) {
			
			int dia=i+5;
			
			
			String resultado="";
			int num= 1+(int) (Math.random()*4);
				switch (num) {
				case 1: resultado="Nubes";
					break;
				case 2: resultado="Sol";
					break;
				case 3: resultado="Niebla";
					break;
				case 4: resultado="Lluvia";
					break;
				}
				
			int prob;
				if (resultado.equals("Lluvia")) {
					prob=50+(int) (Math.random()*51);
				}else {
					prob=0+(int) (Math.random()*51);
				}
				
			int tempMax;
			int tempMin=(int) (Math.random()*36); 
				do {
					tempMax=(int) (Math.random()*36);
				}while(tempMin>tempMax);
				
			int velocidadViento = 0+(int) (Math.random()*26);
			
			semana[i]= new Tiempo ("Manzanares", dia, 03, 2021, resultado, prob, tempMin, tempMax, velocidadViento);
		}
		
		
		//MENÚ
		System.out.println("####BIENVENIDO A AEMET####");
				int opcMenu=0;
				do {
					System.out.println();
					System.out.println("¿Qué desea hacer?");
					System.out.println("1. Salir");
					System.out.println("2. Mostrar el tiempo de la próxima semana");
					System.out.println("3. Mostrar el día de la semana con mayor probabilidad de lluvia");
					System.out.println("4. Mostrar los días con un tiempo determinado");
					System.out.println("5. Obtener temperatura media");
					System.out.println("6. Media temperatura mínima y máxima");
					System.out.println("7. Cantidad de días por tiempo");
					System.out.println("8. Días peligrosos para los conductores");
						opcMenu=sc.nextInt();
					switch (opcMenu) {
					case 1:
							System.exit(0);
						break;

					case 2:
						for (int i = 0; i<semana.length; i++) {
							System.out.println(semana[i].toString());
						}
						break;
						
					case 3:
							filtrarProbLluvia(semana);
						break;
					case 4: 
							filtrarTiempo(semana);
						break;
					
					case 5:
							mediaTemp(semana);
						break;
					
					case 6:
							tempMediaMinMax(semana);
						break;
					
					case 7:
							cantDias(semana);
						break;
					
					case 8:
							peligrosos(semana);
						break;
					}
				}while (opcMenu!=1);

}


public static void filtrarProbLluvia (Tiempo[] semana) {
	int max=0, posicion=0;
	for (int i = 0; i<semana.length; i++) {
		if(semana[i].getProbLluvia()>max) {
			max=semana[i].getProbLluvia();
			posicion=i;
		}
	}
	System.out.println("El día con más probabilidad de lluvia será el "+semana[posicion].getDia()+"-"+semana[posicion].getMes()+"-"+semana[posicion].getAño()+" con una probabilidad de lluvia del "+semana[posicion].getProbLluvia()+"%");
}

public static void filtrarTiempo(Tiempo[] semana) {
	int opcTiempo=0;
	Scanner sc = new Scanner (System.in);
	
	System.out.println("¿Qué tiempo eliges?");
	System.out.println("1. Nubes");
	System.out.println("2. Sol");
	System.out.println("3. Niebla");
	System.out.println("4. LLuvia");
		opcTiempo=sc.nextInt();
		String resultado="";
		switch (opcTiempo) {
			case 1: resultado="Nubes";
				break;
			case 2: resultado="Sol";
				break;
			case 3: resultado="Niebla";
				break;
			case 4: resultado="Lluvia";
				break;
}
		System.out.println("Los días con "+resultado+" serán:");
		for (int i = 0; i<semana.length; i++) {
			if(semana[i].getTiempo().equals(resultado)) {
				System.out.println(semana[i].getCiudad()+" "+semana[i].getDia()+"-"+semana[i].getMes()+"-"+semana[i].getAño());
			}
		}	
}

public static void mediaTemp(Tiempo[] semana) {
	for (int i = 0; i<semana.length; i++) {
		int media=(semana[i].getTempMin()+semana[i].getTempMax())/2;
			System.out.println(semana[i].getCiudad()+" "+semana[i].getDia()+"-"+semana[i].getMes()+"-"+semana[i].getAño()+". La temperatura media es: "+ media+"ºC.");
	}
}

public static void tempMediaMinMax(Tiempo[] semana) {
	int sumaMax=0, sumaMin=0;
	for (int i = 0; i<semana.length; i++) {
		sumaMax+=semana[i].getTempMax();
		sumaMin+=semana[i].getTempMin();
	}
	System.out.println("La temperatura máxima media es: "+ (sumaMax/7)+"ºC.");
	System.out.println("La temperatura mínima media es: "+ (sumaMin/7)+"ºC.");
}

public static void cantDias(Tiempo[] semana) {
	String resultado="";

	for (int i = 0; i <4; i++) {
		int num=0;
		switch (i) {
		case 0:
				resultado="Sol";
			break;
		case 1:
				resultado="Niebla";
			break;
		case 2:
				resultado="Nubes";
			break;
		case 3:
				resultado="Lluvia";
			break;
		}		
		for (int j = 0; j < semana.length; j++) {
			if(semana[j].getTiempo().equalsIgnoreCase(resultado)) {
				num++;
			}
		}
		System.out.print("Días con "+resultado+" ("+num+"): ");
		for (int j = 0; j < semana.length; j++) {
			if(semana[j].getTiempo().equalsIgnoreCase(resultado)) {
				System.out.print(semana[i].getCiudad()+" "+semana[i].getDia()+"-"+semana[i].getMes()+"-"+semana[i].getAño()+" // ");
			}
		}
		System.out.println();
	}
}

public static void peligrosos(Tiempo[] semana) {
	System.out.println("Los días que son peligrosos son:");
	for (int i = 0; i < semana.length; i++) {
		if(semana[i].getTempMin()<=5) {
			System.out.println(semana[i].getCiudad()+" "+semana[i].getDia()+"-"+semana[i].getMes()+"-"+semana[i].getAño()+": Temperaturas inferiores a 5ºC.");
		}
		if(semana[i].getVelocidad()>=20) {
			System.out.println(semana[i].getCiudad()+" "+semana[i].getDia()+"-"+semana[i].getMes()+"-"+semana[i].getAño()+": Velocidad del viento superior a 20km/h.");

		}
	}
}

}

