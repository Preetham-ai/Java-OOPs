import java.io.*;

class EmployeeRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int id;
    private transient String password; // Won't be serialized

    public EmployeeRecord(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String toString() {
        return "EmployeeRecord [name=" + name + ", id=" + id + ", password=" + password + "]";
    }

    public static void main(String[] args) {
        EmployeeRecord emp1 = new EmployeeRecord("John Doe", 1001, "secret123");
        EmployeeRecord emp2 = new EmployeeRecord("Jane Smith", 1002, "password456");

        try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("employee1.dat"));
             ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("employee2.dat"))) {

            oos1.writeObject(emp1);
            oos2.writeObject(emp2);
            System.out.println("Employees serialized to files successfully");

        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
            return;
        }

        try (ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("employee1.dat"));
             ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("employee2.dat"))) {

            EmployeeRecord restored1 = (EmployeeRecord) ois1.readObject();
            EmployeeRecord restored2 = (EmployeeRecord) ois2.readObject();

            System.out.println("\nDeserialized Employees:");
            System.out.println(restored1);
            System.out.println(restored2);

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
    }
}
