package Step3.CreatingOperator;

import java.util.concurrent.TimeUnit;

import Step3.utils.CommonUtils;
import Step3.utils.Log;
import io.reactivex.Observable;

public class IntervalMethod {

    public static void main(String[] args) {
        IntervalMethod intervalMethod = new IntervalMethod();
        intervalMethod.intervalMethodTest();
    }

    private void intervalMethodTest() {
        // interval 함수는 별도의 스레드 에서 돌기 때문에 해당 스레드가 종료될때 까지 기다려야 하기 때문에
        // sleep을 호출한다.

        CommonUtils.exampleStart();

        Observable<Long> observable = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(data -> (data + 1) * 100)
                .take(5);

        observable.subscribe(Log::it);

        CommonUtils.sleep(1000);
    }
}
