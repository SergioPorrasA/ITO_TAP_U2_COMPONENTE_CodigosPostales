/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codigopostal;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author Sergio Porras A
 */
public class CodigoPostalPanel extends JPanel {

    private JComboBox<String> estadoComboBox, ciudadComboBox, muniComboBox, codComboBox, colComboBox;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6;

    private ArrayList<String[]> info = new ArrayList<>();

    public CodigoPostalPanel() {
        initComponents();
        leerArchivoCSV("C:\\Users\\Sergio Porras A\\Documents\\NetBeansProjects\\ITO_TAP_U2_COMPONENTE_CodigosPostales\\src\\codigopostal\\CodigosPostales.csv");
        llenarEstadosComboBox();
        
    }

    private void initComponents() {
        jLabel4 = new JLabel("CODIGOS POSTALES");
        jLabel1 = new JLabel("Estado:");
        jLabel2 = new JLabel("Ciudad:");
        jLabel3 = new JLabel("Municipio:");
        jLabel6 = new JLabel("Colonia:");
        jLabel5 = new JLabel("Codigo Postal:");

        estadoComboBox = new JComboBox<>();
        ciudadComboBox = new JComboBox<>();
        muniComboBox = new JComboBox<>();
        codComboBox = new JComboBox<>();
        colComboBox = new JComboBox<>();

        estadoComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedEstado = (String) estadoComboBox.getSelectedItem();
                llenarCiudadesComboBox(selectedEstado);
            }
        });

        ciudadComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCiudad = (String) ciudadComboBox.getSelectedItem();
                llenarMuniComboBox(selectedCiudad);
            }
        });

        muniComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMunicipio = (String) muniComboBox.getSelectedItem();
                llenarCodigoPostalComboBox(selectedMunicipio);
            }
        });

        codComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCodigo = (String) codComboBox.getSelectedItem();
                llenarColoniaComboBox(selectedCodigo);
            }
        });

        setLayout(new java.awt.GridLayout(6, 2));

        add(jLabel4);
        add(new JLabel());
        add(jLabel1);
        add(estadoComboBox);
        add(jLabel2);
        add(ciudadComboBox);
        add(jLabel3);
        add(muniComboBox);
        add(jLabel5);
        add(codComboBox);
        add(jLabel6);
        add(colComboBox);
    }

    private void leerArchivoCSV(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                procesarLineaCSV(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void procesarLineaCSV(String line) {
        if (!line.trim().isEmpty()) {
            String[] parts = line.split(",");
            if (parts.length > 4) {
                info.add(parts);
            } else {
                System.out.println("Error en la línea del archivo CSV: " + line);
            }
        }
    }

    private void llenarEstadosComboBox() {
        estadoComboBox.removeAllItems();
        for (String[] parts : info) {
            String estado = parts[1];
            boolean estadoPresente = false;
            for (int i = 0; i < estadoComboBox.getItemCount(); i++) {
                if (estadoComboBox.getItemAt(i).equals(estado)) {
                    estadoPresente = true;
                    break;
                }
            }
            if (!estadoPresente) {
                estadoComboBox.addItem(estado);
            }
        }
    }
    
    
    private void llenarCiudadesComboBox(String estado) {
        ciudadComboBox.removeAllItems();

        for (String[] parts : info) {
            if (estado.equals(parts[1])) {
                String ciudad = parts[2];
                boolean ciudadPresente = false;

                // existencia
                for (int i = 0; i < ciudadComboBox.getItemCount(); i++) {
                    if (ciudadComboBox.getItemAt(i).equals(ciudad)) {
                        ciudadPresente = true;
                        break;
                    }
                }
                if (!ciudadPresente && ciudad != null) {
                    ciudadComboBox.addItem(ciudad);
                }
            }
        }
    }

    private void llenarMuniComboBox(String ciudad) {
        muniComboBox.removeAllItems();

        for (String[] parts : info) {
            if (parts[2] != null && parts[2].equals(ciudad))  {
                String muni = parts[3];
                boolean muniPresente = false;
                if (ciudad!= null){

                // existencia
                for (int i = 0; i < muniComboBox.getItemCount(); i++) {
                    if (muniComboBox.getItemAt(i).equals(muni)) {
                        muniPresente = true;
                        break;
                    }
                }
                if (!muniPresente && muni != null) {
                    muniComboBox.addItem(muni);
                }}
            }
        }
    }
    
    private void llenarCodigoPostalComboBox(String muni) {
        codComboBox.removeAllItems();

        for (String[] parts : info) {
            if (parts[3] != null && parts[3].equals(muni)) {

                String cod = parts[0];
                boolean CodigoPresente = false;

                if (muni != null) {
                // existencia
                    for (int i = 0; i < codComboBox.getItemCount(); i++) {
                        if (codComboBox.getItemAt(i).equals(cod)) {
                            CodigoPresente = true;
                            break;
                        }
                    }
                    if (!CodigoPresente && cod != null) {
                        codComboBox.addItem(cod);
                    }
                }
            }
        }
    }

   private void llenarColoniaComboBox(String cod) {
        colComboBox.removeAllItems();

        for (String[] parts : info) {
            // Verificar si el código postal no es null y luego comparar
            if (parts[0] != null && parts[0].equals(cod)) {
                String col = parts[4];
                boolean colPresente = false;

                // Verificar si la colonia no es null y si ya está presente en el ComboBox
                if (col != null) {
                    for (int i = 0; i < colComboBox.getItemCount(); i++) {
                        if (colComboBox.getItemAt(i).equals(col)) {
                            colPresente = true;
                            break;
                        }
                    }
                    // Agregar la colonia al ComboBox si no está presente
                    if (!colPresente) {
                        colComboBox.addItem(col);
                    }
                }
            }
        }
    }


    public String getInfoSeleccionada() {
        if (estadoComboBox.getSelectedItem() == null || ciudadComboBox.getSelectedItem() == null) {
            return null; 
        }
        String selectedEstado = estadoComboBox.getSelectedItem().toString();
        String selectedCiudad = ciudadComboBox.getSelectedItem().toString();
        String selectedMun = muniComboBox.getSelectedItem().toString();
        String selectedCod = codComboBox.getSelectedItem().toString();
        String selectedCol = colComboBox.getSelectedItem().toString();

        return "Codigo Postal: " + selectedCod + "\n" + "Estado: " + selectedEstado + "\n" + "Ciudad: " + selectedCiudad
                + "\n" + "Municipio: " + selectedMun + "\n" + "Colonia: " + selectedCol;
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Panel de Códigos Postales");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new CodigoPostalPanel());
            frame.pack();
            frame.setVisible(true);
        });
    }
}