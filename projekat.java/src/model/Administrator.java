package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileInputStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.RandomAccessFile;

import crud.AdministratorInterface;

public class Administrator extends Korisnik implements AdministratorInterface {
	
	private int plata;
	
	public Administrator() {
		super();
	}

	public Administrator(Integer id, String ime, String prezime, String JMBG, String pol, String adresa, String broj_telefona,
			String korisnicko_ime, String lozinka, int plata) {
		super(id, ime, prezime, JMBG, pol, adresa, broj_telefona, korisnicko_ime, lozinka);
		this.plata = plata;
	}

	public int getPlata() {
		return plata;
	}

	public void setPlata(int plata) {
		this.plata = plata;
	}


	@Override
	public String toString() {
		return "Administrator [plata=" + plata + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", JMBG="
				+ JMBG + ", pol=" + pol + ", adresa=" + adresa + ", broj_telefona=" + broj_telefona
				+ ", korisnicko_ime=" + korisnicko_ime + ", lozinka=" + lozinka + "]";
	}

	@Override
	public void dodajAdministratora(Administrator admin) throws IOException {
		
		String filepath = "C:\\Users\\stefa\\git\\UOP\\projekat.java\\src\\app\\administratori.txt";
		
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
	    
	    	String adminId = newId.toString();
	    	String newRow =  "\n"+ adminId + ',' + admin.getIme() + "," + admin.getPrezime() + "," + admin.getJMBG() 
	    					+ "," + admin.getPol() + "," + admin.getAdresa() + "," + admin.getBroj_telefona()
	    					+ "," + admin.getKorisnicko_ime() + "," + admin.getLozinka() + "," + admin.getPlata() ;
	    	bw.write(newRow);
	    	bw.close();
	      }catch(IOException ioe){
	         System.out.println("Exception occurred:");
	    	 ioe.printStackTrace();
	       }

	}

	@Override
	public void izmeniAdministratora(Integer id, Administrator admin) throws IOException {
		
		String filepath = "C:\\Users\\stefa\\git\\UOP\\projekat.java\\src\\app\\administratori.txt";
		
		try {
            FileInputStream fstream = new FileInputStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                
                String fields[] = strLine.split(",");
                if (fields.length > 0) {
                    if (fields[0].equals(id.toString())) {
                        String newLine =  fields[0] + "," + admin.getIme() + "," + admin.getPrezime() + "," + admin.getKorisnicko_ime() 
    					+ "," + admin.getLozinka() + "," + admin.getAdresa() + "," + admin.getBroj_telefona()
    					+ "," + admin.getJMBG() + "," + admin.getPlata() + "," + admin.getPol();
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
	public void obrisiAdministratora(Integer id) throws IOException {
		
		String filepath = "C:\\Users\\stefa\\git\\UOP\\projekat.java\\src\\app\\administratori.txt";
		
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


