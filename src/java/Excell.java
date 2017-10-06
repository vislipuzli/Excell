import java.util.List;
import java.util.Scanner;

public class Excell {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int columns = input.nextInt();

        Table table = new Table(rows, columns);

        table.setNameOFCells();

        String valueOfCell = input.nextLine();

        table.setValueOfCells(valueOfCell);

        ValidatorOfCell.validate(table.getCells());
    }
}
// example for 2 2       5 =1a =1a*1b =2a-1b