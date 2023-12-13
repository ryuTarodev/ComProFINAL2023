package company;
import java.util.Objects;
public class Employee implements Comparable<Employee> {
    private final int id;
    private String name;
    public Employee(int id, String name) {
        if (id < 0 || name == null || name.isBlank())
            throw new IllegalArgumentException("Invalid Initialization");
        this.id = id;
        this.name = name;
    }
    public Employee copy() { return new Employee(id, name); }
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) {
        if (name != null && ! name.isBlank()) this.name = name;
    }
    @Override
    public String toString() {
        return "Employee(" + id + ",'" + name + "')";
    }
    @Override
    public int hashCode() { return Objects.hash(id,name); }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        final Employee other = (Employee) obj;
        return this.id == other.id && Objects.equals(this.name, other.name);
    }
    @Override
    public int compareTo(Employee o) { return name.compareTo(o.name); }
}
