
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Inventario {

    String name;
    private ArrayList<Categoria> categorias = new ArrayList<>();
    // private ArrayList<Produto> productos = new ArrayList<>();

    Scanner in = new Scanner(System.in);

    public Inventario(String name) {
        this.name = name;
        this.categorias = new ArrayList<>();
        //this.productos = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void addCategorias() {
        System.out.println("Ingrese el nombre");
        String name = in.nextLine();
        Categoria categoriaActual = new Categoria(name);
        categorias.add(categoriaActual);
        System.out.println("Categoria " + name + " agregada con exito");

    }

    public void mostrar() {
        System.out.println("------ Categorias -------\n");
        for (Categoria elem : categorias) {
            System.out.println(elem);
        }
    }

    public void eliminarCategoria() {
        if (!categorias.isEmpty()) {
            boolean encontrado = false;
            System.out.println("Ingrese el nombre de la categoria");
            String name = in.nextLine();
            ListIterator<Categoria> it = categorias.listIterator();

            while (it.hasNext()) {
                Categoria elem = it.next();
                if (elem.getName().equalsIgnoreCase(name)) {
                    encontrado = true;
                    it.remove();
                    System.out.println(name + " Elimninada con éxito");
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Categoria no encontrada");
            }
        } else {
            System.out.println("Inventario vacio");
        }

    }

    public void addProducto() {
        if (!categorias.isEmpty()) {
            boolean encontrado = false;
            System.out.println("Ingresa el nombre de la categoria");
            String name = in.nextLine();
            for (Categoria elem : categorias) {
                if (elem.getName().equalsIgnoreCase(name)) {
                    encontrado = true;
                    elem.addProductos();
                }
            }
            if (!encontrado) {
                System.out.println("La categoria que ingreso no existe");
            }
        } else {
            System.out.println("\nInventario vacio\n");
        }

    }

    public void mostrarInventario() {
        if (!categorias.isEmpty()) {
            System.out.println("------- CATEGORIAS -------");
            for (Categoria elem : categorias) {
                System.out.println("\n" + elem.getName().toUpperCase());
                System.out.println("\n------ PRODUCTOS ------");
                for (Produto elems : elem.getProdutos()) {
                    System.out.println(elems);

                }
                System.out.println("\n---------------------------");
            }
        }

    }

    public void editarProducto() {
        boolean cond = true;
        int opc;

        while (cond) {

            System.out.println("Menú");
            System.out.println("1. Aumentar Stock");
            System.out.println("2. Disminuir Stock");
            System.out.println("3. Cambiar Nombre");
            System.out.println("0. Salir");
            System.out.println("Ingresa una opción");
            opc = in.nextInt();
            switch (opc) {
                case 1:
                    aumentarStock();
                    break;
                case 2:
                    disminuirStock();
                    break;
                case 3:
                    cambiarNombre();
                    break;
                case 0:
                    cond = false;
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    public void aumentarStock() {
        in.nextLine();
        System.out.println("Ingresa el nombre del producto");
        String name = in.nextLine();
        for (Categoria elem : categorias) {
            for (Produto producto : elem.getProdutos()) {
                if (producto.getNombre().equalsIgnoreCase(name)) {
                    System.out.println("Ingrese la cantidad a aumentar");
                    int cantidadAument = in.nextInt();
                    producto.setCantidad(producto.getCantidad() + cantidadAument);
                    System.out.println("Cantidad actualizada");
                }
            }
        }

    }

    public void disminuirStock() {
        boolean valido = false;
        in.nextLine();
        System.out.println("Ingrese el nombre del producto");
        String name = in.nextLine();

        for (Categoria elem : categorias) {
            for (Produto producto : elem.getProdutos()) {
                if (producto.getNombre().equalsIgnoreCase(name)) {
                    System.out.println("Ingrese la cantidad a disminuir");
                    int cantidadDismin = in.nextInt();
                    valido = true;
                    if (producto.getCantidad() > 0 && producto.getCantidad() >= cantidadDismin) {
                        producto.setCantidad(producto.getCantidad() - cantidadDismin);
                        System.out.println("Cantidad actualizada");
                    } else {
                        System.out.println("No valido");
                    }

                }

            }

        }

    }

    public void cambiarNombre() {
        boolean encontrado = false;
        in.nextLine();
        System.out.println("Ingrese el nombre del producto");
        String name = in.nextLine();

        for (Categoria elem : categorias) {
            for (Produto prod : elem.getProdutos()) {
                if (prod.getNombre().equalsIgnoreCase(name)) {
                    encontrado = true;
                    System.out.println("Ingresa el nombre modificado");
                    String nameModificado = in.nextLine();
                    prod.setNombre(nameModificado);
                }
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado");
        } else {
            System.out.println("Nombre modificado con exito");
        }
    }

}
