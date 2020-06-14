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

import crud.MusterijaInterface;

public class Musterija extends Korisnik implements MusterijaInterface{

	private String broj_sakupljenih_nagradnih_bodova;

	public Musterija() {
		super();
	}

	public Musterija(Integer id, String ime, String prezime, String JMBG, String pol, String adresa, String broj_telefona,
			String korisnicko_ime, String lozinka, String broj_sakupljenih_nagradnih_bodova) {
		super(id, ime, prezime, JMBG, pol, adresa, broj_telefona, korisnicko_ime, lozinka);
		this.broj_sakupljenih_nagradnih_bodova = broj_sakupljenih_nagradnih_bodova;
		
	}

	public String getBroj_sakupljenih_nagradnih_bodova() {
		return broj_sakupljenih_nagradnih_bodova;
	}

	public void setBroj_sakupljenih_nagradnih_bodova(String broj_sakupljenih_nagradnih_bodova) {
		this.broj_sakupljenih_nagradnih_bodova = broj_sakupljenih_nagradnih_bodova;
	}

	@Override
	public String toString() {
		return "Musterija [broj_sakupljenih_nagradnih_bodova=" + broj_sakupljenih_nagradnih_bodova + ", ime=" + ime
				+ ", prezime=" + prezime + ", JMBG=" + JMBG + ", pol=" + pol + ", adresa=" + adresa + ", broj_telefona="
				+ broj_telefona + ", korisnicko_ime=" + korisnicko_ime + ", lozinka=" + lozinka + "]";
	}
	

	@Override
	public void dodajMusteriju(Musterija musterija) throws IOException {
		
		String filepath = "C:\\Users\\stefa\\git\\UOP\\projekat.java\\src\\app\\musterije.txt";
		
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
	    	String musterijaId = newId.toString();
	    	String newRow = "\n"+musterijaId + ',' + musterija.getIme() + "," + musterija.getPrezime() + "," + musterija.getKorisnicko_ime() 
	    					+ "," + musterija.getLozinka() + "," + musterija.getAdresa() + "," + musterija.getBroj_telefona()
	    					+ "," + musterija.getJMBG() + "," + musterija.getPol();
	    	pw.println(newRow);
	    	pw.close();
	    	bw.close();
	      }catch(IOException ioe){
	         System.out.println("Exception occurred:");
	    	 ioe.printStackTrace();
	       }

	}

	@Override
	public void izmeniMusteriju(Integer id, Musterija musterija) throws IOException {
		
		String filepath = "C:\\Users\\stefa\\git\\UOP\\projekat.java\\src\\app\\musterije.txt";
		
		try {
            FileInputStream fstream = new FileInputStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                
                String fields[] = strLine.split(",");
                if (fields.length > 0) {
                    if (fields[0].equals(id.toString())) {
                        String newLine = fields[0] + "," + musterija.getIme() + "," + musterija.getPrezime() + "," + musterija.getKorisnicko_ime() 
    					+ "," + musterija.getLozinka() + "," + musterija.getAdresa() + "," + musterija.getBroj_telefona()
    					+ "," + musterija.getJMBG() + ","  + musterija.getPol();
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
	public void obrisiMusteriju(Integer id) throws IOException {
		
		String filepath = "C:\\Users\\stefa\\git\\UOP\\projekat.java\\src\\app\\musterije.txt";
		
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