import java.util.Map;


public class Calculation {
    public Calculation(){

    }
//вычисляем приравнивание
    static void parseForEquating(String value, Map<String, String> treeMap) {
        String stringForEquating = treeMap.get(value);
        String[] formula = stringForEquating.split("=");
        for (int i = 1; i < stringForEquating.length(); i++){
            char a = stringForEquating.charAt(i);
            if (a == '+')
                addition(value, treeMap, formula);
            if (a == '*')
                multiple(value, treeMap, formula);
            if (a == '/')
                division(value, treeMap, formula);
            if (a == '-')
                subtraction(value, treeMap, formula);
        }

        String valueOfCell = treeMap.get(value);
        String[] ValueOfEquating = stringForEquating.split("=");
        String keyForEquating = value;
        String valueForKey = treeMap.get(ValueOfEquating[1]);
        treeMap.put(keyForEquating, valueForKey);
    }

//вычисляем сложение
    static void addition(String value, Map<String, String> treeMap, String[] formula) {

        String[] s = formula[1].split("\\+"); // убираем знак +
        int result = 0;
        for (int i = 0; i < s.length; i++) {
            String f = treeMap.get(s[i]);//проверяем если в ячейке лежит ссылка
            char firstChar = f.charAt(0);
            if(firstChar == '=') {
                parseForEquating(s[i], treeMap); // выполняем ссылку
            }
            int x = Integer.parseInt(treeMap.get(s[i]));

            result = result + x;
        }
        treeMap.put(value, String.valueOf(result));
    }


    //вычисляем умножение
    static void multiple(String value, Map<String, String> treeMap, String[] formula){

        String[] s = formula[1].split("\\*"); // убираем знак +
        int result = 1;
        for (int i = 0; i < s.length; i++) {
            String f = treeMap.get(s[i]);//проверяем если в ячейке лежит ссылка
            char firstChar = f.charAt(0);
            if(firstChar == '=') {
                parseForEquating(s[i], treeMap); // выполняем ссылку
            }
            int x = Integer.parseInt(treeMap.get(s[i]));

            result = result * x;
        }
        treeMap.put(value, String.valueOf(result));
    }

    //вычисляем деление
    static void division(String value, Map<String, String> treeMap, String[] formula) {

        String[] s = formula[1].split("/"); // убираем знак +

        for (int i = 0; i < (s.length - 1); i++) {
            String f = treeMap.get(s[i]);//проверяем если в ячейке лежит ссылка
            char firstChar = f.charAt(0);                                               //lenght 3 [0][1][2]
            if(firstChar == '=') {
                parseForEquating(s[i], treeMap); // выполняем ссылку
            }
        }

        int result = Integer.parseInt(treeMap.get(s[0]));
        for (int i = 1; i < (s.length); i++) {
            result = result / Integer.parseInt(treeMap.get(s[i]));
        }
        treeMap.put(value, String.valueOf(result));
    }


//вычисляем вычитание
    static void subtraction(String value, Map<String, String> treeMap, String[] formula) {

        String[] s = formula[1].split("-"); // убираем знак +

        for (int i = 0; i < (s.length - 1); i++) {
            String f = treeMap.get(s[i]);//проверяем если в ячейке лежит ссылка
            char firstChar = f.charAt(0);
            if(firstChar == '=') {
                parseForEquating(s[i], treeMap); // выполняем ссылку
            }
        }

        int result = Integer.parseInt(treeMap.get(s[0]));
        for (int i = 1; i < (s.length); i++) {
            result = result - Integer.parseInt(treeMap.get(s[i]));
        }
        treeMap.put(value, String.valueOf(result));
    }
}


//    1 2 3 =1c+1b+1a =1d =1a+2a =1a*1b*2b =2c*2b*2a =2d =3a+2b =3b+2c =2d/1d
// =2b+3c 5 10 =1c/1b 15 =2a+1b 50 =2c-2b-2a =2a*2b*2c*2d 10 =3a/2c =3c+3b+3a