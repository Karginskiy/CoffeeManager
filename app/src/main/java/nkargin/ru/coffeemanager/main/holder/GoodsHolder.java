package nkargin.ru.coffeemanager.main.holder;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import nkargin.ru.coffeemanager.databinding.GoodBinding;
import nkargin.ru.coffeemanager.databinding.GoodsListBinding;
import nkargin.ru.coffeemanager.main.dialog.SellCoffeeDialogFragment;
import nkargin.ru.coffeemanager.main.domain.GoodsDomain;
import nkargin.ru.coffeemanager.main.model.Good;
import nkargin.ru.coffeemanager.main.viewmodel.GoodViewModel;
import rx.functions.Action1;


public class GoodsHolder extends RecyclerView.ViewHolder {

    private final boolean isAdminLogged;
    private GoodBinding binding;
    private SellCoffeeDialogFragment sellCoffeeDialogFragment;
    private Activity activity;
    private GoodsDomain goodsDomain;
    private GoodsListBinding goodsListBinding;

    public GoodsHolder(GoodBinding binding,
                       Activity activity,
                       GoodsDomain domain,
                       GoodsListBinding goodsListBinding) {
        super(binding.getRoot());

        this.activity = activity;
        this.goodsDomain = domain;
        this.goodsListBinding = goodsListBinding;
        this.binding = binding;
        updateView(binding.getRoot());
        binding.setViewModel(new GoodViewModel());

        SharedPreferences sharedPreferences = activity.getSharedPreferences("Login", Context.MODE_PRIVATE);
        isAdminLogged = sharedPreferences.getBoolean("isAdminLogged", false);

        subscribeCups();
        subscribeProceed();
    }

    private void subscribeProceed() {
        goodsDomain.observeSold().subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                GoodsHolder.this.goodsListBinding.getModel().setPrice(integer);
            }
        });
    }

    private void subscribeCups() {
        goodsDomain.observeCupsLeft().subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                GoodsHolder.this.goodsListBinding.getModel().setCupsLeft(integer);
            }
        });
    }

    private void updateView(View root) {
        final Button goodButton = root.findViewWithTag("good_button");

        goodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAdminLogged) {
                    sellCoffeeDialogFragment = SellCoffeeDialogFragment.newInstance(binding);
                    sellCoffeeDialogFragment.show(activity.getFragmentManager(), "good_dialog");
                } else {
                    goodsDomain.sellGood(binding.getViewModel().getGood());
                }
            }
        });
    }

    public void bind(Good good) {
        binding.getViewModel().setGood(good);
        binding.executePendingBindings();
    }
}
