import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class Collection {

    final RandNumber randNumber;
    final CompareNum compareNumber;
    final String numberBuf;

    public Collection(RandNumber randNumber, CompareNum compareNumber){
        this.compareNumber = compareNumber;
        this.randNumber = randNumber;
        numberBuf = randNumber.getNumber();
    }

    public String guess(String input) {
        if (input.length() == 4 && isNumber(input)){
            return compareNumber.compare(numberBuf, input);
        }
        else
            return null;
    }
}
