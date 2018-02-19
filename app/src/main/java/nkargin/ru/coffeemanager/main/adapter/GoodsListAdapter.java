package nkargin.ru.coffeemanager.main.adapter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import nkargin.ru.coffeemanager.R;
import nkargin.ru.coffeemanager.databinding.GoodBinding;
import nkargin.ru.coffeemanager.databinding.GoodsListBinding;
import nkargin.ru.coffeemanager.main.dialog.SellCoffeeDialogFragment;
import nkargin.ru.coffeemanager.main.domain.GoodsDomain;
import nkargin.ru.coffeemanager.main.holder.GoodsHolder;
import nkargin.ru.coffeemanager.main.model.Good;


public class GoodsListAdapter extends RecyclerView.Adapter<GoodsHolder> implements SellCoffeeDialogFragment.OnFragmentInteractionListener{

    private final Activity context;
    private final GoodsDomain domain;
    private final GoodsListBinding goodsListBinding;

    public GoodsListAdapter(Activity context, GoodsDomain goodsDomain, GoodsListBinding goodsListBinding) {
        this.context = context;
        this.domain = goodsDomain;
        this.goodsListBinding = goodsListBinding;
    }

    @Override
    public GoodsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        GoodBinding binding = DataBindingUtil.inflate(inflater, R.layout.good, parent, false);
        return new GoodsHolder(binding, context, domain, goodsListBinding);
    }

    @Override
    public void onBindViewHolder(GoodsHolder holder, int position) {
        Good good = domain.getGoodList().get(position);
        holder.bind(good);
    }

    @Override
    public int getItemCount() {
        return domain.getGoodList().size();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
