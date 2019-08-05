
#### RxJava의 제네릭 함수형 인터페이스
 인터페이스 이름 | 포함 메서드 | 설명 
------- | ------- | ------- 
| Predicate<T> | boolean test(T t) | t 값을 받아서 참이나 거짓을 반환.
| Consumer<T> | void accept(T t) | t 값을 받아서 처리한다. 반환값은 없다.
| Function<T, R> | R apply(T t) | t 값을 받아서 결과를 반환
| BiFunction<T1, T2, R> | R apply(T1 t1, T2 t2) | t1, t2 값을 받아서 결과를 반환
 
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
  
#### 필터(Filter) 연산자
- 입력 데이터 중에 원하는 데이터만 걸러낸다. ex) filter(), first(), take() 등.
- filter() : Observable에서 원하는 데이터만 걸러내는 역할을 한다. 즉, 필요 없는 데이터는 제거하고 오직 관심 있는 데이터만 filter()함수를 통과한다.

##### filter 함수 원형
~~~
@SchedulerSupport(SchedulerSupport.NONE)
public final Observable<T> filter(Predicate<? super T> predicate)
~~~

##### filter() 함수와 비슷한 함수 종류
- first(default) 함수 : Observable의 첫 번째 값을 필터함. 만약 값없이 완료된면 대신 기본값을 리턴함.
- last(default) 함수 : Observable의 마지막 값을 필터함. 만약 값없이 완료되면 대신 기본값을 리턴함.
- take(N) 함수 : 최초 N개 값만 가져옴.
- takeLast(N) 함수 : 마지막 N개 값만 필터함.
- skip(N) 함수 : 최초 N개 값을 건너뜀.
- skipLast(N) 함수 : 마지막 N개 값을 건너뜀.

#### reduce() 함수
- reduce() 함수는 발행한 데이터를 모두 사용하여 어떤 최종 결과 데이터를 합성할 때 활용한다.
- 함수형 프로그래밍의 가장 기본 연산자인 map/filter/reduce 패턴을 이루는 마지막 필수 함수이다.
  * 입력된 데이터를 필요한 방식으로 매핑 하는 map() 함수
  * 원하는 데이터만 추출 할 때는 불필요한 데이터를 걸러내는 filter() 함수
  * 상황에 따라 발행된 데이터를 취합하여 어떤 결과로 만들어 내는 reduce() 함수
  
##### reduce 함수 원형
~~~
@SchedulerSupport(SchedulerSupport.NONE)
public final Maybe<T> reduce(BiFunction<T, T, T> reducer)
~~~
