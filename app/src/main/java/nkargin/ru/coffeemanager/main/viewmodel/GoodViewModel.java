package nkargin.ru.coffeemanager.main.viewmodel;

import android.databinding.BaseObservable;

import nkargin.ru.coffeemanager.main.model.Good;

/**
 * Created by hei on 19.02.2018.
 */

public class GoodViewModel extends BaseObservable {

    private Good good;

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
        notifyChange();
    }

}
