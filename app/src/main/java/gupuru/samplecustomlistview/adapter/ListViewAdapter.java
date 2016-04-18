package gupuru.samplecustomlistview.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import gupuru.samplecustomlistview.R;
import gupuru.samplecustomlistview.bean.User;

/**
 * ListView adapter
 */
public class ListViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<User> userArrayList;

    public ListViewAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.userArrayList = userArrayList;
    }

    @Override
    public int getCount() {
        if (userArrayList.isEmpty()) {
            return 0;
        }
        return userArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        if (userArrayList.isEmpty()) {
            return null;
        }
        return userArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.item_list_view_user,
                    parent, false);

            viewHolder = new ViewHolder();

            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.age = (TextView) convertView.findViewById(R.id.age);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (!userArrayList.isEmpty()) {
            viewHolder.name.setText(userArrayList.get(position).getName());
            viewHolder.age.setText(userArrayList.get(position).getAge() + "さい");
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView name;
        TextView age;
    }

}