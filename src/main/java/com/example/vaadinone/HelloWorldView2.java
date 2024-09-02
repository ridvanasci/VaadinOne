package com.example.vaadinone;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("ridvan")
public class HelloWorldView2 extends VerticalLayout {

    private TextField heightField = new TextField("Uzunluk (cm)");
    private TextField weightField = new TextField("Genişlik (kg)");
    private Button calculateButton = new Button("Calculate Area");
    private Button openTrendyol = new Button("Trendyol Vivabien Mağazası");
    private TextField menuNameField = new TextField("Menu Name");
    private TextField menuDescriptionField = new TextField("Menu Description");
    private Button saveMenuButton = new Button("Save Menu");

    @Autowired
    private MenuRepository menuRepository;

    public HelloWorldView2() {
        add(heightField, weightField, calculateButton, openTrendyol, menuNameField, menuDescriptionField, saveMenuButton);

        calculateButton.addClickListener(e -> calculateBMI());
        openTrendyol.addClickListener(event -> {
            getUI().ifPresent(ui -> ui.getPage().open("https://www.trendyol.com/magaza/vivabien-m-982575?sst=0", "_blank"));
        });
        saveMenuButton.addClickListener(e -> saveMenu());
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
}