package com.example;
import com.example.DAO.Carrera;
import com.example.DAO.CarrerasDAO;
import com.example.DAO.Clasificacion;
import com.example.DAO.ClasificacionesDAO;
import com.example.DAO.Participante;
import com.example.DAO.ParticipantesDAO;
import com.example.UI.Alerta;
import com.example.UI.Validar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//pantalla de las Clasificaciones
public class ControladorClasificaciones {

    //variable para comprobar si se esta editando un registro
    private boolean esEdicion = false;

    //variable auxiliar para guardar la clasificación editada
    private Clasificacion clasificacionEdicion = null;

    //variable para comprobar si está buscando un registro en la tabla
    private boolean hayBusqueda=false;

    //imagenes para los botones editar y borrar de la tabla
    private Image imagenEditar = new Image(getClass().getResourceAsStream("/com/example/images/IconoEditar.png"));
    private Image imagenBorrar = new Image(getClass().getResourceAsStream("/com/example/images/IconoBorrar.png"));

     //botón "añadir" del formulario y su animación
    @FXML
    private Button botonFormularioAnadir;

    @FXML
    private void botonFormularioEncima() throws IOException {
        botonFormularioAnadir.setStyle("-fx-background-color: #0bcbfb; -fx-background-radius: 20; -fx-text-fill: #262626;");
    }

    @FXML
    private void botonFormularioFuera() throws IOException {
        botonFormularioAnadir.setStyle("-fx-background-color: #8ffca0; -fx-background-radius: 20; -fx-text-fill: #262626;");
    }

    @FXML
    private void botonFormularioPresionado() throws IOException {
        botonFormularioAnadir.setLayoutY(493.0);
    }

    @FXML
    private void botonFormularioSoltado() throws IOException {
        botonFormularioAnadir.setLayoutY(492.0);
    }

    //botón "buscar" de la tabla y su animación
    @FXML
    private Button botonTablaBuscar;

    private Image buscar = new Image(getClass().getResourceAsStream("/com/example/images/IconoBuscar.png"));
    private Image buscarSalir = new Image(getClass().getResourceAsStream("/com/example/images/IconoBuscarSalir.png"));
    private ImageView iconoBuscar = new ImageView(buscar);

    @FXML
    private void botonBusquedaEncima() throws IOException {
        botonTablaBuscar.setStyle("-fx-background-color: #8ffca0; -fx-background-radius: 20; -fx-text-fill: #262626;");
    }

    @FXML
    private void botonBusquedaFuera() throws IOException {
        botonTablaBuscar.setStyle("-fx-background-color: #0bcbfb; -fx-background-radius: 20; -fx-text-fill: #262626;");
    }

    @FXML
    private void botonBusquedaPresionado() throws IOException {
        botonTablaBuscar.setLayoutY(94.0);
    }

    @FXML
    private void botonBusquedaSoltado() throws IOException {
        botonTablaBuscar.setLayoutY(92.0);
    }

    //elementos
    @FXML
    private TextField campoFormularioPuesto;

    @FXML
    private TextField campoFormularioTiempo;

    @FXML
    private ChoiceBox<Carrera> seleccionCarrera;

    @FXML
    private ChoiceBox<Participante> seleccionParticipante;

    @FXML
    private ChoiceBox<Carrera> seleccionarCarrerTabla;

    @FXML
    private TableView<Clasificacion> tablaClasificaciones;

    @FXML
    private TableColumn<Carrera, String> columnaTablaCarrera;

    @FXML
    private TableColumn<Participante, String> columnaTablaParticipante;

    @FXML
    private TableColumn<Clasificacion, String> columnaTablaPuesto;

    @FXML
    private TableColumn<Clasificacion, Integer> columnaTablaTiempo;   

    @FXML
    private TableColumn<Clasificacion, Void> columnaTablaOpciones;

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
        imagenBotonEstadisticas.setImage(estadisticas1);
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
        imagenBotonClasificaciones.setImage(clasificacion3);
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

        //valores de las columnas de la tabla
        columnaTablaCarrera.setCellValueFactory(new PropertyValueFactory<>("nombreCarrera"));
        columnaTablaParticipante.setCellValueFactory(new PropertyValueFactory<>("nombreParticipante"));
        columnaTablaPuesto.setCellValueFactory(new PropertyValueFactory<>("puesto"));
        columnaTablaTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempo"));
        columnaTablaOpciones.setResizable(false);
        
        //estilo de los elementos mediante un archivo css
        campoFormularioPuesto.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        campoFormularioTiempo.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        seleccionCarrera.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        seleccionParticipante.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        seleccionarCarrerTabla.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        tablaClasificaciones.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        
        //tamaño fijo para el botón "buscar" de la tabla
        botonTablaBuscar.setMaxWidth(32);
        botonTablaBuscar.setMaxHeight(32);
        botonTablaBuscar.setMinWidth(32);
        botonTablaBuscar.setMinHeight(32);
        botonTablaBuscar.setGraphic(iconoBuscar);

