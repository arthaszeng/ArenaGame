import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class CollectionOps {

    final RandNumber randNumber;
    final CompareNum compareNumber;

    public CollectionOps(RandNumber randNumber, CompareNum compareNumber){
        this.compareNumber = compareNumber;
        this.randNumber = randNumber;
    }

    public String guess(String input) {
        if (input.length() == 4 && isNumber(input)){
            return compareNumber.compare(randNumber.getNumber(), input);
        }
        else
            return null;
    }
}
