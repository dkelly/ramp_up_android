package com.macadamian;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SimpleListAdapterActivity
    extends Activity
    implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    class Info {
        int textId;
        int iconId;
    }

    final private Info[] DATA = new Info[] {
        new Info() {{ textId = R.string.am; iconId = R.drawable.am; }},
        new Info() {{ textId = R.string.au; iconId = R.drawable.au; }},
        new Info() {{ textId = R.string.ca; iconId = R.drawable.ca; }},
        new Info() {{ textId = R.string.cn; iconId = R.drawable.cn; }},
        new Info() {{ textId = R.string.cz; iconId = R.drawable.cz; }},
        new Info() {{ textId = R.string.eg; iconId = R.drawable.eg; }},
        new Info() {{ textId = R.string.fi; iconId = R.drawable.fi; }},
        new Info() {{ textId = R.string.fr; iconId = R.drawable.fr; }},
        new Info() {{ textId = R.string.gr; iconId = R.drawable.gr; }},
        new Info() {{ textId = R.string.ie; iconId = R.drawable.ie; }},
        new Info() {{ textId = R.string.it; iconId = R.drawable.it; }},
        new Info() {{ textId = R.string.lb; iconId = R.drawable.lb; }},
        new Info() {{ textId = R.string.uk; iconId = R.drawable.uk; }}
    };
        
    class FlagAdapter extends ArrayAdapter<Info> {
        public FlagAdapter(Context context, Info[] contents) {
            super(context, R.layout.simple_list_adapter_item, contents);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = getLayoutInflater().inflate(R.layout.simple_list_adapter_item, parent, false);
            Info i = getItem(position);
            ((TextView) v.findViewById(R.id.simple_list_adapter_item_text)).setText(i.textId);
            ((ImageView) v.findViewById(R.id.simple_list_adapter_item_icon)).setImageResource(i.iconId);
            return v;
        }
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list_adapter);

        configure_list();
        configure_spinner();
    }

    private void configure_list() {
        ListView v = (ListView) findViewById(R.id.simple_list_adapter_list);
        v.setAdapter(new FlagAdapter(this, DATA));
        v.setOnItemClickListener(this);
    }

    private void configure_spinner() {
        ArrayList<CharSequence> text = new ArrayList<CharSequence>();

        for (Info i : DATA) {
            text.add(getResources().getString(i.textId));
        }

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, text);
        Spinner v = (Spinner) findViewById(R.id.simple_list_adapter_spinner);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        v.setAdapter(adapter);
        v.setOnItemSelectedListener(this);
    }

    private void showItem(int pos) {
        Toast.makeText(this, DATA[pos].textId, Toast.LENGTH_SHORT).show();
    }

    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        showItem(pos);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        showItem(pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }
}
