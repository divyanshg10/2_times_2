package com.dcodestar.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    ListView listView;
    static ArrayList<String> table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=findViewById(R.id.seekBar);
        listView=findViewById(R.id.tablelist);
        seekBar.setProgress(5);
        seekBar.setMax(10);
        table=new ArrayList<>();
        for(int i=1;i<=20;i++){
            table.add(Integer.toString(i));
        }
        final ArrayAdapter<String> listContent=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,table);
        listView.setAdapter(listContent);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                table.clear();
                for(int i=1;i<=20;i++){
                    MainActivity.table.add(Integer.toString(i*progress));
                }
                listContent.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
