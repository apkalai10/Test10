package com.pbo.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.SystemUtils;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.Repository;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



public class PdfReport {
	public static String user="daniel";
	public static String pass="acs123";
	
	
	
@Test	
public void pdf() throws DocumentException, MalformedURLException, IOException, InterruptedException, ParserConfigurationException, SAXException, XmlPullParserException
{
	
	  WebDriver driver = new ChromeDriver(); 
	   
	  Capabilities caps = (Capabilities) driver;
      String browserName = caps.getBrowserName().toLowerCase();
      String browserVersion = caps.getBrowserVersion();
 
        HeaderFooterPageEvent event = new HeaderFooterPageEvent();
        
        Calendar cal = Calendar.getInstance();
	    Date time = cal.getTime(); 
		String timestamp = time.toString().replace(":", "").replace(" ", "");
		
		
        FileOutputStream fos = new FileOutputStream("Report_"+timestamp+".pdf");
        Document document = new Document(PageSize.A4, 20, 20, 50, 25);
        PdfWriter writer = PdfWriter.getInstance(document, fos);
        writer.setEncryption(user.getBytes(), pass.getBytes(), PdfWriter.ALLOW_PRINTING,PdfWriter.ENCRYPTION_AES_128);
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
        writer.setViewerPreferences(PdfWriter.PageLayoutOneColumn);
        document.open();
        
        event.startpage(writer, document);
        event.endpage(writer, document);
        writer.setPageEvent(event);
       
        document.add(Chunk.NEWLINE);//space
        PdfPTable table = new PdfPTable(8);
        
        Font c1 = new Font(FontFamily.TIMES_ROMAN, 8, Font.BOLD);
        table.addCell(new PdfPCell(new Phrase("User Name",c1)));
        table.addCell(new PdfPCell(new Phrase("OS Name",c1)));
        table.addCell(new PdfPCell(new Phrase("OS Version",c1)));
        table.addCell(new PdfPCell(new Phrase("Java Version",c1)));
        table.addCell(new PdfPCell(new Phrase("Browser Name",c1)));
        table.addCell(new PdfPCell(new Phrase("Browser Version",c1)));
        table.addCell(new PdfPCell(new Phrase("API",c1)));
        table.addCell(new PdfPCell(new Phrase("TestNG Version",c1)));
        table.addCell(new PdfPCell(new Phrase(SystemUtils.getUserName(),c1)));
        table.addCell(new PdfPCell(new Phrase(System.getProperty("os.name"),c1)));
        table.addCell(new PdfPCell(new Phrase(System.getProperty("os.version"),c1)));
        table.addCell(new PdfPCell(new Phrase(System.getProperty("java.version"),c1)));
        table.addCell(new PdfPCell(new Phrase(browserName,c1)));
        table.addCell(new PdfPCell(new Phrase(browserVersion,c1)));
        table.addCell(new PdfPCell(new Phrase(WebDriver.class.getPackageName(),c1)));
        table.addCell(new PdfPCell(new Phrase(TestNG.class.getPackage().getImplementationVersion(),c1)));
        
     
      
        document.add(table);
    
        document.newPage();
        event.startpage(writer, document);
        event.endpage(writer, document);
        writer.setPageEvent(event);
        
        Font dep = new Font(FontFamily.TIMES_ROMAN, 7, Font.NORMAL);
        document.add(Chunk.NEWLINE);//space
        
       
        
        File pomfile = new File("./pom.xml");
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader(pomfile));
        
        PdfPTable table1 = new PdfPTable(4);
        table1.addCell(new PdfPCell(new Phrase("Model Version",c1)));
        table1.addCell(new PdfPCell(new Phrase("Group Id",c1)));
        table1.addCell(new PdfPCell(new Phrase("Artifacted Id",c1)));
        table1.addCell(new PdfPCell(new Phrase("Version",c1)));
        table1.addCell(new PdfPCell(new Phrase(model.getModelVersion(),c1)));
        table1.addCell(new PdfPCell(new Phrase(model.getGroupId(),c1)));
        table1.addCell(new PdfPCell(new Phrase(model.getArtifactId(),c1)));
        table1.addCell(new PdfPCell(new Phrase(model.getVersion(),c1)));
        
        document.add(table1);
        
       // document.add(new Paragraph(model.getName(), dep));
       // document.add(new Paragraph(model.getDescription(), dep));
       document.add(Chunk.NEWLINE);//space
        
        
        
      
     
       List<Plugin> plugins = model.getBuild().getPlugins();
       for (Plugin plugin : plugins) {
    	   document.add(new Paragraph("------------------------------------------------------", dep));
    	   document.add(new Paragraph( "Group Id: "+plugin.getGroupId(),dep));
    	   document.add(new Paragraph( "Artifact Id: "+plugin.getArtifactId(),dep));
    	   document.add(new Paragraph( "Version: "+plugin.getVersion(),dep));	
	      }
       
       
      List<Dependency> dependencies = model.getDependencies();
      for (Dependency dependency : dependencies) {
    	  document.add(new Paragraph("------------------------------------------------------", dep));
    	  document.add(new Paragraph( "Group Id: "+dependency.getGroupId(),dep));
    	  document.add(new Paragraph( "Artifact Id: "+dependency.getArtifactId(),dep));
    	  document.add(new Paragraph( "Version: "+dependency.getVersion(),dep));
		}
       
      
    
                                
  
        
        document.close();
	    System.out.println("PDF Report generated Successfully");
	    driver.quit();
	    

}

}
