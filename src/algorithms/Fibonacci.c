#include<stdio.h>
#include<stdlib.h>

long long** multiplly(long long** A, long long** B) {
    long long** result = (long long**)malloc(2*sizeof(long long*));
    for (long long i = 0; i < 2; i++) {
        result[i] = (long long*)malloc(2*sizeof(long long));
    }
    result[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0];
    result[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
    result[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
    result[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1];
    return result;
}

long long** power(long long n) {
    long long** result = (long long**)malloc(2*sizeof(long long*));
    long long** M = (long long**)malloc(2*sizeof(long long*));
    for (long long i = 0; i < 2; i++) {
        result[i] = (long long*)malloc(2*sizeof(long long));
        M[i] = (long long*)malloc(2*sizeof(long long));
    }
    result[0][0] = 1;
    result[0][1] = 0;
    result[1][0] = 0;
    result[1][1] = 1;
    M[0][0] = 1;
    M[0][1] = 1;
    M[1][0] = 1;
    M[1][1] = 0;
    while(n>0){
    if (n % 2 == 1) {
        result = multiplly(result, M);
    }
    M = multiplly(M,M);
    n = n/2;
    }
    return result;
}


long long fib(int n){
    if(n ==0) return 1;
    if(n ==1) return 1;
    long long** result = power(n-1);
    return result[0][0];
}

int main(){
    printf("%d",fib(46));
    return 0;
}