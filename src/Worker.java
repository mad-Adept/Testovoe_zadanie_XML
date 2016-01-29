import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.TreeMap;
import java.util.Map;

@XmlType(name = "Worker", propOrder = {"firstName", "secondName", "menu"})
public class Worker {

    private String firstName;
    private String secondName;
    private TreeMap<Product, Integer> menu = new TreeMap();

    public Worker() {
    }

    public Worker(String f_name, String s_name){
        this.firstName = f_name;
        this.secondName = s_name;
    }

    public void add_Product(Product product_name){
        if(chek_servings(product_name)){
            menu.put(product_name, menu.get(product_name) + 1);
        }
        else menu.put(product_name, 1);
    }

    private boolean chek_servings(Product product_name){
        for (Map.Entry<Product, Integer> iterator : menu.entrySet()){
            if (iterator.getKey().equals(product_name)) return true;
        }
        return false;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    @XmlElement(name = "menu")
    public TreeMap<Product, Integer> getMenu() {
        return menu;
    }
    public void setMenu(TreeMap<Product, Integer> menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (!firstName.equals(worker.firstName)) return false;
        if (!secondName.equals(worker.secondName)) return false;
        return menu.equals(worker.menu);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        result = 31 * result + menu.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", menu=" + menu +
                '}';
    }
}

