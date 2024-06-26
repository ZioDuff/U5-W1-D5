package JacopoDemaio.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Prenotazione {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utenteId;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazioneId;

    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;

    public Prenotazione(Utente utenteId, Postazione postazioneId, LocalDate dataPrenotazione) {
        this.utenteId = utenteId;
        this.postazioneId = postazioneId;
        this.dataPrenotazione = dataPrenotazione;
    }
}
