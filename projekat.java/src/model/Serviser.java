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


import crud.ServiserInterface;

public class Serviser extends Korisnik implements ServiserInterface {
	
	private int plata;
	private Specijalizacija specijalizacija;
	
	public Serviser() {
		super();
	}

	public Serviser(Integer id, String ime, String prezime, String JMBG, String pol, String adresa, String broj_telefona,
			String korisnicko_ime, String lozinka, int plata, Specijalizacija specijalizacija) {
		super(id, ime, prezime, JMBG, pol, adresa, broj_telefona, korisnicko_ime, lozinka);
		this.plata = plata;
		this.specijalizacija = specijalizacija;
	}

	public int getPlata() {
		return plata;
	}

	public void setPlata(int plata) {
		this.plata = plata;
	}

	public Specijalizacija getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(Specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

	@Override
	public String toString() {
		return "Serviser [plata=" + plata + ", specijalizacija=" + specijalizacija + ", ime=" + ime + ", prezime="
				+ prezime + ", JMBG=" + JMBG + ", pol=" + pol + ", adresa=" + adresa + ", broj_telefona="
				+ broj_telefona + ", korisnicko_ime=" + korisnicko_ime + ", lozinka=" + lozinka + "]";
	}

	@Override
	public void dodajServisera(Serviser serviser) throws IOException {
		
		String filepath = "C:\\Users\\stefa\\git\\UOP\\projekat.java\\src\\app\\serviseri.txt";
		
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
	    	String serviserId = newId.toString();
	    	String newRow =  "\n"+serviserId + ',' + serviser.getIme() + "," + serviser.getPrezime() + "," + serviser.getKorisnicko_ime() 
	    					+ "," + serviser.getLozinka() + "," + serviser.getAdresa() + "," + serviser.getBroj_telefona()
	    					+ "," + serviser.getJMBG() + "," + serviser.getPlata() + "," + serviser.getPol()+ serviser.getSpecijalizacija();
	    	pw.println(newRow);
	    	pw.close();
	    	bw.close();
	      }catch(IOException ioe){
	         System.out.println("Exception occurred:");
	    	 ioe.printStackTrace();
	       }

	}

	@Override
	public void izmeniServisera(Integer id, Serviser serviser) throws IOException {
		
		String filepath = "C:\\Users\\stefa\\git\\UOP\\projekat.java\\src\\app\\serviseri.txt";
		
		try {
            FileInputStream fstream = new FileInputStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                
                String fields[] = strLine.split(",");
                if (fields.length > 0) {
                    if (fields[0].equals(id.toString())) {
                        String newLine = fields[0] + "," + serviser.getIme() + "," + serviser.getPrezime() + "," + serviser.getKorisnicko_ime() 
    					+ "," + serviser.getLozinka() + "," + serviser.getAdresa() + "," + serviser.getBroj_telefona()
    					+ "," + serviser.getJMBG() + "," + serviser.getPlata() + "," + serviser.getPol();
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

	@Override
	public void obrisiServisera(Integer id) throws IOException {
		
		String filepath = "C:\\Users\\stefa\\git\\UOP\\projekat.java\\src\\app\\serviseri.txt";
		
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