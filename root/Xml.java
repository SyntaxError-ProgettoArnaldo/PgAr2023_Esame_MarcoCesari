package root;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Xml
{
    private static final String PATH_INPUT = "file/Mappe.xml";
    static XMLInputFactory xmlif = null;
    static XMLStreamReader xmlr = null;


    /**
     * @param filename path del file con cui inizializzare
     */
    public static void inizializzaXMLLettura(String filename) throws FileNotFoundException, XMLStreamException
    {
        xmlif = XMLInputFactory.newInstance();
        xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
    }
    /**
     * Legge il file xml e crea gli oggetti inserendoli nell array
     */
    
    public static ArrayList<ArrayList<Nodo>> leggiMappe() throws XMLStreamException, FileNotFoundException {
        inizializzaXMLLettura(PATH_INPUT);
        ArrayList<ArrayList<Nodo>> listaMappe = new ArrayList<>();  //lista delle mappe
        ArrayList<Nodo> mappa = null; //singola mappa
        ArrayList<Integer> link = null;     //lista dei collegamenti deI SINGOLI COLLEGAMENTI
        int id = 0;
        String tipo = null;

        while (xmlr.hasNext()) // continua a leggere finché ha eventi a disposizione
        {
            switch (xmlr.getEventType()) // switch sul tipo di evento
            {
                case XMLStreamConstants.START_ELEMENT ->
                {
                    switch (xmlr.getLocalName())
                    {
                        case "MAPPA" ->
                        {
                            //quando trovi mappa
                            mappa = new ArrayList<>();
                        }
                        case "NODO" ->
                        {

                            id = Integer.parseInt(xmlr.getAttributeValue(0));
                            link= new ArrayList<>();
                            //crea mappa
                        }
                        case "TIPO"->
                        {
                            while(xmlr.hasNext() && xmlr.getEventType() != XMLStreamConstants.CHARACTERS)  //vai fino a caratteri
                                xmlr.next();
                            if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                            {
                                tipo= xmlr.getText();

                            }
                        }
                        case "COLLEGAMENTI"->
                        {
                            link = new ArrayList<>();
                        }
                        case "COLLEGAMENTO"->
                        {
                            while(xmlr.hasNext() && xmlr.getEventType() != XMLStreamConstants.CHARACTERS)  //vai fino a caratteri
                                xmlr.next();

                            link.add(Integer.valueOf(xmlr.getText()));
                        }

                    }
                }
                case XMLStreamConstants.END_ELEMENT ->
                {
                    if(xmlr.getLocalName().equals("NODO"))
                    {
                        //aggiungi mappa singola
                        mappa.add(new Nodo(id,tipo,link));

                    } else if (xmlr.getLocalName().equals("MAPPA")) {
                        //aggiungi mappa alla lista
                        listaMappe.add(mappa);
                    }

                }
            }
            xmlr.next();
        }
        xmlr.close();
        return listaMappe;
    }

     
}
