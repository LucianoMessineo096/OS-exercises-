public class Biglietteria
{
    private Stabilimento stabilimento;

    public Biglietteria(Stabilimento)
    {
        this.stabilimento=stabilimento;
    }

    public void run()
    {
        while(true)
        {
            System.out.println("la biglietteria sta per servire un gruppo");
            stabilimento.serviGruppo(this);
        }
    }
}