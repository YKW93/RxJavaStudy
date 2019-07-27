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
