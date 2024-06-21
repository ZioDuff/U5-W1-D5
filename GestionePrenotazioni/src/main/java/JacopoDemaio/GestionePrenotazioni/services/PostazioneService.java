package JacopoDemaio.GestionePrenotazioni.services;

import JacopoDemaio.GestionePrenotazioni.entities.Postazione;
import JacopoDemaio.GestionePrenotazioni.repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

//    METODO SAVE

    public void savePostazione(Postazione newPostazione){

        postazioneRepository.save(newPostazione);

        log.info("La postazione nell'edificio: " + newPostazione.getEdificio().getNome() + " è stata salvata del db");

    }
}
