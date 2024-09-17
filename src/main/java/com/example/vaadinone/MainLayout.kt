package com.example.vaadinone


import com.vaadin.flow.component.applayout.AppLayout
import com.vaadin.flow.component.applayout.DrawerToggle
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.router.Route
import com.vaadin.flow.theme.lumo.LumoUtility

private const val PRIMARY_TEXT_COLOR = "var(--lumo-primary-text-color)"

/**
 * The main view is a top-level placeholder for other views.
 */
@Route("mainlayout")
class MainLayout : AppLayout() {
    private lateinit var viewTitle: H2

    init {
        primarySection = Section.DRAWER

        viewTitle = H2("View Title")
        viewTitle.addClassName("view-title")
        addToNavbar(true, viewTitle)
        addToNavbar(true, DrawerToggle())
        addDrawerContent()
        addHeaderContent()
        addFooter() // TODO: Add footer content when header content is available in the navigation bar instead of the main content layout
    }

    private fun addDrawerContent() {    // TODO: Add drawer content when drawer content is available in the navigation bar instead of the main content layout


    }

    private fun addHeaderContent() { // Implement the logic to add content to the header
        val toggle = DrawerToggle()
        toggle.setAriaLabel("Menu toggle")

        viewTitle = H2("Deneme Dashboard")
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE)

        addToNavbar(true, toggle, viewTitle)
    }

    private fun addFooter() {
        // Implement the logic to add content to the footer
    }

    // ... rest of the code
}