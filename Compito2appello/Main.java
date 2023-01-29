public class Main
{
    public static void main(String args[])
    {
        int numElettori=10;
        int numCommissioni=2;
        
        Seggio seggio = new Seggio();

        Elettore elettori[]=new Elettore[numElettori];
        Commissione commissioni[]=new Commissione[numCommissioni];
        

        for(int i=0;i<numElettori;i++)
        {
            elettori[i]=new Elettore(i,seggio);
            elettori[i].start();
        }

        for(int j=0;j<numCommissioni;j++)
        {
            commissioni[j]=new Commissione(j,seggio);
            commissione[j].start();
        }
    }
}