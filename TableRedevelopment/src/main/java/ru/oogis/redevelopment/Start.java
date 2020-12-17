package ru.oogis.redevelopment;

import ru.oogis.redevelopment.data.model.Building;
import ru.oogis.redevelopment.ui.FrameForGlobalTable;

import java.util.Arrays;
import java.util.Map;

public class Start {
    private FrameForGlobalTable frameForGlobalTable;
private String[] nameParameters = {"human" , "Area" , "value" , "pipe" , "price" };
    public Start(){

        frameForGlobalTable = new FrameForGlobalTable(Arrays.asList(nameParameters), initMap());
        frameForGlobalTable.setVisible(true);
    }
private Map<String, Map<String, Map<String, Building>>> initMap(){

}


    public static void main(String[] args) {
        new Start();
    }
}
