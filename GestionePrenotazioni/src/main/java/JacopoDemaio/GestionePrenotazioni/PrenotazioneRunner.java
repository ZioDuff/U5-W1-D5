package JacopoDemaio.GestionePrenotazioni;

import JacopoDemaio.GestionePrenotazioni.entities.Edificio;
import JacopoDemaio.GestionePrenotazioni.entities.Postazione;
import JacopoDemaio.GestionePrenotazioni.entities.Prenotazione;
import JacopoDemaio.GestionePrenotazioni.entities.Utente;
import JacopoDemaio.GestionePrenotazioni.enums.Tipo;
import JacopoDemaio.GestionePrenotazioni.services.EdificioService;
import JacopoDemaio.GestionePrenotazioni.services.PostazioneService;
import JacopoDemaio.GestionePrenotazioni.services.PrenotazioneService;
import JacopoDemaio.GestionePrenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class PrenotazioneRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PrenotazioneService prenotazioneService;
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




        postazioneService.searchPostazioni("PRIVATO","Oscar Ruitt").forEach(System.out::println);

Utente uFromDb = utenteService.findByIdUtente(UUID.fromString("139aef69-0b1b-4061-95ff-e3aadf8a0062"));
Postazione pFromDb = postazioneService.findById(UUID.fromString("336453d5-cd82-429e-a3eb-e00f550ea6f3"));
        Edificio edFromDb = edificioService.findById(UUID.fromString("873af56b-9495-45f0-8dfb-b0daa44bd0b9"));
//        System.out.println(edFromDb);
//        Postazione p1 = new Postazione("non so che scrivere", Tipo.OPEN_SPACE,80,edFromDb);
//        postazioneService.savePostazione(p1);


        Prenotazione p1 = new Prenotazione(uFromDb,pFromDb, LocalDate.now());
//        prenotazioneService.savePrenotazione(p1);



        ctx.close();




    }
}
