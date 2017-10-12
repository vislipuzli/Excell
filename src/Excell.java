import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class Excell {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int columns = input.nextInt();

        Table table = new Table(rows, columns);

        table.setNameOFCells();
        Scanner inputValue = new Scanner(System.in);
        String valueOfCell = inputValue.nextLine();

        table.setValueOfCells(toUpperCase(valueOfCell));

        ValidatorOfCell.validate(table.getCells(), columns);

    }
}
// example for 2 2       5 =1a =1a*1b =2a-1b