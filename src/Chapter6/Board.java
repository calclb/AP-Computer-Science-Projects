package Chapter6;

import java.util.*;

public class Board
{
    private final Map<Integer, ArrayList<Integer>> unfilledCellMap = new HashMap<>();
    private final Marker[][] grid;

    public Board(int size)
    {
        grid = new Marker[size][size];
        for(int i = 0; i < grid.length; i++) Arrays.fill(grid[i], Marker.EMPTY);
        createBoardMapping();
        /*for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                grid[i][j] = Marker.EMPTY;
            }
        }*/
    }

    public void play()
    {
        Scanner s = new Scanner(System.in);
        Marker playerMarker = Marker.X, computerMarker = Marker.O;

        while(getUnfilledCells() > 0)
        {

            int rowToPlace = 0;
            int columnToPlace = 0;

            boolean isValidInput;
            do
            {
                do
                {
                    System.out.print("Specify a row to place " + playerMarker + ": ");
                    try { rowToPlace = s.nextInt(); } catch (Exception ignored) {}
                } while(rowToPlace <= 0 || rowToPlace > grid.length);

                do
                {
                    System.out.print("Specify a column to place " + playerMarker + ": ");
                    try { columnToPlace = s.nextInt(); } catch (Exception ignored) {}
                } while(columnToPlace <= 0 || columnToPlace > grid.length);

                isValidInput = getMarkerAt(rowToPlace-1, columnToPlace-1) == Board.Marker.EMPTY;
                if(!isValidInput) System.out.println("That cell is already filled!");
            } while(!isValidInput);


            System.out.println("Placed marker at (" + rowToPlace + ", " + columnToPlace + ")");
            placeMarkerAt(playerMarker, rowToPlace-1, columnToPlace-1);

            System.out.println(this);
            if(checkForTicTacToe(playerMarker))
            {
                System.out.println("You won!");
                break;
            }

            if(getUnfilledCells() == 0) { System.out.println("The game ended in a cat."); break; }

            System.out.println("The computer is playing...");
            doComputerMarkerPlacement(computerMarker);
            System.out.println(this);
            if(checkForTicTacToe(computerMarker))
            {
                System.out.println("You lost.");
                break;
            }

            if(getUnfilledCells() == 0) { System.out.println("The game ended in a cat."); break; }
        }
    }

    private boolean checkForTicTacToe(Board.Marker m)
    {
        return checkIfRowIsFilledWith(m) || checkIfColumnIsFilledWith(m) || checkIfDiagonalIsFilledWith(m);
    }

    private boolean checkIfRowIsFilledWith(Board.Marker marker)
    {
        for(int i = 0; i < grid.length; i++) if(grid[i][0] != marker) return false;
        return true;
    }

    private boolean checkIfColumnIsFilledWith(Board.Marker marker)
    {
        for(int i = 0; i < grid.length; i++) if(grid[0][i] != marker) return false;
        return true;
    }

    private boolean checkIfDiagonalIsFilledWith(Board.Marker marker) // could produce NPEs if grid length isn't same between rows and columns
    {
        for(int i = 0; i < grid.length; i++) if(grid[i][i] != marker && grid[i][grid.length - (i+1)] != marker) return false;
        return true;
    }

    private void doComputerMarkerPlacement(Marker m)
    {
        Random r = new Random();
        ArrayList<Integer> row = unfilledCellMap.get(r.nextInt(grid.length));
        int rRow = 0;
        for(int i = 0; i < grid.length; i++) if(unfilledCellMap.get(i) == row) rRow = i;
        int rColumn = row.get(r.nextInt(row.size()));
        placeMarkerAt(m, rRow, rColumn);
    }


    private void createBoardMapping()
    {
        for(int i = 0; i < grid.length; i++)
        {
            ArrayList<Integer> coordinateArraylist = new ArrayList<>();
            for(int j = 0; j < grid.length; j++) coordinateArraylist.add(j);
            unfilledCellMap.put(i, coordinateArraylist);
        }
    }

    public void placeMarkerAt(Marker marker, int rowIndex, int columnIndex)
    {
        ArrayList<Integer> al = unfilledCellMap.get(rowIndex);
        boolean replaceable = al.contains(columnIndex);
        if(replaceable)
        {
            grid[rowIndex][columnIndex] = marker;
            al.remove((Integer)columnIndex); // remove by value (not index)
            if(al.isEmpty()) unfilledCellMap.remove(rowIndex);
        }
        // return replaceable;
    }

    public Marker getMarkerAt(int rowIndex, int columnIndex) { return grid[rowIndex][columnIndex]; }

    public int getUnfilledCells()
    {
        int unfilledCells = 0;
        for (Marker[] markers : grid) for (Marker marker : markers) if (marker == Marker.EMPTY) unfilledCells++;
        return unfilledCells;
    }

    public int getGridSize()
    {
        return grid.length;
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < grid.length; i++) s.append("   ").append(i+1);

        for(int i = 0; i < grid.length; i++)
        {
            s.append("\n").append(i+1);
            for(int j = 0; j < grid[i].length; j++)
            {
                s.append("「").append(grid[i][j]).append("」");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public enum Marker
    {
        O("O"), X("X"), EMPTY(" ");

        private final String val;
        Marker(String s) { val = s; }

        public String toString() { return val; }
    }
}
