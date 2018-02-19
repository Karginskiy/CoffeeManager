package nkargin.ru.coffeemanager.main.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nkargin.ru.coffeemanager.R;
import nkargin.ru.coffeemanager.databinding.GoodsListBinding;
import nkargin.ru.coffeemanager.main.adapter.GoodsListAdapter;
import nkargin.ru.coffeemanager.main.domain.GoodsDomain;
import nkargin.ru.coffeemanager.main.viewmodel.MainViewModel;

import static android.databinding.DataBindingUtil.inflate;


public class WorkFragment extends Fragment {

    private GoodsDomain goodsDomain;
    private static WorkFragment INSTANCE;

    public WorkFragment() {}

    public static WorkFragment newInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WorkFragment();
            INSTANCE.goodsDomain = new GoodsDomain();
        }
        return INSTANCE;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        GoodsListBinding goodsListBinding = inflate(inflater, R.layout.goods_list, container, false);

        goodsListBinding.setModel(new MainViewModel());
        goodsListBinding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        goodsListBinding.recyclerView.setAdapter(new GoodsListAdapter(getActivity(), goodsDomain, goodsListBinding));
        return goodsListBinding.getRoot();
    }
}
