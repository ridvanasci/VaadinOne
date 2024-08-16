package com.example.vaadinone;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route("")
public class HelloWorldView2 extends VerticalLayout {

    private TextField heightField = new TextField("Height (cm)");
    private TextField weightField = new TextField("Weight (kg)");
    private Button calculateButton = new Button("Calculate BMI");
    private Button openTrendyol= new Button("Trendyol Vivabien Mağazası");

    public HelloWorldView2() {
        add(heightField, weightField, calculateButton, openTrendyol);

        calculateButton.addClickListener(e -> calculateBMI());
        openTrendyol.addClickListener(event -> {
            getUI().ifPresent(ui -> ui.getPage().open("https://www.trendyol.com/magaza/vivabien-m-982575?sst=0", "_blank"));
        });


    }

    private void calculateBMI() {
        try {
            double height = Double.parseDouble(heightField.getValue());
            double weight = Double.parseDouble(weightField.getValue());

            double bmi = weight / (height / 100 / height / 100);

            Notification.show("Your BMI is: " + String.format("%.2f", bmi));
        } catch (NumberFormatException e) {
            Notification.show("Invalid input. Please enter a valid height and weight.");
        }
    }
}

