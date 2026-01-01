/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.cedilloe_millerm_final.controller;

import est.ups.edu.ec.cedilloe_millerm_final.dao.LogDAO;
import est.ups.edu.ec.cedilloe_millerm_final.model.Log;
import est.ups.edu.ec.cedilloe_millerm_final.view.MenuView;
import est.ups.edu.ec.cedilloe_millerm_final.view.ReadLogsView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReadLogsController {

    private final ReadLogsView view;
    private final LogDAO logDAO;

    public ReadLogsController(ReadLogsView view) {
        this.view = view;
        this.logDAO = new LogDAO();

        this.view.getBtnGoBack().addActionListener(e -> goBack());
        this.view.getBtnSearch().addActionListener(e -> searchLog());
    }

    public void searchLog() {

        Date startDate = view.getJdDate_start().getDate();
        Date endDate = view.getJdDate_end().getDate();

        if (startDate == null || endDate == null) {
            JOptionPane.showMessageDialog(
                    view,
                    "Seleccione Start y End.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (startDate.after(endDate)) {
            JOptionPane.showMessageDialog(
                    view,
                    "Start no puede ser mayor que End.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String startStr = sdf.format(startDate);
        String endStr = sdf.format(endDate);

        System.out.println("START: " + startStr);
        System.out.println("END  : " + endStr);

        List<Log> logs = logDAO.obtenerLogsPorRango(startStr, endStr);

        DefaultTableModel model = (DefaultTableModel) view.getTblLogs().getModel();
        model.setRowCount(0);

        for (Log l : logs) {
            model.addRow(new Object[]{
                l.getId(),
                l.getUsuario(),
                l.getFechaHora(),
                l.getAccion(),
                l.getDescripcion()
            });
        }

        if (logs.isEmpty()) {
            JOptionPane.showMessageDialog(
                    view,
                    "No se encontraron logs en el rango seleccionado.",
                    "Sin resultados",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public void goBack() {
        view.dispose();
        new MenuView().setVisible(true);
    }
}