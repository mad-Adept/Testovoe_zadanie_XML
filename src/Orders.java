import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Класс Orders, обрабатывает данные и выводит их в две таблицы зказаов.
 */
public class Orders {

    /**
     * Создание переменной ordering_data класса Model, для получения данных итз файла.
     */
    Model ordering_data = new Model();

    /**
     * Создание коллекции products_list_name для заполнения неповторяющихся имен блюд.
     */
    ArrayList<String> products_list_name = new ArrayList<>();

    /**
     * Конструктор кдасса Orders считывает данные в переменную ordering_data, с помощью метода getData
     */
    Orders() {
        try {
            ordering_data = new Util().getData(ordering_data);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Исключение в конструкторе Orders," +
                    " ошибка чтения из файла по пути: src\\resources\\Ordering_data.xml");
        }
    }

    /**
     * Метод printPlacedOrder обрабатывает данные о заказах в столовую и выводит их в таблицу с указанием имени блюда,
     * количества порций и цены за одну порцию.
     */
    public void printPlacedOrder() {
        int price;
        int quantity;
        int suma_zakaza = 0;
        merger_servings();
        printSymbol("bottom");
        System.out.println();
        System.out.println("|            Наименование продукта            | Порции  |   Цена   |");
        //Бежим по коллекции products_list_name и выбираем блюда.
        for (int dish_name = 0; dish_name < products_list_name.size(); dish_name++){
            quantity = 0;
            price = 0;
            //Бежим по рабочим и обрабатываем его меню заказов.
            for (Worker workers : ordering_data.getWorkers_list()) {
                //Бежим по меню выбирая поля порций и цены.
                for (Map.Entry<Product, Integer> products : workers.getMenu().entrySet()) {
                    if (products.getKey().getName().equals(products_list_name.get(dish_name))) {
                        quantity = quantity + products.getValue();
                        price = products.getKey().getPrice();
                    }
                }
            }
            //Считаем общую сумму заказов и выводим в таблицу.
            suma_zakaza = suma_zakaza + (quantity * price);
            System.out.printf("|%-45s|%9d|%10d|\n", products_list_name.get(dish_name), quantity, price);
        }
        printSymbol("top");
        System.out.println();
        System.out.println("Общая сумма заказов: " + suma_zakaza);
    }

    /**
     * Метод printReceivedOrder работает с данными работников и выводит таблицу с заказанными блюдами и их стоимостью.
     */
    public  void printReceivedOrder(){
        String name;
        String ordered_dishes;
        int cost;
        printSymbol("bottom");
        printSymbol("bottom");
        System.out.println();
        System.out.println("|Имя сотрудника |                               Заказаные блюда                       " +
                "                                       |Стоимость|");
        //Бежим по рабочим и обрабатываем его меню заказов.
        for (Worker workers : ordering_data.getWorkers_list()) {
                cost = 0;
                ordered_dishes = "";
                name = workers.getSecondName()+ " " + workers.getFirstName();
                Iterator<Map.Entry<Product, Integer>> iterator = workers.getMenu().entrySet().iterator();
                //Бежим по меню выбирая поля порций и цены.
                while (iterator.hasNext()){
                    Map.Entry<Product, Integer> products = iterator.next();
                    if(iterator.hasNext()) ordered_dishes = ordered_dishes + products.getKey().getName() + ", ";
                    else ordered_dishes = ordered_dishes + products.getKey().getName();
                    cost = cost + products.getKey().getPrice();
                }
                System.out.printf("|%-15s|%-108s|%9d|\n", name, ordered_dishes, cost);
            }
        printSymbol("top");
        printSymbol("top");
        System.out.println();
        }

    /**
     * Метод merger_servings заполняет коллекцию products_list_name именами продуктов, бнз повторений.
     */
    private void merger_servings() {
        for (Worker workers : ordering_data.getWorkers_list()) {
            for (Map.Entry<Product, Integer> products : workers.getMenu().entrySet()){
                if(chek_Product(products.getKey().getName())) continue;
                else products_list_name.add(products.getKey().getName());
            }
        }
    }

    /**
     * Метод check_name осуществляет проверку на совпадение блюд из коллекции products_list_name.
     * @param product_name поле имя передаваемое из метода merger_servings.
     * @return возвращает true если такое блюдо уже существует и false если его еще нет.
     */
    private boolean chek_Product(String product_name){
           for (String p : products_list_name){
               if(p.equals(product_name)) return true;
           }
            return false;
        }

    /**
     * Метод printSymbol отрисовывает линию.
     * @param value если параметр указан как "top", то будет выведена верхняя линия, если любая другая строка,
     *              то нижняя линия.
     */
    private void printSymbol(String value){
        char c;
        if(value.equalsIgnoreCase("top")) c = 175;
        else c = 95;
        for(int i = 0; i < 68; i++){
            System.out.print(c);
        }
    }
}


