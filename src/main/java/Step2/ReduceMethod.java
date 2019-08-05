package Step2;


import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;


public class ReduceMethod {

    public static void main(String args[]) {
        ReduceMethod reduceMethod = new ReduceMethod();
        reduceMethod.reduceMethodTest();
    }

    private void reduceMethodTest() {
        String[] balls = {"1", "3", "5"};
        Maybe<String> source = Observable.fromArray(balls)
                .reduce(new BiFunction<String, String, String>() {
                    @Override
                    public String apply(String s, String s2) throws Exception {
                        return s2 + "(" + s + ")";
                    }
                });
        source.subscribe(System.out::println).dispose();
    }
}
