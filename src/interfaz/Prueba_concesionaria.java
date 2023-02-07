package interfaz;

import java.util.Scanner;

import dominio.Coche;
import dominio.Concesionaria;

public class Prueba_concesionaria {
	//  PUEDE QUE ESTE PARCIAL ESTE MEDIO FLOJO POR QUE EL ENUNCIADO NO ES MUY CLARO, HICE LO QUE ENTENDI.

	public static void main(String[] args) {
       Scanner teclado=new Scanner(System.in);
       Concesionaria actual=new Concesionaria(10);
       int opcion;
       
       do {   
       System.out.println("ingrese la opcion a realizar:"
       		+ "\n1 - Ingresar coche a la concesionaria"
       		+ "\n2 - Obtener el cero Kilometro de menor precio"
       		+ "\n3 - Contar la cantidad de coches de determinado modelo"
       		+ "\n4 - Contar la cantidad de marcas distintas"
       		+ "\n5 - Buscar vehiculo por marca y modelo"
       		+ "\n6 - Buscar vehiculo por precio"
       		+ "\n7 - Obtener vehiculo con mayor cantidad de kilometros recorridos"
       		+ "\n9 - SALIR");
       opcion=teclado.nextInt();
       
       switch(opcion) {
       case 1: ingresarCoche(teclado,actual);
    	   
    	   break;
       case 2: ceroKmMenorPrecio(actual);
    	   
    	   break;
       case 3: cantidadCochesDeterminadoModelo(teclado,actual);
    	   
    	   break;
       case 4: marcasDistiantas(actual);
    	   
    	   break;
       case 5: buscarCocheMarcaModelo(teclado,actual);
       
    	   break;
       case 6: buscarCochePrecio(teclado,actual);
    	   
    	   break;
       case 7: buscarVehiculoMayorKm(actual);
    	   
    	   break;
       case 9: System.out.println("adios!");
    	   
    	   break;
       default: System.out.println("opcion incorrecta");
    	   
    	   break;
    }
       
       }while(opcion!=9);
       
       
	}
	
	private static void buscarVehiculoMayorKm(Concesionaria actual) {
		Coche coche=actual.cocheMayorKm();
		if(coche!=null) {
			System.out.println(coche.toString());
		 }else {
			System.out.println("aun no hay vehiculos registrados");
		}
	}
	
	private static void buscarCochePrecio(Scanner teclado,Concesionaria actual) {
		System.out.println("ingrese el precio del vehiculo");
		double precio=teclado.nextDouble();
		
		Coche coche=actual.buscarVehiculo(precio);
		if(coche!=null) {
			System.out.println(coche.toString());
		}else {
			System.out.println("no se encontro el vehiculo");
		}
	}
	
	
	
	private static void buscarCocheMarcaModelo(Scanner teclado,Concesionaria actual) {
		System.out.println("ingrese la marca del vehiculo");
		String marca=teclado.next();
		System.out.println("ingrese el modelo");
		String modelo=teclado.next();
		
		Coche coche=actual.buscarVehiculo(marca, modelo);
		if(coche!=null) {
			System.out.println(coche.toString());
		}else {
			System.out.println("no se encontro el vehiculo");
		}
	}
	
	private static void marcasDistiantas(Concesionaria actual) {
		int cant=actual.calcularCantidadDeMarcasDistintas();
		System.out.println("hay un total de " + cant + " marcas distintas");
	}	
	
	private static void cantidadCochesDeterminadoModelo(Scanner teclado,Concesionaria actual) {
		System.out.println("ingrese el modelo");
		String modelo=teclado.next();
		int cant=actual.contarCocheDeDeterminadoModelo(modelo);
		
		System.out.println("la cantidad de coches del modelo " + modelo + " es: " + cant);
		
		
	}
	
	private static void ceroKmMenorPrecio(Concesionaria actual) {
		Coche coche=actual.encontrarCeroKilometroDeMenorPrecio();
		
		if(coche!=null) {
		System.out.println("el cero km de menor precio:" + coche.toString());
		} else {
			System.out.println("no se encontraron vehiculos");
		}
		
	}
	
	
	private static void ingresarCoche(Scanner teclado,Concesionaria actual) {
		String op;
		Coche coche=null;
		do {
		System.out.println("es un 0km? si/no");
		op=teclado.next();
        
		switch(op) {
          case "si": coche=cerokm(teclado);
          break;
          
          case "no": coche=vehiculo(teclado);
          break;
          
          default:         	  
	      break;
}

	}while(op=="si" || op=="no");
		
	actual.ingresarCoche(coche);
	System.out.println("se registro el auto");
		
	}
	
	private static Coche cerokm(Scanner teclado) {
		System.out.println("ingrese la marca");
		String marca=teclado.next();
		System.out.println("ingrese el modelo");
		String modelo=teclado.next();
		System.out.println("ingrese el precio");
		double precio=teclado.nextDouble();
		
		Coche coche=new Coche(marca,modelo,precio);
		return coche;
		
	}
	
	private static Coche vehiculo(Scanner teclado) {
		System.out.println("ingrese la marca");
		String marca=teclado.next();
		System.out.println("ingrese el modelo");
		String modelo=teclado.next();
		System.out.println("ingrese la contidad de kilometros recorridos");
		int km=teclado.nextInt();
		System.out.println("ingrese el anio");
		int anio=teclado.nextInt();
		System.out.println("ingrese el precio");
		double precio=teclado.nextDouble();
		
		Coche coche=new Coche(marca,modelo,km,anio,precio);
		return coche;
		
	}
	

}
