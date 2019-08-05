package Step2.FilterOperator;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Predicate;

public class FilterMethod {

    public static void main(String[] args) {
        FilterMethod filterMethod = new FilterMethod();
        filterMethod.filterSimilarMethodTest();
    }

    private void filterMethodTest() {

        // filter 함수를 통해 참을 반환하는 값만 subscribe를 통해 데이터를 출력 하게 된다.
        String[] objs = {"1 CIRCLE", "2 DIAMOND", "3 TRIANGLE", "4 DIAMOND", "5 CIRCLE", "6 HEXAGON"};
        Observable.fromArray(objs)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.endsWith("CIRCLE");
                    }
                })
                .subscribe(System.out::println);
        /*
        결과값
            1 CIRCLE
            5 CIRCLE
         */
    }

    private void filterSimilarMethodTest() {
        Integer[] numbers = {100, 200, 300, 400, 500};
        Single<Integer> single;
        Observable<Integer> source;

        // 1. first 사용
        single = Observable.fromArray(numbers).first(-1); // 값을 못가져올 경우 -1 출력
        single.subscribe(data -> System.out.println("first() value = " + data)).dispose();

        // 2. last 사용
        single = Observable.fromArray(numbers).last(999);
        single.subscribe(data -> System.out.println("last() value = " + data)).dispose();

        // 3. take(N) 사용
        source = Observable.fromArray(numbers).take(3);
        source.subscribe(data -> System.out.println("take(3) value = " + data)).dispose();

        // 4. takeLast(N) 사용
        source = Observable.fromArray(numbers).takeLast(3);
        source.subscribe(data -> System.out.println("takeLast(3) value = " + data)).dispose();

        // 5. skip(N) 사용
        source = Observable.fromArray(numbers).skip(2);
        source.subscribe(data -> System.out.println("skip(2) values = " + data)).dispose();

        // 6. skipLast(N) 사용
        source = Observable.fromArray(numbers).skipLast(2);
        source.subscribe(data -> System.out.println("skipLast(2) values = " + data)).dispose();

        /*
        결과값
        first() value = 100
        last() value = 500
        take(3) value = 100
        take(3) value = 200
        take(3) value = 300
        takeLast(3) value = 300
        takeLast(3) value = 400
        takeLast(3) value = 500
        skip(2) values = 300
        skip(2) values = 400
        skip(2) values = 500
        skipLast(2) values = 100
        skipLast(2) values = 200
        skipLast(2) values = 300
         */
    }
}
