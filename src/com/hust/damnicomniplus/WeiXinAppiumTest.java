package com.hust.damnicomniplus;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class WeiXinAppiumTest {

	private AndroidDriver driver; 
    @Before
    public void setUp() throws Exception {
        //设置apk的路径
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "微信.apk");
        
        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        
        //设置安卓系统版本
        capabilities.setCapability("platformVersion", "4.4.2");
        //设置apk路径
        capabilities.setCapability("app", app.getAbsolutePath()); 
        
        //设置网络选项
        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.tencent.mm");
        capabilities.setCapability("appActivity", ".ui.LauncherUI");
//        capabilities.setCapability("appActivity", ".u0a140");
        
        //初始化
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);   
    }
 
    @Test
    public void login(){
    	WebElement login=driver.findElementById("com.tencent.mm:id/select_login_btn");
//    	WebElement login=driver.findElement(By.name("登录"));
//    	WebElement login=driver.findElementByAndroidUIAutomator("new UiSelector().text(\"登录\")");
    	login.click();
    	String page=driver.getPageSource();
    	System.out.println(page);
//    	List<WebElement> buttons=driver.findElementsByClassName("android.widget.Button");
//    	buttons.get(0).click();
    	WebElement phonenumber=driver.findElementById("com.tencent.mm:id/mobile_number");
    	phonenumber.sendKeys("13349987441");
    	WebElement password=driver.findElementById("com.tencent.mm:id/edittext");
    	password.sendKeys("gxx5885118");
    	WebElement next=driver.findElementById("com.tencent.mm:id/next_btn");
    	next.click();
        List<WebElement> linearlayouts = driver.findElementsByClassName("android.widget.LinearLayout");
        linearlayouts.get(0).click();
//        el.click();
//        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
//        textFieldsList.get(0).sendKeys("feimaoyuzhubaobao1");
//        textFieldsList.get(1).sendKeys("15648971455");
//        textFieldsList.get(2).sendKeys("kjgierhgi@jhig.com");
//        driver.swipe(100, 500, 100, 100, 2);
//        driver.findElementByName("Save").click();
    }    
    
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}