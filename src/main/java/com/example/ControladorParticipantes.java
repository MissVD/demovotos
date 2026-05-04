package com.example;
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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

//pantalla de los Participantes
public class ControladorParticipantes {

    //variable para comprobar si se esta editando un registro
    private boolean esEdicion = false;

    //variable auxiliar para guardar el participante editado
    private Participante participanteEdicion = null;

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
        botonFormularioAnadir.setLayoutY(403.0);
    }

    @FXML
    private void botonFormularioSoltado() throws IOException {
        botonFormularioAnadir.setLayoutY(402.0);
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
    private TextField campoFormularioEdad;

    @FXML
    private TextField campoFormularioCategoria;

    @FXML
    private TextField campoTablaBuscar;

    @FXML
    private TableView<Participante> tablaParticipantes;

    @FXML
    private TableColumn<Participante, String> columnaTablaNombre;

    @FXML
    private TableColumn<Participante, Integer> columnaTablaEdad;

    @FXML
    private TableColumn<Participante, String> columnaTablaCategoria;

    @FXML
    private TableColumn<Participante, Void> columnaTablaOpciones;

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
        imagenBotonParticipantes.setImage(participante3);
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
        columnaTablaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columnaTablaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        columnaTablaOpciones.setResizable(false);

        //estilo de los elementos mediante un archivo css
        campoFormularioNombre.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        campoFormularioEdad.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        campoFormularioCategoria.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        campoTablaBuscar.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        tablaParticipantes.getStylesheets().add(getClass().getResource("/com/example/images/style.css").toExternalForm());
        
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
    private void anadirParticipante() throws IOException {
        //comprueba que todos los campos son válidos
        if (campoFormularioNombre.getText().trim().isEmpty() || campoFormularioEdad.getText().trim().isEmpty() || campoFormularioCategoria.getText().trim().isEmpty()) {
            Alerta.mostrar("Rellene todos los campos.");
            return;
        } else if (Validar.esDigito(campoFormularioNombre.getText()) || Validar.esDigito(campoFormularioCategoria.getText())) {
            Alerta.mostrar("Nombre y categoría no pueden contener números.");
            return;
        } else if (Validar.contieneCaracteres(campoFormularioEdad.getText())) {
            Alerta.mostrar("Edad solo puede contener números.");
            return;
        } else if (Validar.edadInvalida(campoFormularioEdad.getText())) {
            Alerta.mostrar("Introduce una edad válida.");
            return;
        } else if (Validar.longitudInvalida(campoFormularioNombre.getText())) {
            Alerta.mostrar("Nombre demasiado largo.");
            return;
        } else if (Validar.longitudInvalida(campoFormularioCategoria.getText())) {
            Alerta.mostrar("Nombre de categoría demasiado largo.");
            return;

        //comprueba si se trata de una edición y modifica el registro
        } else if (esEdicion) {
            String nombre = campoFormularioNombre.getText();
            String edad =  campoFormularioEdad.getText();
            String categoria =  campoFormularioCategoria.getText();
            participanteEdicion.setNombre(nombre);
            participanteEdicion.setEdad(Integer.parseInt(edad));
            participanteEdicion.setCategoria(categoria);

            //comprueba si el/la participante ya existe
            if (Validar.participanteExiste(participanteEdicion)){
                Alerta.mostrar("Participante duplicada.");
                return;
            }

            ParticipantesDAO.modificarParticipante(participanteEdicion);
            actualizarTabla();
            limpiarCampos();
            esEdicion = false;
            botonFormularioAnadir.setText("AÑADIR");
            Alerta.mostrar("Se ha editado correctamente.");

        //si no se trata de una edición se añade el registro
        } else {
            String nombre = campoFormularioNombre.getText();
            String edad =  campoFormularioEdad.getText();
            String categoria =  campoFormularioCategoria.getText();
            Participante participante = new Participante(0, nombre, Integer.parseInt(edad), categoria);

            //comprueba si el/la participante ya existe
            if (Validar.participanteExiste(participante)){
                Alerta.mostrar("Participante duplicada.");
                return;
            }
            
            ParticipantesDAO.insertarParticipante(participante);
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

        List<Participante> coincidencias = new ArrayList<Participante>();
        List<Participante> listaCompleta = ParticipantesDAO.mostrarParticipantes();
        String busqueda = campoTablaBuscar.getText();

        //valida si el campo de busqueda está vacio o si no hay registros en la tabla
        if (Validar.campoVacio(campoTablaBuscar)) {
                Alerta.mostrar("Campo de busqueda vacío.");
                return;
        }  
        if (Validar.listaParticipanteVacia(listaCompleta))  {
                Alerta.mostrar("No hay registros.");
                return;
        } 

        //añade todas los participantes cuyos elementos coincidan con la busqueda a una lista
        for (int i=0; i<listaCompleta.size(); i++){
            if ((listaCompleta.get(i).getNombre()!=null && listaCompleta.get(i).getNombre().toLowerCase().contains(busqueda.toLowerCase())) ||
                (Validar.esDigito(busqueda) && listaCompleta.get(i).getEdad()==Integer.parseInt(busqueda)) ||
                (listaCompleta.get(i).getCategoria()!=null && listaCompleta.get(i).getCategoria().toLowerCase().contains(busqueda.toLowerCase()))){
                    coincidencias.add(listaCompleta.get(i));
            }  
        } 

        //si no hay coincidencias se muestra una alerta
        if (coincidencias.isEmpty()) {
            Alerta.mostrar("No se encontraron coincidencias.");
            campoTablaBuscar.clear();
            return;
        }
        
        //actualiza la tabla con las coincidencias
        tablaParticipantes.getItems().clear();
        tablaParticipantes.getItems().setAll(coincidencias);
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
                    Participante participante = getTableView().getItems().get(getIndex());
                    participanteEdicion = participante;
                    campoFormularioNombre.setText(participante.getNombre());
                    campoFormularioEdad.setText(Integer.toString(participante.getEdad()));
                    campoFormularioCategoria.setText(participante.getCategoria());
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
                    if (Alerta.confirmacion("¿Desea borrar este/a participante y todas las clasificaciones relacionadas?")) {
                        List<Clasificacion> clasificaciones = ClasificacionesDAO.mostrarClasificaciones();
                        Participante participante = getTableView().getItems().get(getIndex());
                        for (Clasificacion clasificacion:clasificaciones){
                            if (clasificacion.getIdParticipante()==participante.getId()){
                                ClasificacionesDAO.eliminarClasificacion(clasificacion);
                            }
                        }
                        ParticipantesDAO.eliminarParticipante(participante);
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
        List<Participante> lista = ParticipantesDAO.mostrarParticipantes();
        tablaParticipantes.getItems().clear();
        tablaParticipantes.getItems().setAll(lista);
    }

    //método para limpiar los campos del formulario
    public void limpiarCampos() {
        campoFormularioNombre.clear();
        campoFormularioEdad.clear();
        campoFormularioCategoria.clear();
    }

    //funcionalidad botón "salir" del programa
    @FXML
    private void cerrarPrograma() throws IOException {
        Platform.exit();
    }
}

