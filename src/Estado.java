import java.util.LinkedList;

public class Estado {

    LinkedList<Integer> piezas;
    int costo;
    int heuristica;
    int f;

    public Estado(LinkedList<Integer> piezas, int costo, int heuristica) {
        this.piezas = piezas;
        this.costo = costo;
        this.heuristica = heuristica;
        this.f = costo+ heuristica;
    }
}
