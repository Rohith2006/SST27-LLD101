package exercise;
public class EmployeeCSVAdapter implements Employee {
    private final EmployeeCSV adaptee;

    public EmployeeCSVAdapter(EmployeeCSV adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public String getId() {
        return adaptee.getId();
    }

    @Override
    public String getFirstName() {
        return adaptee.getFirstName();
    }

    @Override
    public String getLastName() {
        return adaptee.getLastName();
    }

    @Override
    public String getEmail() {
        return adaptee.getEmail();
    }
}
