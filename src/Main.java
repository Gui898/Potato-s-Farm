import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {5,9,1,7,3,4,7,6,10};

//        SELECTION SORT
//
//        for (int j = 0; j < arr.length; j++) {
//            for (int i = 0; i < arr.length; i++) {
//
//                int atual = arr[i];
//                int posterior = 0;
//
//                if(i+1 < arr.length){
//                    posterior= arr[i+1];
//                }else {
//                    break;
//                }
//
//                if (posterior < atual){
//                    arr[i] = posterior;
//                    arr[i+1] = atual;
//                }
//            }
//        }
//

        System.out.println(Arrays.toString(arr));

    }
}