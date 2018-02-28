package com.launch4j.example;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GUIMain {

   public GUIMain() {

      WebDriver driver;

      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");

      /*
       * String fp = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
       *
       * File f = new File(fp);
       *
       * if(f.exists()) { System.out.println("Exist"); }
       */
      driver = new ChromeDriver();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.navigate().to("http://google.com");

   }

   public static void main(final String[] args) {

      RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
      List<String> arguments = runtimeMxBean.getInputArguments();
      for (String argument : arguments) {
         if (argument.startsWith("-javaagent:")) {
            System.out.println(argument);
         }
      }
      try {
         Class.forName("org.aspectj.weaver.loadtime.Agent");
      } catch (ClassNotFoundException e) {
         System.err.println("WARNING: AspectJ weaving agent not loaded");
      }
      new GUIMain();

   }

}