        //opciones de los choicebox de carreras y de participantes
        List<Carrera> carreras = CarrerasDAO.mostrarCarreras();
        List<Participante> participantes = ParticipantesDAO.mostrarParticipantes();
        seleccionCarrera.setItems(FXCollections.observableArrayList(carreras));
        seleccionParticipante.setItems(FXCollections.observableArrayList(participantes));

        agregarBotonesATabla();
        actualizarTabla();
        actualizarChoiceBox();
    }

    //funcionalidad botón "añadir" del formulario
    @FXML
    private void anadirClasificacion() throws IOException {
        //comprueba que todos los campos son válidos
        if (campoFormularioPuesto.getText().trim().isEmpty() || campoFormularioTiempo.getText().trim().isEmpty() || seleccionCarrera.getValue()==null || seleccionParticipante.getValue()==null) {
            Alerta.mostrar("Rellene y seleccione todos los campos.");
            return;
        } else if (Validar.contieneCaracteres(campoFormularioPuesto.getText())) {
            Alerta.mostrar("Distancia solo puede contener números.");
            return;
        } else if (Validar.formatoTiempoInvalido(campoFormularioTiempo.getText())) {
            Alerta.mostrar("Tiempo debe seguir el formato (HH:MM:SS).");
            return;
        } else if (Validar.tiempoInvalido(campoFormularioTiempo.getText())) {
            Alerta.mostrar("Tiempo inválido.");
            return;

        //comprueba si se trata de una edición y modifica el registro
        } else if (esEdicion) {
            int carrera = seleccionCarrera.getValue().getId();
            int participante = seleccionParticipante.getValue().getId();
            String puesto =  campoFormularioPuesto.getText();
            String tiempo =  campoFormularioTiempo.getText();
            clasificacionEdicion.setIdCarrera(carrera);
            clasificacionEdicion.setIdParticipante(participante);
            clasificacionEdicion.setPuesto(Integer.parseInt(puesto));
            clasificacionEdicion.setTiempo(tiempo);
            ClasificacionesDAO.modificarClasificacion(clasificacionEdicion);
            actualizarTabla();
            limpiarCampos();
            esEdicion = false;
            botonFormularioAnadir.setText("AÑADIR");
            Alerta.mostrar("Se ha editado correctamente.");

        //si no se trata de una edición se añade el registro
        } else {
            int carrera = seleccionCarrera.getValue().getId();
            int participante = seleccionParticipante.getValue().getId();
            String puesto =  campoFormularioPuesto.getText();
            String tiempo =  campoFormularioTiempo.getText();
            Clasificacion clasificacion = new Clasificacion(0, carrera, participante, Integer.parseInt(puesto), tiempo);

            //comprueba si la clasificación ya existe
            if (Validar.clasificacionExiste(clasificacion)){
                Alerta.mostrar("Clasificicación duplicada.");
                return;
            } else if (Validar.mismoParticipanteCarrera(clasificacion)) {
                Alerta.mostrar("Participante duplicado/a en dicha carrera.");
                return;
            } else if (Validar.puestoRepetido(clasificacion)) {
                Alerta.mostrar("Puesto duplicado/a en dicha carrera.");
                return;
            }

            ClasificacionesDAO.insertarClasificacion(clasificacion);
            actualizarTabla();
            limpiarCampos();
        } 
    }

    //funcionalidad botón "buscar" de la tabla
    @FXML
    private void abrirBusqueda() throws IOException {
        //cancela la busqueda
        if (hayBusqueda){
            actualizarTabla();
            actualizarChoiceBox();
            iconoBuscar.setImage(buscar);
            seleccionarCarrerTabla.setDisable(false);
            hayBusqueda=false;
            return;
        }

        List<Clasificacion> coincidencias = new ArrayList<Clasificacion>();
        List<Clasificacion> listaCompletaID = ClasificacionesDAO.mostrarClasificaciones();
        List<Clasificacion> listaCompletaNombre = ClasificacionesDAO.mostrarClasificacionesNombres();
        Carrera busqueda = seleccionarCarrerTabla.getValue();

        //valida si el campo de busqueda está vacio o si no hay registros en la tabla
        if (seleccionarCarrerTabla.getValue().toString().equals("Seleccionar carrera")) {
                Alerta.mostrar("Campo de busqueda vacío.");
                return;
        }  
        if (Validar.listaClasificacionesVacia(listaCompletaID))  {
                Alerta.mostrar("No hay registros.");
                return;
        }

        //añade todas las clasificaciones que coincidan con seleccion del choicebox
        for (int i=0; i<listaCompletaID.size(); i++){
            if ((listaCompletaID.get(i).getIdCarrera()==busqueda.getId())){
                    coincidencias.add(listaCompletaNombre.get(i));
            }  
        } 

        //si no hay coincidencias se muestra una alerta
        if (coincidencias.isEmpty()) {
            Alerta.mostrar("No se encontraron coincidencias.");
            actualizarChoiceBox();
            return;
        }

        //actualiza la tabla con las coincidencias
        tablaClasificaciones.getItems().clear();
        tablaClasificaciones.getItems().setAll(coincidencias);
        iconoBuscar.setImage(buscarSalir);
        seleccionarCarrerTabla.setDisable(true);
        hayBusqueda=true;
    }

    //método para añadir los botones de editar y borrar en cada registro de la tabla
    private void agregarBotonesATabla() {
        columnaTablaOpciones.setCellFactory(col -> new TableCell<>() {
        private final Button editar = new Button();
        private final Button borrar = new Button();

        {   //estilo de los botones
            editar.setStyle("-fx-background-color: #0bcbfb; -fx-text-fill: black; -fx-background-radius: 20;");
            editar.setMinSize(30, 18);
            editar.setMaxSize(30, 18);
            editar.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

            borrar.setStyle("-fx-background-color: #8ffca0; -fx-text-fill: black; -fx-background-radius: 20;");
            borrar.setMinSize(30, 18);
            borrar.setMaxSize(30, 18);
            borrar.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

            //funcionalidad botón editar de los registros de la tabla
            editar.setOnAction(event -> {

                 //comprueba si actualmente se está editando un registro y alerta si se desea cancelar la edición
                if (esEdicion) {
                    Boolean confirmacionEditar = Alerta.confirmacion("¿Desea cancelar la edición?");
                    if (confirmacionEditar) {
                        esEdicion = false;
                        limpiarCampos();
                        botonFormularioAnadir.setText("AÑADIR");
                    }

                //devuelve los elementos del registro al formulario para que puedan ser editados
                } else {
                    Clasificacion clasificacion = getTableView().getItems().get(getIndex());
                    clasificacionEdicion = clasificacion;
                    seleccionCarrera.setValue(null);
                    seleccionParticipante.setValue(null);
                    campoFormularioPuesto.setText(Integer.toString(clasificacion.getPuesto()));
                    campoFormularioTiempo.setText(clasificacion.getTiempo());
                    esEdicion = true;
                    botonFormularioAnadir.setText("GUARDAR");
                }
            });

            //funcionalidad botón borrar de los registros de la tabla
            borrar.setOnAction(event -> {

                //comprueba si actualmente se está editando un registro y alerta si se desea cancelar la edición
                if (esEdicion) {
                    Boolean confirmacionEditar = Alerta.confirmacion("¿Desea cancelar la edición?");
                    if (confirmacionEditar) {
                        esEdicion = false;
                        limpiarCampos();
                        botonFormularioAnadir.setText("AÑADIR");
                    }

            //alerta para confirmar el borrado de la clasificación y procede al borrado del registro
                } else {
                    Boolean confirmacionBorrar = Alerta.confirmacion("¿Desea borrar esta clasificación?");
                    if (confirmacionBorrar) {
                        Clasificacion clasificacion = getTableView().getItems().get(getIndex());
                        ClasificacionesDAO.eliminarClasificacion(clasificacion);
                        actualizarTabla();
                    }
                }

            });
        }

        //añade los botones a cada registro de la tabla, para los campos vacios no se muestran botones
        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
            } else {
                HBox botones = new HBox(8, editar, borrar);
                ImageView iconoEditar = new ImageView(imagenEditar);
                editar.setGraphic(iconoEditar);
                ImageView iconoBorrar = new ImageView(imagenBorrar);
                borrar.setGraphic(iconoBorrar);
                setGraphic(botones);
            }
        }
        });
    }

    //método para actualizar la tabla clasificaciones
    public void actualizarTabla() {
        List<Clasificacion> lista = ClasificacionesDAO.mostrarClasificacionesNombres();
        tablaClasificaciones.getItems().clear();
        tablaClasificaciones.getItems().setAll(lista);
    }

    //método para limpiar el choicebox de busqueda de la tabla
    public void actualizarChoiceBox() {
        List<Carrera> carreras = CarrerasDAO.mostrarCarreras();
        Carrera placeholder = new Carrera(0, "Seleccionar carrera", "", "", 0);
        ObservableList<Carrera> items = FXCollections.observableArrayList();
        items.add(placeholder);
        items.addAll(carreras);

        seleccionarCarrerTabla.setItems(items);
        seleccionarCarrerTabla.setValue(placeholder);
    }

    //método para limpiar los campos del formulario
    public void limpiarCampos() {
        seleccionCarrera.setValue(null);
        seleccionParticipante.setValue(null);
        campoFormularioPuesto.clear();
        campoFormularioTiempo.clear();
    }

    //funcionalidad botón "salir" del programa
    @FXML
    private void cerrarPrograma() throws IOException {
        Platform.exit();
    }
}
