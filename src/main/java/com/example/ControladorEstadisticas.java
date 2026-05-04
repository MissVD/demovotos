package com.example;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.DAO.Carrera;
import com.example.DAO.CarrerasDAO;
import com.example.DAO.Clasificacion;
import com.example.DAO.ClasificacionesDAO;
import com.example.DAO.Participante;
import com.example.DAO.ParticipantesDAO;
import com.example.UI.Alerta;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Tooltip;

import javafx.util.StringConverter;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

//pantalla de las Estadísticas
public class ControladorEstadisticas {

    //elementos
    @FXML
    private TextFlow campoDuracionMedia;
    @FXML
    private TextFlow campoMejorMarca;
    @FXML
    private ChoiceBox<String> seleccionFecha;
    @FXML
    private ChoiceBox<Carrera> seleccionCarrera;
    @FXML
    private ChoiceBox<Participante> seleccionParticipante;
    @FXML
    private ChoiceBox<Carrera> seleccionCarreraGrafica;
    @FXML
    private ListView<String> listaParticipantes;
    @FXML
    private ScatterChart<Number, Number> graficaCarreras;
    @FXML
    private NumberAxis ejeX;
    @FXML
    private NumberAxis ejeY;

    //botones para cambiar las vistas y sus animaciones 
    @FXML
    private Button botonCarreras;
    @FXML
    private ImageView imagenBotonCarreras;
    @FXML
    private Button botonParticipantes;
    @FXML
    private ImageView imagenBotonParticipantes;
    @FXML
    private Button botonClasificaciones;   
    @FXML
    private ImageView imagenBotonClasificaciones;
    @FXML
    private Button botonEstadisticas;
    @FXML
    private ImageView imagenBotonEstadisticas;
    @FXML
    private Button botonSalir;
    @FXML
    private ImageView imagenBotonSalir;

    private Image carrera1 = new Image(getClass().getResourceAsStream("/com/example/images/Carrera1.png"));
    private Image carrera2 = new Image(getClass().getResourceAsStream("/com/example/images/Carrera2.png"));
    private Image carrera3 = new Image(getClass().getResourceAsStream("/com/example/images/Carrera3.png"));
    private Image participante1 = new Image(getClass().getResourceAsStream("/com/example/images/Participante1.png"));
    private Image participante2 = new Image(getClass().getResourceAsStream("/com/example/images/Participante2.png"));
    private Image participante3 = new Image(getClass().getResourceAsStream("/com/example/images/Participante3.png"));
    private Image estadisticas1 = new Image(getClass().getResourceAsStream("/com/example/images/Estadisticas1.png"));
    private Image estadisticas2 = new Image(getClass().getResourceAsStream("/com/example/images/Estadisticas2.png"));
    private Image estadisticas3 = new Image(getClass().getResourceAsStream("/com/example/images/Estadisticas3.png"));
    private Image clasificacion1 = new Image(getClass().getResourceAsStream("/com/example/images/Clasificacion1.png"));
    private Image clasificacion2 = new Image(getClass().getResourceAsStream("/com/example/images/Clasificacion2.png"));
    private Image clasificacion3 = new Image(getClass().getResourceAsStream("/com/example/images/Clasificacion3.png"));
    private Image salir1 = new Image(getClass().getResourceAsStream("/com/example/images/Salir1.png"));
    private Image salir2 = new Image(getClass().getResourceAsStream("/com/example/images/Salir2.png"));
    private Image salir3 = new Image(getClass().getResourceAsStream("/com/example/images/Salir3.png"));

    @FXML
    private void botonCarrerasEncima() throws IOException {
        botonCarreras.setLayoutY(16.0);
        imagenBotonCarreras.setImage(carrera3);
    }
    @FXML
    private void botonCarrerasFuera() throws IOException {
        botonCarreras.setLayoutY(18.0);
        imagenBotonCarreras.setImage(carrera1);
    }
    @FXML
    private void botonCarrerasPresionado() throws IOException {
        botonCarreras.setLayoutY(19.0);
        imagenBotonCarreras.setImage(carrera2);

    }
    @FXML
    private void botonCarrerasSoltado() throws IOException {
        botonCarreras.setLayoutY(18.0);
        imagenBotonCarreras.setImage(carrera3);
    }

