package com.example;
import com.example.DAO.Carrera;
import com.example.DAO.CarrerasDAO;
import com.example.DAO.Clasificacion;
import com.example.DAO.ClasificacionesDAO;
import com.example.UI.Alerta;
import com.example.UI.Validar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
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

//pantalla de las Carreras
public class ControladorCarreras {

    //variable para comprobar si se esta editando un registro
    private boolean esEdicion = false;

    //variable auxiliar para guardar la carrera editada
    private Carrera carreraEdicion = null;

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
    private TextField campoFormularioNombre;

    @FXML
    private DatePicker campoFormularioFecha;

    @FXML
    private TextField campoFormularioLugar;

    @FXML
    private TextField campoFormularioDistancia;

    @FXML
    private TableView<Carrera> tablaCarreras;

    @FXML
    private TextField campoTablaBuscar;

    @FXML
    private TableColumn<Carrera, String> columnaTablaNombre;

    @FXML
    private TableColumn<Carrera, String> columnaTablaFecha;

    @FXML
    private TableColumn<Carrera, String> columnaTablaLugar;

    @FXML
    private TableColumn<Carrera, Integer> columnaTablaDistancia;   

    @FXML
    private TableColumn<Carrera, Void> columnaTablaOpciones;

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
        imagenBotonCarreras.setImage(carrera3);
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

        //valores de las columnas de la tabla
        columnaTablaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaTablaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnaTablaLugar.setCellValueFactory(new PropertyValueFactory<>("lugar"));
        columnaTablaDistancia.setCellValueFactory(new PropertyValueFactory<>("distancia"));
        columnaTablaOpciones.setResizable(false);

        //estilo de los elementos mediante un archivo css
        campoFormularioFecha.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        campoFormularioNombre.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        campoFormularioLugar.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        campoFormularioDistancia.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        campoTablaBuscar.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        tablaCarreras.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        
        //tamaño fijo para el botón "buscar" de la tabla
        botonTablaBuscar.setMaxWidth(32);
        botonTablaBuscar.setMaxHeight(32);
        botonTablaBuscar.setMinWidth(32);
        botonTablaBuscar.setMinHeight(32);
        botonTablaBuscar.setGraphic(iconoBuscar);

