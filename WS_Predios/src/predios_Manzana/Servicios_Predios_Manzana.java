package predios_Manzana;

public class Servicios_Predios_Manzana {
	
	public String [] cuentaPredial (int edo_cve, int regcat_cve, int mun_cve, int zoncat_cve, int lim_cve, int sectorcat_cve, int man_cve){
		DatosPredios datosPredios = new DatosPredios();
		return datosPredios.cuentaPredial(edo_cve, regcat_cve, mun_cve, zoncat_cve, lim_cve, sectorcat_cve, man_cve);		
	}
	
	public String geoManzana (int edo_cve, int regcat_cve, int mun_cve, int zoncat_cve, int lim_cve, int sectorcat_cve, int man_cve){
		DatosPredios datosPredios = new DatosPredios();
		return datosPredios.manzanaFuncion(edo_cve, regcat_cve, mun_cve, zoncat_cve, lim_cve, sectorcat_cve, man_cve);
	}
	
	public String jsonDatosPredios (int edo_cve, int regcat_cve, int mun_cve, int zoncat_cve, int lim_cve, int sectorcat_cve, int man_cve){
		DatosPredios datosPredios = new DatosPredios();		
		return datosPredios.json(edo_cve, regcat_cve, mun_cve, zoncat_cve, lim_cve, sectorcat_cve, man_cve);
	}
	
	public String jsonDatosNuevo (int edo_cve, int regcat_cve, int mun_cve, int zoncat_cve, int lim_cve, int sectorcat_cve, int man_cve){
		DatosPredios datosPredios = new DatosPredios();		
		return datosPredios.jsonNuevo(edo_cve, regcat_cve, mun_cve, zoncat_cve, lim_cve, sectorcat_cve, man_cve);
	}

}
