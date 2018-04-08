#include <stdio.h>
#include <stdlib.h>

void func ( float (*f)(float*, int), float* a, int length);
float sum(float* a, int length);
float product(float* a, int length);
float average(float* a, int length);

int main (){
  //Declare (define) these variables.

  float* a;
  int n, num, i, fun; //Must define all variables used at start of function
  //Ask the user how numbers
  printf("How many numbers? ");

  //Pass scanf the address location of N - which you get by dereferencing it with &
  scanf("%d",&n);

  //Print a new line saying enter N numbers - in this case since n contains a value you only need to pass that
  printf("Enter %d number(s): ", n);
  
  // Now that you know how many numbers you will be reading in (N) allocate an array of size N
  // In C array's have to be initialized by allocating the proper amount of memory in bytes
  // So - since a is of type float* (essentially this means an array of float numbers)
  // you cast your allocated bytes to the type float (float*) at the start
  // malloc is a call to allocate memory at location a - and you need to allocate enough memory
  // to fit N float numbers, so you get the sizeof(float) in bytes and multiply it by N to allocate
  // the proper amount of memory.
  // Side note - in C there is no such thing as Strings. They are arrays of characters
  a = (float*)malloc(sizeof(float) * n);
  
  // Scan in float numbers by passing the location of each index in the array
  for(i = 0; i < n; i++){
	  scanf("%f",&a[i]);
  }
  //The user enters a positive integer. Give it to variable: n
  // Use the built-in function: malloc to allocate n consecutive location of 
  // type float for variable: a
  // Ask the user to enter n decimal numbers and give them to array: a. Do not
  // forget, you need to use: & to read to an element of an array.
  // Prompte the user the following message:
  printf("Enter 1,2,or 3 to calculate the sum, product, or average of the numbers respectively: ");
  // Code based on the number the user enters. If the number entered is:
  // 1 then call func with the argument: sum and two more arguments a and n.
  // 2 then call func with the argument: product and two more arguments a and n. 
  // 3 then call func with the argument: average and two more arguments a and n. 
  // An integer other than 1, 2, or 3 then output the use that only numbers 1, 
  // 2, or 3 should be entered.
  
  scanf("%d", &fun);
  
  // If a user inputs a number other than 1, 2, or 3 then it will continue to ask for a valid
  // number until one is input
  while(fun > 3 || fun < 1) {
	  printf("Please input a correct number - 1, 2, or 3 - ");
	  scanf("%d", &fun);
  }
  
  // Switch statement for the variable fun - aka when fun = 1 do case 1 etc.
  switch(fun) {
	  case 1: func(sum, a, n); break;
	  case 2: func(product, a, n); break;
	  case 3: func(average, a, n); break;
  }

  return 0;
}


// In this function since the return value of the functions called is the answer to be printed
// we can simply run the function in the print statement to print the return value
void func (float (*f)(float *, int), float* a, int length) {
	printf("The result is: %.2f", (*f)(a, length));
}

// Remeber all float* a means is an array of float the equivalent in Java would be float[]
float sum(float* a, int length) {
	int index = 0;
	float sum = 0;
	
	for(index = 0; index < length; index++){
		sum += a[index];
	}
	
	return sum;
}

float product(float* a, int length) {
	int index = 0;
	// The initial product is 1, not 0. If 0 answer will always be 0 because of multiplication by 0
	float product = 1;
	
	for(index = 0; index < length; index++) {
		product *= a[index];
	}
	
	return product;
}

// We already have a function for getting the sum - to get avg just call sum and divide by N
float average(float* a, int length) {
	return sum(a, length) / length;
}