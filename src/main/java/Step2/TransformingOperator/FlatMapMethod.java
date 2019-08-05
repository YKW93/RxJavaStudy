package Step2.TransformingOperator;

import java.util.Scanner;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

public class FlatMapMethod {

    public static void main(String[] args) {
        FlatMapMethod flatMapMethod = new FlatMapMethod();
        flatMapMethod.test();
    }

    private void flatMapTest() {
        Function<String, Observable<String>> function = s -> Observable.just(s + "*", s + "**");

        String[] balls = {"1", "2", "3"};
        Observable.fromArray(balls)
                .flatMap(function)
                .subscribe(System.out::println);
    }

    // 구구단
    private void test() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input : ");
        int dan = Integer.parseInt(scanner.nextLine());

        // map 방식 사용
        Observable.range(1, 9)
                .map(data -> dan + "*" + data + "=" + dan * data)
                .subscribe(System.out::println);

        // flatMap 방식 사용
        Function<Integer, Observable<String>> function = integer -> Observable.just(dan).map(data -> data + "*" + integer + "=" + dan * integer);

        Observable.range(1, 9)
                .flatMap(function)
                .subscribe(System.out::println);

        // flatMap(1) 방식 사용
        Observable.just(dan)
                .flatMap(data -> Observable.range(1, 9)
                .map(row -> data + "*" + row + "=" + data * row))
                .subscribe(System.out::println);

        // flatMap - BiFunction 사용
        Observable<String> source = Observable.just(dan)
                .flatMap(gugu -> Observable.range(1, 9), new BiFunction<Integer, Integer, String>() {
                    @Override
                    public String apply(Integer gugu, Integer i) throws Exception {
                        return gugu + " * " + i + " = " + gugu*i;
                    }
                });
        source.subscribe(System.out::println).dispose();

    }
}
