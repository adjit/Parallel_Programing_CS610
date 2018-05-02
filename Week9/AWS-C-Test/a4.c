//File name: a.c
#include <stdio.h>
#include <omp.h>

int main(){
  int thread_count; 

  printf("How many threads? ");
  scanf("%d", &thread_count);
  printf("Before parallel part.\n");

#pragma omp parallel num_threads(thread_count)
  printf("Hello from thread %d of %d\n", omp_get_thread_num(), omp_get_num_threads());

  printf("After parallel part.\n");

  return 0; 
}
