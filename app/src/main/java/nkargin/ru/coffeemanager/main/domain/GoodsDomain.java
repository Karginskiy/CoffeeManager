package nkargin.ru.coffeemanager.main.domain;

import java.util.Arrays;
import java.util.List;

import nkargin.ru.coffeemanager.main.model.Good;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by hei on 19.02.2018.
 */

public class GoodsDomain {

    private final List<Good> goodList = Arrays.asList(
            Good.builder().title("Latte").price(120).size(300).build(),
            Good.builder().title("Cappucino").price(110).size(400).build(),
            Good.builder().title("Americano").price(80).size(300).build(),
            Good.builder().title("Latte").price(80).size(250).build(),
            Good.builder().title("Cappucino").price(80).size(250).build(),
            Good.builder().title("Americano").price(80).size(400).build(),
            Good.builder().title("Latte").price(180).size(450).build(),
            Good.builder().title("Cappucino").price(100).size(450).build(),
            Good.builder().title("Americano").price(100).size(450).build(),
            Good.builder().title("Latte").price(180).size(450).build(),
            Good.builder().title("Cappucino").price(100).size(450).build(),
            Good.builder().title("Americano").price(100).size(450).build()
    );

    private int sold = 0;
    private int cupsLeft = 100;

    private BehaviorSubject<Integer> cupsLeftSubject = BehaviorSubject.create(cupsLeft);
    private BehaviorSubject<Integer> soldSubject = BehaviorSubject.create(sold);

    public void sellGood(Good good) {
        sold += good.getPrice();
        cupsLeft--;
        soldSubject.onNext(sold);
        cupsLeftSubject.onNext(cupsLeft);
    }

    public int soldPrice() {
        return sold;
    }

    public List<Good> getGoodList() {
        return goodList;
    }

    public Observable<Integer> observeCupsLeft() {
        return cupsLeftSubject.asObservable();
    }

    public Observable<Integer> observeSold() {
        return soldSubject.asObservable();
    }

}
