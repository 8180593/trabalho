package Interfaces;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public interface NetworkADT<T> extends GraphADT<T> {
    void addEdge(T vertex1, T vertex2, double weight);
    double shortestPathWeight(T startVertex, T targetVertex);
}

