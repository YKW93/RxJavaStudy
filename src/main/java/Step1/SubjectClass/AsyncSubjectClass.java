package Step1.SubjectClass;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectClass {

    public static void main(String args[]) {
        AsyncSubjectClass asyncSubjectClass = new AsyncSubjectClass();
        asyncSubjectClass.AsyncSubjectTest2();
    }

    private void AsyncSubjectTest() {
        AsyncSubject<String> asyncSubject = AsyncSubject.create();
        asyncSubject.subscribe(s -> System.out.println("Subscriber #1 => " + s)); // 구독 시작
        asyncSubject.onNext("1");
        asyncSubject.onNext("2");
        asyncSubject.subscribe(s -> System.out.println("Subscriber #2 => " + s)); // 구독 시작
        asyncSubject.onNext("3");
        asyncSubject.onComplete(); // 이때 마지막으로 입력된 값이 구독자에게 전달된다.
        asyncSubject.onNext("4");// onComplete 이후의 onNext()는 무시 된다.

        /*

        결과값
            Subscriber #1 => 3
            Subscriber #2 => 3

         */
    }

    private void AsyncSubjectTest2() {
        Float[] temperature = {10.1f, 20.2f, 30.3f};
        Observable<Float> observable = Observable.fromArray(temperature);

        AsyncSubject<Float> subject = AsyncSubject.create();
        subject.subscribe(System.out::println); // subject에 대한 구독 시작

        // Subject 클래스가 Observable을 상속하고 동시에 Observer 인터페이스를 구현하기 때문에 밑에 구문이 동작 가능.
        observable.subscribe(subject); // observable는 데이터를 발행하고 subject는 마지막 데이터를 가져옴.

        /*
        결과값
            30.3
         */
    }
}
