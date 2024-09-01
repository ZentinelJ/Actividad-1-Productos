import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Product[] productsList = new Product[5];
        int size = 0;

        while (true) {
            JOptionPane.showMessageDialog(null, "Tu almacén cuenta con 5 espacios." +
                            "\n A continuación, el menú.", "Bienvenido",
                    JOptionPane.INFORMATION_MESSAGE);

            String input = JOptionPane.showInputDialog(null, """
                            Por favor ingrese una opción.\
                            
                             1. Ver lista de productos. \
                            
                             2. Administrar tus productos. \
                            
                             3. Salir del programa.""",
                    "Menú principal", JOptionPane.INFORMATION_MESSAGE);

            int option = Integer.parseInt(input);

            switch (option) {
                case 1:
                    StringBuilder spaceList = new StringBuilder("La lista de productos es:\n");
                    for (int i = 0; i < size; i++) {
                        spaceList.append((i + 1)).append(". ").append(productsList[i]).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, spaceList.toString(),
                            "Lista de productos", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    boolean adminMenu = true;
                    while (adminMenu) {
                        String secondInput = JOptionPane.showInputDialog(null, """
                                        Ha elegido administrar sus productos, por favor, seleccione:\
                                        
                                         1. Eliminar un producto. \
                                        
                                         2. Agregar un producto. \
                                        
                                         3. Regresar al menú.\
                                        
                                         4. Salir del programa.""",
                                "Administrador", JOptionPane.INFORMATION_MESSAGE);
                        int option2 = Integer.parseInt(secondInput);

                        switch (option2) {
                            case 1:
                                if (size == 0) {
                                    JOptionPane.showMessageDialog(null, "No hay productos para eliminar.",
                                            "¡Error!", JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                                StringBuilder productsForDelete = new StringBuilder("La lista de productos es:\n");
                                for (int i = 0; i < size; i++) {
                                    productsForDelete.append((i + 1)).append(". ").append(productsList[i]).append("\n");
                                }

                                String deleteInput = JOptionPane.showInputDialog(null, productsForDelete + "\nIngrese el número del producto a eliminar:",
                                        "Eliminar producto", JOptionPane.QUESTION_MESSAGE);

                                int numberSelected = Integer.parseInt(deleteInput);

                                if (numberSelected > 0 && numberSelected <= size) {
                                    for (int i = numberSelected - 1; i < size - 1; i++) {
                                        productsList[i] = productsList[i + 1];
                                    }
                                    productsList[size - 1] = null;
                                    size--;
                                    JOptionPane.showMessageDialog(null, "Producto eliminado",
                                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "El número ingresado no es válido",
                                            "¡Error!", JOptionPane.ERROR_MESSAGE);
                                }
                                break;
                            case 2:
                                if (size >= productsList.length) {
                                    JOptionPane.showMessageDialog(null, "No tienes espacio para más productos.",
                                            "¡Error!", JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                                String category = JOptionPane.showInputDialog(null, "Ingrese la categoría del producto:",
                                        "Insertar datos", JOptionPane.QUESTION_MESSAGE);
                                String name = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto:",
                                        "Insertar datos", JOptionPane.QUESTION_MESSAGE);
                                String presentation = JOptionPane.showInputDialog(null, "Ingrese la presentación del producto:",
                                        "Insertar datos", JOptionPane.QUESTION_MESSAGE);
                                String price = JOptionPane.showInputDialog(null, "Ingrese el precio del producto:",
                                        "Insertar datos", JOptionPane.QUESTION_MESSAGE);
                                String quantity = JOptionPane.showInputDialog(null, "Ingrese la cantidad del producto:",
                                        "Insertar datos", JOptionPane.QUESTION_MESSAGE);
                                String expireDate = JOptionPane.showInputDialog(null, "Ingrese la fecha de vencimiento (año):",
                                        "Insertar datos", JOptionPane.QUESTION_MESSAGE);

                                double priceDouble = Double.parseDouble(price);
                                int quantityInt = Integer.parseInt(quantity);
                                int expireDateInt = Integer.parseInt(expireDate);

                                Product newProduct = new Product(category, name, presentation, priceDouble, quantityInt, expireDateInt);

                                productsList[size] = newProduct;
                                size++;
                                JOptionPane.showMessageDialog(null, "Producto ingresado exitosamente",
                                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            case 3:
                                adminMenu = false;
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Saliendo del programa.",
                                        "¡Hasta luego!", JOptionPane.INFORMATION_MESSAGE);
                                System.exit(0);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "La opción elegida no es válida",
                                        "¡Error!", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.",
                            "¡Hasta luego!", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción elegida no es válida",
                            "¡Error!", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
}