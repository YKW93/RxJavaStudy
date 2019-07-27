package Step1.SubjectClass;

import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectClass {

    public static void main(String[] args) {
        BehaviorSubjectClass behaviorSubject = new BehaviorSubjectClass();
        behaviorSubject.BehaviorSubjectTest();
    }

    private void BehaviorSubjectTest() {
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.createDefault("default value"); // AsyncSubject 와 다르게 기본값 설정을 위해 creatDefault() 함수로 생성
        behaviorSubject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        behaviorSubject.onNext("데이터 - 1");
        behaviorSubject.onNext("데이터 - 2");
        behaviorSubject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        behaviorSubject.onNext("데이터 - 3");
        behaviorSubject.onComplete();

        /*
        결과값
            Subscriber #1 => default value
            Subscriber #1 => 데이터 - 1
            Subscriber #1 => 데이터 - 2
            Subscriber #2 => 데이터 - 2
            Subscriber #1 => 데이터 - 3
            Subscriber #2 => 데이터 - 3
         */
    }
}
