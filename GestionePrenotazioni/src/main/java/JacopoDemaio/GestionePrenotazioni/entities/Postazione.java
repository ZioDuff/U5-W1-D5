package JacopoDemaio.GestionePrenotazioni.entities;

import JacopoDemaio.GestionePrenotazioni.enums.Tipo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Postazione {

    @Id
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
