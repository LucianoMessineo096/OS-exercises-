import java.util.LinkedList;

public class Magazzino
{

    private LinkedList<Integer> magazzinoPezzi1 = new LinkedList<Integer>();
    private LinkedList<Integer> magazzinoPezzi2 = new LinkedList<Integer>();
    private int countPezzo1=0;
    private int countPezzo2=0;
    private int MAX1=5;
    private int MAX2=5;


    public synchronized void produci(Produzione unitaP)
    {
        try
        {
            Thread.sleep((int)(Math.random()*1001));
        }catch(InterruptedException e){

            e.printStackTrace();
        }

        System.out.println("il pezzo :"+" "+unitaP.getTipoPezzo()+" "+"e stato prodotto");
    }

    public synchronized void stocca(Produzione unitaP)
    {
    
        if(unitaP.getTipoPezzo()==0)
        {
            while(countPezzo1==MAX1)
            {
                try
                {
                    System.out.println("l'unità di produzione :"+" "+unitaP.getID()+" "+"deve attendere che il magazzino si svuoti del pezzo :"+" "+unitaP.getTipoPezzo());
                    wait();
                }catch(InterruptedException e){

                    e.printStackTrace();
                }

            }

            try
            {
                Thread.sleep((int)(Math.random()*1001));
            }catch(InterruptedException e){

                e.printStackTrace();
            }

            magazzinoPezzi1.add(unitaP.getTipoPezzo());
            countPezzo1++;

            System.out.println("il pezzo :"+" "+unitaP.getTipoPezzo()+" "+"e stato stoccato in magazzino");
        }
        else if(unitaP.getTipoPezzo()==1)
        {
            while(countPezzo1==MAX1)
            {
                try
                {
                    System.out.println("l'unità di produzione :"+" "+unitaP.getID()+" "+"deve attendere che il magazzino si svuoti del pezzo :"+" "+unitaP.getTipoPezzo());
                    wait();
                }catch(InterruptedException e){

                    e.printStackTrace();
                }

            }

            try
            {
                Thread.sleep((int)(Math.random()*1001));
            }catch(InterruptedException e){

                e.printStackTrace();
            }

            magazzinoPezzi2.add(unitaP.getTipoPezzo());
            countPezzo2++;

            System.out.println("il pezzo :"+" "+unitaP.getTipoPezzo()+" "+"e stato stoccato in magazzino");
        }
        else
        {
            System.out.println("ERROR");
        }
        

        notifyAll();
    }

    /*********************************************************************************** */


    public synchronized void prendi(Assemblaggio unitaA)
    {
        if((unitaA.getPezziTipo1Richiesti()>countPezzo1 && unitaA.getPezziTipo2Richiesti()>countPezzo2) || unitaA.getPezziTipo1Richiesti()>countPezzo1 || unitaA.getPezziTipo2Richiesti()>countPezzo2)
        {
            System.out.println("l'unità di assemblaggio : "+" "+unitaA.getID()+" "+"deve attendere che i pezzi si trovino in magazzino");

            try
            {
                wait();

            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }
        else
        {
            for(int i=0;i<unitaA.getPezziTipo1Richiesti();i++)
            {
                magazzinoPezzi1.removeFirst();
                countPezzo1--;
                notifyAll();
            }

            for(int i=0;i<unitaA.getPezziTipo2Richiesti();i++)
            {
                magazzinoPezzi2.removeFirst();
                countPezzo2--;
                notifyAll();
            }



            System.out.println("l'unità di assemblaggio : "+" "+unitaA.getID()+" "+"ha preso :"+" "+unitaA.getPezziTipo1Richiesti()+"pezzi di tipo 1 e :"+" "+unitaA.getPezziTipo2Richiesti()+" "+"pezzi di tipo 2");

            System.out.println("l'unità di assemblaggio : "+" "+unitaA.getID()+" "+"sta per assemblare il prodotto finale");

            try
            {
                Thread.sleep((int)(Math.random()*1001));
            }catch(InterruptedException e){

                e.printStackTrace();
            }

            System.out.println("l'unità di assemblaggio : "+" "+unitaA.getID()+" "+"ha  assemblato il prodotto finale");
        }
    }
}