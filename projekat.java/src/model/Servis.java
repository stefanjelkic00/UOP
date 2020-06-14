package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import crud.ServisInterface;

public class Servis implements ServisInterface {
	
	public static final String AUTO_PATH = "C:\\Users\\hrle9\\eclipse-workspace\\ServisApplication\\src\\app\\automobili";
	public static final String SERVISERI_PATH = "C:\\Users\\hrle9\\eclipse-workspace\\ServisApplication\\src\\app\\serviseri";
	public static final String SERVISI_PATH = "C:\\Users\\hrle9\\eclipse-workspace\\ServisApplication\\src\\app\\servisi";
	
	private Integer id;
	private Automobil auto_za_servis;
	private Serviser serviser;
	private String termin;
	private String opis;
	private List<Deo> delovi;
	private String status_servisa;
	
	public Servis() {
		
	}

	public Servis(Integer id, Automobil auto_za_servis, Serviser serviser, String termin, String opis, List<Deo> delovi,
			String status_servisa) {
		super();
		this.id = id;
		this.auto_za_servis = auto_za_servis;
		this.serviser = serviser;
		this.termin = termin;
		this.opis = opis;
		this.delovi = delovi;
		this.status_servisa = status_servisa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Automobil getAuto_za_servis() {
		return auto_za_servis;
	}

	public void setAuto_za_servis(Automobil auto_za_servis) {
		this.auto_za_servis = auto_za_servis;
	}

	public Serviser getServiser() {
		return serviser;
	}

	public void setServiser(Serviser serviser) {
		this.serviser = serviser;
	}

	public String getTermin() {
		return termin;
	}

	public void setTermin(String termin) {
		this.termin = termin;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Deo> getDelovi() {
		return delovi;
	}

	public void setDelovi(List<Deo> delovi) {
		this.delovi = delovi;
	}

	public String getStatus_servisa() {
		return status_servisa;
	}

	public void setStatus_servisa(String status_servisa) {
		this.status_servisa = status_servisa;
	}

	@Override
	public String toString() {
		return "Servis [id=" + id + " " + auto_za_servis.getMarka() + " " + auto_za_servis.getModel() + ", serviser=" + serviser + ", termin="
				+ termin + ", opis=" + opis + ", delovi=" + delovi + ", status_servisa=" + status_servisa + "]";
	}

	@Override
	public void dodajServis(Integer idAutomobila, Integer idServisera, List<Deo> delovi, Servis servis) throws IOException {
		
		FileReader frAuto = new FileReader(AUTO_PATH);
		BufferedReader brAuto = new BufferedReader(frAuto);
		String markaAuta = null;
		String modelAuta = null;
		try {
		String fileLine = null;
		
		while ((fileLine =  brAuto.readLine()) != null) {
			String[] fields = fileLine.split(",");
			if (fields.length > 0) {
                if (fields[0].equals(idAutomobila.toString())) {
                  markaAuta = fields[2];
                  modelAuta = fields[3];
                } 
            }	
		}
		} finally {
			brAuto.close();
		}
		
		FileReader frServiser = new FileReader(SERVISERI_PATH);
		BufferedReader brServiser = new BufferedReader(frServiser);
		String prezimeServisera = null;
		try {
		String fileLine = null;
		
		while ((fileLine =  brServiser.readLine()) != null) {
			String[] fields = fileLine.split(",");
			if (fields.length > 0) {
                if (fields[0].equals(idServisera.toString())) {
                  prezimeServisera = fields[2];
                } 
            }	
		}
		} finally {
			brServiser.close();
		}
		
		
		FileReader frSer = new FileReader(SERVISI_PATH);
		
		BufferedReader brSer = new BufferedReader(frSer);
		String last = "", line;

	    while ((line = brSer.readLine()) != null) { 
	        last = line;
	    }
	    
	    String[] fields = last.split(",");
	    
	    String id = fields[0];
	    Integer newId = Integer.parseInt(id) + 1;

		brSer.close();
		
		try{	   	
	    	
	    	FileWriter fw = new FileWriter(SERVISI_PATH,true);
	    	BufferedWriter bw = new BufferedWriter(fw);
	    	PrintWriter pw = new PrintWriter(bw);
	    	String servisId = newId.toString();
	    	String newRow = servisId + ',' + markaAuta + "," + modelAuta + "," + prezimeServisera + "," + servis.getTermin() 
	    					+ "," + servis.getOpis() + "," + delovi + "," + servis.getStatus_servisa();
	    	pw.println(newRow);
	    	pw.close();

	      }catch(IOException ioe){
	         System.out.println("Exception occurred:");
	    	 ioe.printStackTrace();
	      }

		
	}

	@Override
	public void izmeniServis(Integer id, Servis servis) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obrisiServis(Integer id) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}