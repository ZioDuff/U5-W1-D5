package JacopoDemaio.GestionePrenotazioni.services;

import JacopoDemaio.GestionePrenotazioni.entities.Edificio;
import JacopoDemaio.GestionePrenotazioni.entities.Postazione;
import JacopoDemaio.GestionePrenotazioni.enums.Tipo;
import JacopoDemaio.GestionePrenotazioni.exceptions.ItemNotFoundException;
import JacopoDemaio.GestionePrenotazioni.repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Postazione findById(UUID postazioneId){

        return  postazioneRepository.findById(postazioneId).orElseThrow(()-> new ItemNotFoundException(postazioneId));
    }

    public void findByIdAndDelete(UUID postazioneId){
        Postazione found = this.findById(postazioneId);
        postazioneRepository.delete(found);
        log.info("la postazione con id:" + found.getId()+ " situatoa in: " + found.getEdificio().getNome()+ " è stato eliminata dal db");
    }


//    public List<Postazione> searchPostazioni(String tipo, String nome){
//        return postazioneRepository.findByTipoAndEdificio(tipo,nome);
//
//    }

    public List<Postazione> findAll(){
        return postazioneRepository.findAll();
    }
}
