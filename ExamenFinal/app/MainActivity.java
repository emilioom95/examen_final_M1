import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y setters
}

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductoAdapter adapter;
    private List<Producto> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
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
public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {
    private Context context;
    private List<Producto> listaProductos;

    public ProductoAdapter(Context context, List<Producto> listaProductos) {
        this.context = context;
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = listaProductos.get(position);
        holder.txtNombre.setText(producto.getNombre());
        holder.txtCantidadPrecio.setText("Cantidad: " + producto.getCantidad() + " - Precio: $" + producto.getPrecio());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre, txtCantidadPrecio;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtCantidadPrecio = itemView.findViewById(R.id.txtCantidadPrecio);
        }
    }
}
