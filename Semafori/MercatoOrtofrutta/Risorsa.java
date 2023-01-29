import java.util.*;

public class Risorsa
{
    final int PV=10;//prezzo di vendita per i produttori
    final int PA=12;//prezo di acquisto per i grossisti
    final int MAX=100;//capacità massima del mercato

    int merce;
    int cassa;

    Semaforo sP; //serve per sospendere i thread produttori
    Semaforo sG;//serve per sospendere i thread grossisti
    Semaforo sM;//semaforo mutex

    int sospesiP; // numero di thread produttori in sospensione su sP
    int sospesiG; // numero di thread consumatori in sospensione su sG

    public Risorsa(int M,int C) //costruttore
    {
        sP=new Semaforo(0);
        sG=new Semaforo(0);
        sM=new Semaforo(1);
        merce=M;
        cassa=C;
        sospesiG=0;
        sospesiP=0;
    }

    public void compra(int quintali) //azione eseguita dai grossisti
    {
        int i;
        int prezzo; //prezzo totale

        prezzo=quintali*PA;

        try
        {
            sM.p();

            //inizio sezione critica

            while(quintali>merce)
            {
                sospesiG++;
                sM.v();
                sG.p(); // attesa
                sM.p();
            }

            merce=merce-quintali;
            cassa=cassa+prezzo;

            while(sospesiP>0)
            {
                sP.v();
                sospesiP--;
            }

            sM.v();

            //fine sezione critica
        }catch(InterruptedException e){

            System.out.println("Errore");
        }


        
    }

    public void vendi(int quintali)
        {
            int i;

            int ricavo;//ricavo dalla vendita

            ricavo=quintali*PV;

            try
            {
                sM.p();

                //inizio sezione critica

                while((ricavo>cassa) || (quintali+merce>MAX))
                {
                    sospesiP++;
                    sM.v();
                    sP.p();
                    sM.p();
                }

                merce=merce+quintali;
                cassa=cassa-ricavo;

                while(sospesiG>0)
                {
                    sG.v();
                    sospesiG--;
                }

                sM.v();
            }catch(InterruptedException e){

                System.out.println("errore");
            }
        }
}