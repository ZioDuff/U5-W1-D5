package JacopoDemaio.GestionePrenotazioni;

import JacopoDemaio.GestionePrenotazioni.entities.Edificio;
import JacopoDemaio.GestionePrenotazioni.entities.Postazione;
import JacopoDemaio.GestionePrenotazioni.entities.Utente;
import JacopoDemaio.GestionePrenotazioni.enums.Tipo;
import JacopoDemaio.GestionePrenotazioni.services.EdificioService;
import JacopoDemaio.GestionePrenotazioni.services.PostazioneService;
import JacopoDemaio.GestionePrenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PrenotazioneRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;


    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);



//        SALVO NEL DB
//
//        Utente ut1 = ctx.getBean("utente1",Utente.class);
//        Edificio ed1= ctx.getBean("edificio3",Edificio.class);
//
//        utenteService.saveUtente(ut1);
//        edificioService.saveEdificio(ed1);




        postazioneService.searchPostazioni(Tipo.PRIVATO,"Oscar Ruitt").forEach(System.out::println);


        Edificio edFromDb = edificioService.findById(UUID.fromString("873af56b-9495-45f0-8dfb-b0daa44bd0b9"));
//        System.out.println(edFromDb);
//        Postazione p1 = new Postazione("non so che scrivere", Tipo.OPEN_SPACE,80,edFromDb);
//        postazioneService.savePostazione(p1);



        ctx.close();




    }
}
