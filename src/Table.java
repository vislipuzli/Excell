import java.util.LinkedList;
import java.util.List;

public class Table {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private int rows;
    private int columns;
    private List<Cell> cells;


    public Table(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
    }

    //создаем название ячеек и иниЦиализируем хашмап
    public void setNameOFCells() {
        cells = new LinkedList<>();
        for(int i = 1; i < rows + 1; i++) {
            for(int f = 0; f < columns; f++) {
                char a_char = ALPHABET.charAt(f);
                String cellNumber = a_char + String.valueOf(i);
                Cell cell = new Cell();
                cell.setName(cellNumber);
                cells.add(cell);
            }
        }
    }

    public void setValueOfCells(String valueOfcells){
        String[] s = valueOfcells.split(" ");
        if (s.length != rows * columns) {
            throw new RuntimeException("Error rows are more than you have entered!");
        }

        int i = 0;

        for (Cell cell : cells) {
            cell.setValue(s[i]);
            i++;
        }
    }

    public List<Cell> getCells(){
        return cells;
    }

}