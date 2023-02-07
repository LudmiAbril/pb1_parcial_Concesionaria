package dominio;

public class Concesionaria {
	private Coche [] flota;

	public Concesionaria (int cantidadDeCochesEnLaFlota) {
		this.flota=new Coche[cantidadDeCochesEnLaFlota];
		
	}
	
	public void ingresarCoche(Coche coche) {
		for(int i=0;i<flota.length;i++) {
			if(flota[i]==null) {
				flota[i]=coche;
				break;
			}
		} 
	}
	
	public Coche encontrarCeroKilometroDeMenorPrecio() {
		Coche [] km=new Coche[flota.length];
		int j=0;
		for(int i=0;i<flota.length;i++) {
			if(flota[i]!=null && flota[i].calcularKilometrosRecorridos()==0) {
				km[j]=flota[i];
				j++;
			}	
		} ordenarPrecio(km); 
		return km[0];
	}
		
	public void ordenarPrecio(Coche[] lista) {
	Coche aux;
	for(int i=1;i<lista.length;i++) {
		for(int j=0;j<lista.length-1;j++) {
			if(lista[j]!=null && lista[j+1]!=null && lista[j].getPrecio()>lista[j+1].getPrecio()) {
				aux=lista[j];
				lista[j]=lista[j+1];
				lista[j+1]=aux;
			}
		}
	}		
}
		
	public int contarCocheDeDeterminadoModelo(String modelo) {
		int cantidad=0;
		for(int i=0;i<flota.length;i++) {
			if(flota[i]!=null && flota[i].getModelo().equals(modelo)) {
				cantidad++;
			}
		} return cantidad;
	}	
	
	public int calcularCantidadDeMarcasDistintas() {
		int cantidad=0;
		String refe=null;
		
		for(int i=0;i<flota.length;i++) {
			if(flota[i]!=null) {
				refe=flota[i].getMarca();
				break;
			}
		}
		
		for(int j=0;j<flota.length;j++) {
			if(flota[j]!=null && refe!=null && flota[j].getMarca()!=refe) {
				cantidad++;
			}
		}
		
		return cantidad;
	}
	
	public Coche buscarVehiculo(String marca, String modelo) {
		for(int i=0;i<flota.length;i++) {
			if(flota[i]!=null && flota[i].getMarca().equals(marca) && flota[i].getModelo().equals(modelo)) {
				return flota[i];
			}
		} return null;
	}
	
	public Coche buscarVehiculo(double precio) {
		for(int i=0;i<flota.length;i++) {
			if(flota[i]!=null && flota[i].getPrecio()==precio) {
				return flota[i];
			}
		}
		
		
		return null;
		
	}
	
	 public void ordenarFlota() {
		 Coche aux;
		 for(int i=1;i<flota.length;i++) {
			 for(int j=0;j<flota.length-1;j++) {
				 if(flota[j]!=null && flota[j+1]!=null && flota[j].calcularKilometrosRecorridos()>flota[j+1].calcularKilometrosRecorridos()) {
				aux=flota[j];
				flota[j]=flota[j+1];
				flota[j+1]=aux;
				 }
			 }
		 }
	 }
	
	
	public Coche cocheMayorKm() {
		 Coche aux;
		 for(int i=1;i<flota.length;i++) {
			 for(int j=0;j<flota.length-1;j++) {
				 if(flota[j]!=null && flota[j+1]!=null && flota[j].calcularKilometrosRecorridos()<flota[j+1].calcularKilometrosRecorridos()) {
				aux=flota[j];
				flota[j]=flota[j+1];
				flota[j+1]=aux;
				 }
			 }
		 }
		return flota[0];
	}
	
	
}
