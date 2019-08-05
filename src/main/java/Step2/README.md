
#### RxJava의 제네릭 함수형 인터페이스
 인터페이스 이름 | 포함 메서드 | 설명 
------- | ------- | ------- 
| Predicate<T> | boolean test(T t) | t 값을 받아서 참이나 거짓을 반환.
| Consumer<T> | void accept(T t) | t 값을 받아서 처리한다. 반환값은 없다.
| Function<T, R> | R apply(T t) | t 값을 받아서 결과를 반환

#### 변환(Transforming) 연산자
- 어떤 입력을 받아서 원하는 출력 결과를 내는 함수
- map() : 입력값을 어떤 함수에 넣어서 원하는 값으로 변환하는 함수
- flatMap() : map() 함수는 원하는 입력값을 어떤 함수에 넣어서 변환할 수 있는 일대일 함수이지만, flatMap() 함수는 똑같이 함수에 넣더라도 결과가 Observable 나온다. 즉, map() 함수가 일대일 함수라면 flatMap() 함수는 일대다 혹은 일대일 Observable 함수이다.

##### map 함수 원형
~~~
@CheckReturnValue  
@SchedulerSupport(value="none")  
public final <R> Observable<R> map(Function<? super T, ? extends R> mapper)
~~~

##### flatMap 함수 원형
~~~
형태-1
@SchedulerSupport(SchedulerSupport.NONE)
public final <R> Observable<R> flatMap(
    Function<? super T, ? extends ObservableSource<? extends R>> mapper)

형태-2
@SchedulerSupport(SchedulerSupport.NONE)
public final <U, R> Observable<R> flatMap(
    Function<? super T, ? extends ObservableSource<? extends U>> mapper,
        Bifunction<? super T, ? super U, ? extends R> resultSelector)
~~~
- ObservableSource란 ?
  * Observable, AsyncSubject, BehaviorSubject등이 공통으로 구현된 인터페이스이다.
- Bifunction이란 ?
  * T, U 값을 받아서 결과값 R 반환. (= Function 확장 개념이라고 생각)

