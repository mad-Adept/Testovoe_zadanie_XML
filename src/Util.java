import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Класс Util, утилитный клас производящий маршалинг и анмаршалинг данных.
 */
public class Util {

    /**
     * Поле PATH содержит путь в дирректорию resources.
     */
    private final static String PATH = "src\\resources\\";

    /**
     *  Метод setData производит запись в файл ordering_data.xml.
     * @param ordering_data в качестве параметра передаем ссылочную переменную на объект класса Model, которая содержит
     *                      две коллекции workers_list и products_list.
     */
    public void setData(Model ordering_data) {
        try {
            JAXBContext context = JAXBContext.newInstance(ordering_data.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.marshal(ordering_data, new File(PATH + "ordering_data.xml"));
        } catch (JAXBException e) {
            System.out.println("Исключение в методе setData класса Util," +
                    " записи в файл по пути: src\\resources\\ordering_data.xml");
            e.printStackTrace();
        }
    }

    /**
     * Метод getData производит чтение из файла ordering_data.xml.
     * @param ordering_data в качестве параметра передаем ссылочную переменную на класс Model.
     * @return метод возвращает данные в переменной ordering_data.
     * @throws JAXBException перехватывает исключение связаннле с ошибкой чтения из файла.
     */
    public Model getData(Model ordering_data) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(ordering_data.getClass());
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ordering_data = (Model) unmarshaller.unmarshal(new File(PATH + "ordering_data.xml"));

        } catch (JAXBException e) {
            System.out.println("Исключение в методе getData класса Util," +
                    " чтения из файла по пути: src\\resources\\ordering_data.xml");
            e.printStackTrace();
        }
            return ordering_data;
    }
}




