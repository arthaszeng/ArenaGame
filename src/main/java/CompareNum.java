import static java.lang.String.format;

public class CompareNum {
    public static String compare(String inputNum, String srcNum) {
        int aCount = 0;
        int countainedCount = 0;

        for (int index = 0; index < inputNum.length(); index++){
            if (inputNum.charAt(index) == srcNum.charAt(index)){
                aCount++;
            }
            if (srcNum.indexOf(inputNum.charAt(index)) != -1){
                countainedCount++;
            }
        }

        return String.format("%dA%dB", aCount, countainedCount - aCount);
    }
}
