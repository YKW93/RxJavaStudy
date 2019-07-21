package ObservableClass;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

public class CreateMethod {


    public static void main(String args[]) {
        CreateMethod createFactoryMethod = new CreateMethod();
        createFactoryMethod.createMethodTest();
    }

    /*
    create() 함수는 자동으로 데이터가 발행되는 just() 함수와 달리 onNext(), onComplete(), onError() 같은 알림을 개발자 직접 호출해야 된다.

    * 주의 사항
     - Observable이 구독 해지(dispose)되었을 때 등록된 콜백을 모두 해제해야 합니다. 그렇지 않으면 잠재적으로 메모리 누수(memory leak)가 발생한다.
     - 구독자가 구독하는 동안에만 onNext와 onComplete 이벤트를 호출해야 한다.
     - 에러가 발생했을 때는 오직 onError 이벤트로만 에러를 전달해야 한다.
     - 배압(back pressure)을 직접 처리해야 한다.
         -> TODO 배압에 대해서 공부 필요..
    */

    private void createMethodTest() {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                // 데이터를 차례대로 발행 후 onComplete 실행
                emitter.onNext(100);
                emitter.onNext(200);
                emitter.onNext(400);
                emitter.onComplete();
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        }).dispose(); // 위에서 onComplete()를 실행 했기 때문에 오류가 없는 이상 dispose()를 생략 가능 (왜 생략 가능한지 ? just 함수쪽 참고)


    }
}
