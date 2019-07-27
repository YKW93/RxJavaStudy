package Step1.SubjectClass;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectClass {

    public static void main(String[] args) {
        ReplaySubjectClass replaySubjectClass = new ReplaySubjectClass();
        replaySubjectClass.ReplaySubjectTest();
    }

    private void ReplaySubjectTest() {
        ReplaySubject<String> replaySubject = ReplaySubject.create();
        replaySubject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        replaySubject.onNext("데이터 - 1");
        replaySubject.onNext("데이터 - 3");
        replaySubject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        replaySubject.onNext("데이터 - 5");
        replaySubject.onComplete();

        /*
        결과값
            Subscriber #1 => 데이터 - 1
            Subscriber #1 => 데이터 - 3
            Subscriber #2 => 데이터 - 1
            Subscriber #2 => 데이터 - 3
            Subscriber #1 => 데이터 - 5
            Subscriber #2 => 데이터 - 5
         */
    }
}
