package laryson.martins.model;

public class CalculadoraAntiga implements Matematica {

    public CalculadoraAntiga() {
    }

    @Override
    public double potencia(double base, double expoente) {
        double resultado = base;
        for (int i = 1; i < expoente; i++){
            resultado = resultado * base;
        }
        return resultado;
    }

    @Override
    public int raizQuadrada(int valor) {
        int resultado = valor;
        for (int i = 0; i < 10; i++) {
            resultado = (resultado + valor / resultado) / 2;
        }

        return resultado;
    }
}
