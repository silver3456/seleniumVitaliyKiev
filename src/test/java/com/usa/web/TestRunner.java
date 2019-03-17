package com.usa.web;


import com.usa.web.listeners.LogListener;
import com.usa.web.utils.CaptureScreenshots;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import static com.usa.web.utils.PropertyLoader.getDefaultWait;


@Listeners(value = {LogListener.class})
public class TestRunner {
    protected WebDriver driver;
    protected BrowserMobProxyServer proxyServer;

    @BeforeClass
    public void beforeSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = setUpDriver();

        driver.manage().timeouts().implicitlyWait(getDefaultWait(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeTest() {
        driver.manage().deleteAllCookies();
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        String status = result.getStatus() == 2 ? "failure" : "success";
        CaptureScreenshots.captureScreen(driver, status);
    }

    @AfterClass
    public void afterSuiteTearDown() {
        driver.quit();
        if (proxyServer != null) {
            proxyServer.stop();
            Har har = proxyServer.getHar();
            try {
                har.writeTo(new File("testProxySetUp.har"));
            } catch (IOException e) {
                System.err.println("FAILED TO SAVE PROXY LOGS");
            }
        }
    }


    private WebDriver setUpDriver() {
        //-Dproxy=true
        if ("true".equalsIgnoreCase(System.getProperty("proxy"))) {
            //setUp
            proxyServer = new BrowserMobProxyServer();
            proxyServer.start();

            ///setUp selenium proxy
            Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
            try {
                String hostIp = Inet4Address.getLocalHost().getHostAddress();
                seleniumProxy.setHttpProxy(hostIp + ":" + proxyServer.getPort());
                seleniumProxy.setSslProxy(hostIp + ":" + proxyServer.getPort());
            } catch (UnknownHostException e) {
                System.err.println("FAILED TO INIT PROXY SERVER");
            }

            DesiredCapabilities seleniumCapabilities = new DesiredCapabilities();
            seleniumCapabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
            ChromeOptions options = new ChromeOptions();
            options.merge(seleniumCapabilities);
            WebDriver driver = new ChromeDriver(options);

            proxyServer.enableHarCaptureTypes(CaptureType.RESPONSE_CONTENT);
            proxyServer.newHar("testProxySetUp");
            return driver;
        }

        return new ChromeDriver();
    }
}
