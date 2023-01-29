#include<stdio.h>
#include<unistd.>
#include<pthread.h>

struct thread_args
{
    char* string;
    int len;
    int start_index , end_index;
}

void* t1_function(void* param);
void* t2_function(void* param);

void palindrome(char res1[] , char res2[]);

int main()
{
    char palindroma[4]="otto";

    pthread_t thread1_id;
    struct thread_args t1_args;
    t1_args.string=palindroma;
    t1_args.len=4;
    t1_args.start_index=0;
    t1_args.end_index=1;

    char t1_returnValue[2];

    pthread_t thread2_id;
    struct thread_args t2_args;
    t2_args.string=palindroma;
    t2_args.len=4;
    t2_args.start_index=2;
    t2_args.end_index=3;

    char t2_returnValue[2];


    pthread_create(&thread1_id,NULL,&t1_function,&t1_args);
    pthread_create(&thread2_id,NULL,&t2_function,&t2_args);


    pthread_join(&thread1_id , (void**) &t1_returnValue);
    pthread_join(&thread2_id,(void**) &t2_returnValue);

    palindrome(t1_returnValue , t2_returnValue);

    return 0;


}

void* t1_function(void* param)
{
    struct t1_args* e = (struct t1_args*) param;

    char momentaneo1[2];

    for(int i=e->start_index ;i<=e->end_index ;i++)
    {
        momentaneo1[i] = e->string[i];
    }

    return (void*) &(momentaneo1);
}

void* t1_function(void* param)
{
    struct t1_args* e = (struct t1_args*) param;

    char momentaneo2[2];

    for(int i=e->end_index ;i>=e->start_index ;i--)
    {
        momentaneo2[i] = e->string[i];
    }

    return (void*) &(momentaneo2);
}


void palindrome(char res1[] , char res2[])
{
    bool flag = false;

    for(int i=0 ; i<2 ; i++)
    {
        if(res1[i]==res2[i])
        {
            flag=true;
        }
        else
        {
            flag=false;
        }
    }

    if(flag==true)
    {
        printf("la stringa e palindroma");
    }
    else
    {
        printf("la stringa non e palindroma");
    }
}