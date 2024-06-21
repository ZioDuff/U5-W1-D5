package JacopoDemaio.GestionePrenotazioni.services;

import JacopoDemaio.GestionePrenotazioni.entities.Postazione;
import JacopoDemaio.GestionePrenotazioni.entities.Prenotazione;
import JacopoDemaio.GestionePrenotazioni.exceptions.ItemNotFoundException;
import JacopoDemaio.GestionePrenotazioni.repositories.PrenotazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void savePrenotazione(Prenotazione newPrenotazione){

        if (prenotazioneRepository.existsByUtenteAndData(newPrenotazione.getUtenteId(), newPrenotazione.getDataPrenotazione())){
            throw new RuntimeException("L'utente " + newPrenotazione.getUtenteId().getNomeCompleto() + " Ha già una prenotazione in questa data");
        }
        if (prenotazioneRepository.findByPostazioneAndData(newPrenotazione.getPostazioneId(), newPrenotazione.getDataPrenotazione()).size() >= newPrenotazione.getPostazioneId().getMaxPartecipanti()){
            throw new RuntimeException("Capienza massima raggiunta per la postazione " + newPrenotazione.getPostazioneId().getId());
        }

        prenotazioneRepository.save(newPrenotazione);
        log.info("La prenotazione con id: "+ newPrenotazione.getId() + "in data: "+ newPrenotazione.getDataPrenotazione()+ " è avvenuta correttamente" );

    }

    public Prenotazione findById(UUID prenotazioneId){
      return   prenotazioneRepository.findById(prenotazioneId).orElseThrow(()-> new ItemNotFoundException(prenotazioneId));
    }

    public void findByIdAndDelete(UUID prenotazioneId){
        Prenotazione found = this.findById(prenotazioneId);
        prenotazioneRepository.delete(found);
        log.info("La prenotazione con id: "+ found.getId()+ " è stata eliminata dal db");
    }

    public List<Prenotazione> findAll(){
        return prenotazioneRepository.findAll();
    }


}
