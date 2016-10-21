package sunpj.loveticket.ui.view.recycleview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sunpj.loveticket.R;
import sunpj.loveticket.bean.Ticket;

/**
 * Created by sunpi on 2016/10/21.
 */

public class RecyclerCardAdapter extends RecyclerView.Adapter<RecyclerCardAdapter.CardViewHolder> {

    private List<Ticket> list = new ArrayList<>();

    public RecyclerCardAdapter(List<Ticket> list) {
        this.list = list;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public CardViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.card_name);
        }
    }
}
