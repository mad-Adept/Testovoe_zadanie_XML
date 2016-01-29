import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlType(name = "Product", propOrder = {"name", "weight", "price"})
public class Product implements Comparable<Product>{
    private String name;
    private int weight;
    private int price;
    private static ArrayList<String> namelist_products = new ArrayList();

    public Product() {
    }

    public Product(String name, int weight, int price) {
        if (check_name(name)){
            System.out.println("Product: " + name +  ", name already exists!");  }

        this.name = name;
        this.weight = weight;
        this.price = price;
        namelist_products.add(name);
    }

    private boolean check_name (String name){
        for (String iterator : namelist_products){
            if (iterator.equals(name)) return true;
        }
        return false;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (weight != product.weight) return false;
        if (price != product.price) return false;
        return name.equals(product.name);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + weight;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    @Override

    public int compareTo(Product o) {
        return this.getName().compareTo(o.getName());
    }
}

