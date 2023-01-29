/************************ */

// @author :Luciano Messineo 0682968

/************************** */

public class Main
{
    public static void main(String args[])
    {
        int numClienti=10;
        int numSportelli=10;

        Ufficio ufficio=new Ufficio();

        Cliente clienti[]=new Cliente[numClienti];
        Sportello sportelli[] = new Sportello[numSportelli];

        for(int i=0;i<numClienti;i++)
        {
            clienti[i]=new Cliente(i,ufficio);
            clienti[i].start();
        }

        for(int j=0;j<numSportelli;j++)
        {
            sportelli[j]=new Sportello(j,ufficio);
            sportelli[j].start();
        }

    }
}