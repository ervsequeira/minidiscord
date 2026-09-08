package cr.ac.una.est.minidiscord.presentation.controller;

import cr.ac.una.est.minidiscord.business.model.Message;
import cr.ac.una.est.minidiscord.business.model.User;
import cr.ac.una.est.minidiscord.business.service.ChatService;
import cr.ac.una.est.minidiscord.data.dao.MessageDAO;
import cr.ac.una.est.minidiscord.data.dao.MessageXmlExporter;
import cr.ac.una.est.minidiscord.data.dao.PersistenceManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class ChatViewController {
    @FXML private ListView<String> messageListView;
    @FXML private TextField messageInputField;

    private final ChatService chatService = new ChatService();
    private final User currentUser = new User("EstudianteUNA");
    private final MessageDAO messageDAO = PersistenceManager.getInstance().getMessageDAO();
    private final List<Message> historial = new ArrayList<>();

    private final ObservableList<String> messages = FXCollections.observableArrayList();
    private final MessageXmlExporter xmlExporter = new MessageXmlExporter();

    @FXML
    public void initialize(){
        messageListView.setItems(messages);

        for (Message m : messageDAO.cargarTodos()) {
            historial.add(m);
            messages.add(m.toString());
        }
    }

    @FXML
    private void handleSendMessage() {
        try {
            // esta línea ya existía la clase pasada, no cambió
            Message nuevoMsg = chatService.processMessage(currentUser, messageInputField.getText());
            // Nuevo de la clase 8: guardamos también el objeto de dominio (no solo el texto)
            historial.add(nuevoMsg);
            // estas dos líneas ya existían la clase pasada, no cambiaron
            messages.add(nuevoMsg.toString());
            messageInputField.clear();

            // Nuevo de la clase 8: se persiste el historial completo cada vez que se agrega un mensaje válido
            messageDAO.guardarTodos(historial);
            xmlExporter.exportar(historial);
        } catch (IllegalArgumentException e) {
            System.out.println("Aviso de Validación: " + e.getMessage()); // ya existía
        }
    }
}
