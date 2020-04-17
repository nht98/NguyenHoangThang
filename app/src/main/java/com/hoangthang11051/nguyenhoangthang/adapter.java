package com.hoangthang11051.nguyenhoangthang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hoangthang11051.nguyenhoangthang.R;
import java.util.List;

public class adapter extends ArrayAdapter<ItemThoitiet> {
    Context context;
    List<ItemThoitiet> items;

    public adapter(@NonNull Context context, int resource, @NonNull List<ItemThoitiet> objects) {
        super(context, resource, objects);
        this.context = context;
        this.items = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);//.inflate(R.layout.item_thoitiet, null, true);
        View v = inflater.inflate(R.layout.item_thoitiet, null, true);

        ImageView img = v.findViewById(R.id.img_thoitiet);
        TextView tv_tenquocgia = v.findViewById(R.id.tv_quocgia);
        TextView tv_thoitiet = v.findViewById(R.id.tv_thoitiet);
        TextView tv_nhietdo = v.findViewById(R.id.tv_nhietdo);

        img.setImageResource(getItem(position).getIMG());
        tv_tenquocgia.setText(getItem(position).tenquocgia);
        tv_thoitiet.setText(getItem(position).getKieuThoiTiet());
        tv_nhietdo.setText(getItem(position).getNhietDo());


        return v;

    }
}
