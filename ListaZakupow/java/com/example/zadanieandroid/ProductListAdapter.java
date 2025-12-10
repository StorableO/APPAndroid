package com.example.zadanieandroid;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>{

    private List<Product> productList;
    private OnProductClickListener listener;

    public interface OnProductClickListener {
        void onProductClick(int position);
        void onProductLongClick(int position);
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewProductName;
        private Button btnClick;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewProductName = itemView.findViewById(R.id.textViewProductName);
            btnClick = itemView.findViewById(R.id.btnClicked);
        }


        public void bind(Product product, int position) {
            textViewProductName.setText(" - " +product.getName());

            if (product.isPurchased()) {
                textViewProductName.setPaintFlags(textViewProductName.getPaintFlags());
                textViewProductName.setPaintFlags(android.graphics.Paint.STRIKE_THRU_TEXT_FLAG);
                btnClick.setText("usun!");
            } else {
                textViewProductName.setPaintFlags(textViewProductName.getPaintFlags());
                textViewProductName.setPaintFlags(Paint.ANTI_ALIAS_FLAG);
                btnClick.setText("zaznacz!");
            }

            btnClick.setOnClickListener(v -> listener.onProductClick(position));
            btnClick.setOnLongClickListener(v -> {
                listener.onProductLongClick(position);
                return true;
            });
        }
    }
    public ProductListAdapter(List<Product> productList, OnProductClickListener listener) {
        this.productList = productList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.bind(product, position);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}

