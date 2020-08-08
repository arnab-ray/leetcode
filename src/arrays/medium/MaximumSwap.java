package arrays.medium;

public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] numArray = Integer.toString(num).toCharArray();

        int maxPos = numArray.length - 1;
        int[] pos = new int[numArray.length];

        for (int i = numArray.length - 1; i >= 0; i--) {
            if (numArray[i] > numArray[maxPos]) {
                maxPos = i;
                pos[i] = maxPos;
            } else if (numArray[i] < numArray[maxPos]) {
                pos[i] = maxPos;
            } else {
                pos[i] = i;
            }
        }

        for(int i = 0; i < numArray.length; i++) {
            if(pos[i] > i) {
                char temp = numArray[i];
                numArray[i] = numArray[pos[i]];
                numArray[pos[i]] = temp;

                break;
            }
        }


        String number = new String(numArray);
        return Integer.parseInt(number);
    }
}
