package com.example.vaadinone;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "1", layout = MainLayoutJava.class)
public class MainLayoutJava extends AppLayout {

    public MainLayoutJava() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("My App");
        logo.addClassNames("text-l", "m-m");

        Button navigateButton = new Button("Navigate");
        navigateButton.addClickListener(event -> {
            // navigate to a specific route or view
        });

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, navigateButton);
        header.addClassNames("bg-primary", "text-secondary", "p-m", "box-border");
        header.setWidthFull();
        header.setAlignItems(FlexComponent.Alignment.CENTER);

        addToNavbar(header);
    }

    private void createDrawer() {
        // add items to the drawer here
    }
}
