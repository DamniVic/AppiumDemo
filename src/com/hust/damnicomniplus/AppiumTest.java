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

public class AppiumTest {
    private AndroidDriver driver; 
    @Before
    public void setUp() throws Exception {
        //����apk��·��
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "ContactManager.apk");
        
        //�����Զ�����ز���
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        
        //���ð�׿ϵͳ�汾
        capabilities.setCapability("platformVersion", "4.4.2");
        //����apk·��
        capabilities.setCapability("app", app.getAbsolutePath()); 
        
        //��������ѡ��
        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        //����app����������������
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        
        //��ʼ��
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);   
    }
 
    @Test
    public void addContact(){
        WebElement el = driver.findElement(By.name("Add Contact"));
        el.click();
        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("yuandamao1");
        textFieldsList.get(1).sendKeys("15648971455");
        textFieldsList.get(2).sendKeys("kjgierhgi@jhig.com");
        driver.swipe(100, 500, 100, 100, 2);
        driver.findElementByName("Save").click();
    }    
    
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}