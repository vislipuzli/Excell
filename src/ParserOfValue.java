import java.util.Map;


public class ParserOfValue {
    public ParserOfValue(Map<String, String> treeMap){

        }
        static void parsingOfCalculating(Map<String, String> treeMap) {

            for (String value : treeMap.keySet()) {
                String valueOfCell = treeMap.get(value);
                char firstChar = valueOfCell.charAt(0);
                if(firstChar == '=') {
                    String[] formula = valueOfCell.split("=");
                    for (int i = 1; i < valueOfCell.length(); i++) {
                        valueOfCell = formula[1];
                        char a = valueOfCell.charAt(i);
                        if (a == '+')
                            Calculation.addition(value, treeMap, formula);
                        if (a == '*')
                            Calculation.multiple(value, treeMap, formula);
                        if (a == '/')
                            Calculation.division(value, treeMap, formula);
                        if (a == '-')
                            Calculation.subtraction(value, treeMap, formula);
                    }
                }
                valueOfCell = treeMap.get(value);
                firstChar = valueOfCell.charAt(0);// проверка первого чара второй раз
                if (firstChar == '=')
                    Calculation.parseForEquating(value, treeMap); // попадает сюда если в формуле нет +-*/
                if(firstChar == '\'') {
                    System.out.println("testchar");
                }
            }

            //unit test
            for (String key : treeMap.keySet()) {
                String valueOfCell = key;
                char lastChar = valueOfCell.charAt(valueOfCell.length() - 1);
                if(lastChar == 'A')
                    System.out.println("");
                System.out.print(treeMap.get(key) + " ");
            }
    }
}
