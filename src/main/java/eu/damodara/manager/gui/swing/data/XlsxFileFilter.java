package eu.damodara.manager.gui.swing.data;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class XlsxFileFilter {
    public static final String EXTENSION = ".xlsx";

    private XlsxFileFilter() {
    }

    public static FileFilter createFileFilter() {
        return new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory() || file.getName().endsWith(EXTENSION);
            }

            @Override
            public String getDescription() {
                return null;
            }
        };
    }
}
