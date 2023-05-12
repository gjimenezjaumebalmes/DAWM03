package conectarbdremota_gja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejemplo de aplicación JavaFX para conectar a una base de datos MySQL remota
 * y mostrar los datos de una tabla en una tabla de JavaFX TableView.
 *
 * Autor: Guillem Jimenez Agullo
 */

public class MySQLConnectionApp extends Application {

    // Declaración de constantes para la conexión a la base de datos
    private static final String DB_URL = "jdbc:mysql://vps-89148e22.vps.ovh.net:3306/jjfaro";
//    private static final String SERVER = "vps-89148e22.vps.ovh.net:3306";
//    private static final String USER = "jjfaro";
//    private static final String PASSWORD = "keiL2lai";
//    private static final String DB = "jjfaro";
    private static final String TABLE_NAME = "actor";

    // Declaración de variables de clase
    private Connection connection;
    private TableView table = new TableView();

    @Override
    public void start(Stage primaryStage) {
        // Creación del contenedor principal y configuración del espacio entre elementos y del padding
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // Creación de los elementos de la interfaz de usuario
        Label serverNameLabel = new Label("Nom del servidor:");
        TextField serverNameField = new TextField("vps-89148e22.vps.ovh.net");

        Label userLabel = new Label("Usuari:");
        TextField userField = new TextField("jjfaro");

        Label passwordLabel = new Label("Contrasenya:");
        TextField passwordField = new TextField("keiL2lai");

        Button connectButton = new Button("Connecta");
        connectButton.setOnAction(event -> {
            // Obtenemos los valores de los campos de texto y llamamos al método de conexión a la base de datos
            String serverName = serverNameField.getText();
            String user = userField.getText();
            String password = passwordField.getText();
            connectToDatabase(serverName, user, password);
        });

        // Añadimos los elementos a la interfaz de usuario
        root.getChildren().addAll(serverNameLabel, serverNameField, userLabel, userField, passwordLabel, passwordField, connectButton, table);

        // Creamos la escena con el contenedor principal y la mostramos en la ventana
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método de conexión a la base de datos
    private void connectToDatabase(String serverName, String user, String password) {
        try {
            // Cargamos el driver de MySQL y nos conectamos a la base de datos
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME); // ejecuta una consulta SQL para obtener todos los datos de la tabla indicada
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();  // obtiene el número de columnas de la tabla

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            for (int i = 1; i <= columnCount; i++) {
                final int j = i - 1;
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(metaData.getColumnName(i)); // crea una nueva columna de tabla con el nombre de la columna correspondiente
                column.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(j)));
                // establece la propiedad de valor de celda de la columna para mostrar los datos de la columna correspondiente
                table.getColumns().add(column);
            }

            while (resultSet.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = resultSet.getString(i);
                    row.add(columnValue);
                }
                data.add(row);
            }
            // Establece los datos de la tabla usando la lista
            table.setItems(data);
            // Captura cualquier excepción que pueda ocurrir durante la conexión a la base de datos o la ejecución de la consulta SQL
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
