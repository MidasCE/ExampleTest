package com.example.midas.exampletest.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.midas.exampletest.R;
import com.example.midas.exampletest.model.UserModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Midas on 4/3/2559.
 */
public class UserAdapter extends BaseAdapter  {
    private ArrayList<UserModel> userCollection;
    private final LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;

    @Inject
    public UserAdapter(Context context) {
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public interface OnItemClickListener {
        void onUserItemClicked(UserModel userModel);
    }

    public void setUsersCollection(Collection<UserModel> usersCollection) {
        this.userCollection = (ArrayList<UserModel>) usersCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getCount() {
        if (userCollection == null) {
            return 0;
        }else{
            return userCollection.size();
        }
    }

    @Override
    public UserModel getItem(int position) {
        if (userCollection == null) {
            return null;
        }else{
            return userCollection.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = layoutInflater.inflate(R.layout.row_user, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder.name.setText(userCollection.get(position).getLogin());
        return convertView;
    }
    static class ViewHolder {
        @Bind(R.id.userText) TextView name;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
