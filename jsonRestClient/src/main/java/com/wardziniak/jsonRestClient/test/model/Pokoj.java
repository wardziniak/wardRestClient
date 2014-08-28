package com.wardziniak.jsonRestClient.test.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pokoj {
	
	@XmlElement
	private String typPokoju;
	
	@XmlElement
	private int metraz;
	
	@XmlElement
	private boolean czyMaOkno;

	public Pokoj() {
		this.typPokoju = "typPokoju" + Blok.r.nextInt();
		this.metraz = Blok.r.nextInt(90);
		this.czyMaOkno = Blok.r.nextBoolean();
	}
	
}
