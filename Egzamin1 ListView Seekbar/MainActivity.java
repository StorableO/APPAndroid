package com.example.zadaniedzianisdzikun;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] gatunki = {
            "Pies",
            "Kot",
            "Swinka morska"
    };
    private ArrayAdapter<String> adapter;
    private ListView listView1 ;
    private String elementWybrany;
    public SeekBar seekBar1;
    private TextView ileMaLat;
    private Button btn1;
    public TextView result;
    private TextView imieNazw;
    private EditText cel;
    private EditText time;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
            ileMaLat = findViewById(R.id.ileMaLat);
            listView1 = findViewById(R.id.listView);
            seekBar1 = findViewById(R.id.seekBar1);
            btn1 = findViewById(R.id.button);
            result = findViewById(R.id.result);
            imieNazw = findViewById(R.id.ImieNazwisko);
            cel = findViewById(R.id.cel);
            time = findViewById(R.id.time);

            ArrayList<String> gatunkiZwierzat = new ArrayList<String>();
            gatunkiZwierzat.addAll( Arrays.asList(gatunki) );

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.list_element, R.id.lvelement, gatunkiZwierzat);
        listView1.setAdapter(arrayAdapter);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                elementWybrany = (String) listView1.getItemAtPosition(position);
                if(elementWybrany.equals("Pies")){
                    seekBar1.setMax(18);
                } else if (elementWybrany.equals("Kot")) {
                    seekBar1.setMax(20);
                }else seekBar1.setMax(9);
            }
        });

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ileMaLat.setText(progress+"");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = imieNazw.getText()+", " + elementWybrany+", "+ileMaLat.getText()+", " +cel.getText()+", "+time.getText();
                result.setText(text);
            }
        });

    }
}