import java.util.LinkedList;

public class Stabilimento
{
    private LinkedList<Gruppo> codaAbbonati = new LinkedList<Gruppo>();
    private LinkedList<Gruppo> coda = new LinkedList<Gruppo>();
    private LinkedList<Gruppo> spiaggia = new LinkedList<Gruppo>();
    private Gruppo rimossoA;
    private Gruppo rimosso;



    public synchronized void entraCodaAbbonati(Gruppo g)
    {
        coda.add(g);

        System.out.println("il gruppo :"+" "+coda.getFirst()+" "+"e entrato");

        notifyAll();

    }

    public synchronized void entraCoda(Gruppo g)
    {
        coda.add(g);

        System.out.println("il gruppo :"+" "+coda.getFirst()+" "+"e entrato");

        notifyAll();
    }

    public synchronized void serviGruppo(Biglietteria b)
    {

        //controllo che le code siano non vuote

        while(codaAbbonati.size()==0 && coda.size()==0)
        {
            System.out.println("la biglietteria attende l'arrivo dei gruppi");

            try
            {
                wait();
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }

        // entrano i gruppi abbonati

        rimossoA=codaAbbonati.removeFirst();

        System.out.println("la biglietteria sta servendo il gruppo :"+" "+rimosso);

        

        


    }
}