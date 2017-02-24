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

public class ClickAppiumTest {
	private AndroidDriver driver;
	 @Before
	    public void setUp() throws Exception {
	        //����apk��·��
	        File classpathRoot = new File(System.getProperty("user.dir"));
	        File appDir = new File(classpathRoot, "apps");
	        File app = new File(appDir, "app-debug.apk");
	        
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
	        capabilities.setCapability("appPackage", "com.hskj.damnicomniplusvic.appiumdemo1");
	        capabilities.setCapability("appActivity", ".AppiumdemoActivity");
	        
	        //��ʼ��
	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);   
	    }
	 
	    @Test
	    public void click(){
	    	WebElement el=driver.findElement(By.id("button"));
	    	el.click();
	    }    
	    
	    @After
	    public void tearDown() throws Exception {
	        driver.quit();
	    }

}
