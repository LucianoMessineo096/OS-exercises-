public class Main
{
    public static void main(String args[])
    {
        int numGruppi=6;

        Stabilimento stabilimento = new Stabilimento();

        Gruppo gruppi[]=new Gruppo[numGruppi];

        for(int i=0;i<numGruppi;i++)
        {
            gruppi[i]=new Gruppo(i,stabilimento);
            gruppi[i].start();
        }

        Biglietteria biglietteria = new Biglietteria(stabilimento);
    }
}