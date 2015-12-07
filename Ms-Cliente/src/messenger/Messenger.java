
package messenger;


public class Messenger {
    
    public static Conector servidor,cliente;
    public static void main (String[] args){
        VCliente cliente = new VCliente();
        (new Login(cliente)).setVisible(true);
    }
    
    public static void initCliente(String ip)
    {
        cliente = new Conector(ip);
        cliente.start();
    }
    
}
