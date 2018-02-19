package nkargin.ru.coffeemanager.main.dialog;

import android.app.DialogFragment;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nkargin.ru.coffeemanager.R;
import nkargin.ru.coffeemanager.databinding.FragmentSellCoffeeDialogBinding;
import nkargin.ru.coffeemanager.databinding.GoodBinding;

public class SellCoffeeDialogFragment extends DialogFragment {

    private GoodBinding binding;

    public SellCoffeeDialogFragment() {}

    public static SellCoffeeDialogFragment newInstance(GoodBinding binding) {
        SellCoffeeDialogFragment fragment = new SellCoffeeDialogFragment();
        fragment.binding = binding;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSellCoffeeDialogBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_sell_coffee_dialog, container, false);
        binding.setModel(this.binding.getViewModel());
        return binding.getRoot();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
