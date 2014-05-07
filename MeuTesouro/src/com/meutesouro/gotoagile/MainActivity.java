package com.meutesouro.gotoagile;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

import com.meutesouro.adapter.FavoriteListAdapter;
import com.meutesouro.entity.MoneyTitle;
import com.meutesouro.parser.HtmlParser;
import com.meutesouro.parser.HtmlParser.ErrorCode;
import com.meutesouro.parser.IParserListener;

public class MainActivity extends Activity implements IParserListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    List<MoneyTitle> titleList;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        HtmlParser html = HtmlParser.getInstance();
        html.parse(this);
    }

    public void listContent(List<MoneyTitle> data){
    	
    	ListView listView = (ListView) findViewById(R.id.listView1);
    	listView.setAdapter(new FavoriteListAdapter(getApplication(), R.layout.favorite_list_item, data));
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void infoReceived(List<MoneyTitle> moneyTitlesList) {
		titleList = moneyTitlesList;
		listContent(titleList);
	}

	@Override
	public void error(ErrorCode errorCode, String errorMessage) {
		Log.d(TAG, errorMessage);
	}
    
}
