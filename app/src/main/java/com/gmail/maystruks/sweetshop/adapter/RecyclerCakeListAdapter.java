package com.gmail.maystruks.sweetshop.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.maystruks.sweetshop.Cake;
import com.gmail.maystruks.sweetshop.DescriptionSingleton;
import com.gmail.maystruks.sweetshop.ItemType;
import com.gmail.maystruks.sweetshop.R;
import com.gmail.maystruks.sweetshop.fragment.CakeDescriptionFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


public class RecyclerCakeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Cake> cakesList;


    public RecyclerCakeListAdapter(List<Cake> cakesList) {

        this.cakesList = new ArrayList<>();
        this.cakesList.addAll(cakesList);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh = null;
        View itemLayoutView;

        switch (viewType) {
            case 0:
                itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
                vh = new CakeViewHolder(itemLayoutView);
                break;
            case 1:
                itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_commercial, parent, false);
                vh = new CommercialViewHolder(itemLayoutView);
                break;
        }

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {


        final int positionIndex = position - position / 3;

        if (holder instanceof CakeViewHolder) {
            ((CakeViewHolder) holder).ivCakeImage.setImageBitmap((cakesList.get(positionIndex)).getCakeImage());
            ((CakeViewHolder) holder).tvTitle.setText((cakesList.get(positionIndex)).getName());
            ((CakeViewHolder) holder).tvDescription.setText((cakesList.get(positionIndex)).getDescription());
            ((CakeViewHolder) holder).mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DescriptionSingleton.getINSTANCE().setCake(cakesList.get(positionIndex));
                    EventBus.getDefault().post(new Event(CakeDescriptionFragment.ID_DESCRIPTION_FRAGMENT));

                }
            });
        } else if (holder instanceof CommercialViewHolder) {
            ((CommercialViewHolder) holder).tvCommercial
                    .setText("The best cakes in the world!");
        }

    }


    public void updateList(List<Cake> newsList) {
        this.cakesList.clear();
        this.cakesList.addAll(newsList);
        notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {


        if (position % 3 == 0) {
            return ItemType.COMMERCIAL_TYPE;
        }
        return ItemType.CAKE_TYPE;
    }

    @Override
    public int getItemCount() {

        return cakesList.size() + cakesList.size() / 3;
    }


    private static class CakeViewHolder extends RecyclerView.ViewHolder {

        ImageView ivCakeImage;
        TextView tvTitle;
        TextView tvDescription;
        CardView mCardView;

        public CakeViewHolder(View v) {
            super(v);
            ivCakeImage = v.findViewById(R.id.iv_cake_image);
            tvTitle = v.findViewById(R.id.tv_cake_name);
            tvDescription = v.findViewById(R.id.tv_cake_description);
            mCardView = v.findViewById(R.id.card_view_cake);
        }
    }


    private static class CommercialViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCommercial;

        public CommercialViewHolder(View itemView) {
            super(itemView);
            tvCommercial = itemView.findViewById(R.id.tv_commercial);
        }
    }


}