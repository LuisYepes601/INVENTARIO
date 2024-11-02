
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Inventario in = new Inventario("Tiendas D1");
        Scanner entrada = new Scanner(System.in);

        boolean cond = true;
        while (cond) {
            System.out.println("Menú");
            System.out.println("1. ADD");
            System.out.println("2. MOSTRAR CATEGORIAS");
            System.out.println("3. ELIMINAR");
            System.out.println("4. ADD PRODUCTOS");
            System.out.println("5. MOSTRAR INVENTARIO");
            System.out.println("6. EDITAR PRODUCTOS");
            System.out.println("0. SALIR");
            System.out.println("Ingresa una opción");
            int opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    in.addCategorias();
                    break;
                case 2:
                    in.mostrar();
                    break;
                case 3:
                    in.eliminarCategoria();
                    break;
                case 4:
                    in.addProducto();
                    break;
                case 5:
                    in.mostrarInventario();
                   break;
                   case 6:
                   in.editarProducto();
                   break;
                case 0:
                    cond = false;
                    break;
                default:
                    throw new AssertionError();
            }

        }
    }
}
