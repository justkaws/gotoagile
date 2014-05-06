package com.meutesouro.parser;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.util.Log;

import com.meutesouro.entity.MoneyTitle;
import com.meutesouro.entity.TitleTax;

public class HtmlParser {
	private static String TAG = "HtmlParser";
	private static String URL = "http://www3.tesouro.gov.br/tesouro_direto/consulta_titulos_novosite/consultatitulos.asp";
	
	private String url;
	private Document htmlDocument;
	private IParserListener listener;
	
	public HtmlParser(IParserListener listener) {
		this.listener = listener;
		parse();
	}
	
	public void setHtmlDocument(Document htmlDocument) {
		this.htmlDocument = htmlDocument;
		PopulateMoneyTitleList();
	}
	
	private void parse() {
		new FetchHtmlTask(this).execute(URL);
	}
	
	private void PopulateMoneyTitleList() {
		ArrayList<MoneyTitle> moneyTitleList = new ArrayList<MoneyTitle>();
		
		for (int i = 4; i < 16; i++)
		{
			Elements lineItems = htmlDocument.select("tr:nth-child(" + i + ") td");
			if (lineItems.size() > 1)
			{
				Log.d(TAG, "Line: " + i);
				
				MoneyTitle moneyTitle = new MoneyTitle();
				moneyTitle.setName(lineItems.get(0).text().trim());
				
				String dateAsString = lineItems.get(1).text().trim();
				Date date = null;
				try {
					SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
					date = dateFormatter.parse(dateAsString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				moneyTitle.setExpiredDate(date);
				
				TitleTax anualTax = new TitleTax();
				String taxesBuying = lineItems.get(2).text().trim();
				taxesBuying = taxesBuying.replaceFirst("%", "");
				taxesBuying = taxesBuying.replaceFirst(",", ".");
				anualTax.setTaxesBuying(Double.parseDouble(taxesBuying));
				
				String taxesSelling = lineItems.get(3).text().trim();
				if (taxesSelling.equals("-"))
					anualTax.setTaxesSelling(0);
				else
					anualTax.setTaxesSelling(Double.parseDouble(taxesSelling.replaceFirst("%", "")));
				moneyTitle.setAnualTitleTax(anualTax);
				
				TitleTax currentTax = new TitleTax();
				String currentTaxesBuying = lineItems.get(4).text().trim();
				currentTaxesBuying = currentTaxesBuying.replaceFirst("R", "");
				currentTaxesBuying = currentTaxesBuying.replaceFirst("\\$", "");
				currentTaxesBuying = currentTaxesBuying.replaceFirst("\\.", "");
				currentTaxesBuying = currentTaxesBuying.replaceFirst(",", ".");
				currentTax.setTaxesBuying(Double.parseDouble(currentTaxesBuying.trim()));
				
				String currentTaxesSelling = lineItems.get(5).text().trim();
				if (currentTaxesSelling.equals("-"))
					currentTax.setTaxesSelling(0);
				else
					currentTax.setTaxesSelling(Double.parseDouble(currentTaxesSelling.replaceFirst("%", "")));
				moneyTitle.setCurrentTitleTax(currentTax);
				
				moneyTitleList.add(moneyTitle);
			}
		}
		
		Log.d(TAG, "Finished parsing.");
		
		listener.infoReceived(moneyTitleList);
	}
}
