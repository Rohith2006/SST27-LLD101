package exercise;
public class EmployeeLDAPAdapter implements Employee {
    private final EmployeeLDAP adaptee;

    public EmployeeLDAPAdapter(EmployeeLDAP adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public String getId() {
        return adaptee.getAttribute("uid");
    }

    @Override
    public String getFirstName() {
        return adaptee.getAttribute("givenName");
    }

    @Override
    public String getLastName() {
        return adaptee.getAttribute("sn");
    }

    @Override
    public String getEmail() {
        return adaptee.getAttribute("mail");
    }
}
