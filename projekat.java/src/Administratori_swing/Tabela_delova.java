package Administratori_swing;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Liste.Liste;
import Moduli.Deo;
import Liste.Liste;

public class Tabela_delova extends JFrame {


	
	private JToolBar main_tool_bar = new JToolBar();
	private JButton btnAdd = new JButton("Dodaj");
	private JButton btnEdit = new JButton("Izmeni");
	private JButton btnDelete = new JButton("Obrisi");
	private JButton btnSimetricni = new JButton("Simetricni");
	
	
	private DefaultTableModel table_model;
	private JTable delovi_tabela;
	
	private Liste listee;
	
	public Tabela_delova(Liste listee) {
		this.listee = listee;
		setTitle("Pregled delova");
		setSize(650, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	private void initGUI() {

		
		main_tool_bar.add(btnAdd);
		main_tool_bar.add(btnEdit);
		main_tool_bar.add(btnDelete);
		main_tool_bar.add(btnSimetricni);


		add(main_tool_bar, BorderLayout.SOUTH);
		String[] zaglavlje = new String[] {"ID","Marka", "Model" ,"Naziv", "Cena"};
		Object[][] sadrzaj = new Object[listee.getDelovi().size()][zaglavlje.length];
		
		for(int i = 0; i < listee.getDelovi().size(); i ++) {
			Deo deo = listee.getDelovi().get(i);
			sadrzaj[i][0] = deo.getId();
			sadrzaj[i][1] = deo.getMarka();
			sadrzaj[i][2] = deo.getModel();
			sadrzaj[i][3] = deo.getNaziv();
			sadrzaj[i][4] = deo.getCena();
	
		
		
		}
		
		table_model = new DefaultTableModel(sadrzaj, zaglavlje);
		delovi_tabela = new JTable(table_model);
		
		delovi_tabela.setRowSelectionAllowed(true);
		delovi_tabela.setColumnSelectionAllowed(false);
		delovi_tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		delovi_tabela.setDefaultEditor(Object.class, null);
		delovi_tabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jsp = new JScrollPane(delovi_tabela);
		add(jsp, BorderLayout.CENTER);
	
	}
	
	private void initActions() {
		
		
		btnSimetricni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int red = delovi_tabela.getSelectedRow();
				if(red != -1) {
				Deo deo = listee.NadjiDeo(Integer.parseInt(table_model.getValueAt(red,  0).toString()));
				
				String poruka = "";
				String[] naziv_dela = deo.getNaziv().split(" ");
				int brojacc = 0;
				for(String rec : naziv_dela) {
					if(rec.equalsIgnoreCase("levi")) {
						rec = "desni";
						brojacc ++;
					
					}else if(rec.equalsIgnoreCase("levo")) {
						rec = "desno";
						brojacc ++;

					
					}else if(rec.equalsIgnoreCase("leva")) {
						rec = "desna";
						brojacc ++;

					}else if(rec.equalsIgnoreCase("desni")) {
						rec = "levi";
						brojacc ++;

					
					}else if(rec.equalsIgnoreCase("desno")) {
						rec = "levo";
						brojacc ++;

					
					}else if(rec.equalsIgnoreCase("desna")) {
						rec = "leva";
						brojacc ++;

					}
					
					poruka += rec + " ";
				}
				if(brojacc == 0) {
					JOptionPane.showMessageDialog(null, "Za izabrani deo ne postoji simentricni", "!", JOptionPane.WARNING_MESSAGE);
				}else {
				listee.getDelovi().add(new Deo(listee.getDelovi().get(listee.getDelovi().size() - 1).getId() + 1, deo.getMarka(), deo.getModel(), poruka.substring(0, poruka.length() - 1), deo.getCena(), deo.Namenjen_za_taj_servis()));
				listee.upisDelova();
				JOptionPane.showMessageDialog(null, "Dodat simetricni deo", "Uspesno!", JOptionPane.INFORMATION_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Odaberite red", "!", JOptionPane.WARNING_MESSAGE);
			}
			}
			
		});
		
		
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int red = delovi_tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite deo koji zelite da obrisete.", "Greska!", JOptionPane.WARNING_MESSAGE);
				}else {
					int id = Integer.parseInt(table_model.getValueAt(red,  0).toString());
					Deo deo = listee.NadjiDeo(id);
					int izbor = JOptionPane.showConfirmDialog(null, "Obrisi deo: " + deo.getNaziv() + "?", "Neophodna potvrda.",JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						listee.getDelovi().remove(deo);
						table_model.removeRow(red);
						JOptionPane.showMessageDialog(null, "Deo sa ID: " + id + " obrisan!");
						listee.upisiSvih();
					}
					
					
							
				}
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				dodaj_izmeni_deo fda = new dodaj_izmeni_deo(listee, null);
				fda.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int red = delovi_tabela.getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Odaberite red za izmenu.", "Greska!", JOptionPane.WARNING_MESSAGE);
					
				}else {
					String idd = table_model.getValueAt(red, 0).toString();
					Deo s = listee.NadjiDeo(Integer.parseInt(idd));
					dodaj_izmeni_deo fda = new dodaj_izmeni_deo(listee, s);
					fda.setVisible(true);
				}
				
			}
		});
		
	}
}
