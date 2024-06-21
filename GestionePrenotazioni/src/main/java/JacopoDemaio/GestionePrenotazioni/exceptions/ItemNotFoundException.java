package JacopoDemaio.GestionePrenotazioni.exceptions;

import java.util.UUID;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(UUID id) {
        super("Il record con id " + id + " non è stato trovato!");
    }
}
