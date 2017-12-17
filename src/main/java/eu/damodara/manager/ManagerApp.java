package eu.damodara.manager;

import eu.damodara.manager.gui.swing.Panel;
import eu.damodara.manager.poi.PoiSheetManager;

public class ManagerApp {
    public static void main(String[] args) {
        new Panel(new PoiSheetManager()).start();
    }
}
