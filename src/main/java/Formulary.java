
import utils.HibernateUtil;
import entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import javax.swing.*;

import javax.swing.table.DefaultTableModel;


import java.util.*;

public class Formulary extends  JFrame {


    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();


    private JButton addButton;
    private JPanel mainPanel;
    private JButton updateButton;
    private JButton usersButton;
    private JButton deleteButton;
    private JTextField textName;
    private JTextField textAge;
    private JTextField textAddress;
    private JTextField textSalary;
    private JTextField textFieldID;
    private JTable table1;
    private JButton findSalary;



    {

            setContentPane(mainPanel);
            setTitle("Employee");
            setSize(1000, 600);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(true);

        }
    private boolean areFieldsEmpty() {
        boolean empty = textName.getText().trim().isEmpty() ||
                textAge.getText().trim().isEmpty() ||
                textAddress.getText().trim().isEmpty() ||
                textSalary.getText().trim().isEmpty();


        System.out.println("Name is empty: " + textName.getText().isEmpty());
        System.out.println("Age is empty: " + textAge.getText().isEmpty());
        System.out.println("Address is empty: " + textAddress.getText().isEmpty());
        System.out.println("Salary is empty: " + textSalary.getText().isEmpty());
        return empty;
    }



    private boolean isValidNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
        private void clearFields() {
            textName.setText("");
            textAge.setText("");
            textAddress.setText("");
            textSalary.setText("");
            textFieldID.setText("");


    }



    public Formulary() {

            //add person..in the database
            //================================================================///


            addButton.addActionListener(e -> {

                if (areFieldsEmpty()) {
                    JOptionPane.showMessageDialog(null, " Please complete all the fields");
                    return;
                }
                try{

                    Operation_DATABASE operation_database = new Operation_DATABASE();
                    String lastName = textName.getText();
                    int age = Integer.parseInt(textAge.getText());
                    String address = textAddress.getText();
                    int salary = Integer.valueOf(textSalary.getText());

                    if (age < 18) {
                        JOptionPane.showMessageDialog(null, " The age must be more then 18 old");
                        return;
                    }
                    if (salary <= 0) {
                        JOptionPane.showMessageDialog(null, " The salary need to be a positive number");
                        return;
                    }

                    Person person = new Person(lastName, age, address, salary);
                    operation_database.addPerson(person);

                    JOptionPane.showMessageDialog(null, "Person saved ..");

                    clearFields();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, " Please enter a valid format ");

                }
            });


            ///update button that you can update the person details
///======================================================================================//
            updateButton.addActionListener(e -> {

                if (areFieldsEmpty()) {
                    JOptionPane.showMessageDialog(null, " Please fill all the fields");
                    return;
                }
                if (textFieldID.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "  Enter the id that want to be update ");
                }
                try {

                    Operation_DATABASE operation_database = new Operation_DATABASE();

                    String lastName = textName.getText();
                    int age = Integer.parseInt(textAge.getText());
                    String address = textAddress.getText();
                    int salary = Integer.valueOf(textSalary.getText());
                    int id = Integer.parseInt(textFieldID.getText());

                    if (age < 18) {
                        JOptionPane.showMessageDialog(null, "  Greater then 18 ");
                        return;
                    }
                    if (salary <= 0) {
                        JOptionPane.showMessageDialog(null, " The salary need to be a positive number");
                        return;
                    }

                    Person person = operation_database.getPersonById(id);

                    if (person == null) {
                        JOptionPane.showMessageDialog(null, " The person with this id doesn't exist!");
                        return;
                    }
                    person.setLastName(lastName);
                    person.setAge(age);
                    person.setAddress(address);
                    person.setSalary(salary);

                    operation_database.updatePerson(person);
                    JOptionPane.showMessageDialog(null, "Person updated ..");

                     clearFields();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, " Please enter a valid format");
                }
            });

            deleteButton.addActionListener(e -> {
                if (textFieldID.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, " Enter the id that want to be deleted");
                    return;
                }
                try {

                    Operation_DATABASE operation_database = new Operation_DATABASE();
                    int id = Integer.parseInt(textFieldID.getText());

                    Person person = operation_database.getPersonById(id);
                    if (person == null) {
                        JOptionPane.showMessageDialog(null, "  Not  person find  with this id");
                    }else {

                        operation_database.deletePerson(id);
                        JOptionPane.showMessageDialog(null, "Person deleted successfully!!");
                    }



               clearFields();


                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, " Please enter  a valid  ID number");

                }
            });


            //This button is to list all the persons from the database

