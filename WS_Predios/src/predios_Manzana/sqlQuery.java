package predios_Manzana;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import json.JSONArray;
import json.JSONObject;

public class sqlQuery {
	Connection conexion;
    Statement sentencia;
    ResultSet resultado;
    Vector vectorCuentaPredial = null;
    JSONObject jsonFinal = new JSONObject();
    
    
    
    public sqlQuery (Connection con){
        conexion = con;
    }

    public String [] geoCuentaPredial(String cad_sql){    	
    	String [] consulta = null;
    	try{
    		sentencia=conexion.createStatement();
    		resultado = sentencia.executeQuery(cad_sql); 
    		vectorCuentaPredial = new Vector();
    		if(resultado.next()){
    			while (resultado.next()){
        			vectorCuentaPredial.addElement(resultado.getString("precuentapredial"));
        		}
    		}else{
    			vectorCuentaPredial.add("0");
    		}
    		
    	}catch (SQLException E){
    	}
    	consulta = new String [vectorCuentaPredial.size()];
    	for (int i=0; i<vectorCuentaPredial.size(); i++){    		
    		consulta [i] = vectorCuentaPredial.elementAt(i).toString();
    	}
    	return consulta;
    }
    
    public String geoManzanaArr(String cad_sql){
    	String consulta = null ;
    	try{
    		sentencia=conexion.createStatement();
    		resultado = sentencia.executeQuery(cad_sql);
    		
    		while (resultado.next()){
    			consulta = resultado.getString("man_geom");
    		}
    	}catch (SQLException E){
    	}
    	return consulta;
    }
    
    public String geoDatosPredios(String cad_sql){
    	try{
    		sentencia=conexion.createStatement();
    		resultado = sentencia.executeQuery(cad_sql);
    		//JSONArray que contendra todos los parametros
    		JSONArray jsonArray = new JSONArray();
    		int iConta = 0; 
    		while (resultado.next()){
    			String centroide = resultado.getString("centroide");
    			String geometria = resultado.getString("pre_geom");
    			
    			GeoPredios geoPredios = new GeoPredios(centroide, geometria);   
    			
    			try {
    				//JSONObject para llenarlo con los parametros
    				JSONObject jsonObject = new JSONObject();
    				jsonObject.put("geo", geoPredios.getGeometria());
    				jsonObject.put("centroide", geoPredios.getCentroide());
    				//Llenamos el JSONArray
    				jsonArray.put(jsonObject);
    			} catch (Exception e) {
    				// TODO: handle exception
    			}
    		}
    		//Este json contiene el array completo
    		jsonFinal.put("geoDatos", jsonArray);
	
    	}catch (SQLException E){
    	}          
    	return jsonFinal.toString();
    }
    
    public String geoJson(String cad_sql){
    	try{
    		sentencia=conexion.createStatement();
    		resultado = sentencia.executeQuery(cad_sql);
    		//JSONArray que contendra todos los parametros
    		JSONArray jsonArray = new JSONArray();
    		int iConta = 0; 
    		while (resultado.next()){
    			String centroide = resultado.getString("centroide");
    			String geometria = resultado.getString("pre_geom");
    			
    			GeoPredios geoPredios = new GeoPredios(centroide, geometria);   
    			
    			try {
    				//JSONObject para llenarlo con los parametros
    				JSONObject jsonObject = new JSONObject();
    				jsonObject.put("geo "+iConta, geoPredios.getGeometria());
    				jsonObject.put("centroide "+iConta, geoPredios.getCentroide());
    				//Llenamos el JSONArray
    				jsonArray.put(jsonObject);
    				iConta++;
    			} catch (Exception e) {
    				// TODO: handle exception
    			}
    		}
    		//Este json contiene el array completo
    		jsonFinal.put("geoDatos", jsonArray);
	
    	}catch (SQLException E){
    	}          
    	return jsonFinal.toString();
    }
}
