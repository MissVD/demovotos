package com.example.UI;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.StageStyle;

//clase con métodos estáticos para gestionar las alertas, errores y excepciones
public class Alerta {
    public static void mostrar(String mensaje) {
        //alerta personalizada
        Alert alerta = new Alert(Alert.AlertType.NONE);
        alerta.initStyle(StageStyle.UNDECORATED);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.getDialogPane().getButtonTypes().add(ButtonType.OK);

        //personalizar ventana mediante css directo
        Button ok = (Button) alerta.getDialogPane().lookupButton(ButtonType.OK);
        ok.setStyle("-fx-background-color: #0bcbfb; -fx-background-radius: 20px;-fx-text-fill: #000000ff; -fx-font-size: 11px; -fx-font-weight: bold;");
        ok.setText("ACEPTAR");

        //personalizar botón ok mediante css directo
        DialogPane ventana = alerta.getDialogPane();
        ventana.setStyle("-fx-background-color: #333333;");
        ventana.lookup(".content.label").setStyle("-fx-text-fill: #fdfdfd; -fx-font-size: 14px;");

        alerta.showAndWait();
    }

    public static boolean confirmacion(String mensaje) {
        //alerta de tipo confirmacion
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.initStyle(StageStyle.UNDECORATED);
        alerta.setTitle("Borrar registro");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);

        ImageView icono = new ImageView(new Image(String.valueOf(Alerta.class.getResource("/com/example/images/Error.png"))));
        icono.setFitHeight(48);
        icono.setFitWidth(48);
        alerta.getDialogPane().setGraphic(icono);

        //personalizar ventana mediante css directo
        DialogPane ventana = alerta.getDialogPane();
        ventana.setStyle("-fx-background-color: #333333;");
        ventana.lookup(".content.label").setStyle("-fx-text-fill: #fdfdfd; -fx-font-size: 14px;");

        //personalizar botón ok mediante css directo
        Button ok = (Button) ventana.lookupButton(ButtonType.OK);
        ok.setStyle("-fx-background-color: #8ffca0; -fx-background-radius: 20px; -fx-text-fill: #000000ff; -fx-font-size: 11px; -fx-font-weight: bold;");
        ok.setText("ACEPTAR");

        //personalizar botón cancel mediante css directo
        Button cancel = (Button) ventana.lookupButton(ButtonType.CANCEL);
        cancel.setStyle("-fx-background-color: #0bcbfb; -fx-background-radius: 20px; -fx-text-fill: #000000ff; -fx-font-size: 11px; -fx-font-weight: bold;");
        cancel.setText("CANCELAR");

        //devuelve true o false dependiendo el botón presionado
        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

}
