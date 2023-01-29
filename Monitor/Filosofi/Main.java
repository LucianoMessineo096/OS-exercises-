import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        int numFilosofi=5;
        int numBacchette=5;

        Filosofo filosofi[] = new Filosofo[numFilosofi];
        Bacchetta bacchette[]=new Bacchetta[numBacchette];

        for(int i=0;i<numBacchette;i++)
        {
            bacchette[i]=new Bacchetta(i);
        }

        for(int j=0;j<numFilosofi;j++)
        {
            int sinistra , destra;

            sinistra=j-1;

            if(sinistra<0)
            {
                sinistra = numFilosofi-1;
            }

            destra=j;

            filosofi[j]=new Filosofo(j ,bacchette[sinistra] , bacchette[destra] );

            filosofi[j].start();
        }



    }
}