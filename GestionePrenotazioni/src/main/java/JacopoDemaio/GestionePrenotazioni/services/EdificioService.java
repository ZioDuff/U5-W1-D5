package JacopoDemaio.GestionePrenotazioni.services;

import JacopoDemaio.GestionePrenotazioni.entities.Edificio;
import JacopoDemaio.GestionePrenotazioni.exceptions.ItemNotFoundException;
import JacopoDemaio.GestionePrenotazioni.repositories.EdificioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

//    METODO SAVE

    public void saveEdificio(Edificio newEdificio){

        edificioRepository.save(newEdificio);

        log.info("L'edificio: "+ newEdificio.getNome() + " situato in: " + newEdificio.getCitta()+ " è stato salvato nel db");
    }

    public Edificio findById(UUID edificioId){

        return  edificioRepository.findById(edificioId).orElseThrow(()-> new ItemNotFoundException(edificioId));
    }

    public void findByIdAndDelete(UUID edificioId){
        Edificio found = this.findById(edificioId);
        edificioRepository.delete(found);
        log.info("L'edificio con nome:" + found.getNome()+ " situato in: " + found.getCitta()+ " è stato eliminato dal db");
    }

    public List<Edificio> findAll(){
        return edificioRepository.findAll();
    }
}
