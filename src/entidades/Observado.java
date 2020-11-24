package entidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface Observado {

    public void addObservador(List<Observador> o);

    public void removerObservador(Observador o);

    public void notificar();

}
