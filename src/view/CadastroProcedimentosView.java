/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ControleProcedimentoControl;
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
 * @author a1819879
 */
public class CadastroProcedimentosView extends Application {
    
    Button bCadastrar;
    Button bCancelar;

    Label lCodigo;
    Label lNome;
    Label lValor;
    Label lOrientacao;
    Label lData;

    TextField tCodigo;
    TextField tNome;
    TextField tValor;
    TextField tOrientacao;
    TextField tData;
    
    public static void main(String[] args){
        Application.launch(args);
    }
    
    public void start(Stage stage){
        
        lCodigo = new Label("Codigo procedimento: ");
        lNome = new Label("Nome: ");
        lValor = new Label("Valor :");
        lOrientacao = new Label("Orientacao :");
        tCodigo = new TextField();
        tNome = new TextField();
        tValor = new TextField();
        tOrientacao = new TextField();
        bCadastrar = new Button("Cadastrar");
        bCancelar = new Button("Cancelar");
        
        GridPane root = new GridPane();

        HBox buttonBox = new HBox(10);
        bCancelar.setCancelButton(true);
        
        root.addRow(0,lCodigo,tCodigo);
        root.addRow(1,lNome,tNome);
        root.addRow(2,lValor,tValor);
        root.addRow(3,lOrientacao,tOrientacao);
        root.addRow(4, lData, tData);
        tData.setText("DD/MM/YYYY");
        
        root.add(buttonBox, 1, 6);
        root.getChildren().addAll(bCadastrar, bCancelar);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.getChildren().addAll(bCadastrar, bCancelar);
        
        lCodigo.setLabelFor(tCodigo);
        lCodigo.setMnemonicParsing(true);
        lNome.setLabelFor(tNome);
        lNome.setMnemonicParsing(true);
        lValor.setLabelFor(tValor);
        lValor.setMnemonicParsing(true);
        lOrientacao.setLabelFor(tOrientacao);
        lOrientacao.setMnemonicParsing(true);
        
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
                    
                    ControleProcedimentoControl controleProcedimento = new ControleProcedimentoControl();
                    controleProcedimento.cadastrar(tCodigo.getText(), tNome.getText(), tValor.getText(), tData.getText(), tOrientacao.getText());

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
        stage.setScene(scene);
        stage.setTitle("Cadastro de Procedimentos");
        stage.show();
    }
}
