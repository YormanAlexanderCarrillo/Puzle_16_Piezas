
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        //LinkedList<Integer> estadoInicial = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 0, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 5));
        LinkedList<Integer> estadoInicial = new LinkedList<>(Arrays.asList(1, 2, 3, 0, 5, 6, 7, 8, 9, 10, 11, 12, 13,4,  14, 15));
        LinkedList<Integer> estadoFinal = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0));

        PuzzleResolve puzzleResolve = new PuzzleResolve();
        puzzleResolve.resolverPuzle(estadoInicial, estadoFinal);

    }
}