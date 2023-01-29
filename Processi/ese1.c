#include<stdio.h>
#include<unistd.h>

int main()
{
    pid_t pid1=fork();

    if(pid1==0)
    {
        //child process p1

        //creazione della pipe tra p1 e p3

        int fd1[2]; // standard error
        pipe(fd1);
        int buffer1;

        //creazione del figlio p3

        pid_t pid3=fork();

        if(pid3==0)
        {
            //child process p3

            //p3 invia il proprio pid a p1

            int PID3 = (int)(getpid());

            close(fd1[0]); // standard input

            write(fd1[1] , &PID3,sizeof(PID3));

            printf("p3 ha inviato il proprio pid a p1");
        }
        else
        {
            //parent process p1

            //p1 riceve il pid di p3 e lo legge

            close(fd1[1]); // standard output

            read(fd1[0] , buffer1 , sizeof(buffer1));

            printf("p1 ha ricevuto il pid di p3 : %d",buffer1);
        }


    }
    else
    {
        //parent process p0

        //creazione del figlio p2

        pid_t pid2=fork();


    }


    return 0;
}