#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <omp.h>

#define ASCIIs		127
#define atmost		1000

void find(int count[], char letters[], int start, int end);

int main()
{
	char letters[atmost+1];
	int total_count[ASCIIs];

	int i, thread_count, n;
	int count[ASCIIs], my_rank, segment, p;

	printf("Enter a line not larger than 1000 characters.\n");
	fgets(letters, atmost, stdin);
	
	printf("How many segments?: ");
	scanf("%d", &thread_count);

	while(strlen(letters) % thread_count != 0) strcat(letters, " ");

	n = strlen(letters);

	for(i = 0; i < ASCIIs; i++)
		total_count[i] = 0;

	segment = n / thread_count;

	#pragma omp parallel num_threads(thread_count)
	{
		int rank, start, end;

		rank = omp_get_thread_num();

		start = rank*segment;
		end = start+segment;

		find(count, letters, start, end);

		for(i = 0; i < ASCIIs; i++) {
			if(count[i] != 0) {
				#pragma omp critical
					total_count[i] += count[i];
			}			
		}
			
	}

	for(i = 33; i < ASCIIs; i++) {
		if(total_count[i] != 0)
			printf("Number of %c is: %d\n", i, total_count[i]);
	}

	return 0;
}

void find(int count[], char letters[], int start, int end)
{
	int i;
	for(i = 0; i < ASCIIs; i++)
		count[i] = 0;
	for(i = start; i < end; i++)
		count[(int)letters[i]]++;
}
