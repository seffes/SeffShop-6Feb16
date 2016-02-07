package com.example.seff4_000.myshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {

    //ประกาศตัวแปร
    private TextView showNameTextView;
    private Spinner deakSpinner;
    private ListView foodListView;
    private String officerString, deskString, foodString, amountString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //bind Widget
        bindWidget();

        //Show View
        showView();

        //showDesk
        showDesk();

    }  //main methrod

    private void showDesk() {

        final String[] showDeskStrings = {"โต๊ะ 1", "โต๊ะ 2", "โต๊ะ 3", "โต๊ะ 4", "โต๊ะ 5",
                "โต๊ะ 6", "โต๊ะ 7", "โต๊ะ 8", "โต๊ะ 9", "โต๊ะ 10"};
        ArrayAdapter<String> deskAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, showDeskStrings);
        deakSpinner.setAdapter(deskAdapter);
        deakSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                deskString = showDeskStrings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                deskString = showDeskStrings[0];
            }
        });


    }  //showDesk

    private void showView() {

        //receive from Intent รับค่าจากอินเท้น
        officerString = getIntent().getStringExtra("Name");
        showNameTextView.setText(officerString);

    }  //Show View


    private void bindWidget() {
        showNameTextView = (TextView) findViewById(R.id.textView2);
        deakSpinner = (Spinner) findViewById(R.id.spinner);
        foodListView = (ListView) findViewById(R.id.listView);
    }  //bind Widget


}   //mainclass
