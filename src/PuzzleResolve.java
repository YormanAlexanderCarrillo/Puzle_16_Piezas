import java.util.*;

public class PuzzleResolve {

    public int distanciaManhattan (LinkedList<Integer> piezas){
        int distancia =0;
        for (int i =0; i <piezas.size(); i++){
            if (piezas.get(i) != 0){
                int filaActual = i/4;
                int columnaActual = i%4;
                int filaFinal = (piezas.get(i) -1) /4;
                int columnaFinal = (piezas.get(i) - 1 ) %4;
                distancia += Math.abs(filaActual-filaFinal) + Math.abs(columnaActual - columnaFinal);

            }
        }
       // System.out.println("distancia: " +distancia);
        return distancia;
    }

    public void resolverPuzle(LinkedList<Integer> estadoInicial, LinkedList<Integer> estadoFinal){

        PriorityQueue<Estado> colaPrioridad = new PriorityQueue<>(new Comparator<Estado>() {
            @Override
            public int compare(Estado e1, Estado e2) {
                return e1.f - e2.f;
            }
        });
        Map<String, Integer> visitados = new HashMap<>();

        Estado estadoActual = new Estado(estadoInicial, 0, distanciaManhattan(estadoInicial));
        colaPrioridad.add(estadoActual);
        while (!colaPrioridad.isEmpty()){
            estadoActual = colaPrioridad.poll();
           // System.out.println("Estado Actual: " + estadoActual.piezas);

            for (int i = 0; i < estadoActual.piezas.size(); i++) {
                System.out.print(estadoActual.piezas.get(i) + "\t");
                if ((i + 1) % 4 == 0) {
                    System.out.println(); // Cambiar de línea después de cada fila
                }
            }
            System.out.println();

            if (estadoActual.piezas.equals(estadoFinal)){
                System.out.println("Solucion Encontrada");
                break;
            }

            visitados.put(estadoActual.piezas.toString(), estadoActual.costo);
            //System.out.println(visitados);
            int posicionEspacioBlanco = estadoActual.piezas.indexOf(0);
            int fila = posicionEspacioBlanco /4;
            int columna = posicionEspacioBlanco %4;

            if (fila >0){
                LinkedList<Integer> nuevoEstado = new LinkedList<>(estadoActual.piezas);
                Collections.swap(nuevoEstado, posicionEspacioBlanco, posicionEspacioBlanco -4);
                String nuevoEstadoString = nuevoEstado.toString();
                if (!visitados.containsKey(nuevoEstadoString)){
                    Estado nuevoEstadoObj = new Estado(nuevoEstado, estadoActual.costo +1, distanciaManhattan(nuevoEstado));
                    colaPrioridad.add(nuevoEstadoObj);
                }
            }

            if (fila < 3){
                LinkedList<Integer> nuevoEstado = new LinkedList<>(estadoActual.piezas);
                Collections.swap(nuevoEstado, posicionEspacioBlanco, posicionEspacioBlanco + 4);

                String nuevoEstadoString = nuevoEstado.toString();
                if (!visitados.containsKey(nuevoEstadoString)) {
                    Estado nuevoEstadoObj = new Estado(nuevoEstado, estadoActual.costo + 1, distanciaManhattan(nuevoEstado));
                    colaPrioridad.add(nuevoEstadoObj);
                }
            }

            if (columna > 0) {
                LinkedList<Integer> nuevoEstado = new LinkedList<>(estadoActual.piezas);
                Collections.swap(nuevoEstado, posicionEspacioBlanco, posicionEspacioBlanco - 1);

                String nuevoEstadoString = nuevoEstado.toString();
                if (!visitados.containsKey(nuevoEstadoString)) {
                    Estado nuevoEstadoObj = new Estado(nuevoEstado, estadoActual.costo + 1, distanciaManhattan(nuevoEstado));
                    colaPrioridad.add(nuevoEstadoObj);
                }
            }

            if (columna < 3) {
                LinkedList<Integer> nuevoEstado = new LinkedList<>(estadoActual.piezas);
                Collections.swap(nuevoEstado, posicionEspacioBlanco, posicionEspacioBlanco + 1);

                String nuevoEstadoString = nuevoEstado.toString();
                if (!visitados.containsKey(nuevoEstadoString)) {
                    Estado nuevoEstadoObj = new Estado(nuevoEstado, estadoActual.costo + 1, distanciaManhattan(nuevoEstado));
                    colaPrioridad.add(nuevoEstadoObj);
                }
            }
        }
    }
}
