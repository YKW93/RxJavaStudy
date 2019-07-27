package Step1.ObservableClass;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class JustMethod {

    public static void main(String args[]) {
        JustMethod justFactoryMethod = new JustMethod();
        justFactoryMethod.justAndSubcribeTest();
    }

    /*
    just 함수는 인자로 넣은 데이터를 차례로 발행하려고 Observable 생성합니다.
    - 실제 데이터 발행은 subscribe()를 호출해야 시작
    - 데이터타입은 모두 동일해야 된다.
     */
    private void justAndSubcribeTest() {

        // dispose() 는 Observable에게 더 이상 데이터를 발행하지 않도록 구독을 해지하는 함수이다.
        Observable.just("Red", "blue", "orange")
                .subscribe(System.out::println).dispose();

        Observable
                .just("Red", "blue", "orange")
                .subscribe(
                        s -> { // onNext
                            System.out.println(s); // System.out::println 람다식으로 변경 가능
                        },
                        throwable -> { // onError
                            System.out.println(throwable.getMessage());
                        }, () -> { // onComplete
                            System.out.println("onComplete");
                        })
                .dispose(); // Observable 구독 해제 (단, onComplete가 성공적으로 발생 됐을 경우 dipose()가 자동으로 호출된다.)


        // 호출 순서 onSubscribe -> onNext - > onComplete
        // subscribe(new Observer<T>) .. 은 Diposable을 반환하지 않아 dispose을 쓰지 않아도 된다.
        Observable
                .just("Red", "blue", "orange")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }

//
//    public void emit6() {
//        AsyncSubject<String> asyncSubject = AsyncSubject.create();
//        asyncSubject.subscribe(data -> System.out.println("첫번째 구독자 : " + data));
//        asyncSubject.onNext(String.valueOf(1));
//        asyncSubject.onNext(String.valueOf(2));
//        asyncSubject.subscribe(data -> System.out.println("두번째 구독자 : " + data));
//        asyncSubject.onNext(String.valueOf(5));
//        asyncSubject.onComplete();
//    }
}
