package cr.ac.una.est.minidiscord.presentation.controller;

import cr.ac.una.est.minidiscord.business.model.Message;
import cr.ac.una.est.minidiscord.business.model.User;
import cr.ac.una.est.minidiscord.business.service.ChatService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatViewController {
    @FXML private ListView<String> messageListView;
    @FXML private TextField messageInputField;

    private final ChatService chatService = new ChatService();
    private final User currentUser = new User("EstudianteUNA");

    private final ObservableList<String> message = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        messageListView.setItems(message);
    }

    @FXML
    private void handleSendMessages() {
        try {
            Message nuevoMsg = chatService.processMessage(currentUser, messageInputField.getText());

        } catch (IllegalArgumentException e) {
            System.out.println("Aviso de validación:" + e.getMessage());
        }
    }
}
