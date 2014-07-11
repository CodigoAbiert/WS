package predios_Manzana;

public class GeoPredios {

	public String centroide;
	public String geometria;
	
	public GeoPredios(String centroide, String geometria){
		this.centroide = centroide;
		this.geometria = geometria;
	}
	
	public String getCentroide() {
		return centroide;
	}
	public void setCentroide(String centroide) {
		this.centroide = centroide;
	}
	public String getGeometria() {
		return geometria;
	}
	public void setGeometria(String geometria) {
		this.geometria = geometria;
	}
}
