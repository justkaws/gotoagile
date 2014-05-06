package com.meutesouro.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.meutesouro.entity.MoneyTitle;
import com.meutesouro.gotoagile.R;

public class FavoriteListAdapter extends ArrayAdapter<MoneyTitle> {

	public FavoriteListAdapter(Context context, int resource, List<MoneyTitle> objects) {
		super(context, resource, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		MoneyTitle title = getItem(position);
		
		// Check if an existing view is being reused, otherwise inflate the view
	       if (convertView == null) {
	          convertView = LayoutInflater.from(getContext()).inflate(R.layout.favorite_list_item, parent, false);
	       }
	       // Lookup view for data population
	       TextView tvTitleName = (TextView) convertView.findViewById(R.id.money_title);
	       // Populate the data into the template view using the data object
	       tvTitleName.setText(title.getName());
	       // Return the completed view to render on screen
	       return convertView;
	}
}
