import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Orders {
    Model ordering_data = new Model();
    ArrayList<String> products_list_name = new ArrayList<>();

    Orders() {
        try {
            ordering_data = new Util().getData(ordering_data);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Исключение в конструкторе Orders," +
                    " ошибка чтения из файла по пути: src\\resources\\Ordering_data.xml");
        }
    }

    public void printPlacedOrder() {
        int price;
        int quantity;
        int suma_zakaza = 0;
        merger_servings();
        printSymbol("bottom");
        System.out.println();
        System.out.println("|            Наименование продукта            |Порции   |   Цена   |");
        for (int dish_name = 0; dish_name < products_list_name.size(); dish_name++){
            quantity = 0;
            price = 0;
            for (Worker workers : ordering_data.getWorkers_list()) {
                for (Map.Entry<Product, Integer> products : workers.getMenu().entrySet()) {
                    if (products.getKey().getName().equals(products_list_name.get(dish_name))) {
                        quantity = quantity + products.getValue();
                        price = products.getKey().getPrice();
                    }
                }
            }
            suma_zakaza = suma_zakaza + (quantity * price);
            System.out.printf("|%-45s|%9d|%10d|\n", products_list_name.get(dish_name), quantity, price);
        }
        printSymbol("top");
        System.out.println();
        System.out.println("Общая сумма заказов: " + suma_zakaza);
    }


    public  void printReceivedOrder(){
        String name;
        String ordered_dishes;
        int cost;
        printSymbol("bottom");
        printSymbol("bottom");
        System.out.println();
        System.out.println("|Имя сотрудника |                               Заказаные блюда                       " +
                "                                       |Стоимость|");
            for (Worker workers : ordering_data.getWorkers_list()) {
                cost = 0;
                ordered_dishes = "";
                name = workers.getSecondName()+ " " + workers.getFirstName();
                Iterator<Map.Entry<Product, Integer>> iterator = workers.getMenu().entrySet().iterator();
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

    private void merger_servings() {
        for (Worker workers : ordering_data.getWorkers_list()) {
            for (Map.Entry<Product, Integer> products : workers.getMenu().entrySet()){
                if(chek_Product(products.getKey().getName())) continue;
                else products_list_name.add(products.getKey().getName());
            }
        }
    }
    private boolean chek_Product(String product_name){
           for (String p : products_list_name){
               if(p.equals(product_name)) return true;
           }
            return false;
        }

    private void printSymbol(String value){
        char c;
        if(value.equalsIgnoreCase("top")) c = 175;
        else c = 95;
        for(int i = 0; i < 68; i++){
            System.out.print(c);
        }
    }
}


