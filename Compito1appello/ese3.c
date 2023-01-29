/*
    Si scriva un programma C che istanzi due thread per il riconoscimento di una stringa palindroma.
    • Il thread A restituisce la sequenza di caratteri ottenuta scansionando la stringa dal primo carattere al 
    carattere centrale.
    • Il thread B restituisce la sequenza di caratteri ottenuta scansionando la stringa dall’ultimo carattere al 
    carattere centrale.
    Il programma confronta le due sequenze e determina se la stringa è palindroma.

*/
#include<stdio.h>
#include<pthread.h>
#include<unistd.h>
#include<string.h>

struct thread_args
{
    char* array;
    int bottom;
    int top;
    char* result;

}

void* thread1_function(void* param);
void* thread2_function(void* param);

int main()
{
    char palindroma[]="otto";

    pthread_t thread1;

    int* thread1_returnValue;

    struct thread_args t1_args;
    t1_args.array=palindroma;
    t1_args.bottom=0;
    t1_args.top=1;


    pthread_t thread2;

    int* thread2_returnValue;

    struct thread_args t2_args;
    t2_args.array=palindroma;
    t2_args.bottom=2;
    t2_args.top=4;

    pthread_create(&thread1 , NULL , &thread1_function , &thread1_returnValue);
    pthread_create(&thread2 , NULL , &thread2_function , &thread2_returnValue);

    pthread_join(&thread1,(void**)thread1_returnValue);
    pthread_join(&thread2,(void**)thread2_returnValue);

    //confronto delle stringhe ottenute dalle thread function

    int ret = strncmp(thread1_returnValue , thread2_returnValue , 4);

    if(ret==0)
    {
        printf("le due stringhe comparate sono identiche , dunque la stringa di partenza e palindroma");
    }
}

void* thread1_function(void* param)
{
    struct* thread1_args s = (struct thread1_args) param;

    for(int i=s->bottom;i<s->top;i++)
    {
        s->result[i]=s->array[i];
    }

    return (void*) &(s->result);
}

void* thread2_function(void* param)
{
    struct* thread2_args s = (struct thread1_args) param;

    for(int i=s->bottom;i<s->top;i++)
    {
        s->result[i]=s->array[i];
    }

    return (void*) &(s->result);
}