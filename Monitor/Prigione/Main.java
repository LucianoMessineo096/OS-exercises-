public class Main
{
    public static void main(String args[])
    {
        int numDetenuti=10;
        int numGuardie=5;

        Cortile cortile = new Cortile();

        Detenuto detenuti[]=new Detenuto[numDetenuti];
        Guardia guardie[]=new Guardia[numGuardie];

        for(int i=0;i<numDetenuti;i++)
        {
            detenuti[i]=new Detenuto(i,cortile);
            detenuti[i].start();
        }

        for(int j=0;j<numGuardie;j++)
        {
            guardie[j]=new Guardia(j,cortile);
            guardie[j].start();
        }
    }
}