    @FXML
    private void botonEstadisticasEncima() throws IOException {
        botonEstadisticas.setLayoutY(16.0);
        imagenBotonEstadisticas.setImage(estadisticas3);
    }
    @FXML
    private void botonEstadisticasFuera() throws IOException {
        botonEstadisticas.setLayoutY(18.0);
        imagenBotonEstadisticas.setImage(estadisticas3);
    }
    @FXML
    private void botonEstadisticasPresionado() throws IOException {
        botonEstadisticas.setLayoutY(19.0);
        imagenBotonEstadisticas.setImage(estadisticas2);
    }
    @FXML
    private void botonEstadisticasSoltado() throws IOException {
        botonEstadisticas.setLayoutY(18.0);
        imagenBotonEstadisticas.setImage(estadisticas3);
    }
    
    @FXML
    private void botonClasificacionesEncima() throws IOException {
        botonClasificaciones.setLayoutY(16.0);
        imagenBotonClasificaciones.setImage(clasificacion3);
    }
    @FXML
    private void botonClasificacionesFuera() throws IOException {
        botonClasificaciones.setLayoutY(18.0);
        imagenBotonClasificaciones.setImage(clasificacion1);
    }
    @FXML
    private void botonClasificacionesPresionado() throws IOException {
        botonClasificaciones.setLayoutY(19.0);
        imagenBotonClasificaciones.setImage(clasificacion2);
    }
    @FXML
    private void botonClasificacionesSoltado() throws IOException {
        botonClasificaciones.setLayoutY(18.0);
        imagenBotonClasificaciones.setImage(clasificacion3);
    }

    @FXML
    private void botonParticipantesEncima() throws IOException {
        botonParticipantes.setLayoutY(16.0);
        imagenBotonParticipantes.setImage(participante3);
    }
    @FXML
    private void botonParticipantesFuera() throws IOException {
        botonParticipantes.setLayoutY(18.0);
        imagenBotonParticipantes.setImage(participante1);
    }
    @FXML
    private void botonParticipantesPresionado() throws IOException {
        botonParticipantes.setLayoutY(19.0);
        imagenBotonParticipantes.setImage(participante2);
    }
    @FXML
    private void botonParticipantesSoltado() throws IOException {
        botonParticipantes.setLayoutY(18.0);
        imagenBotonParticipantes.setImage(participante3);
    }

    @FXML
    private void botonSalirEncima() throws IOException {
        imagenBotonSalir.setImage(salir3);
    }

    @FXML
    private void botonSalirFuera() throws IOException {
        imagenBotonSalir.setImage(salir1);
    }

    @FXML
    private void botonSalirPresionado() throws IOException {
        imagenBotonSalir.setImage(salir2);
    }

    @FXML
    private void botonSalirSoltado() throws IOException {
        imagenBotonSalir.setImage(salir3);
    }

    @FXML
    private void vistaCarreras() throws IOException {
        App.setRoot("Carreras");
    }

    @FXML
    private void vistaParticipantes() throws IOException {
        App.setRoot("Participantes");
    }

    @FXML
    private void vistaClasificaciones() throws IOException {
        App.setRoot("Clasificaciones");
    }

    @FXML
    private void vistaEstadisticas() throws IOException {
        App.setRoot("Estadisticas");
    }

    //AnchorPane personalizado para ser arrastrable
    @FXML
    private AnchorPane arrastrable;
    private double x = 0;
    private double y = 0;

