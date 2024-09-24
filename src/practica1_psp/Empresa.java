package practica1_psp;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Empresa extends JFrame {
    // Estructura de datos para almacenar los empleados
    private ArrayList<Empleado> empleados;
    private int currentIndex = 0;

    // Componentes de la interfaz gráfica
    private JLabel nombreLabel, fechaNacimientoLabel, salarioLabel;
    private JTextField nombreField, fechaNacimientoField, salarioField;
    private JButton primeroButton, anteriorButton, siguienteButton, ultimoButton;

    public Empresa() {
        super("Gestión de Empleados");

        // Inicializamos los empleados precargados
        empleados = new ArrayList<>();
        empleados.add(new Empleado("Juan Pérez", "01/01/1980", 2500.00));
        empleados.add(new Empleado("María López", "15/05/1985", 3000.00));
        empleados.add(new Empleado("Carlos Gómez", "10/08/1990", 2800.00));
        empleados.add(new Empleado("Ana Torres", "22/09/1975", 3200.00));
        empleados.add(new Empleado("Luis Martínez", "18/12/1982", 2700.00));

        // Configuramos los JLabels
        nombreLabel = new JLabel("Nombre:");
        fechaNacimientoLabel = new JLabel("Fecha de Nacimiento:");
        salarioLabel = new JLabel("Salario:");

        // Configuramos los JTextFields
        nombreField = new JTextField(15);
        fechaNacimientoField = new JTextField(15);
        salarioField = new JTextField(15);

        // Campos no editables inicialmente
        nombreField.setEditable(false);
        fechaNacimientoField.setEditable(false);
        salarioField.setEditable(false);

        // Configuramos los JButtons
        primeroButton = new JButton("Primero");
        anteriorButton = new JButton("Anterior");
        siguienteButton = new JButton("Siguiente");
        ultimoButton = new JButton("Último");

        // Panel para los botones de navegación
        JPanel botonesPane = new JPanel();
        botonesPane.setLayout(new FlowLayout());
        botonesPane.add(primeroButton);
        botonesPane.add(anteriorButton);
        botonesPane.add(siguienteButton);
        botonesPane.add(ultimoButton);

        // Panel para etiquetas y campos de texto
        JPanel formPane = new JPanel();
        formPane.setLayout(new GridLayout(3, 2, 10, 10));
        formPane.add(nombreLabel);
        formPane.add(nombreField);
        formPane.add(fechaNacimientoLabel);
        formPane.add(fechaNacimientoField);
        formPane.add(salarioLabel);
        formPane.add(salarioField);

        // Configuramos el panel principal
        JPanel mainPane = new JPanel();
        mainPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPane.setLayout(new BorderLayout());
        mainPane.add(formPane, BorderLayout.CENTER);
        mainPane.add(botonesPane, BorderLayout.SOUTH);

        setContentPane(mainPane);

        // Eventos para los botones
        primeroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarEmpleado(0); // Mostrar el primer empleado
            }
        });

        anteriorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarEmpleadoAnterior();
            }
        });

        siguienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarEmpleadoSiguiente();
            }
        });

        ultimoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarEmpleado(empleados.size() - 1); // Mostrar el último empleado
            }
        });

        // Mostrar el primer empleado
        mostrarEmpleado(0);
        anteriorButton.setEnabled(false);
        ultimoButton.setEnabled(false); // Desactiva el botón de último al inicio
    }

    // Método para mostrar un empleado basado en el índice actual
    private void mostrarEmpleado(int index) {
        if (index >= 0 && index < empleados.size()) {
            Empleado empleado = empleados.get(index);
            nombreField.setText(empleado.getNombre());
            fechaNacimientoField.setText(empleado.getFechaNacimiento());
            salarioField.setText(String.valueOf(empleado.getSalario()));
        }

        // Control de botones
        anteriorButton.setEnabled(index > 0); // Desactiva "Anterior" si estamos en el primero
        siguienteButton.setEnabled(index < empleados.size() - 1); // Desactiva "Siguiente" si estamos en el último
        primeroButton.setEnabled(index > 0); // Desactiva "Primero" si estamos en el primero
        ultimoButton.setEnabled(index < empleados.size() - 1); // Desactiva "Último" si estamos en el último
    }

    // Método para mostrar el empleado anterior
    private void mostrarEmpleadoAnterior() {
        if (currentIndex > 0) {
            currentIndex--;
            mostrarEmpleado(currentIndex);
        }
    }

    // Método para mostrar el siguiente empleado
    private void mostrarEmpleadoSiguiente() {
        if (currentIndex < empleados.size() - 1) {
            currentIndex++;
            mostrarEmpleado(currentIndex);
        }
    }

    public static void main(String[] args) {
        Empresa app = new Empresa();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
        app.setVisible(true);
    }
}

// Clase Empleado
class Empleado {
    private String nombre;
    private String fechaNacimiento;
    private double salario;

    public Empleado(String nombre, String fechaNacimiento, double salario) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public double getSalario() {
        return salario;
    }
}






