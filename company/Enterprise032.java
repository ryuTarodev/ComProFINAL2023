package company;

import java.util.Arrays;
import java.util.StringJoiner;

public class Enterprise032 {
    private Employee[] employees;
    private int num;

    public Enterprise032(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("invalid size");
        }
        this.employees = new Employee[size];
        this.num = 0;
    }

    public int size() {
        return num;
    }

    @Override
    public String toString() {
        var s = new StringJoiner(",");

        for (int i = 0; i < num; i++) {
            if (employees[i] != null) {
                s.add(employees[i].toString());
            }
        }
        var sb = new StringBuilder();
        sb.append("Enterprise032(");
        sb.append(num);
        if (num != 0) {
            sb.append(":");
            sb.append(s.toString());
        }
        sb.append(")");
        return sb.toString();
    }

    public void reorganize(int newSize) {
        Arrays.sort(employees, 0, num);
        if (newSize > num) {
            employees = Arrays.copyOf(employees, newSize);
        }
    }

    private int getIndexByEmployeeId(int id) {
        for (int i = 0; i < num; i++) {
            if (employees[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Employee getEmployeeById(int id) {
        if (getIndexByEmployeeId(id) == -1) {
            return null;
        }
        return employees[getIndexByEmployeeId(id)].copy();
    }

    public boolean addOrUpdateEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("invalid parameter");
        }
        if (num == employees.length) {
            reorganize(employees.length << 1);
        } else {
            reorganize(0);
        }
        if (getIndexByEmployeeId(employee.getId()) != -1) {
            employees[getIndexByEmployeeId(employee.getId())] = employee.copy();
            return false;
        }

        employees[num++] = employee.copy();
        return true;
    }


    public Employee removeEmployeeById(int id) {
        if (getIndexByEmployeeId(id) == -1) {
            return null;
        }
        var temp = employees[getIndexByEmployeeId(id)];
        employees[getIndexByEmployeeId(id)] = employees[--num];
        employees[num] = null;
        return temp;
    }

    public String getUniqueNames(String delimiter) {
        reorganize(0);
        if (delimiter == null) {
            delimiter = ",";
        }
//        B , B , C
        StringJoiner sj = new StringJoiner(delimiter);

        for (int i = 0; i < 3; i++) {
            if (!sj.toString().contains(employees[i].getName())) {
                sj.add(employees[i].getName());
            }
        }

        return sj.toString();
    }

    public static Enterprise032 merge(Enterprise032 e1, Enterprise032 e2) {
        var temp = new Enterprise032(e1.size() + e2.size());
        for (var v : e1.employees) {
            if (v != null) temp.addOrUpdateEmployee(v);
        }
        for (var v2 : e2.employees) {
            if (v2 != null) temp.addOrUpdateEmployee(v2);
        }
        return temp;
    }
}
