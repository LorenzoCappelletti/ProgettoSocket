/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettosocket;

import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loren
 */
public class Server 
{
    public static void main(String[] args) 
    {
        Socket socket = null;
        ServerSocket serversocket = null;
        try 
        {
            //1) metto in ascolto il server
            ServerSocket serverSocket=new ServerSocket(2000); // ServerSocket stabilisce la connessione con il client 
            System.out.println("Server avviato correttamente");
            
            //2) server in attesa di connessione da parte del client
            socket=serverSocket.accept();
            System.out.println("Server ha accettato la richiesta, connessione avvenuta con il client" +socket.getRemoteSocketAddress());
            
            //3) scambio dati 
            socket.getInputStream();
            socket.getOutputStream();
        } 
        catch (BindException ex)
        {
            System.err.println("Server già avviato!");
        }
        catch (IOException ex) // se non si riesce ad agganciare il server nella porta 2000 si entra nel catch
        {
            System.err.println("errore nella creazione del server e dell'apertura della porta");
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally // viene sempre eseguito, mettere tutto dentro al finally perchè la chiusura va sempre fatta altrimenti i dati non arrivano a destinazione
        {
            //4) chiusura socket
            try 
            {
                if(socket != null)
                {
                      socket.close(); // chiude il canale di comunicazione con l'altro host 
                }
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
