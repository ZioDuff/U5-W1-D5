package JacopoDemaio.GestionePrenotazioni.configuration;

import JacopoDemaio.GestionePrenotazioni.entities.Edificio;
import JacopoDemaio.GestionePrenotazioni.entities.Postazione;
import JacopoDemaio.GestionePrenotazioni.entities.Utente;
import JacopoDemaio.GestionePrenotazioni.enums.Tipo;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.UUID;

@Configuration
@PropertySource("application.properties")
public class BeanConfiguration {

    Faker faker = new Faker();

//    BEAN

//    EDIFICIO

    @Bean(name = "edificio1")
    public Edificio createEdificio1(){
        return new Edificio(faker.funnyName().name(),"Via le mani dal naso", faker.address().cityName());
    }

    @Bean(name = "edificio2")
    public Edificio createEdificio2(){
        return new Edificio(faker.funnyName().name(),"Piazza la bomba e scappa", faker.address().cityName());
    }
    @Bean(name = "edificio3")
    public Edificio createEdificio3(){
        return new Edificio(faker.funnyName().name(),faker.address().streetAddress(), faker.address().cityName());
    }

//    UTENTE

    @Bean(name = "utente1")
    public Utente createUtente1(){
        return new Utente(faker.funnyName().name(),faker.howIMetYourMother().character(),faker.internet().emailAddress());
    }

//    @Bean(name = "utente2")
//    public Utente createUtente2(){
//        return new Utente(faker.funnyName().name(),faker.howIMetYourMother().character(),faker.internet().emailAddress());
//    }
//
//    @Bean(name = "utente3")
//    public Utente createUtente3(){
//        return new Utente(faker.funnyName().name(),faker.howIMetYourMother().character(),faker.internet().emailAddress());
//    }

//    POSTAZIONE

    @Bean(name = "postazione1")
    public Postazione createPostazione1(){
        return  new Postazione("La piu bella postazione del mondo", Tipo.PRIVATO,10,createEdificio1());
    }

    @Bean(name = "postazione2")
    public Postazione createPostazione2(){
        return  new Postazione("Usatela per quello che vi pare", Tipo.OPEN_SPACE,80,createEdificio2());
    }

    @Bean(name = "postazione3")
    public Postazione createPostazione3(){
        return  new Postazione("Non so piu che scrivere", Tipo.SALA_RIUNIONI,30,createEdificio3());
    }


}
