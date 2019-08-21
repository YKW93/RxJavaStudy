#### 생성(Creating) 연산자
- 데이터 흐름을 만드는 연산자 (Observable, Maybe, Single 객체를 만드는것.)
- interval() : 일정 시간 간격으로 데이터 흐름을 생성하는 함


##### interval 함수 원형
~~~
형태-1
@SchedulerSupport(SchedulerSupport.COMPUTATION)
public static Observable<Long> interval(long period, TimeUnit unit)

형태-2
@SchedulerSupport(SchedulerSupport.COMPUTATION)
public static Observable<Long> interval(long initialDelay, long period, TimeUnit unit)
~~~
- 첫번째 원형은 일정시간(period)를 쉬었다가 데이터를 발행한다. 두 번째 원형은 동작은 같고 최초 지연 시간(initialDelay)을 조절할 수 있다. 보통 초기 지연 시간 없이 (initialDelay를 0으로 입력함) 바로 데이터를 발행하기 위해서 사용한다.
- @SchedulerSupport(SchedulerSupport,COMPUTATION) 란?
    * interval() 함수의 동작이 계산 스케줄러에서 실행된다는 의미이다.
    * 현재 스레드가 아니라 계산을 위한 별도의 스레드를 RxJava에서는 스케줄러라고 한다.