/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettosocket;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loren
 */
public class Client 
{
    public static void main(String[] args) 
    {
        Socket socket = null;
        try 
        {
            //1) richiesta di connessione al server
            socket = new Socket("127.0.0.1",2000);
            System.out.println("Client ha accettato la richiesta, connessione avvenuta con il client" +socket.getRemoteSocketAddress());
            System.out.println("Porta del Client " +socket.getLocalPort());
        } 
        
        catch (ConnectException ex)
        {
            System.err.println("Errore server non disponibile");
        }
        catch (IOException ex) 
        {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally
        {
            try 
            {
                socket.close(); // da giallo perchè evitiamo di chiudere un oggetto se esso è nullo, prima di chiuderlo controlliamo se socket non è nullo
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

