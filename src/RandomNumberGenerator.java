import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final NumberRange range;
    private final Random random;

    public RandomNumberGenerator(NumberRange range){
        this.range = range;
        this.random = new Random();
    }

    @Override
    public int generate(){
        return random.nextInt(range.getMax() - range.getMin())+ range.getMin();
    }
    @Override
    public NumberRange getRange(){
        return range;
    }
}
