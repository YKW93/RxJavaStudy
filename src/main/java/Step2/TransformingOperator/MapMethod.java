package Step2.TransformingOperator;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MapMethod {

    public static void main(String[] args) {
        MapMethod mapMethod = new MapMethod();
        mapMethod.mapMethodTest1();
    }

    private void mapMethodTest() {

        // 기본 사용법
        String[] balls = {"1", "2", "3", "4"};
        Observable<String> observable = Observable.fromArray(balls)
                .map(data -> data + "**");
        observable.subscribe(System.out::println);

        // Function 인터페이스를 이용한 사용법
        Function<String, String> function = s -> s + "**";

        String[] balls1 = {"1", "2", "3", "4"};
        Observable<String> observable1 = Observable.fromArray(balls1)
                .map(function);
        observable1.subscribe(System.out::println);

        /*
        결과값
            1**
            2**
            3**
            4**
         */
    }

    private void mapMethodTest1() {
        Function<String, Integer> function = s -> {
            switch (s) {
                case "RED":
                    return 1;
                case "BLUE":
                    return 2;
                case "YELLOW":
                    return 3;
                default:
                    return 4;
            }
        };

        Observable.just("RED", "BLUE", "YELLOW")
                .map(function)
                .subscribe(System.out::println);
    }
}
