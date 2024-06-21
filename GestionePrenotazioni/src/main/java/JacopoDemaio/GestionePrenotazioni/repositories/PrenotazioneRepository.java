package JacopoDemaio.GestionePrenotazioni.repositories;

import JacopoDemaio.GestionePrenotazioni.entities.Postazione;
import JacopoDemaio.GestionePrenotazioni.entities.Prenotazione;
import JacopoDemaio.GestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

    boolean existsByUtenteIdAndDataPrenotazione(Utente utenteId, LocalDate dataPrenotazione);

    List<Prenotazione> findByPostazioneIdAndDataPrenotazione (Postazione postazioneId, LocalDate dataPrenotazione);
}
