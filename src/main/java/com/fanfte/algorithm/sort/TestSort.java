package com.fanfte.algorithm.sort;

public class TestSort {

    public static void insertSort(int[] arr) {
        int len = arr.length;
        int insertNum;
        for(int i = 0; i < len; i ++) {
            insertNum = arr[i];
            int j = i;
            while(j > 0 && arr[j - 1] > insertNum) {
                arr[j] = arr[j - 1];
                j --;
            }
            arr[j] = insertNum;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {6, 4, 3, 2, 8, 0, 1};
        printArr(arr);
        TestSort.mergeSort(arr, 0, arr.length - 1);
        printArr(arr);

        printArr(arr);
        TestSort.bubbleSort(arr);
        printArr(arr);
    }

    public static void printArr(int[] arr) {
        for(int i = 0;i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selectSort(int[] arr) {
        for(int i = 0;i < arr.length;i++) {
            int value = arr[i];
            int position = i;
            for(int j = i + 1;j <arr.length ;j++) {
                if(arr[j] < value) {
                    value = arr[j];
                    position = j;
                }
            }
            arr[position] = arr[i];
            arr[i] = value;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int middle = getMiddle(arr, low, high);
            quickSort(arr, low, middle - 1);
            quickSort(arr, middle + 1, high);
        }
    }

    public static int getMiddle(int[] arr, int low, int high) {
        int temp = arr[low];
        int left = low;
        while(low < high) {
            while(low < high && arr[high] >= temp) {
                high --;
            }
            while(low < high && arr[low] <= temp) {
                low ++;
            }
            if(low < high) {
                swap(arr, low, high);
            }
        }
        arr[left] = arr[low];
        arr[low] = temp;
        return low;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            if(low < high) {
                mergeSort(arr, low, mid);
                mergeSort(arr, mid + 1, high);
                merge(arr, low, mid, high);
            }
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while( i <= mid && j <= high) {
            if(arr[i] < arr[j]) {
                temp[k ++] = arr[i ++];
            } else {
                temp[k ++] = arr[j ++];
            }
        }
        while(i <= mid) {
            temp[k ++] = arr[i++];
        }
        while(j <= high) {
            temp[k ++] = arr[j++];
        }
        for(int l = 0; l < temp.length;l++) {
            arr[low + l] = temp[l];
        }
    }


    public static void bubbleSort(int[] arr) {
        for(int i = 0;i < arr.length - 1;i ++) {
            for(int j = 0; j < arr.length - i - 1;j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
