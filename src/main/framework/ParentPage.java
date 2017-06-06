package main.framework;

import org.openqa.selenium.WebDriver;

public abstract class ParentPage extends DSL {

    public ParentPage(WebDriver driver) {
        super(driver);
    }

}