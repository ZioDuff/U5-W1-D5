package JacopoDemaio.GestionePrenotazioni.services;

import JacopoDemaio.GestionePrenotazioni.entities.Postazione;
import JacopoDemaio.GestionePrenotazioni.entities.Prenotazione;
import JacopoDemaio.GestionePrenotazioni.entities.Utente;
import JacopoDemaio.GestionePrenotazioni.enums.Tipo;
import JacopoDemaio.GestionePrenotazioni.exceptions.ItemNotFoundException;
import JacopoDemaio.GestionePrenotazioni.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

//    METODO SAVE

    public void saveUtente(Utente newUtente) {

        if (utenteRepository.existsByEmail(newUtente.getEmail())) {
            throw new RuntimeException("L'email " + newUtente.getEmail() + " è già in uso!");
        }

        if(utenteRepository.existsByUsername(newUtente.getUsername())){
            throw new RuntimeException("l'username " + newUtente.getUsername() + " è già in uso!");
        }

        if (newUtente.getUsername().length() <= 2)
            throw new RuntimeException("Il nome non può essere più corto di 2 caratteri");

        utenteRepository.save(newUtente);
        log.info("L'utente: " + newUtente.getNomeCompleto() + " è stato salvato correttamente nel db");
    }



    public Utente findByIdUtente(UUID utenteId) {

        return utenteRepository.findById(utenteId).orElseThrow(() -> new ItemNotFoundException(utenteId));
    }

    public void findByIdAndDeleteUtente(UUID utenteId){
        Utente found = this.findByIdUtente(utenteId);
        utenteRepository.delete(found);
        log.info("Utente con nome:" + found.getNomeCompleto()+ " è stato eliminato con successo");
    }


    public List<Utente> findAll(){
        return utenteRepository.findAll();
    }

}
