package footballmanager.persons;

import java.util.Objects;

public class PlayerUtility {
    public static int generatePlayerHashCode(int dorsal, String name){
        return  Objects.hash(name + dorsal);
    }
}
