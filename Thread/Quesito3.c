/* Quesito 3 : recupero prova in itinere (ulteriori 30 minuti)
Si scriva un programma C che istanzi due thread per il riconoscimento di una stringa palindroma.
• Il thread A restituisce la sequenza di caratteri ottenuta scansionando la stringa dal primo carattere al
carattere centrale.
• Il thread B restituisce la sequenza di caratteri ottenuta scansionando la stringa dall’ultimo carattere al
carattere centrale.
Il programma confronta le due sequenze e determina se la stringa è palindroma. */




#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <pthread.h>

// function thread args
struct thread_args{
	int len;
	char* str;
	char* returnStr;
};

// thread function
void* threadFunction(void* params){
	struct thread_args* args = (struct thread_args*) params;
	for (size_t i = 0; i < args->len/2; i++) {
		*args->returnStr[i] = args->*str[i];
	}
	return (void*) &args->returnStr[0];
}

int main(){
	char str[10];
	printf("%s\n", "Inserire una stringa");
	scanf("%s", str);

	int i = 0;
	int len = 0;
	while (str[i] != *"\0") {
		len++;
		i++;
	}

	pthread_t thread1_id, thread2_id;

	struct thread_args thread1_args;
	thread1_args.len = len;
	thread1_args.str = &str[0];

	struct thread_args thread2_args;
	thread2_args.len = len;
	thread2_args.str = &str[len];

	pthread_create(&thread1_id, NULL, &threadFunction, &thread1_args);
	pthread_create(&thread2_id, NULL, &threadFunction, &thread2_args);

	char thread1_returnValue[5];
	char thread2_returnValue[5];

	pthread_join(thread1_id, (void**) thread1_returnValue);
	pthread_join(thread2_id, (void**) thread2_returnValue);

	return 0;
}
