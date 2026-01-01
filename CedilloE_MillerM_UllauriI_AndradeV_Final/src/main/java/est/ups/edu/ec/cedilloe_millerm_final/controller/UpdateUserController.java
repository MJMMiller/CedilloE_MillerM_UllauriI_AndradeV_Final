/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.cedilloe_millerm_final.controller;

import est.ups.edu.ec.cedilloe_millerm_final.dao.UsuarioDAO;
import est.ups.edu.ec.cedilloe_millerm_final.view.MenuView;
import est.ups.edu.ec.cedilloe_millerm_final.view.UpdateUserView;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class UpdateUserController {

    private final UpdateUserView view;
    private final UsuarioDAO usuarioDAO;

    public UpdateUserController(UpdateUserView view) {
        this.view = view;
        this.usuarioDAO = new UsuarioDAO();
        this.view.getBtnSearchUsr().addActionListener(e -> setUserData());
        this.view.getBtnUpdate().addActionListener(e -> updateUser());
        this.view.getBtnCancel().addActionListener(e -> cancelar());
    }
    
    public void setUserData() {

        String user = view.getTxtUser().getText().trim();

        if (user.isEmpty()) {
            JOptionPane.showMessageDialog(view,
                    "Debe ingresar el usuario.",
                    "Error",
                    0);
            return;
        }

        String password = usuarioDAO.obtenerPasswordByUsername(user);

        if (password == null) {
            JOptionPane.showMessageDialog(view,
                    "Usuario no encontrado.",
                    "Error",
                    0);
            return;
        }
        
        view.getTxtPassword().setText(password);
        
        String ket_pass = usuarioDAO.obtenerKeyPassByUsername(user);

        if (ket_pass == null) {
            JOptionPane.showMessageDialog(view,
                    "Usuario no encontrado.",
                    "Error",
                    0);
            return;
        }

        view.getTxtKeyPass().setText(ket_pass);
    }
    
    public void updateUser() {

        String user = view.getTxtUser().getText().trim();
        String password = view.getTxtPassword().getText().trim();
        String keyPass = view.getTxtKeyPass().getText().trim();

        if (user.isEmpty() || password.isEmpty() || keyPass.isEmpty()) {
            JOptionPane.showMessageDialog(
                    view,
                    "No deje campos vacíos.",
                    "Error",
                    0);
            return;
        }
        
        if (!keyPass.matches("\\d+")) {
            JOptionPane.showMessageDialog(
                view,
                "Key_pass debe contener solo números.",
                "Error",
                0
            );
            return;
        }

        boolean ok = usuarioDAO.actualizarUsuario(user, password, keyPass);

        if (ok) {
            JOptionPane.showMessageDialog(
                    view,
                    "Usuario actualizado correctamente",
                 "Éxito",
                    1);
        } else {
            JOptionPane.showMessageDialog(
                    view,
                    "No se pudo actualizar el usuario",
                    "Error",
                    0);
        }
        
        view.getTxtUser().setText("");
        view.getTxtPassword().setText("");
        view.getTxtKeyPass().setText("");
        
    }
    
    public void cancelar(){
        view.dispose();
        new MenuView().setVisible(true); 
    }
}