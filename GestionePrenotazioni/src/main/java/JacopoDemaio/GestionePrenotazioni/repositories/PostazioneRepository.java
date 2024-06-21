package JacopoDemaio.GestionePrenotazioni.repositories;

import JacopoDemaio.GestionePrenotazioni.entities.Postazione;
import JacopoDemaio.GestionePrenotazioni.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {

    @Query("SELECT p FROM Postazione p JOIN Edificio e ON p.Edificio = e.id WHERE p.tipo = :tipo AND e.nome = :nome")
    List<Postazione> findByTipoAndEdificio(Tipo tipo, String nome);
}
