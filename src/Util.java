import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Util {

    private final static String PATH = "src\\resources\\";

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




