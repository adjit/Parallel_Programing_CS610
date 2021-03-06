#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void* MonteCarlo(void*);
float randomNO();
long long int total_in_circle;

typedef struct {
	long long int number_of_tosses;
	long long int* number_in_circle;
	pthread_mutex_t mutex;
} darts;

int main() {
	int thread_count;
	long thread;
	long long int number_of_tosses, number_in_circle = 0;
	double pi_estimate = 0.0;
	darts* data;
	pthread_t* thread_handles;
	pthread_mutex_t mutex;
	total_in_circle = 0;

	printf("How many threads? ");
	scanf("%d", &thread_count);

	printf("How many tosses? ");
	scanf("%lld", &number_of_tosses);

	thread_handles = (pthread_t*)malloc(thread_count * sizeof(pthread_t));
	data = (darts*)malloc(thread_count * sizeof(darts));
	pthread_mutex_init(&mutex, NULL);

	for (thread = 0; thread < thread_count; thread++) {
		data[thread].number_of_tosses = number_of_tosses/thread_count;
		data[thread].number_in_circle = &number_in_circle;
		data[thread].mutex = mutex;

		pthread_create(&thread_handles[thread], NULL, MonteCarlo, &data[thread]);
	}

	for (thread = 0; thread < thread_count; thread++) {
		pthread_join(thread_handles[thread], NULL);
	}

	pi_estimate = 4 * (double)number_in_circle / (double)number_of_tosses;

	printf("PI estimate: %f\n", pi_estimate);

	free(thread_handles);
	return 0;
	
}

void* MonteCarlo(void* args) {
	long long int number_in_circle = 0;
	double x, y, d_squared;
	int toss;

	darts* data = (darts*)args;

	for (toss = 0; toss < data->number_of_tosses; toss++) {
		x = randomNO();
		y = randomNO();
		d_squared = x*x + y*y;

		if (d_squared <= 1) number_in_circle++;
	}
	
	pthread_mutex_lock(&data->mutex);
	*data->number_in_circle += number_in_circle;
	pthread_mutex_unlock(&data->mutex);
	return NULL;
}

float randomNO() {
	return -1+2*((float)rand())/RAND_MAX;
}