    @FXML
    public void initialize() {
        //AnchorPane personalizado para ser arrastrable
        arrastrable.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        arrastrable.setOnMouseDragged(event -> {
            Stage stage = (Stage) arrastrable.getScene().getWindow();
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        //estilo de los elementos mediante un archivo css
        seleccionFecha.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        seleccionCarrera.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        seleccionParticipante.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        seleccionCarreraGrafica.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        listaParticipantes.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        graficaCarreras.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());

        //recuadro duración media
        setCampo(campoDuracionMedia, "00:00:00", "#0bcbfb");
        campoDuracionMedia.setTextAlignment(TextAlignment.CENTER);

        //recuadro mejor marca
        setCampo(campoMejorMarca, "00:00:00", "#8ffca0");
        campoMejorMarca.setTextAlignment(TextAlignment.CENTER);

        actualizarChoiceBoxFecha();
        actualizarChoiceBoxCarrera();
        actualizarChoiceBoxParticipante();
        actualizarChoiceBoxCarreraGrafica();
        actualizarLista();

        //actualizar los recuadros "Mejor Marca" y "Duración Media" según la fecha seleccionada
        seleccionFecha.setOnAction(event -> {
            if (!"Fecha".equals(seleccionFecha.getValue())) {
                
                //resetea los otros choiceBoxes
                seleccionCarrera.setValue(new Carrera(0, "Carrera", "", "", 0));
                seleccionParticipante.setValue(new Participante(0, "Participante", 0, ""));
                
                actualizarEstadisticasPorFecha(seleccionFecha.getValue());
            }
        });

         //actualizar los recuadros "Mejor Marca" y "Duración Media" según la carrera seleccionada
        seleccionCarrera.setOnAction(event -> {
            if (seleccionCarrera.getValue() != null && seleccionCarrera.getValue().getId() != 0) {
                
                //resetea los otros choiceBoxes
                seleccionFecha.setValue("Fecha");
                seleccionParticipante.setValue(new Participante(0, "Participante", 0, ""));
                
                actualizarEstadisticasPorCarrera(seleccionCarrera.getValue().getId());
            }
        });

        //actualizar los recuadros "Mejor Marca" y "Duración Media" según el/la participante seleccionado/a
        seleccionParticipante.setOnAction(event -> {
            if (seleccionParticipante.getValue() != null && seleccionParticipante.getValue().getId() != 0) {
                
                //resetea los otros choiceBoxes
                seleccionFecha.setValue("Fecha");
                seleccionCarrera.setValue(new Carrera(0, "Carrera", "", "", 0));
               
                actualizarEstadisticasPorParticipante(seleccionParticipante.getValue().getId());
            }
        });

        //actualizar los recuadros "Mejor Marca" y "Duración Media" según el/la participante seleccionado/a en la lista
        listaParticipantes.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null && !newVal.isEmpty()) {
                
                //resetea los choiceBoxes
                seleccionFecha.setValue("Fecha");
                seleccionCarrera.setValue(new Carrera(0, "Carrera", "", "", 0));
                seleccionParticipante.setValue(new Participante(0, "Participante", 0, ""));
                
                //busca el participante cuyo nombre coincida con el de la lista
                List<Participante> participantes = ParticipantesDAO.mostrarParticipantes();
                for (Participante participante : participantes) {
                    if (newVal.equals(participante.lista())) {
                        actualizarEstadisticasPorParticipante(participante.getId());
                        break;
                    }
                }
            }
        });

        //cambia el label del eje X (tiempo en segundos ) para que se muestre como un string con formato (HH:MM:SS)
        ejeX.setTickLabelFormatter(new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return segundosATiempo(object.intValue());
            }

            @Override
            public Number fromString(String string) {
                return tiempoASegundos(string);
            }
            });

        //actualizar la gráfica según la carrera seleccionada
        seleccionCarreraGrafica.setOnAction(event -> {
            
            actualizarGrafica();
        });

        //define el eje Y (puestos) para que se muestre del 0 al 11 (los puestos siempre van del 1 al 10)
        ejeY.setAutoRanging(false);
        ejeY.setLowerBound(0);
        ejeY.setUpperBound(11);
        ejeY.setTickUnit(1);
        ejeY.setMinorTickCount(0);

        ejeY.setTickMarkVisible(false);
        ejeX.setTickMarkVisible(false);

        ejeX.setAutoRanging(false);
        ejeX.setLowerBound(0);
        ejeX.setUpperBound(100);
        ejeX.setTickUnit(10);

        graficaCarreras.setLegendVisible(false); 
    }

    //método para actualizar la gráfica de mejores marcas según la carrera
    public void actualizarGrafica(){
        graficaCarreras.getData().clear();
        List<Clasificacion> clasificaciones = puestoTiempoGrafica();

        if (clasificaciones.size()==0){
            if (seleccionCarreraGrafica.getValue().getId()== 0){
                return;
            }
            ejeX.setLowerBound(0);
            ejeX.setUpperBound(100);
            ejeX.setTickUnit(10);
            Alerta.mostrar("No hay registros.");
            seleccionCarreraGrafica.getSelectionModel().selectFirst();
            return;
        }
        List<Participante> participantes = ParticipantesDAO.mostrarParticipantes();
        
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        
        String nombreParticipante = "";
        
        int minTiempo=tiempoASegundos(clasificaciones.get(0).getTiempo());
        int maxTiempo=tiempoASegundos(clasificaciones.get(0).getTiempo());

        for (Clasificacion clasificacion : clasificaciones){
            //sacamos el nombre del participante
            for (Participante participante: participantes){
                if (participante.getId()==clasificacion.getIdParticipante()){
                    nombreParticipante = participante.getNombre();
                    break;
                }
            }

            //obtenemos el menor tiempo para poder definir el menor valor del eje X (tiempo)
            if (tiempoASegundos(clasificacion.getTiempo())<minTiempo){
                minTiempo=tiempoASegundos(clasificacion.getTiempo());
            }

            //obtenemos el mayor tiempo para poder definir el mayor valor del eje X (tiempo)
            if (tiempoASegundos(clasificacion.getTiempo())>maxTiempo){
                maxTiempo=tiempoASegundos(clasificacion.getTiempo());
            }

            //añadimos el nombre de participante como extrValue de cada registro
            XYChart.Data<Number, Number> data = new XYChart.Data<>(tiempoASegundos(clasificacion.getTiempo()), clasificacion.getPuesto());
            data.setExtraValue(nombreParticipante);

            //añadimos el registro a la serie
            series.getData().add(data);
        }

        int tick;
        //si solo hay un registro el ticks del eje X (tiempo) equivaldran al valor de ese único registro
        if (clasificaciones.size()==1){
                tick = 10;
        //si hay mas de un registro se calculara el tamaño de un tick en funcion de la cantidad de registros
        } else {
            tick = (maxTiempo - minTiempo) / clasificaciones.size();
            if (tick == 0) tick = 10;
        }

        //define el eje X (tiempo) segun la menor y mayor marca/tiempo 
        ejeX.setLowerBound(minTiempo-tick);
        ejeX.setUpperBound(maxTiempo+tick);
        ejeX.setTickUnit(tick);
        
        //añade la serie a la gráfica
        graficaCarreras.getData().add(series);

        //muestra el nombre del participante al pasar el ratón por encima del registro
        Platform.runLater(() -> {
            for (XYChart.Data<Number, Number> d : series.getData()) {
                Tooltip.install(d.getNode(), new Tooltip(d.getExtraValue() != null ? d.getExtraValue().toString() : "Participante"));
            }
        });
    }

    //método que devuelve las clasificaciones que coinciden con la carrera del choicebox de la gráfica y cuyas posiciones son menores que 10
    public List<Clasificacion> puestoTiempoGrafica(){
        Carrera carrera = seleccionCarreraGrafica.getValue();
        List<Clasificacion> clasificacionesFiltradas = new ArrayList<>();
        for (Clasificacion clasificacion : ClasificacionesDAO.mostrarClasificaciones()) {
            if (clasificacion.getIdCarrera() == carrera.getId() && (clasificacion.getPuesto() < 11)){
                clasificacionesFiltradas.add(clasificacion);
            }
        }
        clasificacionesFiltradas.sort((c1, c2) -> Integer.compare(c1.getPuesto(), c2.getPuesto()));
        return clasificacionesFiltradas;
    }

    //método para actualizar la lista de participantes
    public void actualizarLista() {
        List<Participante> participantes = ParticipantesDAO.mostrarParticipantes();
        List<String> lista = new ArrayList<>();
        for (Participante p : participantes) {
            lista.add(p.lista());
        }
        listaParticipantes.getItems().setAll(lista);
    }

    //método para limpiar el choicebox de "fechas"
    public void actualizarChoiceBoxFecha() {
        List<Carrera> carreras = CarrerasDAO.mostrarCarreras();
        List<String> fechas = new ArrayList<>();
        fechas.add("Fecha");
        for (Carrera c : carreras) {
            fechas.add(c.getFecha());
        }
        seleccionFecha.setItems(FXCollections.observableArrayList(fechas));
        seleccionFecha.setValue("Fecha");
    }

    //método para limpiar el choicebox de "carreras"
    public void actualizarChoiceBoxCarrera() {
        List<Carrera> carreras = CarrerasDAO.mostrarCarreras();
        Carrera placeholder = new Carrera(0, "Carrera", "", "", 0);
        List<Carrera> items = new ArrayList<>();
        items.add(placeholder);
        items.addAll(carreras);
        seleccionCarrera.setItems(FXCollections.observableArrayList(items));
        seleccionCarrera.setValue(placeholder);
    }

    //método para limpiar el choicebox de "participantes"
    public void actualizarChoiceBoxParticipante() {
        List<Participante> participantes = ParticipantesDAO.mostrarParticipantes();
        Participante placeholder = new Participante(0, "Participante", 0, "");
        List<Participante> items = new ArrayList<>();
        items.add(placeholder);
        items.addAll(participantes);

        seleccionParticipante.setItems(FXCollections.observableArrayList(items));
        seleccionParticipante.setValue(placeholder);
    }

    //método para limpiar el choicebox de "carreras" de la gráfica
    public void actualizarChoiceBoxCarreraGrafica() {
        List<Carrera> carreras = CarrerasDAO.mostrarCarreras();
        Carrera placeholder = new Carrera(0, "Seleccionar carrera", "", "", 0);
        List<Carrera> items = new ArrayList<>();
        items.add(placeholder);
        items.addAll(carreras);
        seleccionCarreraGrafica.setItems(FXCollections.observableArrayList(items));
        seleccionCarreraGrafica.setValue(placeholder);
    }

    //método que devuelve las clasificaciones que coinciden con la fecha del choicebox
    private void actualizarEstadisticasPorFecha(String fecha) {
        List<Carrera> carreras = CarrerasDAO.mostrarCarreras();
        List<Clasificacion> clasificaciones = ClasificacionesDAO.mostrarClasificaciones();
        List<Integer> carrerasFiltradas = new ArrayList<>();

        //lista con los IDs de las carreras que coincidan con la fecha
        for (Carrera carrera : carreras) {
            if (fecha.equals(carrera.getFecha())) {
                carrerasFiltradas.add(carrera.getId());
            }
        }

        //lista con las clasificaciones que coincidan con los IDs de las carreras
        List<Clasificacion> clasificacionesFiltradas = new ArrayList<>();
        for (Clasificacion  clasificacion : clasificaciones) {
            if (carrerasFiltradas.contains( clasificacion.getIdCarrera())) {
                clasificacionesFiltradas.add(clasificacion);
            }
        }
        actualizarCamposEstadistica(clasificacionesFiltradas);
    }

    //método que devuelve las clasificaciones que coinciden con la carrera del choicebox
    private void actualizarEstadisticasPorCarrera(int id) {
        List<Clasificacion> clasificacionesFiltradas = new ArrayList<>();
        for (Clasificacion clasificacion : ClasificacionesDAO.mostrarClasificaciones()) {
            if (clasificacion.getIdCarrera() == id) clasificacionesFiltradas.add(clasificacion);
        }
        actualizarCamposEstadistica(clasificacionesFiltradas);
    }

    //método que devuelve las clasificaciones que coinciden con el participante del choicebox
    private void actualizarEstadisticasPorParticipante(int id) {
        List<Clasificacion> clasificacionesFiltradas = new ArrayList<>();
        for (Clasificacion clasificacion : ClasificacionesDAO.mostrarClasificaciones()) {
            if (clasificacion.getIdParticipante() == id) clasificacionesFiltradas.add(clasificacion);
        }
        actualizarCamposEstadistica(clasificacionesFiltradas);
    }

    //método que actualiza los recuadros Mejor Marca y Duración Media 
    private void actualizarCamposEstadistica(List<Clasificacion> clasificaciones) {
        //si no hay registro
        if (clasificaciones.isEmpty()) {
            setCampo(campoMejorMarca, "--:--:--", "#8ffca0");
            setCampo(campoDuracionMedia, "--:--:--", "#0bcbfb");
            return;
        }

    String mejorTiempo = "--:--:--";
    int sumaSegundos = 0;

    //obtiene la mejor marca y la el tiempo total
    for (Clasificacion c : clasificaciones) {
        String tiempo = c.getTiempo();

        //obtiene la mejor marca
        if (mejorTiempo.equals("--:--:--") || tiempo.compareTo(mejorTiempo) < 0) {
            mejorTiempo = tiempo;
        }

        //obtiene el tiempo total
        sumaSegundos += tiempoASegundos(tiempo);
    }

    //actualiza el campo de MejorMarca con su nuevo valor
    setCampo(campoMejorMarca, mejorTiempo, "#8ffca0");

    //calcula la media en segundos y la convertimos a formato hh:mm:ss
    double mediaSegundos = 0;
    if (clasificaciones.size() > 0) {
        mediaSegundos = (double) sumaSegundos / clasificaciones.size();
    }
    String mediaTiempo = segundosATiempo((int) mediaSegundos);

    //actualiza el campo de DuracionMedia con su nuevo valor
    setCampo(campoDuracionMedia, mediaTiempo, "#0bcbfb");
    }

    //método que convierte el tiempo en formato HH:MM:SS a segundos
    private int tiempoASegundos(String tiempo) {
        String[] tiempoSeparado = tiempo.split(":");
        return Integer.parseInt(tiempoSeparado[0]) * 3600 + Integer.parseInt(tiempoSeparado[1]) * 60 + Integer.parseInt(tiempoSeparado[2]);
    }

    //método que convierte segundos a formato HH:MM:SS
    private String segundosATiempo(int segundosTotal) {
        int hora = segundosTotal / 3600;
        int minutos = (segundosTotal % 3600) / 60;
        int segundos = segundosTotal % 60;
        return String.format("%02d:%02d:%02d", hora, minutos, segundos);
    }

    //método que centra el texto (Mejor Marca/Duración Media) en el TextoFLow
    private void setCampo(TextFlow campo, String texto, String color) {
        campo.getChildren().clear();
        Text centrado = new Text("\n");
        centrado.setFont(Font.font("Helvetica", FontWeight.BOLD, 50));
        Text valor = new Text(texto);
        valor.setFill(Color.web(color));
        valor.setFont(Font.font("Helvetica", FontWeight.BOLD, 32));
        campo.getChildren().addAll(centrado, valor);
    }

    //funcionalidad botón "salir" del programa
    @FXML
    private void cerrarPrograma() throws IOException {
        Platform.exit();
    }
}
