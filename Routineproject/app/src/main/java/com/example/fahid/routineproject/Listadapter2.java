package com.example.fahid.routineproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by FAHID on 12/27/2017.
 */

public class Listadapter2 extends BaseAdapter {


    Context context;
    List<Syllabuss> valueList;


    public Listadapter2(List<Syllabuss> listValue, Context context)
    {
        this.context = context;
        this.valueList = listValue;
    }

    @Override
    public int getCount()
    {
        return this.valueList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return this.valueList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewItem1 viewItem1 = null;

        if(convertView == null)
        {
            viewItem1 = new ViewItem1();

            LayoutInflater layoutInfiater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInfiater.inflate(R.layout.listview2, null);
            viewItem1.Tcoursename3 = (TextView)convertView.findViewById(R.id.textView14);
            viewItem1.Tcoursename = (TextView)convertView.findViewById(R.id.textView12);
            viewItem1.Tcoursename2 = (TextView)convertView.findViewById(R.id.textView13);

            convertView.setTag(viewItem1);
            convertView.setTag(viewItem1);
            convertView.setTag(viewItem1);
        }
        else
        {
            viewItem1 = (ViewItem1) convertView.getTag();
        }

        viewItem1.Tcoursename.setText(valueList.get(position).Coursename);
        viewItem1.Tcoursename2.setText(valueList.get(position).Credit);
        viewItem1.Tcoursename3.setText(valueList.get(position).Coursecode);

        return convertView;
    }
}

class ViewItem1
{
    TextView Tcoursename;
    TextView Tcoursename2;
    TextView Tcoursename3;

}



