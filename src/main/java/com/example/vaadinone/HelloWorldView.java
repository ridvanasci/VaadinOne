package com.example.vaadinone;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class HelloWorldView extends VerticalLayout {

    public HelloWorldView() {
        Button button = new Button("Click me");
        button.addClickListener(e -> Notification.show("Hello, World!"));
        add(button);
    }
}