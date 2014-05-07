package com.meutesouro.gotoagile;

import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.meutesouro.adapter.FavoriteListAdapter;
import com.meutesouro.entity.MoneyTitle;

import com.meutesouro.parser.HtmlParser;
import com.meutesouro.parser.HtmlParser.ErrorCode;
import com.meutesouro.parser.IParserListener;

import com.meutesouro.utils.XmlUtils;

import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements IParserListener {

    private static final String TAG = MainActivity.class.getSimpleName();
	private SlidingMenu menu;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     
        setContentView(R.layout.activity_main);
        
        HtmlParser html = HtmlParser.getInstance();
        html.parse(this);
        
         
        //List<MoneyTitle> title2 = (List<MoneyTitle>)xmlUti\l.XmlLoadData( "teste.xml" );
        //Log.d(TAG, "Total de Elementos: " + title2.size());
        
        // configure the SlidingMenu
        menu = new SlidingMenu(this);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.menu_frame);
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
		listContent(moneyTitlesList);
	}

	@Override
	public void error(ErrorCode errorCode, String errorMessage) {
		Log.d(TAG, errorMessage);
	}
    
}
