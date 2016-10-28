package sunpj.loveticket.ui.view.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sunpj.loveticket.R;
import sunpj.loveticket.bean.Ticket;

/**
 * Created by sunpi on 2016/10/28.
 */

public class TicketAdapter extends BaseAdapter {

    private List<Ticket> list = new ArrayList<>();

    public TicketAdapter(List<Ticket> list) {
        this.list = list;
    }

    public void refresh(List<Ticket> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, null);
            holder = new Holder();
            holder.textView = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).getName());

        return convertView;
    }

    public static class Holder {
        public TextView textView;
    }
}
