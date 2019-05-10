package review.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by George Fouche on 5/3/19.
 */
public class CheckSum {

    public static void main(String[] args) {
        int[] arr= {1,21,3,14,5,60,7,6};
        int value =27;

        System.out.println(Arrays.toString(findSumExp1(arr,value)));
        System.out.println(Arrays.toString(findSumExp2(arr,value)));
    }

    private static int[] findSumExp1(int[] arr, int value) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0 ; i < arr.length;i++){
           int temp = value - arr[i];
           if(map.containsKey(temp)){
               return new int[]{arr[map.get(temp)],arr[i]};
           }else{
               map.put(arr[i],i);
           }
        }
        return new int[0];
    }

    private static int[] findSumExp2(int [] arr, int value){
        Map<Integer,Boolean> map = new HashMap<>();
        int[]result = new int[2];

        for(int i=0; i< arr.length;i++){
            map.put(value-arr[i],true);
        }
        for(int i=0; i<arr.length;i++){
            if(map.containsKey(arr[i])){
                result[0]= arr[i];
                result[1] = value -arr[i];
                return result;

            }
        }
        return result;
    }

}