package com.meutesouro.utils;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlSerializer;

import com.meutesouro.entity.*;

import android.content.Context;
import android.util.Xml;

public class XmlUtils {
	
	private	String XmlFileName;
	private FileInputStream FileInput;
	private Context XmlContext;
	
	public String getXmlFileName() {
		return XmlFileName;
	}

	public void setXmlFileName(String xmlFileName) {
		XmlFileName = xmlFileName;
	}

	public FileInputStream getFileInput() {
		return FileInput;
	}

	public void setFileInput(FileInputStream fileInput) {
		FileInput = fileInput;
	}
	
	public XmlUtils( Context context ){
		XmlContext = context;
	}

	
	public int XmlSaveData(String m_FileName, Object m_Object){
		
		int StatusReturn = -1;
		/*FileOutputStream FileOutput;
		
		setXmlFileName(m_FileName);
		
		if ( m_Object.getClass().equals( MoneyTitle.class.t)

		FileOutput = XmlContext.openFileOutput( XmlFileName, Context.MODE_APPEND);
		
		if ( null != FileOutput ){
		    XmlSerializer serializer = Xml.newSerializer();
		    serializer.setOutput(FileOutput, "UTF-8");
		    serializer.startDocument(null, Boolean.valueOf(true));
		    serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
		    serializer.startTag(null, "root");
		}
			

	    for(int j = 0 ; j < 3 ; j++)
	    {

	        serializer.startTag(null, "record");

	        serializer.text(data);

	        serializer.endTag(null, "record");
	    }
	     serializer.endDocument();

	     serializer.flush();

	     fos.close();
		
		
		*/
		return StatusReturn;
	}
	
	public void XmlLoadData(){
		
		/*
		   FileInputStream fis = null;
		    InputStreamReader isr = null;

		    fis = context.openFileInput(filename);
		    isr = new InputStreamReader(fis);
		    char[] inputBuffer = new char[fis.available()];
		    isr.read(inputBuffer);
		    data = new String(inputBuffer);
		    isr.close();
		    fis.close();


		        InputStream is = new ByteArrayInputStream(data.getBytes("UTF-8"));

		        ArrayList<XmlData> xmlDataList = new ArrayList<XmlData>();

		    XmlData xmlDataObj;
		    DocumentBuilderFactory dbf;
		    DocumentBuilder db;
		    NodeList items = null;
		    Document dom;

		    dbf = DocumentBuilderFactory.newInstance();
		    db = dbf.newDocumentBuilder();
		    dom = db.parse(is);
		    
		    dom.getDocumentElement().normalize();

		    items = dom.getElementsByTagName("record");

		    ArrayList<String> arr = new ArrayList<String>();

		    for (int i=0;i<items.getLength();i++){

		        Node item = items.item(i);

		         arr.add(item.getNodeValue());

		    }      
		    */
	}
}

