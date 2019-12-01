package com.hatruong.petshop.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hatruong.petshop.Activity.ActivityLoaiThuCung;
import com.hatruong.petshop.DAO.LoaiThuCungDAO;
import com.hatruong.petshop.Model.LoaiThuCung;
import com.hatruong.petshop.R;

import java.util.List;

public class AdapterLoaiThuCung extends BaseAdapter {

    List<LoaiThuCung> arrLoaiThuCung;
    public Activity context;
    public LayoutInflater inflater;
    LoaiThuCungDAO loaiThuCungDAO;

    public AdapterLoaiThuCung(Activity context, List<LoaiThuCung> arrLoaiThuCung) {
        this.arrLoaiThuCung = arrLoaiThuCung;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        loaiThuCungDAO = new LoaiThuCungDAO(context);
    }


    @Override
    public int getCount() {
        return arrLoaiThuCung.size();
    }

    @Override
    public Object getItem(int i) {
        return arrLoaiThuCung.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewHolder {
        ImageView imgLogo;
        TextView tvMaLoaThuCung;
        TextView tvTenLoaiThuCung;
        ImageView imgDelete;

    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_loai_thu_cung, null);
            holder.imgLogo = (ImageView) view.findViewById(R.id.imgLogo);
            holder.tvMaLoaThuCung = (TextView) view.findViewById(R.id.tvMaLoaThuCung);
            holder.tvTenLoaiThuCung = (TextView) view.findViewById(R.id.tvTenLoaiThuCung);
            holder.imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loaiThuCungDAO.deleteLoaiThuCung(arrLoaiThuCung.get(i).getMaLoaiThuCung());
                    arrLoaiThuCung.remove(i);
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            });
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }
        LoaiThuCung loaiThuCung = (LoaiThuCung) arrLoaiThuCung.get(i);
        holder.tvMaLoaThuCung.setText(loaiThuCung.getMaLoaiThuCung());
        holder.tvTenLoaiThuCung.setText(loaiThuCung.getTenLoaiThuCung());
        return view;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<LoaiThuCung> items) {
        this.arrLoaiThuCung = items;
        notifyDataSetChanged();
    }
}
