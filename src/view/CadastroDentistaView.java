/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DentistaControl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author matha
 */
public class CadastroDentistaView extends Application {

    Button bCadastrar;
    Button bCancelar;

    Label lCro;
    Label lNome;
    Label lEndereco;
    Label lTelefone;
    Label lEspecialidade;

    TextField tCro;
    TextField tNome;
    TextField tEndereco;
    TextField tTelefone;
    TextField tEspecialidade;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        lCro = new Label("CRO: ");
        lNome = new Label("Nome: ");
        lTelefone = new Label("Telefone: ");
        lEndereco = new Label("Endereco: ");
        lEspecialidade = new Label("Especialidade: ");
        tEspecialidade = new TextField();
        tTelefone = new TextField();
        tEndereco = new TextField();
        tNome = new TextField();
        tCro = new TextField();
        bCadastrar = new Button("Cadastrar");
        bCancelar = new Button("Cancelar");

        GridPane root = new GridPane();

        HBox buttonBox = new HBox(10);
        bCancelar.setCancelButton(true);
        
        root.addRow(0, lCro, tCro);
        root.addRow(1, lNome, tNome);
        root.addRow(2, lEndereco, tEndereco);
        root.addRow(3, lTelefone, tTelefone);
        root.addRow(4, lEspecialidade, tEspecialidade);
        root.add(buttonBox, 1, 6);
        root.getChildren().addAll(bCadastrar, bCancelar);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.getChildren().addAll(bCadastrar, bCancelar);

        lCro.setLabelFor(tCro);
        lCro.setMnemonicParsing(true);
        lNome.setLabelFor(tNome);
        lNome.setMnemonicParsing(true);
        lEndereco.setLabelFor(tEndereco);
        lEndereco.setMnemonicParsing(true);
        lTelefone.setLabelFor(tTelefone);
        lTelefone.setMnemonicParsing(true);
        lEspecialidade.setLabelFor(tEspecialidade);
        lEspecialidade.setMnemonicParsing(true);

        root.setStyle("-fx-padding: 50;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: black;");

        bCadastrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {

                    DentistaControl dentista = new DentistaControl();
                    dentista.cadastrar(tCro.getText(), tNome.getText(), tEndereco.getText(), tTelefone.getText(), tEspecialidade.getText());

                } catch (Exception ex) {

                    System.out.println(ex.getMessage());

                }

            }
        });

        bCancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.exit(1);
            }
        });
        Scene scene = new Scene(root);

// Add the scene to the Stage
        stage.setScene(scene);
// Set the title of the Stage
        stage.setTitle("Cadastro de Dentista");
// Display the Stage
        stage.show();

    }
}
