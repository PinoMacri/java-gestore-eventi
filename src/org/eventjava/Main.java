package org.eventjava;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {
		try {
			List<Evento> nuoviEventi = new ArrayList<>();
			ProgrammiEventi programmiEventi = new ProgrammiEventi("Programma Eventi", nuoviEventi);
			Evento Concerto = new Evento("Evento 1", LocalDate.of(2023, 5, 17), 100, 0);
			Evento Partita = new Evento("Partita", LocalDate.of(2023, 5, 17), 100, 0);

			

			Scanner scanner = new Scanner(System.in);

			System.out.print("Inserisci il titolo dell'evento: ");
			String titoloEvento = scanner.nextLine();

			System.out.print("Inserisci la data dell'evento (yyyy-MM-dd): ");
			String dataEventoStringa = scanner.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate dataEvento = LocalDate.parse(dataEventoStringa, formatter);
			if (dataEvento.isBefore(LocalDate.now())) {
				throw new Exception("L'Evento è già passato");
			}

			System.out.print("Inserisci i posti totali: ");
			int postiTotaliEvento = scanner.nextInt();

			List<Integer> listaPrenotazioni = new ArrayList<>();

			int numeroPrenotazioni = 0;
			int prenotazione;
			do {
				System.out.print("Indica il numero di prenotazioni (inserisci 0 per terminare): ");
				prenotazione = scanner.nextInt();
				if (prenotazione > 0) {
					listaPrenotazioni.add(prenotazione);
				}
			} while (prenotazione > 0);
			for (int singolaPrenotazione : listaPrenotazioni) {
				numeroPrenotazioni += singolaPrenotazione;
				if (numeroPrenotazioni > postiTotaliEvento) {
					throw new Exception("Non ci sono posti disponibili");
				}
			}

			Evento nuovoEvento = new Evento(titoloEvento, dataEvento, postiTotaliEvento, numeroPrenotazioni);

			System.out.println("Posti Totali: " + postiTotaliEvento);
			System.out.println("Posti Prenotati: " + numeroPrenotazioni);
			System.out.println("Posti Disponibili: " + (postiTotaliEvento - numeroPrenotazioni));

			Scanner sc = new Scanner(System.in);
			System.out.print("Se vuoi disdire delle prenotazioni, inserisci il numero (inserisci 0 per terminare): ");
			int disdette = sc.nextInt();

			if (disdette > numeroPrenotazioni) {
				throw new Exception("Non si possono disdire prenotazioni che non ci sono");
			} else
				numeroPrenotazioni = numeroPrenotazioni - disdette;

			System.out.println("Posti Totali: " + postiTotaliEvento);
			System.out.println("Posti Prenotati: " + numeroPrenotazioni);
			System.out.println("Posti Disponibili: " + (postiTotaliEvento - numeroPrenotazioni));
			programmiEventi.aggiungiEvento(Concerto);
			programmiEventi.aggiungiEvento(Partita);
			programmiEventi.aggiungiEvento(nuovoEvento);
		
			System.out.println(programmiEventi.getElencoEventiOrdinatiPerData());
			
		} catch (Exception e) {
			System.err.println("Campi non validi");
		}

	}
}
