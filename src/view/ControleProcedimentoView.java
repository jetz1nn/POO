/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ControleProcedimentoControl;
import control.PacienteControl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ControleProcedimentoView extends Application {

    Button bEditar;
    Button bBuscar;
    Button bCancelar;

    Label lCod;
    Label lValor;
    Label lCro;
    Label lNome;
    Label lData;

    TextField tCod;
    TextField tValor;
    TextField tCro;
    TextField tNome;
    TextField tDia;
    TextField tAno;
    TextField tMes;

    double largura = 20;
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        lCod = new Label("Codigo: ");
        lNome = new Label("Nome: ");
        lValor = new Label("Valor: ");
        lCro = new Label("Cro: ");
        lData = new Label("Data: ");

        tCod = new TextField();
        tNome = new TextField();
        tValor = new TextField();
        tCro = new TextField();
        tDia = new TextField();
        tMes = new TextField();
        tAno = new TextField();

        bCancelar = new Button("Cancelar");
        bEditar = new Button("Editar");
        bBuscar = new Button("Buscar");

        GridPane root = new GridPane();

        HBox buttonBox = new HBox(10);

        root.addRow(0, lCod, tCod);
        root.addRow(1, lNome, tNome);
        root.addRow(2, lValor, tValor);
        root.addRow(3, lCro, tCro);
        root.addRow(4, lData);
        root.addRow(4, tDia);
        root.addRow(4, tMes);
        root.addRow(4, tAno);
        
        tDia.setPrefWidth(largura);
        tMes.setPrefWidth(largura);
        tAno.setPrefWidth(largura);

        bCancelar.setCancelButton(true);
        root.add(buttonBox, 1, 6);
        root.getChildren().addAll(bEditar, bCancelar, bBuscar);
        buttonBox.getChildren().addAll(bEditar, bCancelar, bBuscar);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        lCod.setLabelFor(tCod);
        lCod.setMnemonicParsing(true);
        lNome.setLabelFor(tNome);
        lNome.setMnemonicParsing(true);
        lValor.setLabelFor(tValor);
        lValor.setMnemonicParsing(true);
        lCro.setLabelFor(tCro);
        lCro.setMnemonicParsing(true);
        lData.setLabelFor(tDia);
        lData.setMnemonicParsing(true);

        root.setStyle("-fx-padding: 50;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: black;");

        bEditar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

            }
        });

        bBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String codigo = tCod.getText();
                ControleProcedimentoControl procedimentocontrol = new ControleProcedimentoControl();
                try {
                    procedimentocontrol.buscar(Integer.parseInt(codigo));
                } catch (IOException ex) {
                    Logger.getLogger(ControleProcedimentoView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControleProcedimentoView.class.getName()).log(Level.SEVERE, null, ex);
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
        stage.setScene(scene);
        stage.setTitle("Controle de Procedimentos");
        stage.show();

    }

}
