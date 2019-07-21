package ObservableClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

import io.reactivex.Observable;

public class FromXXXMethod {

    public static void main(String args[]) {
        FromXXXMethod fromArrayMethod = new FromXXXMethod();
        fromArrayMethod.fromCallableTest();
    }

    /*
    fromXXX() 계열 함수는 단일 데이터를 다루는 just(), create() 달리 배열 혹은 리스트 데이터들을 처리하는데 유용하다.

    * 주의 사항
     - Observable이 구독 해지(dispose)되었을 때 등록된 콜백을 모두 해제해야 합니다. 그렇지 않으면 잠재적으로 메모리 누수(memory leak)가 발생한다.
     - 구독자가 구독하는 동안에만 onNext와 onComplete 이벤트를 호출해야 한다.
     - 에러가 발생했을 때는 오직 onError 이벤트로만 에러를 전달해야 한다.
     - 배압(back pressure)을 직접 처리해야 한다.
         -> TODO 배압에 대해서 공부 필요..
    */

    private void fromArrayMethodTest() {
        Integer[] integers = {100, 200, 300};
        Observable<Integer> source = Observable.fromArray(integers);
        source.subscribe(System.out::println).dispose();

        /*
        * int[] 배열은 어떻게 처리 할 수 있을까?

        int[] intArray = {100, 200, 300};
        Observable.fromArray(intArray).subscribe(System.out:println).dipose();
        -> 실행 결과 : 실제 데이터들의 주소값이 출력되는 문제 발생..

        - 해결 방법 : RxJava에서 int 배열을 인식시키려면 Integer[]로 변환해야 한다.

        private static Integer[] toIntegerArray(int[] intArray) {
            return IntStream.of(intArray).boxed().toArray(Integer[]::new);
        }

        int[] intArray = {100, 200, 300};
        Observable.fromArray(toIntegerArray(intArray).subscribe(System.out:println).dipose();
        */
    }

    private void fromIterableTest() {

        // Iterable<E> 인터페이스를 구현하는 대표적인 클래스는
        // ArrayList(List 인터페이스), BlockingQueue (BlockingQueue 인터페이스), HashSet(Set 인터페이스), LinkedList, Stack, TreeSet, Vector 등이 있다.

        List<String> listData = new ArrayList<>();
        listData.add("RED");
        listData.add("BLUE");
        listData.add("ORANGE");
        Observable<String> source = Observable.fromIterable(listData);
        source.subscribe(System.out::println);

        Set<String> setData = new HashSet<>();
        setData.add("RED");
        setData.add("BLUE");
        setData.add("ORANGE");
        Observable<String> source1 = Observable.fromIterable(setData);
        source1.subscribe(System.out::println);
    }

    private void fromCallableTest() {

        // 자바 5에서 추가된 동시성 API인 Callable도 fromCallable() 함수를 이용해 Observable를 만들 수 있다.

        /*
        Callable (스레드풀에서 사용) VS Runnable (스레드에서 사용)
        - Callable이 Generic으로 받은 Return 타입으로, return을 하는데 반해서, Runnable은 return 값이 없다.
        - Callable이 Exception을 낼 수 있는데 반해서, Runnable은 그럴 수 없다.
        - Callable(자바 1.5)이 Runnable(자바 1.0)의 확장형 개념
        */

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "hello RxJava";
            }
        };

        Observable.fromCallable(callable).subscribe(System.out::println);
    }
}
