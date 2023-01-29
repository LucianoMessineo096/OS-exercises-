public class SportelloVeloce extends Thread
{
    
    private Ufficio ufficio;

    public SportelloVeloce(Ufficio ufficio)
    {
        
        this.ufficio=ufficio;
    }

    

    public void run()
    {
        while(true)
        {
            System.out.println("lo sportello veloce sta per servire i clienti");

            ufficio.serviClienteV(this);
        }
        
    }


}