///========================users button========================//


            usersButton.addActionListener(e -> {
                String tbDat[] = {"Id", "Last Name", "Age", "Address", "Salary"};
                DefaultTableModel model = (DefaultTableModel) table1.getModel();


                Operation_DATABASE operation_database = new Operation_DATABASE();

                try {

                    List<Person> list = operation_database.getAllPersons();

                    if (list == null || list.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "  The database is empty");
                        return;
                    }


                    model.setRowCount(0);
                    model.setColumnCount(0);

                    model.addColumn("Id");
                    model.addColumn("Last Name");
                    model.addColumn("Age");
                    model.addColumn("Address");
                    model.addColumn("Salary");

                    model.addRow(tbDat);


                    for (int i = 0; i < list.size(); i++) {
                        List<Integer> id = new Vector<>(Arrays.asList(list.get(i).getId()));
                        List<String> lastName = new Vector<>(Arrays.asList(list.get(i).getLastName()));
                        List<Integer> age = new Vector<>(Arrays.asList(list.get(i).getAge()));
                        List<String> address = new Vector<>(Arrays.asList(list.get(i).getAddress()));
                        List<Double> salary = new Vector<>(Arrays.asList(list.get(i).getSalary()));


                        Vector<Object> row = new Vector<>();

                        row.addElement(id.get(0));
                        row.addElement(lastName.get(0));
                        row.addElement(age.get(0));
                        row.addElement(address.get(0));
                        row.addElement(salary.get(0));
                        model.addRow(row);
                    }


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, " Error loading database");
                    return;
                }
            });


            //If you want to find by salary database
            //=========================//================================//=====================//


////////////////////////////////////////////////
            findSalary.addActionListener(e -> {

                String[] columnName = {"Id", "Last Name", "Age", "Address", "Salary"};
                DefaultTableModel model = (DefaultTableModel) table1.getModel();

                if (textSalary.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, " Please fill in the salary field ");
                    return;
                }
                try {


                    Operation_DATABASE operation_database = new Operation_DATABASE();
                    double salary = Double.parseDouble(textSalary.getText());
                    if (salary <= 0) {
                        JOptionPane.showMessageDialog(null, " The field must be a positive number");
                        return;
                    }
                    List<Person> personsList = operation_database.getBySalary(salary);

                    if (personsList == null || personsList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, " Is not existing persons with this salary");
                        return;
                    }
                    model.setRowCount(0);

                    model.addRow(columnName);

                    for (int i = 0; i < personsList.size(); i++) {
                        List<Integer> id = new Vector<>(Arrays.asList(personsList.get(i).getId()));
                        List<String> lastName = new Vector<>(Arrays.asList(personsList.get(i).getLastName()));
                        List<Integer> age = new Vector<>(Arrays.asList(personsList.get(i).getAge()));
                        List<String> address = new Vector<>(Arrays.asList(personsList.get(i).getAddress()));
                        List<Double> sSalary = new Vector<>(Arrays.asList(personsList.get(i).getSalary()));

                        Vector<Object> row = new Vector<>();


                        row.addElement(id.get(0));
                        row.addElement(lastName.get(0));
                        row.addElement(age.get(0));
                        row.addElement(address.get(0));
                        row.addElement(sSalary.get(0));
                        model.addRow(row);

                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, " The salary must be a valid number");
                }
            });


        }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}




// Thanks and, hope you like it!


























