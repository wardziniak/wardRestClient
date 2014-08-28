package com.wardziniak.jsonRestClient.test.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Blok {
	
	@XmlElement
	private String adres;
	
	@XmlElement
	private int liczbaPieter;
	
	@XmlElement
	private int liczbaKlatek;
	
	@XmlElement
	private List<Mieszkanie> mieszkania = new ArrayList<Mieszkanie>();
	
	public static Random r = new Random();
	
	public Blok() {
		this.adres = "adres" + r.nextInt(100);
		this.liczbaKlatek = r.nextInt(10);
		this.liczbaPieter = r.nextInt(10);
		int liczbaMieszkan = r.nextInt(100);
		this.mieszkania = new ArrayList<Mieszkanie>();
		for (int i = 0; i < liczbaMieszkan; i++) {
			mieszkania.add(new Mieszkanie());
		}
	}
	
	public int getLiczbaMieszkan() {
		return mieszkania.size();
	}

}
