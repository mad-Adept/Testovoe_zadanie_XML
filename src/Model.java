import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

/**
 * Класс Model, содержит данные о продуктах и данные рабочих.
 */
@XmlRootElement(name = "Model")
@XmlType(propOrder = {"workers_list", "products_list"})
public class Model {

    /**
     * Коллекция workers_list содержит список рабочих с заказами.
     */
    ArrayList<Worker> workers_list = new ArrayList<Worker>();

    /**
     * Коллекция products_list содержит список блюд.
     */
    ArrayList<Product> products_list = new ArrayList<Product>();
    @XmlElement(name = "workers_list")
    public ArrayList<Worker> getWorkers_list() {
        return workers_list;
    }
    public void setWorkers_list(ArrayList<Worker> workers_list) {
        this.workers_list = workers_list;
    }

    @XmlElement(name = "products_list")
    public ArrayList<Product> getProducts_list() {
        return products_list;
    }

    public void setProducts_list(ArrayList<Product> products_list) {
        this.products_list = products_list;
    }

    /**
     * Пустой конструктор класса Model
     */
    public Model(){}

    /**
     * Конструктор создающий данные о рабочих и меню столовой. А также заполняет данными коллекции products_list и
     * workers_list.
     */
 /* public Model() {
        Worker pupkin = new Worker("А.", "Пупкин");
        Worker krivenko = new Worker("С.", "Кривенко");
        Worker gaychenov = new Worker("П.", "Гайченов");
        Worker suhojilov = new Worker("Л.", "Сухожилов");

        Product rulet_s_izumom = new Product("Рулет с изюмом", 75, 15);
        Product pirog_s_povidlom = new Product("Пирог с повидлом", 60, 13);
        Product pirog_s_yablokami = new Product("Пирог с яблоками", 60, 13);
        Product salat_izumenka = new Product("Салат Изюминка", 100, 35);
        Product salat_lukoshko = new Product("Салат Лукошко", 100, 40);
        Product salat_kopustniy_s_pomidorom = new Product("Салат капустный с помидором", 100, 19);
        Product sup_harcho_s_govyadinoy = new Product("Суп харчо с говядиной", 250, 31);
        Product sup_kuriniy_s_gribami = new Product("Суп куриный с грибами", 250, 34);
        Product sup_bolgarskiy_vegetarianskiy = new Product("Суп болгарский вегетарианский", 250, 21);
        Product ribnoe_file_s_pomidorkoy = new Product("Рыбное филе с помидоркой", 80, 54);
        Product pechen_po_korolevski = new Product("Печень по-королевски", 150, 54);
        Product svinina_zapechenaya = new Product("Свинина запеченная \"По-гусарски\"", 80, 68);
        Product grecha_s_maslom = new Product("Греча с маслом", 170, 17);
        Product makarony_otvarnye = new Product("Макароны отварные", 170, 15);
        Product ris_otvarnoy_s_maslom = new Product("Рис отварной с маслом", 170, 16);

        pupkin.add_Product(salat_izumenka);
        pupkin.add_Product(pechen_po_korolevski);
        pupkin.add_Product(ris_otvarnoy_s_maslom);
        pupkin.add_Product(rulet_s_izumom);

        krivenko.add_Product(salat_lukoshko);
        krivenko.add_Product(sup_kuriniy_s_gribami);
        krivenko.add_Product(svinina_zapechenaya);
        krivenko.add_Product(makarony_otvarnye);
        krivenko.add_Product(pirog_s_yablokami);

        gaychenov.add_Product(sup_bolgarskiy_vegetarianskiy);
        gaychenov.add_Product(ribnoe_file_s_pomidorkoy);
        gaychenov.add_Product(rulet_s_izumom);
        gaychenov.add_Product(pirog_s_povidlom);

        suhojilov.add_Product(salat_izumenka);
        suhojilov.add_Product(sup_kuriniy_s_gribami);
        suhojilov.add_Product(pechen_po_korolevski);
        suhojilov.add_Product(makarony_otvarnye);
        suhojilov.add_Product(pirog_s_povidlom);


    Collections.addAll(workers_list, pupkin, krivenko, gaychenov, suhojilov);

    Collections.addAll(products_list, rulet_s_izumom, pirog_s_povidlom, pirog_s_yablokami, salat_izumenka,
    salat_lukoshko, salat_kopustniy_s_pomidorom, sup_harcho_s_govyadinoy, sup_kuriniy_s_gribami,
    sup_bolgarskiy_vegetarianskiy, ribnoe_file_s_pomidorkoy, pechen_po_korolevski,
    svinina_zapechenaya, grecha_s_maslom, makarony_otvarnye, ris_otvarnoy_s_maslom);
    }*/

    @Override
    public String toString() {
        return "Model{" +
                "workers_list=" + workers_list +
                ", products_list=" + products_list +
                '}';
    }
}
