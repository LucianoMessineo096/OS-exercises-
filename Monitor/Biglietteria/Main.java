/*

    Biglietteria
    Si modelli il sistema informatico per la gestione della biglietteria di uno stadio. Per ciascun evento, 
    vengono messi in vendita un numero TOT di biglietti totali che possono essere acquistati presso N 
    diverse rivendite. Ciascun cliente può acquistare fino ad un massimo di MAX biglietti e può scegliere 
    se pagare in contanti o tramite carta di credito (si simuli un tempo per transazione più breve nel 
    secondo caso rispetto al primo).
    A ciascuna rivendita verrà assegnato inizialmente un lotto di L biglietti (L << TOT); se questi si 
    esauriscono, la rivendita potrà rifornirsi, a patto che rimangano ancora biglietti disponibili. Alcune 
    rivendite accettano solo il pagamento mediante carta di credito, mentre altre accettano entrambi i 
    tipi di pagamento, ma daranno precedenza ai clienti che pagano con carta di credito rispetto a quelli 
    che pagano in contanti.
    Si modelli lo scenario descritto mediante thread in linguaggio Java usando il costrutto monitor 
    verificando che la soluzione proposta non presenti rinvio indefinito o deadlock.

*/

public class Main
{
    public static void main(String args[])
    {
        int numClienti=10;
        int numRivendite=5;

        Biglietteria biglietteria = new Biglietteria();

        Cliente clienti[] = new Cliente[numClienti];
        Rivendita rivendite[] = new Rivendita[numRivendite];

        for(int i=0 ; i<numClienti ;i++)
        {
            clienti[i]= new Cliente(i,biglietteria);
            cliente[i].start();
        }

        for(int j=0 ; j<numRivendite ;j++)
        {
            rivendite[j]=new Rivendita(j,biglietteria);
            rivendite[j].start();
        }
    }
}

