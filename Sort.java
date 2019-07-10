
public class Sort {

    public void bubbleSort (int a[], int n) {
        for (int i = 0 ; i < n ; i++ ) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        } 
    }

    public void insertionSort (int a[], int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n ; i++) {
            int value = a[i];
            int j = i - 1;
            for (;j >= 0 ; j--) {
                if (a[j] > value) {
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    public void selectionSort (int a[], int n) {
        for (int i = 0; i < n ; i++) {
            int min_index = i;
            int min = a[i];
            for (int j = i; j < n; j++) {
                if (a[j] < min) {
                    min_index = j;
                    min = a[j];
                }
            }
            int tmp = a[min_index];
            a[min_index] = a[i];
            a[i] = tmp;
        }
    } 
    
    public void mergeSort (int a[], int n) {
        // p_mergeSort(a,)
        this.mergeSort_c(a,0, n-1);
    }

    private void mergeSort_c (int a[], int start , int end) {
        if (end - start <= 1 ) {
            if (a[start] > a[end]) {
                int tmp = a[end];
                a[end] = a[start];
                a[start] = tmp;
            }
            return;
        }
        int center = (start + end) / 2;
        mergeSort_c(a, start, center);
        mergeSort_c(a, center + 1, end);

        int tmp[] = new int[end - start + 1];

        int j = start;
        int k = center + 1;
        int tmp_index = 0;
        while (j <= center && k <= end) {
            if (a[j] < a[k]) {
                tmp[tmp_index] = a[j++];
            }else {
                tmp[tmp_index] = a[k++];
            }
            tmp_index ++;
        }
        while (j <= center) {
            tmp[tmp_index] = a[j++];
            tmp_index ++;
        }

        while (k <= end) {
            tmp[tmp_index] = a[k++];
            tmp_index ++;
        }

        int list_index = 0;
        for (int z = start; z<= end; z++) {
            a[z] = tmp[list_index];
            list_index ++;
        }
    }

    public void quickSort (int[] a, int n) {
        this.quickSort_c(a, 0, n - 1);
    }

    private void quickSort_c (int[] a, int start, int end) {
        if (start >= end) {return;}
        int center = partition(a, start, end);
        quickSort_c(a, start, center - 1);
        quickSort_c(a, center + 1, end);
    }

    private int partition (int[] a, int start, int end) {
        int value = a[end];
        int i = start; 
        for (int j = start; j <= end - 1; j++) {
            if (a[j] < value) {
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
                i ++;
            }

            for (int h = 0; h < 8 ; h++) {
                System.out.print(a[h] + ",");
            }
            System.out.println();
        }

        int tmp = a[i];
        a[i] = a[end];
        a[end] = tmp;
        return i;
    }


    public static void main(String[] args) {
        int a[] = {2,3,39,6,30,1,7,18};
        // new Sort().bubbleSort(a, 8);
        // new Sort().insertionSort(a, 8);
        // new Sort().selectionSort(a, 8);
        // new Sort().mergeSort(a, 8);
        new Sort().quickSort(a, 8);
        for (int i = 0; i < 8 ; i++) {
            System.out.print(a[i] + ",");
        }
    }
}