public class Main
{
    public static void main(String args[])
    {
        int numUnitaProduzione=5;
        int numUnitaAssemblaggio=5;
        int pezziRichiestiTipo1;
        int pezziRichiestiTipo2;

        Magazzino magazzino=new Magazzino();

        Produzione produzioni[]=new Produzione[numUnitaProduzione];
        Assemblaggio assemblaggi[]=new Assemblaggio[numUnitaAssemblaggio];

        for(int i=0;i<numUnitaAssemblaggio;i++)
        {
            pezziRichiestiTipo1=(int)(Math.random()*4);
            pezziRichiestiTipo2=(int)(Math.random()*4);

            assemblaggi[i]=new Assemblaggio(i,magazzino , pezziRichiestiTipo1 , pezziRichiestiTipo2);
            assemblaggi[i].start();
        }

        for(int j=0;j<numUnitaProduzione;j++)
        {
            produzioni[j]=new Produzione(j,magazzino);
            produzioni[j].start();
        }
    }
}