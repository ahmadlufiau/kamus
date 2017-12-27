package com.ahmadlufiau.kamusbahasa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ahmad Lufi A U on 17/12/2017.
 */

public class IdEngAdapter extends RecyclerView.Adapter<IdEngAdapter.IdEngViewHolder> {

    private ArrayList<KamusModel> dataIdEng = new ArrayList<>();
    private Context context;
    private LayoutInflater mInfalter;

    public IdEngAdapter(Context context) {
        this.context = context;
        mInfalter = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ArrayList<KamusModel> getDataIdEng() {
        return dataIdEng;
    }

    public void setDataIdEng(ArrayList<KamusModel> dataIdEng) {
        this.dataIdEng = dataIdEng;
        notifyDataSetChanged();
    }

    @Override
    public IdEngViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kamus, parent, false);
        return new IdEngViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IdEngViewHolder holder, int position) {
        holder.tvName.setText(getDataIdEng().get(position).getName());
        holder.tvDesc.setText(getDataIdEng().get(position).getDescription());

        holder.tvName.setOnClickListener(new ItemClickListener(position, new ItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                KamusModel model = new KamusModel();
                model.setName(getDataIdEng().get(position).getName());
                model.setDescription(getDataIdEng().get(position).getDescription());

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_KAMUS, model);
                context.startActivity(intent);
            }
        }));
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getItemCount() {
        return dataIdEng.size();
    }

    public class IdEngViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDesc;

        public IdEngViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txt_nama);
            tvDesc = itemView.findViewById(R.id.txt_desc);
        }
    }
}