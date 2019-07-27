package Step1.SingleClass;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class SingleClassTest {

    public static void main(String args[]) {
        SingleClassTest singleClassTest = new SingleClassTest();
        singleClassTest.singleClassfromObservable();
    }

    private void singleTest() {
        /*

          - SingleClassTest 클래스는 데이터 하나가 발행과 동시에 종료(onSuccess) 된다.
          - 라이프 사이클 관점에서 보면 onNext()와 onComplete() 함수가 onSuccess() 함수로 통합된 것이다.
          * SingleClassTest 클래스는 onSuccess(T value) 함수와 onError() 함수로 구성된다.
        ex) 보통 결과가 유일한 서버 API를 호출할 때 유용하게 사용할 수 있다.

        */

        Single.just("Hello RxJava")
                .subscribe(System.out::println);

        Single.just("Hello RxJava")
                .subscribe(s -> {  // onSuccess
                    // 데이터 발행과 동시에 종료
                    System.out.println(s);
                }, throwable -> { // onError

                });

        Single.just("hello RxJava")
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    private void singleClassfromObservable() {

        // 1. 기존 Observable에서 Single 객체로 변환하기
        Observable<String> observable = Observable.just("Hello RxJava");
        Single.fromObservable(observable)
                .subscribe(System.out::println);

        // 2. single() 함수를 호출해 Single 객체 생성하기
        Observable.just("Hello RxJava")
                .single("default Item")
                .subscribe(System.out::println);

        // 3. first() 함수를 호출해 Single 객체 생성하기
        Observable.just("RED", "YELLOW", "BLUE")
                .first("default Item")
                .subscribe(System.out::println);

        // 4. empty Observable에서 Single 객체 생성하기
        Observable.empty()
                .single("default Item")
                .subscribe(System.out::println);

        // 5. take 함수에서 Single 객체 생성하기
        Observable.just("RED", "YELLOW", "BLUE")
                .take(1)
                .subscribe(System.out::println);
    }
}
