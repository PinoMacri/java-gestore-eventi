package org.eventjava;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Evento {
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati = 0;
	public Evento(String titolo, LocalDate data, int postiTotali, int postiPrenotati) throws Exception {
		this.titolo = titolo;
		setData(data);
		setPostiTotali(postiTotali);
		this.postiPrenotati = postiPrenotati;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) throws Exception {
		if (data.isBefore(LocalDate.now())) {
			throw new Exception("La data non può essere nel passato");
		}
		this.data = data;
	}
	public int getPostiTotali() {
		return postiTotali;
	}
	public void setPostiTotali(int postiTotali) throws Exception {
		if (postiTotali < 0) {
			throw new Exception("Il numero di posti totali deve essere positivo");
		}
		this.postiTotali = postiTotali;
	}
	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	public int prenota() throws Exception {
		if (data.isBefore(LocalDate.now())) {
			throw new Exception("L'Evento è gia passato");
		} else if (postiPrenotati > postiTotali) {
			throw new Exception("Non ci sono più posti disponibili");
		} else
			return postiPrenotati = postiPrenotati + 1;
	}
	public int disdici() throws Exception {
		if (data.isBefore(LocalDate.now())) {
			throw new Exception("L'Evento è gia passato");
		} else if (postiPrenotati == 0) {
			throw new Exception("Non si può disdire una prenotazione che non c'è");
		} else
			return postiPrenotati = postiPrenotati - 1;
	}
	public String toString() {
		return "Data: " + data + " Titolo: " + titolo;
	}
}
