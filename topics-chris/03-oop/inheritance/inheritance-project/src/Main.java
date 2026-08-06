import classes.parttime;
import classes.fulltime;
import classes.contractor;

public class Main {
    public static void main(String[] args) {
        parttime partTimeEmployee = new parttime("Ken", "Part-time Staff", 120.0);
        fulltime fullTimeEmployee = new fulltime("Ana", "Full-time Staff", 300.0);
        contractor contractorEmployee = new contractor("Leo", "Contractor", 250.0);

        System.out.println("Part-time paycheck: " + partTimeEmployee.calculatePayCheck());
        System.out.println("Full-time paycheck: " + fullTimeEmployee.calculatePayCheck());
        System.out.println("Contractor paycheck: " + contractorEmployee.calculatePayCheck());
    }
}