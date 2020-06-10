public class Employee {

    private String name;
    private String surname;
    private String department;

    public Employee(String name, String surname, String department) {
        this.name = name;
        this.surname = surname;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return this.name + " " + this.surname;
    }

    public boolean equals(Employee employee){
        return(this.name.equals(employee.getName()) && this.surname.equals(employee.getSurname()) &&this.department.equals(employee.getDepartment()));
    }

    public int hashCode(){
        return this.name.length()+this.surname.length()+this.department.length();
    }
}
