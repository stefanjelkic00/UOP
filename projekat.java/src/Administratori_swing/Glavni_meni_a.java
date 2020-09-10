package Administratori_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Liste.Liste;
import Moduli.Administrator;

public class Glavni_meni_a extends JFrame {
		private Liste listee;
		private Administrator admininstrator1;

		
		public Glavni_meni_a(Liste listee, Administrator admin) {
			this.listee = listee;
			this.admininstrator1 = admin;
			setTitle("Glavni prozor");
			setSize(750, 200);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setResizable(false);
			initMeni();
		}

		
		private void initMeni() {
			JMenuBar mainMenu = new JMenuBar();
			setJMenuBar(mainMenu);
			JMenuItem administratori = new JMenuItem("Administratori");
			mainMenu.add(administratori);
			JMenuItem musterije = new JMenuItem("Musterije");
			mainMenu.add(musterije);
			JMenuItem serviseri = new JMenuItem("Serviseri");
			mainMenu.add(serviseri);
			JMenuItem automobili = new JMenuItem("Automobili");
			mainMenu.add(automobili);
			JMenuItem servisi = new JMenuItem("Servisi");
			mainMenu.add(servisi);
			JMenuItem delovi = new JMenuItem("Delovi");
			mainMenu.add(delovi);
			JMenuItem servisne_knj = new JMenuItem("Servisne Knjizice");
			mainMenu.add(servisne_knj);

			
			administratori.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Tabela_administratora admins = new Tabela_administratora(listee);
					admins.setVisible(true);
				}
			});
			musterije.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Tabela_musterija musterijee = new Tabela_musterija(listee);
					musterijee.setVisible(true);
				}
			});
			
			serviseri.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Tabela_servisera serviseri = new Tabela_servisera(listee);
					serviseri.setVisible(true);
					
				}
			});
			automobili.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Tabela_automobila autiii = new Tabela_automobila(listee);
					autiii.setVisible(true);
					
				}
			});
			servisi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Tabela_servisa servisi = new Tabela_servisa(listee);
					servisi.setVisible(true);
					
				}
			});
			delovi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Tabela_delova delovi = new Tabela_delova(listee);
					delovi.setVisible(true);
					
				}
			});
			servisne_knj.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Tabela_servisnih_knjizica servisne = new Tabela_servisnih_knjizica(listee);
					servisne.setVisible(true);
					
				}
			});
			
		}
	}

