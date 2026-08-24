package practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class highLightUsingJavaScript {
    WebDriver driver;
    public highLightUsingJavaScript(WebDriver driver){
        this.driver= driver;
    }

    public static void highlightProcess(WebElement element, WebDriver driver){
        JavascriptExecutor js =( (JavascriptExecutor) driver);
        String bgColor = element.getCssValue("backgroundColor");
        for (int i =0; i< 10; i++){
            changeColor("rgb(0,200,0)",element,driver);
            changeColor(bgColor,element,driver);
        }
    }

    public static void changeColor(String color,WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor= '"+color+"'",element);
   try {
       Thread.sleep(200);
   } catch (InterruptedException e) {
       System.out.println(e);
   }
   }

   public static void drawBorder(WebElement element, WebDriver driver){
        JavascriptExecutor js =((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'",element);
   }

   public static void generateAlert(WebDriver driver,String message){
    JavascriptExecutor js = (JavascriptExecutor)  driver;
    js.executeScript("alert('"+message+"')");
   }

//JavaScript click
   public static void clickJS(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
   }
   //refresh the page using JavaScript
    public static void refreshJavaScript(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("history.go(0);");
    }

    //to get the title of the page
    public static String getTitleByJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
      String title=  js.executeScript("return document.title;").toString();
      return title;
    }

    //to get the contains of the page
    public static String getPageInnerText(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
      String pageText=  js.executeScript("return document.documentElement.innerText;").toString();
     return pageText;
    }
    //to scroll down the page to button
    public static void scrollDownJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

}

public static void scrollIntoView(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);

}

public static void scrollUp(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-400);");
}

public static void selectDateByJS(WebDriver driver,WebElement element,String dateValue){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+dateValue+"');",element);
}





}
