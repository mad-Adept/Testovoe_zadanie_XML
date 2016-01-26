import javax.xml.bind.JAXBException;

public class Start {
        public static void main(String[] args) throws JAXBException {
                Ordering_data ordering_data = new Ordering_data();
                ordering_data = new Util().getData(ordering_data);
                for(Worker w : ordering_data.getWorkers_list()){
                        System.out.println(w);
                }
      }
}

