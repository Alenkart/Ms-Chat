
package messenger;
import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import messenger.VServidor;
public class Conector extends Thread {
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int puerto = 8180;
    EntityManager em = javax.persistence.Persistence.createEntityManagerFactory("ms-chatPU").createEntityManager();
    
    public Conector(String nombre)
    {
        super(nombre);
        VServidor.jTextArea1.setText("Servidor ha sido inicializado");
    }
    public void enviarMSG(String msg)
    {
        try{
            this.salida.writeUTF("Servidor: "+msg+"\n");
            VServidor.jTextArea1.setText(VServidor.jTextArea1.getText()+"\n"+"Servidor: "+msg);
            this.guardarMensaje(new Mensajes_1(msg,"Servidor", new Date()));
        }catch (IOException e){};
    }
    
    public void run()
    {
     String text="test";
     try{
         this.ss = new ServerSocket(puerto);
         this.s = ss.accept();
         
         this.entradaSocket = new InputStreamReader(s.getInputStream());
         this.entrada = new BufferedReader(entradaSocket);
         
         this.salida = new DataOutputStream(s.getOutputStream());
            while(true)
            {
                text = this.entrada.readLine();
                if(text != null )
                    VServidor.jTextArea1.setText(VServidor.jTextArea1.getText()+"\n"+text);
                    this.guardarMensaje(new Mensajes_1(text.split(":")[1], text.split(":")[0], new Date()));
//                System.out.println(text);
            }
         }catch (IOException e){
         System.out.println("Algun Tipo de error");
         };
    }
    public String leerMSG()
    {
        try{
            return this.entrada.readLine();
        }catch(IOException e){};
        return null;
    }
    public void desconectar()
    {
        try{
            s.close();
        }catch(IOException e){};
        try{
            ss.close();
        }catch(IOException e){};
    }
    
    public void guardarMensaje(Mensajes_1 msg){
        try{
            msg.setNumero(em.createQuery("SELECT m FROM Mensajes_1 m").getResultList().size()+1);
            em.getTransaction().begin();
            em.persist(msg);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.err.println("Error guardando mensaje");
        }
    }
}
