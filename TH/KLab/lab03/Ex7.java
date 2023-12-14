public class Ex7 {
    
    public static int minArray(int[] arr, int size) {
        if(size == 1) return arr[0];
        int rs = minArray(arr, size - 1);
        return (rs < arr[size - 1]) ? rs : arr[size - 1];
     }
     public static int sumArray(int[] arr, int size) {
         if(size == 1)   return arr[0];
         return arr[size -1] + sumArray(arr, size -1); 
     }
     public static int countEvenArray(int[] arr, int size) {
         if(size == 0)  return 0;
         else{
             int count = countEvenArray(arr, size - 1);
             if(arr[size - 1]%2 == 0)
                 count++;
             return count;
         }
     }
}
