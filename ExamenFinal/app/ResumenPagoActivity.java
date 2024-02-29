public class ResumenPagoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_pago);

        TextView txtTotal = findViewById(R.id.txtTotal);
        TextView txtDetalle = findViewById(R.id.txtDetalle);

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