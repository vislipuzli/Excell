import java.util.ArrayList;
import java.util.List;

public class Calculation {


    public static String searchCalculation(List<Cell> cells, char[] arrayOfValue) {
        ArrayList formula = createListFromArray(arrayOfValue); //создаем лист из значения ячейки и

        String[] separatedFormula = separateOfArray(formula);//разделяем аррайлист пробелами по +-*/



        String resultOfCell = ifIsLink(cells, separatedFormula);

        return resultOfCell;
    }

    private static String ifIsLink(List<Cell> cells, String[] separatedFormula) {
        String result = null;
        for (int i = 0; i < separatedFormula.length; i++) {
            if (separatedFormula[i].matches("=(.*)")){
                String a = separatedFormula[i];
                String[] linkToValue = a.split("=");//отделяем знак = от ссылки
                String value = linkToValue[1];
                separatedFormula[i] = getByName(cells, value);
                result = separatedFormula[i];
                continue;
            }
            if(separatedFormula[i].matches("-(.*)")){
                String a = separatedFormula[i];
                String[] linkToValue = a.split("-");//отделяем знак = от ссылки
                String value = linkToValue[1];
                separatedFormula[i] = getByName(cells, value);
                result = String.valueOf(Integer.parseInt(result) - Integer.parseInt(separatedFormula[i]));
                continue;
            }
            if(separatedFormula[i].matches("\\+(.*)")){
                String a = separatedFormula[i];
                String[] linkToValue = a.split("\\+");//отделяем знак = от ссылки
                String value = linkToValue[1];
                separatedFormula[i] = getByName(cells, value);
                result = String.valueOf(Integer.parseInt(result) + Integer.parseInt(separatedFormula[i]));
                continue;
            }

            if(separatedFormula[i].matches("\\*(.*)")){
                String a = separatedFormula[i];
                String[] linkToValue = a.split("\\*");//отделяем знак = от ссылки
                String value = linkToValue[1];
                separatedFormula[i] = getByName(cells, value);
                result = String.valueOf(Integer.parseInt(result) * Integer.parseInt(separatedFormula[i]));
                continue;
            }
            if(separatedFormula[i].matches("/(.*)")) { //проверяем если есть знак =+-*/ в каждой ячейке массива
                String a = separatedFormula[i];
                String[] linkToValue = a.split("/");//отделяем знак = от ссылки
                String value = linkToValue[1];
                separatedFormula[i] = getByName(cells, value);
                result = String.valueOf(Integer.parseInt(result) / Integer.parseInt(separatedFormula[i]));
            }


            }

            return result;
        }




    public static ArrayList createListFromArray (char[] listOfValue) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < listOfValue.length; i++) {
            arrayList.add(listOfValue[i]);
        }
        return arrayList;
    }

    public static String[] separateOfArray(ArrayList formula){
        for (int i = 0; i < formula.size(); i++) { //находим знаки +-*/ и разделяем пробелами
            if (formula.get(i).equals('+') || formula.get(i).equals('-') || formula.get(i).equals('*') || formula.get(i).equals('/')) {
                formula.add(i, ' ');
                i++;
            }
        }
        String string = String.valueOf(formula);
        String a = string.replace(", ",""); //удаляем запятые и лишние пробелы
        a = a.replace("[", "");
        a = a.replace("]", "");//удаляем скобки
        String[] result = a.split(" ");//создаем массив значений формулы
        return result;
    }

    private static String getByName(List<Cell> cells, String value) {
        for(int i = 0; i < cells.size(); i++) {//ищет ячейку с именем как в валуе
            if (cells.get(i).getName().equals(value)) {
                value = cells.get(i).getValue();//присваивает значение ячейки с именем валуе в переменную.
            }
        }
        if (value.matches("=(.*)")) { //проверяем если есть знак =
            value = Calculation.searchCalculation(cells, value.toCharArray()); //отправляет на повторное вычисление
        }

        return value;
    }
}





//=B2+C3 5 10 =C1/B1 15 =A2+B1 50 =C2-B2-A2 =A2*B2*C2*D2 10 =A3/C2 =C3+B3+A3

//=A1+B1*C1/5

//=B3-C3

//=A3

//12 =c2 3 =a1+b1*c1/5 =a2*b1 =b3-c3 test =4-3 5