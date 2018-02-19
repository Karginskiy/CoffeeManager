package nkargin.ru.coffeemanager.main.viewmodel;

import android.databinding.BaseObservable;

/**
 * Created by hei on 20.02.2018.
 */

public class MainViewModel extends BaseObservable {

    private Integer price;
    private Integer cupsLeft;

    public void setPrice(Integer integer) {
        this.price = integer;
        notifyChange();
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCupsLeft() {
        return cupsLeft;
    }

    public void setCupsLeft(Integer integer) {
        this.cupsLeft = integer;
        notifyChange();
    }

}
