package org.eventjava;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammiEventi {
	public String titolo;
	public List<Evento> eventi;

	public ProgrammiEventi(String titolo, List<Evento> eventi) {
		this.titolo = titolo;
		this.eventi = eventi;
	}

	public void aggiungiEvento(Evento evento) {
		eventi.add(evento);
	}

	public List<Evento> getEventiPerData(LocalDate data) {
		List<Evento> eventiPerData = new ArrayList<>();

		for (Evento evento : eventi) {
			if (evento.getData().equals(data)) {
				eventiPerData.add(evento);
			}
		}

		return eventiPerData;
	}

	public int getNumeroEventi() {
		return eventi.size();
	}

	public void svuotaEventi() {
		eventi.clear();
	}

	public String getElencoEventiOrdinatiPerData() {
		StringBuilder sb = new StringBuilder();
		sb.append("Titolo del programma: ").append(titolo).append("\n");
		Collections.sort(eventi, Comparator.comparing(Evento::getData));
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (Evento evento : eventi) {
			String dataFormattata = evento.getData().format(dateFormatter);
			sb.append("- ").append(dataFormattata).append(" - ").append(evento.getTitolo()).append("\n");
		}
		return sb.toString();
	}
}
