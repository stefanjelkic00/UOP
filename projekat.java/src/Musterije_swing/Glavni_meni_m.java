package Musterije_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Administratori_swing.Tabela_musterija;
import Liste.Liste;
import Moduli.Administrator;
import Moduli.Musterija;

public class Glavni_meni_m extends JFrame {
		private Liste listee;
		private Musterija musterije1;

		
		public Glavni_meni_m(Liste listee, Musterija musterije1) {
			this.listee = listee;
			this.musterije1 = musterije1;
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
			
			JMenuItem automobili = new JMenuItem("Automobili");
			mainMenu.add(automobili);
			JMenuItem servisi = new JMenuItem("Servisi");
			mainMenu.add(servisi);
			
			JMenuItem servisne_knj = new JMenuItem("Servisne Knjizice");
			mainMenu.add(servisne_knj);

			
			automobili.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
				Tabela_automobila autii = new Tabela_automobila(listee, musterije1);
				autii.setVisible(true);
					
				}
			});
			servisi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
				Tabela_servisa servisii = new Tabela_servisa(listee, musterije1);
				servisii.setVisible(true);
				}
			});
			servisne_knj.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Tabela_servisnih_knjizica serv_knjiz = new Tabela_servisnih_knjizica(listee,musterije1);
					serv_knjiz.setVisible(true);
					
				}
			});
		}
	}

