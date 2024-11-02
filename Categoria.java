
import java.util.ArrayList;
import java.util.Scanner;

public class Categoria {

    String name;
    ArrayList<Produto> produtos = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public Categoria() {
    }

    public Categoria(String name) {
        this.name = name;
        this.produtos = produtos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addProductos() {
        System.out.println("Ingresa los datos del producto");
        System.out.println("Nombre");
        String nameProducto = in.nextLine();
        System.out.println("Precio unidad");
        double precioUnitario = in.nextDouble();
        System.out.println("Cantidad");
        int cantidad = in.nextInt();
        in.nextLine();

        Produto produtoActual = new Produto(nameProducto, precioUnitario, cantidad);
        produtos.add(produtoActual);
        System.out.println("Producto " + nameProducto + " agregado con exito");
    }

}
