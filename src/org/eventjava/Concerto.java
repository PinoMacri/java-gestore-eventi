package org.eventjava;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	public LocalTime ora;
	public BigDecimal prezzo;

	public Concerto(String titolo, LocalDate data, int postiTotali, int postiPrenotati, LocalTime ora,
			BigDecimal prezzo) throws Exception {
		super(titolo, data, postiTotali, postiPrenotati);
		setOra(ora);
		setPrezzo(prezzo);
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public String getFormattedData() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return getData().format(formatter);
	}

	public String getFormattedOra() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		return getOra().format(formatter);
	}

	public String getFormattedPrezzo() {
		DecimalFormat decimalFormat = new DecimalFormat("0.00€");
		return decimalFormat.format(getPrezzo());
	}

	public String toString() {
		return getFormattedData() + " - " + getTitolo() + " - " + getFormattedPrezzo();
	}


}
