# RxJavaStudy


#### Observable 클래스
> 세가지 알림을 구독자에게 전달
> * onNext : Observable이 데이터 발행을 알림.
> * onComplete : 모든 데이터의 발행을 완료했음을 알림. onComplete 이벤트는 단 한번만 발생하며, 발생한 후에는 더 이상 onNext 이벤트가 발생해선 안됨.
> * onError : Observable에서 어떤 이유로 에러가 발생했음을 알림. onError 이벤트가 발생하면 이후에 onNext 및 onComplete 이벤트가 발생하지 않는다. 즉, Observable의 실행을 종료

> 팩토리 함수
> - RxJava 1.x 기본 팩토리 함수 : just(), create(), from()
> - RxJava 2.x 추가 팩토리 함수 : fromArray(), fromIterable(), fromCallable(), fromFuture(), fromPublisher()
> - 기타 팩토리 함수 : interval(), range(), timer(), defer() 등

#### Single 클래스
> Single 클래스는 Observable의 특수한 형태이다. Observable 클래스는 데이터를 무한하게 발행할 수 있지만 SingleClass 클래스는 오직 1개의 데이터만 발행하도록 한정한다.

#### Maybe 클래스
> Single 클래스와 마찬가지로 최대 데이터 하나를 가질 수 있지만 데이터 발행 없이 바로 데이터 발생을 완료(Single 클래스는 1개 완료, Maybe 클래스는 0 혹은 1개 완료) 할 수 있다. 즉, Maybe 클래스는 Single 클래스에 onComplete 이벤트가 추가된 형태이다.

#### Subject 클래스
> Subject 클래스는 차가운 Observable을 뜨거운 Observable로 변경해준다.
> 주요 Subject 클래스 : AsyncSubject, BehaviorSubject, PublishSubject, ReplaySubject 등이 있다.
