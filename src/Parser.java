import java.util.Map;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class Parser {
    public Parser(Map<String, String> treeMap,int rows,int columns){
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        inputToMap(rows, columns, treeMap, line);

        ParserOfValue.parsingOfCalculating(treeMap);

    }
    public void inputToMap(int rows, int columns, Map<String, String> treeMap, String line){
        String[] s = line.split(" ");
        if(s.length != rows * columns)
            System.out.println("Error");
        int i = 0;
        for (String key : treeMap.keySet()) {
            treeMap.put(key, toUpperCase(s[i]));
            i++;
        }
    }


}
