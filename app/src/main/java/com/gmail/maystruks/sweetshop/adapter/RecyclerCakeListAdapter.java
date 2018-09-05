package com.gmail.maystruks.sweetshop.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.maystruks.sweetshop.Cake;
import com.gmail.maystruks.sweetshop.Commercial;
import com.gmail.maystruks.sweetshop.DescriptionSingleton;
import com.gmail.maystruks.sweetshop.ItemType;
import com.gmail.maystruks.sweetshop.R;
import com.gmail.maystruks.sweetshop.fragment.CakeDescriptionFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


public class RecyclerCakeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemType> cakesList;


    public RecyclerCakeListAdapter(List<ItemType> cakesList) {

        this.cakesList = cakesList;
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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof CakeViewHolder) {
            ((CakeViewHolder) holder).ivCakeImage.setImageBitmap(((Cake) cakesList.get(position)).getCakeImage());
            ((CakeViewHolder) holder).tvTitle.setText(((Cake) cakesList.get(position)).getName());
            ((CakeViewHolder) holder).tvDescription.setText(((Cake) cakesList.get(position)).getDescription());
            ((CakeViewHolder) holder).mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DescriptionSingleton.getINSTANCE().setCake((Cake) cakesList.get(position));
                    EventBus.getDefault().post(new Event(CakeDescriptionFragment.ID_DESCRIPTION_FRAGMENT));

                }
            });
        } else if (holder instanceof CommercialViewHolder) {
            ((CommercialViewHolder) holder).tvCommercial
                    .setText(((Commercial) cakesList.get(position)).getTitle());
        }

    }


    public void updateList(List<ItemType> newsList) {
        this.cakesList.clear();
        this.cakesList.addAll(newsList);
        notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {

        if (cakesList.get(position) instanceof Cake) {
            return ItemType.CAKE_TYPE;
        } else if (cakesList.get(position) instanceof Commercial) {
            return ItemType.COMMERCIAL_TYPE;
        } else {
            return -1;
        }

    }

    @Override
    public int getItemCount() {

        return cakesList.size();
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