        agregarBotonesATabla();
        actualizarTabla();
    }

    //funcionalidad botón "añadir" del formulario
    @FXML
    private void anadirCarrera() throws IOException {
        //comprueba que todos los campos son válidos
        if (campoFormularioNombre.getText().trim().isEmpty() || campoFormularioFecha.getValue() == null || campoFormularioLugar.getText().trim().isEmpty() || campoFormularioDistancia.getText().trim().isEmpty()) {
            Alerta.mostrar("Rellene todos los campos.");
            return;
        } else if (Validar.esDigito(campoFormularioNombre.getText()) || Validar.esDigito(campoFormularioLugar.getText())) {
            Alerta.mostrar("Nombre y lugar no pueden contener números.");
            return;
        } else if (Validar.contieneCaracteres(campoFormularioDistancia.getText())) {
            Alerta.mostrar("Distancia solo puede contener números.");
            return;
        } else if (Validar.distanciaInvalida(campoFormularioDistancia.getText())) {
            Alerta.mostrar("Introduce una distancia válida.");
            return;
        } else if (Validar.longitudInvalida(campoFormularioNombre.getText())) {
            Alerta.mostrar("Nombre demasiado largo.");
            return;
        } else if (Validar.longitudInvalida(campoFormularioLugar.getText())) {
            Alerta.mostrar("Nombre de lugar demasiado largo.");
            return;

        //comprueba si se trata de una edición y modifica el registro
        } else if (esEdicion) {
            String nombre = campoFormularioNombre.getText();
            String fecha = campoFormularioFecha.getValue().toString();
            String lugar =  campoFormularioLugar.getText();
            String distancia =  campoFormularioDistancia.getText();
            carreraEdicion.setNombre(nombre);
            carreraEdicion.setFecha(fecha);
            carreraEdicion.setLugar(lugar);
            carreraEdicion.setDistancia(Integer.parseInt(distancia));

            //comprueba si la carrera ya existe
            if (Validar.carreraExiste(carreraEdicion)){
                Alerta.mostrar("Carrera duplicada.");
                return;
            }
            
            CarrerasDAO.modificarCarrera(carreraEdicion);
            actualizarTabla();
            limpiarCampos();
            esEdicion = false;
            botonFormularioAnadir.setText("AÑADIR");
            Alerta.mostrar("Se ha editado correctamente.");

        //si no se trata de una edición se añade el registro
        } else {
            String nombre = campoFormularioNombre.getText();
            String fecha = campoFormularioFecha.getValue().toString();
            String lugar =  campoFormularioLugar.getText();
            String distancia =  campoFormularioDistancia.getText();
            Carrera carrera = new Carrera(0, nombre, fecha, lugar, Integer.parseInt(distancia));

            //comprueba si la carrera ya existe
            if (Validar.carreraExiste(carrera)){
                Alerta.mostrar("Carrera duplicada.");
                return;
            }

            CarrerasDAO.insertarCarrera(carrera);
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
            campoTablaBuscar.clear();
            iconoBuscar.setImage(buscar); 
            campoTablaBuscar.setDisable(false);
            hayBusqueda=false;
            return;
        }

        List<Carrera> coincidencias = new ArrayList<Carrera>();
        List<Carrera> listaCompleta = CarrerasDAO.mostrarCarreras();
        String busqueda = campoTablaBuscar.getText();

        //valida si el campo de busqueda está vacio o si no hay registros en la tabla
        if (Validar.campoVacio(campoTablaBuscar)) {
                Alerta.mostrar("Campo de busqueda vacío.");
                return;
        }  
        if (Validar.listaCarreraVacia(listaCompleta))  {
                Alerta.mostrar("No hay registros.");
                campoTablaBuscar.clear();
                return;
        } 

        //añade todas las carreras cuyos elementos coincidan con la busqueda a una lista
        for (int i=0; i<listaCompleta.size(); i++){
            if ((listaCompleta.get(i).getNombre()!=null && listaCompleta.get(i).getNombre().toLowerCase().contains(busqueda.toLowerCase())) ||
                (listaCompleta.get(i).getFecha()!=null && listaCompleta.get(i).getFecha().toLowerCase().contains(busqueda.toLowerCase()) && busqueda.length()>=4) ||
                (listaCompleta.get(i).getLugar()!=null && listaCompleta.get(i).getLugar().toLowerCase().contains(busqueda.toLowerCase())) ||
                (Validar.esDigito(busqueda) && listaCompleta.get(i).getDistancia()==Integer.parseInt(busqueda)&& busqueda.length()<4)){
                    coincidencias.add(listaCompleta.get(i));
            }  
        } 

        //si no hay coincidencias se muestra una alerta
        if (coincidencias.isEmpty()) {
            Alerta.mostrar("No se encontraron coincidencias.");
            return;
        }
        
        //actualiza la tabla con las coincidencias
        tablaCarreras.getItems().clear();
        tablaCarreras.getItems().setAll(coincidencias);
        iconoBuscar.setImage(buscarSalir); 
        campoTablaBuscar.setDisable(true);
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
                    Carrera carrera = getTableView().getItems().get(getIndex());
                    carreraEdicion = carrera;
                    campoFormularioNombre.setText(carrera.getNombre());
                    campoFormularioFecha.setValue(java.time.LocalDate.parse(carrera.getFecha()));
                    campoFormularioLugar.setText(carrera.getLugar());
                    campoFormularioDistancia.setText(Integer.toString(carrera.getDistancia()));
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

                //alerta para confirmar el borrado de la carrera y de las clasificaciones relacionadas y borrado del registro
                } else {
                    if (Alerta.confirmacion("¿Desea borrar esta carrera y todas las clasificaciones relacionadas?")) {
                        List<Clasificacion> clasificaciones = ClasificacionesDAO.mostrarClasificaciones();
                        Carrera carrera = getTableView().getItems().get(getIndex());
                        for (Clasificacion clasificacion:clasificaciones){
                            if (clasificacion.getIdCarrera()==carrera.getId()){
                                ClasificacionesDAO.eliminarClasificacion(clasificacion);
                            }
                        }
                        CarrerasDAO.eliminarCarrera(carrera);
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

    //método para actualizar la tabla carreras
    public void actualizarTabla() {
        List<Carrera> lista = CarrerasDAO.mostrarCarreras();
        tablaCarreras.getItems().clear();
        tablaCarreras.getItems().setAll(lista);
    }

    //método para limpiar los campos del formulario
    public void limpiarCampos() {
        campoFormularioNombre.clear();
        campoFormularioFecha.setValue(null);
        campoFormularioLugar.clear();
        campoFormularioDistancia.clear();
    }

    //funcionalidad botón "salir" del programa
    @FXML
    private void cerrarPrograma() throws IOException {
        Platform.exit();
    }
}
