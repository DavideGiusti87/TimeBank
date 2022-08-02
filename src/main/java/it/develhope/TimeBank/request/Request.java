package it.develhope.TimeBank.request;

public class Request extends AnonymousRequest{

    private User<> details;
    /*qui immagino ci da una lista coi dati del user: nome, telefono, email
    - più che una lista di User, secondo me all'interno della richiesta una delle variabili sarà un singolo oggetto di
    tipo User, ovvero colui che sta eseguendo la richiesta
     */
    private String description;
    private Skill skill;
    private Area //Area e Address fanno parte dell'oggetto di tipo User, non sono sicura che vadano inseriti anche qui
    private String address;

    //constructors - empty and parametric (from superclass)

    public Request() {
    }

    public Request(String title, String description, String name, int phoneNumber) {
        super(title, description, name, phoneNumber);
    }

}
