import java.util.LinkedList;

public class Falegnameria
{
    private LinkedList<Integer> magazzinoCa = new LinkedList<Integer>();
    private LinkedList<Integer> magazzinoCb = new LinkedList<Integer>();
    private LinkedList<Integer> magazzinoCc = new LinkedList<Integer>();

    private int MAX1=4;

    public synchronized void produci(Produzione p)
    {
        
        if(p.getID()==1 && p.getTipoPezzo()==1)
        {
            if(magazzinoCa.size()==MAX1)
            {
                System.out.println("l'unita di produzione 1 attende che il magazzino Ca si liberi");

                try
                {
                    wait();
                }catch(InterruptedException e){

                    e.printStackTrace();
                }
            }

            System.out.println("l'unita di produzione 1 sta producendo i pezzi di tipo 1");

            try
            {
                Thread.sleep((int)(Math.random()*2001));
            }catch(InterruptedException e){

                e.printStackTrace();
            }

            for(int i=0;i<4;i++)
            {
                magazzinoCa.addFirst(1);
            }

            notifyAll();
            
            System.out.println("l'unita he inserito i pezzi nel magazzino Ca");



        }
        else if(p.getID()==2 && p.getTipoPezzo()==2)
        {
            if(magazzinoCb.size()==MAX1)
            {
                System.out.println("l'unita di produzione 2 attende che il magazzino Cb si liberi");

                try
                {
                    wait();
                }catch(InterruptedException e){

                    e.printStackTrace();
                }
            }

            System.out.println("l'unita di produzione 2 sta producendo i pezzi di tipo 2");

            try
            {
                Thread.sleep((int)(Math.random()*2001));
            }catch(InterruptedException e){

                e.printStackTrace();
            }

            for(int i=0;i<4;i++)
            {
                magazzinoCb.addFirst(3);
            }

            notifyAll();
            
            System.out.println("l'unita ha inserito i pezzi nel magazzino Cb");
        }
        else if(p.getID()==3 && p.getTipoPezzo()==3)
        {
            if(magazzinoCc.size()==MAX1)
            {
                System.out.println("l'unita di produzione 3 attende che il magazzino Cc si liberi");

                try
                {
                    wait();
                }catch(InterruptedException e){

                    e.printStackTrace();
                }
            }

            System.out.println("l'unita di produzione 3 sta producendo i pezzi di tipo 3");

            try
            {
                Thread.sleep((int)(Math.random()*2001));
            }catch(InterruptedException e){

                e.printStackTrace();
            }

            for(int i=0;i<4;i++)
            {
                magazzinoCc.addFirst(3);
            }

            notifyAll();
            
            System.out.println("l'unita ha inserito i pezzi nel magazzino Cc");
        }
        else
        {
            //System.out.println("errore");
        }
    }


    public synchronized void prendi(Assemblaggio a)
    {
        if(magazzinoCa.size()==0 || magazzinoCb.size()==0 || magazzinoCc.size()==0)
        {
            System.out.println("l'unita di assemblaggio"+" "+a.getID()+" "+"attende che 1 dei magazzini si riempia");

            try
            {
                wait();
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }

        for(int i=0;i<a.getPezziTipo1();i++)
        {
            magazzinoCa.removeFirst();
        }

        for(int j=0;j<a.getPezziTipo2();j++)
        {
            magazzinoCb.removeFirst();
        }

        for(int k=0;k<a.getPezziTipo3();k++)
        {
            magazzinoCc.removeFirst();
        }

        notifyAll();

        System.out.println("l'unita di assemblaggio"+" "+a.getID()+" "+"ha preso tutti i pezzi dai magazzini");


    }


    public synchronized void assembla(Assemblaggio a)
    {
        System.out.println("l'unita di assemblaggio"+" "+a.getID()+" "+"sta assemblando il pezzo");

        try
        {
            Thread.sleep((int)(Math.random()*2001));
        }catch(InterruptedException e){

            e.printStackTrace();
        }

        System.out.println("l'unita di assemblaggio"+" "+a.getID()+" "+"ha terminato");
    }

}