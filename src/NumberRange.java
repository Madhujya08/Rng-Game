public class NumberRange {

    private final int min;
    private final int max;

    public NumberRange(int min,int max){
        if (max <= min){
            throw new IllegalArgumentException("Max must be greater than Min.");
        }
        this.min=min;
        this.max=max;
    }
    public int getMin(){
        return min;
    }

    public int getMax(){
        return max;
    }
}

