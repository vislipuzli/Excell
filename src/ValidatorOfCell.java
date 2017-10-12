import java.util.List;

public class ValidatorOfCell {
    public static void validate(List<Cell> cells, int columns) {
        for (Cell cell : cells) { //перебираем все значения ячеек
            String valueOfCell = cell.getValue(); //присваиваем значение оной ячеки
            if (valueOfCell.matches("=(.*)")) { //проверяем если есть знак =
                cell.setValue(Calculation.searchCalculation(cells, valueOfCell.toCharArray())); //присваиваем ячейке результат вычисления формулы
            }
            if (valueOfCell.matches("'(.*)")){ //проеверяет если есть знак '

            }
            if (Character.isDigit(valueOfCell.charAt(0))) { //првоверяет если первый чар является числом

            }
//            System.out.print(valueOfCell + " ");
        }
        for (int i = 0; i < cells.size(); i++) {
            System.out.print(cells.get(i).getValue() + " ");
            if ((i + 1)%columns == 0) {
                System.out.println(" ");
            }
        }
    }

}
