package laryson.martins.model;

public class CalculadoraNova implements Matematica{

    @Override
    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }

    @Override
    public int raizQuadrada(int valor) {
        return (int) Math.sqrt(valor);
    }
}
