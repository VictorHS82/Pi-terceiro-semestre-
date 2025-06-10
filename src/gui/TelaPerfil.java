package gui;

import javax.swing.*;

import banco_de_dados.ClienteDAO;
import interfacesDAO.BaseClienteDAO;
import objetos.Cliente;

/**
 * Classe que modela a tela de perfil
 */
public class TelaPerfil extends JPanel {
    public TelaPerfil(int codUsuario) {
        	BaseClienteDAO usuarioDAO = new ClienteDAO();
        Cliente usuario = usuarioDAO.buscarCliente(codUsuario);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Meu Perfil"));
        add(new JLabel("Nome: " + usuario.getNome()));
        add(new JLabel("Email: " + usuario.getEmail()));
        add(new JLabel("Endereço: " + usuario.getEndereco()));
    }
}
