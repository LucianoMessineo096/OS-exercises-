public class Main
{
    public static void main(String args[])
    {
        int numUomini=10;
        int numDonne=10;

        Bagno bagno = new Bagno();

        Uomo uomini[]=new Uomo[numUomini];
        Donna donne[]=new Donna[numDonne];

        for(int i=0;i<numUomini;i++)
        {
            uomini[i]=new Uomo(i,bagno);
            uomini[i].start();
        }

        for(int j=0;j<numDonne;j++)
        {
            donne[j]=new Donna(j,bagno);
            donne[j].start();
        }
    }
}