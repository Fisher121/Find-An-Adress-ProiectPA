package Client;

import Client.Interface.Mainframe;
import Client.api.ClientCommunicationHandler;

public class Main {
    public static void main(String[] args) {
        new Mainframe().setVisible(true);
        System.out.println(ClientCommunicationHandler.getAdress("Bucharest","Alexandria","Romania"));
    }
}
