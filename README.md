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

>>
