package com.example.examenfinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductoAdapter adapter;
    private List<Producto> listaProductos;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.btnPagar);
        listaProductos = new ArrayList<>();
        // Agregar algunos productos de ejemplo
        listaProductos.add(new Producto("Producto 1", 2, 10.99));
        listaProductos.add(new Producto("Producto 2", 1, 5.99));

        adapter = new ProductoAdapter(this, listaProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Button btnPagar = findViewById(R.id.btnPagar);
        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total = calcularTotal();
                Intent intent = new Intent(MainActivity.this, ResumenPagoActivity.class);
                intent.putExtra("total", total);
                intent.putExtra("listaProductos", new ArrayList<>(listaProductos));
                startActivity(intent);
            }

            private void startActivity(Intent intent) {
            }
        });
    }

    private double calcularTotal() {
        double total = 0;
        for (Producto producto : listaProductos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }
}
