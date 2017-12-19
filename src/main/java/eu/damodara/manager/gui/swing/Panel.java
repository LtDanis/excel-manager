package eu.damodara.manager.gui.swing;

import eu.damodara.manager.api.PatternEntity;
import eu.damodara.manager.api.SheetManager;
import eu.damodara.manager.gui.swing.data.Patterns;
import eu.damodara.manager.gui.swing.data.XlsxFileFilter;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static eu.damodara.manager.gui.swing.data.XlsxFileFilter.EXTENSION;
import static eu.damodara.manager.gui.swing.data.XlsxFileFilter.createFileFilter;
import static java.lang.String.format;

public class Panel {
    private static final String NAME = "Ekselio šablonų tvarkyklė.";
    private static final String IMPORT = "Pasirinkite failą";

    private final SheetManager manager;
    private final JFrame frame;

    private Workbook workbook;
    private List<JButton> exportButtons = new ArrayList<>();

    public Panel(SheetManager manager) {
        this.manager = manager;
        this.frame = new JFrame(NAME);
    }

    public void start() {
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(createImportButton());
        Patterns.getExportPatterns().forEach(pattern ->
                frame.add(createExportButton(pattern)));
        //manual export buttons
        frame.pack();
        frame.setVisible(true);
    }

    private JButton createImportButton() {
        JButton importButton = new JButton(IMPORT);
        importAction(importButton);
        return importButton;
    }

    private void importAction(JButton importButton) {
        importButton.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(createFileFilter());
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                if (selectedFile.canRead())
                    importWorkbook(selectedFile);
                setExportButtons(true);
            }
        });
    }

    private Component createExportButton(PatternEntity patternEntity) {
        JButton exportButton = new JButton(patternEntity.getName());
        exportButtons.add(exportButton);
        exportButton.setEnabled(false);
        exportAction(patternEntity, exportButton);
        return exportButton;
    }

    private void exportAction(PatternEntity patternEntity, JButton exportButton) {
        exportButton.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(createFileFilter());
            fileChooser.setSelectedFile(new File(builderExportFileName(patternEntity)));
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                manager.delete(workbook, patternEntity.getColumns(), patternEntity.getRows());
                exportWorkbook(getSelectedFileWithExtension(fileChooser.getSelectedFile()));
                setExportButtons(false);
            }
        });
    }

    private String builderExportFileName(PatternEntity patternEntity) {
        return format("%s_%s%s", LocalDate.now(), patternEntity.getName(), EXTENSION);
    }

    private File getSelectedFileWithExtension(File selectedFile) {
        if (FilenameUtils.getExtension(selectedFile.getName()).equalsIgnoreCase(XlsxFileFilter.EXTENSION)) {
            return selectedFile;
        } else {
            return new File(selectedFile.getParentFile(), FilenameUtils.getBaseName(selectedFile.getName()) + EXTENSION);
        }
    }

    private void exportWorkbook(File selectedFile) {
        try {
            FileOutputStream outputStream = new FileOutputStream(selectedFile);
            workbook.write(outputStream);
            workbook.close();
        } catch (Exception e) {
            throw new RuntimeException("Export failed." + selectedFile, e);
        }
    }

    private void importWorkbook(File selectedFile) {
        try {
            workbook = new XSSFWorkbook(new FileInputStream(selectedFile));
        } catch (IOException e) {
            throw new RuntimeException("File read exception - " + selectedFile.getAbsolutePath() + selectedFile.getName(), e);
        }
    }

    private void setExportButtons(boolean isEnabled) {
        exportButtons.forEach(b -> b.setEnabled(isEnabled));
    }
}
