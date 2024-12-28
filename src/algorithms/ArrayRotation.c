#include<stdio.h>
#include<stdlib.h>

void rotateArray(int d, int arr[], int length, int i, int replacedKey,int count){
    if (count == length) { 
        return;
    }
        int t = arr[(i+d)%length];
        arr[(i+d)%length] = replacedKey;
     rotateArray(d,arr,length,(i+d)%length,t,count+1);
}

int binarySearchRotated(int arr[],int start,int end ,int value) {
    if (start> end) {
        return -1; 
    }
    int mid=start + (end-start)/2; 
    if (arr[mid]==value) {
        return mid;
    }
    if (arr[start]<= arr[mid]) { 
        if (arr[start]<= value && value <=arr[mid]) {
            return binarySearchRotated(arr, start, mid - 1, value);
        } else {
            return binarySearchRotated(arr, mid + 1, end, value);
        }
    } else {
        if (arr[mid]<=value && value<= arr[end]) {
            return binarySearchRotated(arr, mid + 1, end, value);
        } else {
            return binarySearchRotated(arr, start, mid - 1, value);
        }
    }
}

int main(){
    int arr[] = {1,2,3,4,5,6,7,8,9};
    int length = sizeof(arr) / sizeof(arr[0]);
    int value = 2;
    //Test case 0
    if (value == arr[binarySearchRotated(arr,0,length-1,value)]) {
           printf("Value found");
       } else{
            printf("Value not found");
       }
    //Test case 1
    printf("\n");
    rotateArray(5, arr, length, 0, arr[0], 0);
    if (value == arr[binarySearchRotated(arr,0,length-1,value)]) {
        printf("Value found");
    } else{
        printf("Value not found");
    }
    //Test case 2
    // printf("\n");
    // rotateArray(8, arr, length, 0, arr[0], 0);
    // if (value == arr[binarySearchRotated(arr,0,length-1,value)]) {
    //     printf("Value found");
    // } else{
    //     printf("Value not found");
    // }
    //Test case 3
    // printf("\n");
    // rotateArray(4, arr, length, 0, arr[0], 0);
    // if (value == arr[binarySearchRotated(arr,0,length-1,value)]) {
    //     printf("Value found");
    // } else{
    //     printf("Value not found");
    // }
    return 0;
}