
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> idList = new ArrayList<>();
        idList.add(1003464);
        idList.add(4632);
        new ReciepeInformation(idList);
        ReciepeInformation n = new ReciepeInformation(idList);
        System.out.println(n.info_list.get(0).get(0));
        System.out.println(n.info_list.get(1).get(0));

    }
}
