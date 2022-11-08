public class Ternary {
    public static void main(String[] args) {
        int initialNum = 9;
        String answer = "";
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        int currentNum = initialNum;
        System.out.println(initialNum);
        while(currentNum != 0){
            int digit = currentNum % 3;
            if(digit == 0){
                zeroCount++;
            }else if(digit == 1){
                oneCount++;
            }else{
                twoCount++;
            }
            answer = digit + answer;
            currentNum = currentNum / 3;
        }
        System.out.println("Decimal representation: " + initialNum);
        System.out.println("Ternary representation: " + answer);
        System.out.println(zeroCount + " zeroes, " + oneCount + " ones, and " + twoCount + " twos");
        int digitSum = 0 * zeroCount + 1 * oneCount + 2 * twoCount;
        switch (digitSum % 5){
            case 0: System.out.println("The ternary digits sum to a multiple of 5!");
                    break;
            case 1: System.out.println("The ternary digits almost summed to a multiple 5!");
                    break;
            case 4: System.out.println("So close!");
                    break;
            default: System.out.println("Nope!");
                    break;
        }
    }
}
