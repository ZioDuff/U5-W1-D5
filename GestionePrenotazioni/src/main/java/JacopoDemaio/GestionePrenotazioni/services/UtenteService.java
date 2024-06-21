package JacopoDemaio.GestionePrenotazioni.services;

import JacopoDemaio.GestionePrenotazioni.entities.Utente;
import JacopoDemaio.GestionePrenotazioni.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

//    METODO SAVE

    public void saveUtente(Utente newUtente){

        utenteRepository.save(newUtente);
        log.info("L'utente: " + newUtente.getNomeCompleto()+" è stato salvato correttamente nel db");

    }
}
