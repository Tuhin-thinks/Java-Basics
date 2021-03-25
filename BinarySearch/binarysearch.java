class binarysearch{
    public static void main(String [] args){
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int len = arr.length; // length of the array
        int first, last, mid;
        first = 0;
        last = len - 1;
        mid = (int)(first+last)/2;

        int search = 10;

        while (first <= last){
            if(arr[mid] < search){
                first = mid + 1;
            }
            else if(arr[mid] > search){
                last = mid - 1;
            }
            else if(arr[mid] == search){
                System.out.printf("Element -> [%d] found at array index [%d]\n",search,mid);
                break;
            }
            mid = (first + last)/2;


        }
        if(first > last){
            System.out.println("Element not found.");
        }
    }
}