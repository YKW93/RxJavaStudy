package MaybeClass;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;

public class MaybeClassTest {

    public static void main(String args[]) {
        MaybeClassTest maybeClassTest = new MaybeClassTest();
        maybeClassTest.maybeTest();
    }

    private void maybeTest() {
        /*

        Single 클래스와 마찬가지로 최대 데이터 하나를 가질 수 있지만 데이터 발행 없이 바로 데이터 발생을 완료(Single 클래스는 1개 완료, Maybe 클래스는 0 혹은 1개 완료) 할 수 있다.
        즉, Maybe 클래스는 Single 클래스에 onComplete 이벤트가 추가된 형태이다.


         */

        Maybe<String> maybe = Maybe.empty();

        maybe.subscribe(new MaybeObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            // 정상적으로 String 값이 넘어올 경우 호출됨. ex) Maybe.just("Hello Rxjava");
            @Override
            public void onSuccess(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            // 데이터가 없을 경우 호출됨. ex) Maybe.empth();
            @Override
            public void onComplete() {
                System.out.println("완료");
            }
        });
    }
}
