package com.example.zadanieandroid;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductListAdapter.OnProductClickListener {

    private EditText editTextProduct;
    private Button buttonAdd;
    private RecyclerView recyclerViewProducts;

    private List<Product> productList;
    private ProductListAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getElements();
        RecyclerView();
        getListeners();
    }

    private void getElements() {
        editTextProduct = findViewById(R.id.etProdukt);
        buttonAdd = findViewById(R.id.btnDodaj);
        recyclerViewProducts = findViewById(R.id.rwRecycler);
    }

    private void RecyclerView() {
        productList = new ArrayList<>();
        Adapter = new ProductListAdapter(productList, this);

        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProducts.setAdapter(Adapter);
    }

    private void getListeners() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = editTextProduct.getText().toString().trim();

                if (productName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wpisz nazwę produktu", Toast.LENGTH_SHORT).show();
                    return;
                }

                Product product = new Product(productName);
                productList.add(product);
                Adapter.notifyItemInserted(productList.size() - 1);

                editTextProduct.setText("");
            }
        });
    }


    @Override
    public void onProductClick(int position) {
        Product product = productList.get(position);
        product.setPurchased(!product.isPurchased());
        Adapter.notifyItemChanged(position);
    }

    @Override
    public void onProductLongClick(int position) {
        productList.remove(position);
        Adapter.notifyItemRemoved(position);
    }
}