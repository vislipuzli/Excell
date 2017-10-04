import java.util.*;

public class TableSize {
    int rows;
    int columns;

    public TableSize(){
        this.rows = rows;
        this.columns = columns;
        Scanner input = new Scanner(System.in);
        rows = input.nextInt();
        columns = input.nextInt();
        initialRows(rows, columns);
    }
//создаем название ячеек и иниЦиализируем хашмап
    void initialRows(int rows, int columns) {

        Map<String, String> treeMap = new TreeMap<String, String>();
        for(int i = 1; i < rows + 1; i++) {
            for(int f = 0; f < columns; f++) {
                String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                char a_char = alphabet.charAt(f);
                String cellNumber =  String.valueOf(i) + a_char;
                treeMap.put(cellNumber, null);
            }
        }
//        Map<String, String> treeMap = new TreeMap<String, String>(myHashMap);
        Parser parser = new Parser(treeMap, rows, columns);
    }



}
