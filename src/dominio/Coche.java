package dominio;

public class Coche {
	private String id;
	private String marca;
	private String modelo;
	private int kilometros;
	private int año;
	private double precio;
	
	private static int cantidadCoches=0;
	
	private final int CERO_KM=0;
	private final int AÑO_ACTUAL=2018;
	
	public Coche(String marca, String modelo, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.kilometros = CERO_KM;
		this.año = AÑO_ACTUAL;
		this.id=calcularIdentificador();
		cantidadCoches++;
	
	}
	
	public Coche(String marca, String modelo, int kilometros, int año, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.kilometros = kilometros;
		this.año = año;
		this.id=calcularIdentificador();
		cantidadCoches++;
	
	}

	public String calcularIdentificador() {
		String id=this.modelo+(int)(Math.random()*1000);
		return id;
	}
	
	public int calcularKilometrosRecorridos() {
		return this.kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", kilometros=" + kilometros + ", año="
				+ año + ", precio=" + precio + "]";
	}

	

	

}
