import java.util.concurrent.*;

public class Mercato
{
    public static void main(String args[])
    {
        
        final int NP=3; //numero di produttori
        final int NG=3; //numero di grossisti
        final int MERCE=9;//quintali inizialmente nel mercato
        final int CASSA=50;//soldi disponibili in cassa


        Risorsa R = new Risorsa(MERCE,CASSA); // istanzio un nuovo oggetto risorsa

        System.out.println("\n SISTEMA AVVIATO: ci sono"+MERCE+"quintali e"+CASSA+"Euro...\n");

        ThreadP []TP=new ThreadP[NP]; //thread produttori
        ThreadG []TG=new ThreadG[NG]; //thread grossisti


        for(int i=0 ; i<NP;i++)
        {
            TP[i]=new ThreadP(R);
        }

        for(int j=0;j<NG;j++)
        {
            TG[j]=new ThreadG(R);
        }

        for(int k=0;k<NP;k++)
        {
            TP[k].start();
        }

        for(int z=0;z<NG;z++)
        {
            TG[z].start();
        }
    }
}