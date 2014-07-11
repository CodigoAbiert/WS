package predios_Manzana;

public class DatosPredios {

	public String [] precuentaPredial;
	public String manzana;
	
	

	public String[] getPrecuentaPredial() {
		return precuentaPredial;
	}

	public void setPrecuentaPredial(String[] precuentaPredial) {
		this.precuentaPredial = precuentaPredial;
	}

	public String getManzana() {
		return manzana;
	}
	
	public void setManzana(String manzana) {
		this.manzana = manzana;
	}	

	public String [] cuentaPredial(int edo_cve, int regcat_cve, int mun_cve, int zoncat_cve, int lim_cve, int sectorcat_cve, int man_cve){
		Coneccion con = new Coneccion();
		sqlQuery query = new sqlQuery(con.getConnection());
		setPrecuentaPredial(query.geoCuentaPredial("SELECT precuentapredial "
				+ " FROM padron "
				+ " WHERE preedo = "+edo_cve+" "
				+ " AND preregcat = "+regcat_cve+" "
				+ " AND prempio = "+mun_cve+" "
				+ " AND prezoncat = "+zoncat_cve+" "
				+ " AND preloc = "+lim_cve+" "
				+ " AND presectcat = "+sectorcat_cve+" "
				+ " AND preman = "+man_cve+" "));
		con.closeConnection();
		return precuentaPredial;
	}
	
	public String manzanaFuncion(int edo_cve, int regcat_cve, int mun_cve, int zoncat_cve, int lim_cve, int sectorcat_cve, int man_cve){
		Coneccion con = new Coneccion();
		sqlQuery query = new sqlQuery(con.getConnection());
		setManzana(query.geoManzanaArr("SELECT ST_AsText (man_geom) as man_geom FROM gmanzana "
				+ " WHERE edo_cve = "+edo_cve+" and regcat_cve="+regcat_cve+" and mun_cve="+mun_cve+" "
				+ " and zoncat_cve="+zoncat_cve+" and lim_cve="+lim_cve+" and sectorcat_cve="+sectorcat_cve+" "
				+ " and man_cve ="+man_cve+" "));
		con.closeConnection();
		return manzana;
	}
	
	public String json (int edo_cve, int regcat_cve, int mun_cve, int zoncat_cve, int lim_cve, int sectorcat_cve, int man_cve){
		Coneccion con = new Coneccion();
		sqlQuery query = new sqlQuery(con.getConnection());
		String resultado = query.geoDatosPredios("SELECT ST_AsText (pre_geom) AS pre_geom,ST_AsText(st_Centroid(pre_geom)) AS centroide  FROM gpredio "
				+ " WHERE edo_cve="+edo_cve+" AND regcat_cve="+regcat_cve+" AND mun_cve="+mun_cve+" AND zoncat_cve="+zoncat_cve+" "
				+ " AND lim_cve="+lim_cve+" AND sectorcat_cve="+sectorcat_cve+" AND man_cve="+man_cve+" ");
		con.closeConnection();
		return resultado;
	}
	
	public String jsonNuevo (int edo_cve, int regcat_cve, int mun_cve, int zoncat_cve, int lim_cve, int sectorcat_cve, int man_cve){
		Coneccion con = new Coneccion();
		sqlQuery query = new sqlQuery(con.getConnection());
		String resultado = query.geoJson("SELECT ST_AsText (pre_geom) AS pre_geom,ST_AsText(st_Centroid(pre_geom)) AS centroide  FROM gpredio "
				+ " WHERE edo_cve="+edo_cve+" AND regcat_cve="+regcat_cve+" AND mun_cve="+mun_cve+" AND zoncat_cve="+zoncat_cve+" "
				+ " AND lim_cve="+lim_cve+" AND sectorcat_cve="+sectorcat_cve+" AND man_cve="+man_cve+" ");
		con.closeConnection();
		return resultado;
	}
}
