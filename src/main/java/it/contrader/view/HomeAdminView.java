/**
w * Manage a Business Owner view
 */

package it.contrader.view;


/**
 * Per Ulteriori dettagli vedi Guida sez 9 View.
 * Per la descrizione dei metodi vedi l'interfaccia View in questo pacchetto.
 */
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeAdminView extends AbstractView {

    private String choice;
    
	private Request request;

	/**
	 * Se la request non è nulla mostra un messaggio di benvenuto
	 */
    public void showResults(Request request) {
    	if(request!=null) {
    	System.out.println("\n Welcome to SAMPLE PROJECT "+request.get("username").toString() + "\n");
    	}
    }


    /**
     * Chiede all'utente di effettuare una scelta (da console)
     */
    public void showOptions() {
        System.out.println("------------- MAIN MENU------------\n");
        System.out.println("Choose what you want to handle:");
        System.out.println("[U]sers [P]ackets [EN]vironment [C]ategory [O]S_type [E]xit");
        //Il metodo che salva l'input nella stringa choice.
        //getInput() è definito in AbstractView.
        choice = this.getInput();
    }

    /**
     * Impacchetta una request (in base alla scelta sarà diversa) che invia ai controller tramite il
     * Dispatcher
     */
    public void submit() {    
    	//crea una nuova Request (vedi classe Request)
    	request = new Request();
        switch (choice) {
        case "u":
        	this.request.put("mode", "USERLIST");
        	MainDispatcher.getInstance().callAction("User", "doControl", request);
        	break;
 
        case "e":
        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
        	break;
        	
        case "p":
        	this.request.put("mode", "PACKETLIST");
        	MainDispatcher.getInstance().callAction("Packet", "doControl", request);
        	break;
        	
        case "en":
        	this.request.put("mode", "ENVIRONMENTLIST");
        	MainDispatcher.getInstance().callAction("Environment", "doControl", request);
        	break;
        	
        case "c":
        	this.request.put("mode", "CATEGORYLIST");
        	MainDispatcher.getInstance().callAction("Category", "doControl", request);
        	break;
        	
        case "o":
        	this.request.put("mode", "OSTYPELIST");
        	MainDispatcher.getInstance().callAction("OsType", "doControl", request);
        	break;
        	
        default:
        	
            request.put("choice", choice);
        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }
}
