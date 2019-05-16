package homeObject.adapter;

import homeObject.entity.HomeObjectEntity;

public class HomeObjectEntityAdapterFactory {
    public static HomeObjectEntityAdapter getAdapter(HomeObjectEntity homeObject) {
        String name = homeObject.getName();
        int i = 0;
        while (i < name.length() && !Character.isDigit(name.charAt(i))) i++;

        name = name.substring(0, i);

        switch (name){
            case "Thermometer":
                return new ThermometerAdapter(homeObject);
            default:
                return null;
        }
    }
}
