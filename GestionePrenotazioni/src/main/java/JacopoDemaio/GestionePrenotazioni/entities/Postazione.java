package JacopoDemaio.GestionePrenotazioni.entities;

import JacopoDemaio.GestionePrenotazioni.enums.Tipo;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Postazione {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(name = "numero_massimo_partecipanti")
    private int maxPartecipanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;


    public Postazione(String descrizione, Tipo tipo, int maxPartecipanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.maxPartecipanti = maxPartecipanti;
        this.edificio = edificio;
    }
}
