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

import com.hatruong.petshop.DAO.ThuCungDAO;
import com.hatruong.petshop.Model.ThuCung;
import com.hatruong.petshop.R;

import java.util.List;

public class AdapterThuCung extends BaseAdapter {

    List<ThuCung> arrThuCung;
    public Activity context;
    public LayoutInflater inflater;
    ThuCungDAO thuCungDAO;

    public AdapterThuCung(Activity context, List<ThuCung> arrThuCung) {
        super();
        this.context = context;
        this.arrThuCung = arrThuCung;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        thuCungDAO = new ThuCungDAO(context);
    }

    @Override
    public int getCount() {
        return arrThuCung.size();
    }

    @Override
    public Object getItem(int i) {
        return arrThuCung.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewHolder {
        ImageView imgLogo;
        TextView tvMaThuCung;
        TextView tvTenThuCung;
        TextView tvSoLuong;
        ImageView imgDelete;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_thu_cung, null);
            holder.imgLogo = (ImageView) view.findViewById(R.id.imgLogo);
            holder.tvMaThuCung = (TextView) view.findViewById(R.id.tvMaThuCung);
            holder.tvTenThuCung = (TextView) view.findViewById(R.id.tvTenThuCung);
            holder.tvSoLuong = (TextView) view.findViewById(R.id.tvSoLuong);
            holder.imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    thuCungDAO.deleteThuCung(arrThuCung.get(i).getMaThuCung());
                    arrThuCung.remove(i);
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            });
            view.setTag(holder);

        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        ThuCung thuCung = arrThuCung.get(i);
        holder.tvMaThuCung.setText(thuCung.getMaThuCung());
        holder.tvTenThuCung.setText(thuCung.getTenThuCung());
        holder.tvSoLuong.setText(thuCung.getSoLuong() + "");
        return view;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

}
