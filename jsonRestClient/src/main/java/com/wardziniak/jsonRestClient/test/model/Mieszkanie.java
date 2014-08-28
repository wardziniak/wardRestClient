package com.wardziniak.jsonRestClient.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mieszkanie {

	@XmlElement
	private int pietro;
	
	@XmlElement
	private boolean czyMaKomorke;
	
	@XmlElement
	private List<Pokoj> pokoje;
	
	public Mieszkanie() {
		this.pietro = Blok.r.nextInt(10);
		this.czyMaKomorke = Blok.r.nextBoolean();
		int liczbaPokoi = Blok.r.nextInt(10);
		this.pokoje = new ArrayList<Pokoj>();
		for (int i = 0; i < liczbaPokoi; i++) {
			this.pokoje.add(new Pokoj());
		}
	}
	
}
