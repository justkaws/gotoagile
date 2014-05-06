package com.meutesouro.gotoagile;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

import com.meutesouro.adapter.FavoriteListAdapter;
import com.meutesouro.entity.MoneyTitle;
import com.meutesouro.utils.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        List<MoneyTitle> titleList = new ArrayList<MoneyTitle>();
        titleList.add(new MoneyTitle().setName("NTNB Principal 150519"));
        titleList.add(new MoneyTitle().setName("NTNB 150820"));
        titleList.add(new MoneyTitle().setName("NTNB Principal 150824"));
        titleList.add(new MoneyTitle().setName("NTNB 150535"));
        
        listContent(titleList);
        
        XmlUtils xmlUtil = new XmlUtils(getBaseContext());
        xmlUtil.XmlSaveData("teste.xml", titleList);
        
        List<MoneyTitle> title2 = (List<MoneyTitle>)xmlUtil.XmlLoadData( "teste.xml" );
        
        Log.d("Total de Elementos", title2.size());
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
    
}
