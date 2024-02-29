package com.example.examenfinal;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.examenfinal.Producto;

import java.util.List;

public class ResumenPagoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_pago);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView txtTotal = findViewById(R.id.txtTotal);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView txtDetalle = findViewById(R.id.txtDetalle);

        Intent intent = getIntent();
        double total = intent.getDoubleExtra("total", 0);
        List<Producto> listaProductos = (List<Producto>) intent.getSerializableExtra("listaProductos");

        txtTotal.setText("Total a pagar: $" + total);

        StringBuilder detalle = new StringBuilder();
        for (Producto producto : listaProductos) {
            detalle.append(producto.getNombre())
                    .append(" - Cantidad: ")
                    .append(producto.getCantidad())
                    .append(", Precio: $")
                    .append(producto.getPrecio())
                    .append("\n");
        }
        txtDetalle.setText(detalle.toString());
    }
}