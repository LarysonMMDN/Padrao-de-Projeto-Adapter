package laryson.martins.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import laryson.martins.model.CalculadoraAntiga;
import laryson.martins.model.CalculadoraNova;
import laryson.martins.model.Matematica;

public class CalculadoraController {
    @FXML
    private TextField valorInserido;
    @FXML
    private TextField expoenteInserido;
    @FXML
    private TextArea resultado;
    @FXML
    private HBox camposPotencia;
    @FXML
    private VBox campoExpoente;
    @FXML
    private Label lblOperacao;
    @FXML
    private Button btnCalcular;

    private boolean operacaoPotencia = true;

    // Independente de qual calculadora eu use o sistema vai funcionar igualmente como o esperado
    public Matematica calculo = new CalculadoraNova();
    //public Matematica calculo = new CalculadoraAntiga();

    @FXML
    public void initialize() {
        mostrarPotencia();
    }

    @FXML
    private void mostrarPotencia() {

        operacaoPotencia = true;

        camposPotencia.setVisible(true);
        camposPotencia.setManaged(true);

        campoExpoente.setVisible(true);
        campoExpoente.setManaged(true);

        lblOperacao.setText("Potência");

        valorInserido.clear();
        valorInserido.setMinWidth(120);
        expoenteInserido.clear();
        resultado.clear();

        valorInserido.setPromptText("Base");
        btnCalcular.setText("Calcular potência");
    }

    @FXML
    private void mostrarRaiz() {

        operacaoPotencia = false;

        camposPotencia.setVisible(true);
        camposPotencia.setManaged(true);

        campoExpoente.setVisible(false);
        campoExpoente.setManaged(false);

        lblOperacao.setText("Raiz quadrada");


        valorInserido.clear();
        valorInserido.setMinWidth(250);
        expoenteInserido.clear();
        resultado.clear();

        valorInserido.setPromptText("Valor");
        btnCalcular.setText("Calcular raiz");
    }

    @FXML
    private void calcular() {

        try {

            int valor = Integer.parseInt(
                    valorInserido.getText()
            );

            if (operacaoPotencia) {

                int expoente = Integer.parseInt(
                        expoenteInserido.getText()
                );

                double potencia = calculo.potencia(valor, expoente);

                resultado.setText(
                        valor + " elevado a " + expoente
                                + " = " + potencia
                );

            } else {

                if (valor < 0) {
                    resultado.setText(
                            "Não existe raiz quadrada real de número negativo."
                    );
                    return;
                }

                int raiz = calculo.raizQuadrada(valor);

                resultado.setText(
                        "Raiz quadrada de " + valor
                                + " = " + raiz
                );
            }

        } catch (NumberFormatException e) {

            resultado.setText(
                    "Por favor, digite valores numéricos válidos!"
            );

        }

    }
}
