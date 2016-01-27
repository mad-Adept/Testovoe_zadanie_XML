/*
Первый отчет состоит из таблицы со столбцами: название блюда, количество, стоимость. После таблицы должна быть напечатана полная стоимость заказа.
Второй отчет состоит из таблицы со столбцами: имя сотрудника, заказанные блюда, стоимость его обеда.
    "firstName": "А.",
    "secondName": "Пупкин",
    "menu": {
      "Product{name='Рис отварной с маслом', weight=170, price=16, list_products=[Рис отварной с маслом]}": 1,
      "Product{name='Рулет с изюмом', weight=75, price=15, list_products=[Рулет с изюмом]}": 1,
      "Product{name='Салат изюменка', weight=100, price=35, list_products=[Салат изюменка]}": 1,
      "Product{name='Печень по королевски', weight=150, price=54, list_products=[Печень по королевски]}": 1
 */

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.Map;

public class Orders {
    Ordering_data ordering_data = new Ordering_data();
    ArrayList<String> products_list_name = new ArrayList<>();
    Orders() {
        try {
            ordering_data = new Util().getData(ordering_data);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Ошибка чтения из файла!");
        }
    }

    public void printPlacedOrder() {
        int price;
        int quantity = 0;
        for (int iter_name = 0; iter_name < products_list_name.size(); iter_name++){
            for (Worker workers : ordering_data.getWorkers_list()) {
                for (Map.Entry<Product, Integer> products : workers.getMenu().entrySet()) {
                    if (products.getKey().getName().equals(products_list_name.get(iter_name))) {
                        quantity = quantity + products.getValue();
                        price = products.getKey().getPrice();
                    }
                }
            }
            System.out.printf("%c%c", 124, 862);
        }
    }


    public  void printReceivedOrder(){

        }

    public void merger_servings() {
        for (Worker workers : ordering_data.getWorkers_list()) {
            for (Map.Entry<Product, Integer> products : workers.getMenu().entrySet()){
                if(chek_Product(products.getKey().getName())) break;
                else products_list_name.add(products.getKey().getName());
            }
        }
    }
        public boolean chek_Product(String product_name){
           for (String p : products_list_name){
               if(p.equals(product_name)) return true;
           }
            return false;
        }
    }

