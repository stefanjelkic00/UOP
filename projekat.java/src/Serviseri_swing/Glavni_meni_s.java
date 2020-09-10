package Serviseri_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Administratori_swing.Tabela_musterija;
import Administratori_swing.Tabela_servisera;
import Liste.Liste;
import Moduli.Administrator;
import Moduli.Serviser;

public class Glavni_meni_s extends JFrame {
		private Liste listee;
		private Serviser serviser1;

		
		public Glavni_meni_s(Liste listee, Serviser serviser1) {
			this.listee = listee;
			this.serviser1 = serviser1;
			setTitle("Glavni prozor");
			setSize(400, 200);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setResizable(false);
			initMeni();
		}

		
		private void initMeni() {
			JMenuBar mainMenu = new JMenuBar();
			setJMenuBar(mainMenu);
			
			JMenuItem servisi = new JMenuItem("Servisi");
			mainMenu.add(servisi);
		

			
			servisi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Tabela_servisa ata = new Tabela_servisa(listee,serviser1);
					ata.setVisible(true);
				}
			});
		}
	}

