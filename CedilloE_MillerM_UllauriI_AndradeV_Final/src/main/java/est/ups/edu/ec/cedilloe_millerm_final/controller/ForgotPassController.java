/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.cedilloe_millerm_final.controller;

import est.ups.edu.ec.cedilloe_millerm_final.dao.UsuarioDAO;
import est.ups.edu.ec.cedilloe_millerm_final.view.ForgotPassView;
import est.ups.edu.ec.cedilloe_millerm_final.view.InicioView;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Mateo
 */
public class ForgotPassController {

    private final UsuarioDAO usuarioDAO;
    private final ForgotPassView view;

    public ForgotPassController(ForgotPassView view) {
        this.view = view;
        this.usuarioDAO = new UsuarioDAO();
        this.view.getBtnRestore().addActionListener(e -> recuperarPassword());
        this.view.getBtnCancel().addActionListener(e -> cancelar());
    }

    public void recuperarPassword() {

        String user = view.getTxtUser().getText().trim();
        String keyPass = view.getTxtKeyPass().getText().trim();

        if (user.isEmpty() || keyPass.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Debe ingresar usuario y key_pass.", "Error", 1);
            return;
        }

        Integer id = usuarioDAO.validarCredenciales(user, keyPass);
        if (id == null) {
            JOptionPane.showMessageDialog(view, "Credenciales Incorrectas", "Error", 0);
            return;
        }

        JPasswordField passField = new JPasswordField();
        int opt = JOptionPane.showConfirmDialog(
                view,
                passField,
                "Ingrese la nueva contraseña:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (opt != JOptionPane.OK_OPTION) {
            return;
        }

        String newPass = new String(passField.getPassword()).trim();
        if (newPass.isEmpty()) {
            JOptionPane.showMessageDialog(view, "La contraseña no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean ok = usuarioDAO.actualizarPass(user, newPass);

        if (ok) {
            JOptionPane.showMessageDialog(view, "Contraseña actualizada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
            new InicioView().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "No se pudo actualizar la contraseña", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cancelar(){
        view.dispose();
        new InicioView().setVisible(true); 
    }
}