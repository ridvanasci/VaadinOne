package com.example.vaadinone;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@PageTitle("Hoşgeldiniz")
@Route("ridvan")
public class HelloWorldView2 extends VerticalLayout {
    private Label pageTitleLabel = new Label("Hoşgeldiniz");
    private TextField heightField = new TextField("Uzunluk (cm)");
    private TextField weightField = new TextField("Genişlik (kg)");
    private Button calculateButton = new Button("Calculate Area");
    private Button openTrendyol = new Button("Trendyol Vivabien Mağazası");
    private TextField menuNameField = new TextField("Menu Name");
    private TextField menuDescriptionField = new TextField("Menu Description");
    private Button saveMenuButton = new Button("Save Menu");
    private TextField userField = new TextField("User Name");
    private TextField userIDField = new TextField("User ID");
    private Button saveUserButton = new Button("Save User");

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private UserRepository userRepository;

    public HelloWorldView2() {
        add(pageTitleLabel, heightField,weightField, calculateButton, openTrendyol, menuNameField, menuDescriptionField, saveMenuButton, userField, userIDField, saveUserButton);

        calculateButton.addClickListener(e -> calculateBMI());
        openTrendyol.addClickListener(event -> {
            getUI().ifPresent(ui -> ui.getPage().open("https://www.trendyol.com/magaza/vivabien-m-982575?sst=0", "_blank"));
        });
        saveMenuButton.addClickListener(e -> saveMenu());
        saveUserButton.addClickListener(e -> saveUser());
    }

    private void calculateBMI() {
        try {
            double uzunluk = Double.parseDouble(heightField.getValue());
            double genişlik = Double.parseDouble(weightField.getValue());

            double Alan = uzunluk * genişlik;

            Notification.show("Alan büyüklüğü : " + String.format("%.2f", Alan));
        } catch (NumberFormatException e) {
            Notification.show("Invalid input. Please enter a valid height and weight.");
        }
    }

    private void saveMenu() {
        Menu menu = new Menu();
        menu.setName(menuNameField.getValue());
        menu.setDescription(menuDescriptionField.getValue());

        menuRepository.save(menu);

        Notification.show("Menu saved successfully!");
    }
    private void saveUser() {
        User user1 = new User();
        user1.setName(userField.getValue());
        user1.setUserID(Integer.parseInt(userIDField.getValue()));

        userRepository.save(user1);

        Notification.show("User saved successfully!");
    }
}