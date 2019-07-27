package Step1.SubjectClass;

import io.reactivex.subjects.PublishSubject;

public class PublishSubjectClass {

    public static void main(String[] args) {
        PublishSubjectClass publishSubjectClass = new PublishSubjectClass();
        publishSubjectClass.PublishSubjectTest();
    }

    private void PublishSubjectTest() {

        // 오직 해당 시간에 발생한 데이를 구독자에게 전달 받는다.
        PublishSubject<String> publishSubject = PublishSubject.create();
        publishSubject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        publishSubject.onNext("데이터 - 2");
        publishSubject.onNext("데이터 - 3");
        publishSubject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        publishSubject.onNext("데이터 - 4");
        publishSubject.onComplete();

        /*
        결과값
            Subscriber #1 => 데이터 - 2
            Subscriber #1 => 데이터 - 3
            Subscriber #1 => 데이터 - 4
            Subscriber #2 => 데이터 - 4
         */
    }
}
