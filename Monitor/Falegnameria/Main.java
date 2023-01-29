public class Main
{
    public static void main(String args[])
    {
        int numProduzioni=3;
        int numAssemblaggi=5;

        Falegnameria falegnameria = new Falegnameria();

        Produzione produzioni[] = new Produzione[numProduzioni];
        Assemblaggio assemblaggi[]= new Assemblaggio[numAssemblaggi];

        for(int i=0;i<numProduzioni;i++)
        {
            produzioni[i]= new Produzione(i,falegnameria);
            produzioni[i].start();
        }

        for(int j=0;j<numAssemblaggi;j++)
        {
            assemblaggi[j]=new Assemblaggio(j,falegnameria);
            assemblaggi[j].start();
        }
    }
}