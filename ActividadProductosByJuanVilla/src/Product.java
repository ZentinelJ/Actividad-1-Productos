public class Product {

    private String category;
    private String name;
    private String presentation;
    private double price;
    private int quantity;
    private int expireDate;

    public Product(String category, String name, String presentation, double price, int quantity, int expireDate) {
        this.category = category;
        this.name = name;
        this.presentation = presentation;
        this.price = price;
        this.quantity = quantity;
        this.expireDate = expireDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category != null && !category.trim().isEmpty()) {
            this.category = category;
        } else {
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        if (presentation != null && !presentation.trim().isEmpty()) {
            this.presentation = presentation;
        } else {
            throw new IllegalArgumentException("La presentación no puede estar vacía");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Por favor introduzca un valor superior a 0");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("La cantidad introducida no puede ser igual a 0");
        }
    }

    public int getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(int expireDate) {
        if (expireDate > 2024) {
            this.expireDate = expireDate;
        } else {
            throw new IllegalArgumentException("El producto está vencido");
        }
    }

    @Override
    public String toString() {
        return "Categoría: " + category + ", Nombre: " + name + ", Precio: " + price + ", Cantidad: " + quantity + ", Fecha de Vencimiento: " + expireDate;
    }
}
