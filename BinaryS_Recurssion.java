public class BinaryS_Recurssion {
    public static void main(String[] args) {
        int[] arr = {2,1,4,3,6,5};
        int target = 2;
        System.out.println(Search(arr, target, 0, arr.length-1));
    }
    static int Search(int[] arr,int target,int s,int e){
        if (s>e) {
            return -1;
        }int m = s+(e-s)/2;
        if (arr[m]==target) {
            return m;
        }if (arr[m]>target) {
            return Search(arr, target, s, m-1);
        }return Search(arr, target, m+1, e);
    }
}
