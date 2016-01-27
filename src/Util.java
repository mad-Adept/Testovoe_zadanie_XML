import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Util {

    private final static String PATH = "src\\resources\\";

    public void setData(Ordering_data data) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(data.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.marshal(data, new File(PATH + "Ordering_data.xml"));
    }

    public Ordering_data getData(Ordering_data data) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(data.getClass());
        Unmarshaller unmarshaller = context.createUnmarshaller();
        data = (Ordering_data) unmarshaller.unmarshal(new File(PATH + "Ordering_data.xml"));
        return data;
    }
}




