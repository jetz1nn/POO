/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.PacienteControl;
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
public class CadastroPacienteView extends Application {
    
    Button bCadastrar;
    Button bCancelar;

    Label lDataNasc;
    Label lNome;
    Label lEndereco;
    Label lTelefone;
    Label lSexo;
    Label lPagamento;

    TextField tDataNasc;
    TextField tNome;
    TextField tEndereco;
    TextField tTelefone;
    //tornar combo
    TextField tSexo;
    //criar combo pagamento
    TextField tPagamento;
    
    public static void main(String[] args){
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        
        lDataNasc = new Label("Data Nascimento: ");
        lNome = new Label("Nome: ");
        lTelefone = new Label("Telefone: ");
        lEndereco = new Label("Endereco: ");
        lSexo = new Label("Sexo: ");
        lPagamento = new Label("Pagamento: ");
        
        tSexo = new TextField();
        tTelefone = new TextField();
        tEndereco = new TextField();
        tNome = new TextField();
        tDataNasc = new TextField();
        tPagamento = new TextField();
        bCadastrar = new Button("Cadastrar");
        bCancelar = new Button("Cancelar");

        GridPane root = new GridPane();

        HBox buttonBox = new HBox(10);
        bCancelar.setCancelButton(true);
        
        root.addRow(0, lDataNasc, tDataNasc);
        root.addRow(1, lNome, tNome);
        root.addRow(2, lEndereco, tEndereco);
        root.addRow(3, lTelefone, tTelefone);
        root.addRow(4, lSexo, tSexo);
        root.add(buttonBox, 1, 6);
        root.getChildren().addAll(bCadastrar, bCancelar);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.getChildren().addAll(bCadastrar, bCancelar);
        
        lDataNasc.setLabelFor(tDataNasc);
        lDataNasc.setMnemonicParsing(true);
        lNome.setLabelFor(tNome);
        lNome.setMnemonicParsing(true);
        lEndereco.setLabelFor(tEndereco);
        lEndereco.setMnemonicParsing(true);
        lTelefone.setLabelFor(tTelefone);
        lTelefone.setMnemonicParsing(true);
        lSexo.setLabelFor(tSexo);
        lSexo.setMnemonicParsing(true);
        
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

                    PacienteControl paciente = new PacienteControl();
                    paciente.cadastrar(tNome.getText(), tDataNasc.getText(), tSexo.getText(), tEndereco.getText(), tTelefone.getText(), tPagamento.getText());

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
        stage.setTitle("Cadastro de Pacientes");
        stage.show();

    
    }

    
}
