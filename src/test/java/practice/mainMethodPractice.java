package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class mainMethodPractice {
    public static void main(String[] args) throws InterruptedException, IOException {
        example1Practice  eg1 = new example1Practice();
        //eg1.lunchChromeDriver();
        //eg1.lunchFirefoxDriver();
        example2Locators eg2 = new example2Locators();
        //eg2.locator();
        example3Dropdown eg3 = new example3Dropdown();
        //eg3.dropdown();
        xpathPractice eg4 = new xpathPractice();
        //eg4.xpathPractic();
        javaScriptAlert js= new javaScriptAlert();
        //js.javaScriptAlert();
       // js.fileUpload();
        ActionClassMouseMovement action = new ActionClassMouseMovement();
        //action.hoverElement();
        dragAndDrop drag = new dragAndDrop();
        //drag.dragAndDrop();
        differentWaits wait = new differentWaits();
        //wait.differentWaits();
        bootStrapListBox box = new bootStrapListBox();
       // box.bootStrapListBox();
        handlingWindowPopUp popUp =new handlingWindowPopUp();
        //popUp.handlingWindowPopUp();
        handlingMultipleWindowPopUP multiplePopUp = new handlingMultipleWindowPopUP();
        //multiplePopUp.handlingMultipleWindowPopUp();
        singleLinkDoubleWindowHandler single = new singleLinkDoubleWindowHandler();
        //single.singleLinkDoubleWindowHandler();
        browserInitiateUsingConfig initiate = new browserInitiateUsingConfig();
        WebDriver driver =initiate.initiateBrowser();

        try {
            highLightUsingJavaScript highlight = new highLightUsingJavaScript(driver);
            screenSortUtility screenSort = new screenSortUtility(driver);
            navigationToSubMenuPage navigation = new navigationToSubMenuPage(driver);
            navigation.navigationToSubMenuPage();
          testCalculatorForm test1 = new testCalculatorForm(driver);
          test1.calculatorAdditionVerification();
          test1.calculatorAdditionVerificationNegative();
           test1.checkBoxTesting();
           tableDataTesting table = new tableDataTesting(driver);
          table.tableDataCheck();
          table.tablePagination();
           table.dataRetriveFromDynamicTable();
            //searchBoxSuggestionHandling searchBox = new searchBoxSuggestionHandling();
            //searchBox.searchBoxSuggestionHandling();
            calenderHandling calander = new calenderHandling(driver);
            calander.testCalanderHandling();
            calander.handleCalenderJS();
            actionsClassMethods actions = new actionsClassMethods(driver);
            actions.actionsClassMethods();
            fileUpload file = new fileUpload(driver);
            file.fileUpload();
            file.fileDownload();
            shadowDom shadow = new shadowDom(driver);
            shadow.shadowDom();
        }
        finally {
           // initiate.closeBrowser();
        }
    }
}
