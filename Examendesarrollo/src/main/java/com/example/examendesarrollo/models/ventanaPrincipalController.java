package com.example.examendesarrollo.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class ventanaPrincipalController implements Initializable {

    @FXML
    private TextField txtnombre;
    @FXML
    private Label labelduracion;
    @FXML
    private Slider sliderduracion;
    @FXML
    private ComboBox<String> combodificultad;
    @FXML
    private ListView<String> listtipo;
    @FXML
    private Button btnanadir;
    @FXML
    private TableView<Examen_desarrollo> tabla;
    @FXML
    private TableColumn<Examen_desarrollo,String> cduracion;
    @FXML
    private TableColumn<Examen_desarrollo,String> cdificultad;
    @FXML
    private TableColumn<Examen_desarrollo,String> ctipo;
    @FXML
    private Label info;
    @FXML
    private TableColumn<Examen_desarrollo,String> cnombre;
    @FXML
    private MenuItem menusalir;
    @FXML
    private MenuItem menuacercade;
    @FXML
    private ComboBox<Examen_desarrollo> examenDesarrolloComboBox;
    @FXML
    private ToggleGroup dificultad;
    @FXML
    private ImageView carita;
    private MediaPlayer mediaPlayer;

    @FXML
    protected void onHelloButtonClick() {

    }

    @FXML
    public void insertarexamenDesarrollo(ActionEvent actionEvent) {
        if(!txtnombre.getText().isEmpty()){
            Examen_desarrollo examenDesarrollo = new Examen_desarrollo();
            examenDesarrollo.setNombre(txtnombre.getText());
            examenDesarrollo.setTipo(listtipo.getSelectionModel().getSelectedItem());
            examenDesarrollo.setDuracion((int) sliderduracion.getValue());
            examenDesarrollo.setDificultad( combodificultad.getSelectionModel().getSelectedItem());
            tabla.getItems().add(examenDesarrollo);
            info.setText(examenDesarrollo.toString());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        sliderduracion.setValue(60);
        labelduracion.setText(Math.round(sliderduracion.getValue())+ " min");

        sliderduracion.valueProperty().addListener((observableValue, number, t1) -> labelduracion.setText(t1.intValue()+ " min"));



        tabla.getSelectionModel().selectedItemProperty().addListener(
                (observable, vold, vnew)->{
                    info.setText(vnew.toString());
                    txtnombre.setText(vnew.getNombre());
                    sliderduracion.setValue(vnew.getDuracion());
                    listtipo.getSelectionModel().select(vnew.getTipo());
                    combodificultad.getSelectionModel().select(vnew.getDificultad());
                    
                }
        );


        cnombre.setCellValueFactory((fila)-> {
            String nombre = fila.getValue().getNombre();
            return new SimpleStringProperty(nombre);
        } );

        ctipo.setCellValueFactory((fila)-> new SimpleStringProperty(fila.getValue().getTipo()));

        cduracion.setCellValueFactory((fila)-> {
            String duracion = fila.getValue().getDuracion().toString()+" min";
            return new SimpleStringProperty(duracion);
        });

        cdificultad.setCellValueFactory((fila)-> new SimpleStringProperty(fila.getValue().getDificultad()));


        ChoiceBox<Examen_desarrollo> comboexamenDesarrollo = null;
        comboexamenDesarrollo.setConverter(new StringConverter<>() {
            @Override
            public String toString(Examen_desarrollo examenDesarrollo) {
               if(examenDesarrollo!=null) {return examenDesarrollo.getNombre();}
               else {return null;}
            }

            @Override
            public Examen_desarrollo fromString(String s) {
                return null;
            }
        });

        comboexamenDesarrollo.getItems().addAll(tabla.getItems());

    }

    @FXML
    public void salir(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void acercade(ActionEvent actionEvent) {
        var alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setContentText("");
        alert.showAndWait();

    }


}