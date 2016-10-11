package utilities;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import tasks.Task;
import tasks.TaskList;

public abstract class XMLUtil {
    
    public static TaskList getTasks(){
        return readXML();
    }
    
    private static TaskList readXML(){
        TaskList tasksList = new TaskList();
        File fXmlFile = new File("C:/ToDoListDesktop/tasks-data.xml");
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("task");
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    tasksList.getTasks().add(new Task( eElement.getAttribute("name")
                            , eElement.getAttribute("date"), eElement.getAttribute("time")
                            , eElement.getAttribute("list")
                            , eElement.getElementsByTagName("notes").item(0).getTextContent()
                            , eElement.getAttribute("complete")));

                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return tasksList;
    }
}
