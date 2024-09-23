package com.example.vaadinone;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.button.Button;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.vaadin.flow.component.Tag.H2;

@Route(value = "test")

public class Test extends VerticalLayout {
   @Autowired
    private UserRepository userRepository;
private MenuRepository menuRepository;;

    public Test( MenuRepository menuRepository   ) {

        this.menuRepository = menuRepository;
    }

    @PostConstruct
    public void init() {
        // Add a text label
        add(new Text("Hello, World!"));

        // Create a grid layout
        Grid<User> gridLayout = new Grid<>(User.class);
        Grid<Menu> grid2 = new Grid<>(Menu.class);

        // Create a list of User objects
        List<User> users = userRepository.findAll();

        gridLayout.setItems(users);
        grid2.setColumns("id", "name","description"); //Kendi sıralamana göre sütunları düzenleyebilirsin ancak
                                                     //aynı field isimlerini kullanmak gerek.
        grid2.setItems(menuRepository.findAll());

        // Add the grid layout to the vertical layout
        add( gridLayout,grid2);



        SideNav sidebar = new SideNav("Side");
        SideNavItem homeItem = new SideNavItem("Home");
        SideNavItem aboutItem = new SideNavItem("About");

        sidebar.addItem(homeItem);
        sidebar.addItem(aboutItem);
         add(sidebar);
}}