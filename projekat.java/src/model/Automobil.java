package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class Automobil {

	private Musterija vlasnik;
	private Marka_auta marka;
	private Model_auta model;
	private Integer godina_proizvodnje;
	private String zapremina_motora;
	private String snaga_motora;
	private String vrsta_goriva;
	
	public Automobil() {
		
	}

	public Automobil(Musterija vlasnik, Marka_auta marka, Model_auta model, Integer godina_proizvodnje, String zapremina_motora,
			String snaga_motora, String vrsta_goriva) {
		super();
		this.vlasnik = vlasnik;
		this.marka = marka;
		this.model = model;
		this.godina_proizvodnje = godina_proizvodnje;
		this.zapremina_motora = zapremina_motora;
		this.snaga_motora = snaga_motora;
		this.vrsta_goriva = vrsta_goriva;
	}

	public Musterija getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(Musterija vlasnik) {
		this.vlasnik = vlasnik;
	}

	public Marka_auta getMarka() {
		return marka;
	}

	public void setMarka(Marka_auta marka) {
		this.marka = marka;
	}
	
	

	public Model_auta getModel() {
		return model;
	}

	public void setModel(Model_auta model) {
		this.model = model;
	}

	public Integer getGodina_proizvodnje() {
		return godina_proizvodnje;
	}

	public void setGodina_proizvodnje(Integer godina_proizvodnje) {
		this.godina_proizvodnje = godina_proizvodnje;
	}

	public String getZapremina_motora() {
		return zapremina_motora;
	}

	public void setZapremina_motora(String zapremina_motora) {
		this.zapremina_motora = zapremina_motora;
	}

	public String getSnaga_motora() {
		return snaga_motora;
	}

	public void setSnaga_motora(String snaga_motora) {
		this.snaga_motora = snaga_motora;
	}

	public String getVrsta_goriva() {
		return vrsta_goriva;
	}

	public void setVrsta_goriva(String vrsta_goriva) {
		this.vrsta_goriva = vrsta_goriva;
	}

	@Override
	public String toString() {
		return "Automobil [vlasnik=" + vlasnik.getPrezime() + ", marka=" + marka + ", model=" + model + ", godina_proizvodnje="
				+ godina_proizvodnje + ", zapremina_motora=" + zapremina_motora + ", snaga_motora=" + snaga_motora
				+ ", vrsta_goriva=" + vrsta_goriva + "]";
	}
	
	public static void dodajAutomobil(Automobil auto) throws IOException {
		
		String filepath = "C:\\Users\\stefa\\git\\UOP\\projekat.java\\src\\app\\automobili.txt";
		
		FileReader frAd = new FileReader(filepath);
		
		BufferedReader brAd = new BufferedReader(frAd);
		String last = "", line;

	    while ((line = brAd.readLine()) != null) { 
	        last = line;
	    }
	    
	    String[] fields = last.split(",");
	    
	    String id = fields[0];
	    Integer newId = Integer.parseInt(id) + 1;

		brAd.close();
		
		try{	   	
	    	

	    	
	    	FileWriter fw = new FileWriter(filepath,true);
	    	BufferedWriter bw = new BufferedWriter(fw);
	    	PrintWriter pw = new PrintWriter(bw);
	    	String autoId = newId.toString();
	    	String newRow =   "\n" +  autoId + ',' + auto.getVlasnik().getPrezime() + "," + auto.getMarka() + "," + auto.getModel() 
	    					+ "," + auto.getGodina_proizvodnje() + "," + auto.getZapremina_motora() + "," + auto.getSnaga_motora()
	    					+ "," + auto.getVrsta_goriva()  ;
	    	pw.println(newRow);
	    	pw.close();
	    	bw.close();
	      }catch(IOException ioe){
	         System.out.println("Exception occurred:");
	    	 ioe.printStackTrace();
	       }

	}

	public void izmeniAutomobil(Integer id, Automobil auto) throws IOException {
		
		String filepath = "C:\\Users\\stefa\\git\\UOP\\projekat.java\\src\\app\\automobili.txt";
		
		try {
            FileInputStream fstream = new FileInputStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                
                String fields[] = strLine.split(",");
                if (fields.length > 0) {
                    if (fields[0].equals(id.toString())) {
                        String newLine = fields[0] + ',' + auto.getVlasnik().getPrezime() + "," + auto.getMarka() + "," + auto.getModel() 
    					+ "," + auto.getGodina_proizvodnje() + "," + auto.getZapremina_motora() + "," + auto.getSnaga_motora()
    					+ "," + auto.getVrsta_goriva() ;
                        fileContent.append(newLine);
                        fileContent.append("\n");
                    } else {
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            FileWriter fstreamWrite = new FileWriter(filepath);
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            br.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
		
	}

	public void obrisiAutomobil(Integer id) throws IOException {
		
		String filepath = "C:\\Users\\stefa\\git\\UOP\\projekat.java\\src\\app\\automobili.txt";
		
		RandomAccessFile file = new RandomAccessFile(filepath, "rw");
		String delete;
		String task="";
		
	    while ((delete = file.readLine()) != null) {
	    	String fields[] = delete.split(",");
	        if (fields[0].equals(id.toString())) {
	            continue;
	        }
	        task+=delete+"\n";
	    }

	        BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
	        writer.write(task);
	        file.close();
	        writer.close();
		
	}

}
	
	
	
