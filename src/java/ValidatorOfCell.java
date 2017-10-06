import java.util.List;
import java.util.Map;


public class ValidatorOfCell {

    public static void validate(List<Cell> cells) {

            for (Cell cell : cells) {
                String value = cell.getValue();
                char firstChar = value.charAt(0);
                if(firstChar == '=') {
                    String[] formula = value.split("=");
                    for (int i = 1; i < value.length(); i++) {
                        value = formula[1];
                        char a = value.charAt(i);
                        if (a == '+')
                            Calculation.addition(cell.getName(), cells, formula);
                        if (a == '*')
                            Calculation.multiple(cell.getName(), cells, formula);
                        if (a == '/')
                            Calculation.division(cell.getName(), cells, formula);
                        if (a == '-')
                            Calculation.subtraction(cell.getName(), cells, formula);
                    }
                }

                firstChar = cell.getValue().charAt(0);// проверка первого чара второй раз

                if (firstChar == '=')
                    Calculation.parseForEquating(cell.getName(), cells); // попадает сюда если в формуле нет +-*/
                if(firstChar == '\'') {
                    System.out.println("testchar");
                }
            }

            for (Cell cell : cells) {
                String nameOfCell = cell.getName();

                char firstChar = nameOfCell.charAt(0);

                if(firstChar == 'A') {
                    System.out.print("\n" + cell.getValue() + " ");
                }
            }
    }
}
