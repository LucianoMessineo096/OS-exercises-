public class Filosofo extends Thread
{
    private int ID;
    private Bacchetta bacchettaSinistra;
    private Bacchetta bacchettaDestra;

    int NSEC=2;

    public Filosofo(int ID , Bacchetta sinistra , Bacchetta destra)
    {
        this.ID=ID;
        this.setName("Filosofo #"+ID);
        this.bacchettaSinistra=sinistra;
        this.bacchettaDestra=destra;
    }

    public void pensa()
    {
        System.out.println("il filosofo"+this.getName()+"sta pensando");

        try
        {
            Thread.sleep(Math.round(Math.random()* NSEC *1000));
        }catch(InterruptedException e){

            e.printStackTrace();
        }
    }

    public void prendeBacchetta()
    {
        System.out.println(this.getName() + "ha fame");

        System.out.println(this.getName() + "sta cercando di prendere la bacchetta"+ bacchettaSinistra.bacchettaNum+"alla sua sinistra");

        bacchettaSinistra.prende();

        System.out.println(this.getName()+"ha preso la bacchetta" + bacchettaSinistra.bacchettaNum);

        System.out.println(this.getName() + "sta cercando di prendere la bacchetta"+ bacchettaDestra.bacchettaNum+"alla sua destra");

        bacchettaDestra.prende();

        System.out.println(this.getName()+"ha preso la bacchetta" + bacchettaDestra.bacchettaNum);


    }

    public void mangia()
    {
        System.out.println("il filosofo"+this.getName()+"sta mangiando");

        try
        {
            Thread.sleep(Math.round(Math.random()* NSEC *1000));
        }catch(InterruptedException e){

            e.printStackTrace();
        }
    }

    public void lasciaBacchetta()
    {
        
        System.out.println(this.getName() + "rilascia la bacchetta"+ bacchettaSinistra.bacchettaNum+"alla sua sinistra");

        bacchettaSinistra.rilascia();


        System.out.println(this.getName() + "rilascia la bacchetta"+ bacchettaDestra.bacchettaNum+"alla sua destra");

        bacchettaDestra.rilascia();

        


    }

    public void run()
    {
        while(true)
        {
            this.pensa();

            if(this.ID %2==0)
            {
                //filosofo indice pari

                this.prendeBacchetta();

                this.mangia();

                this.lasciaBacchetta();
            }
            else
            {
                //filosofo indice dispari

                this.prendeBacchetta();

                this.mangia();

                this.lasciaBacchetta();
            }
        }

    }
}