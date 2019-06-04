package sg.edu.rp.c346.simpletodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText etTask;
    Spinner spn;
Button btnAdd , btnDelete ,btnClear;
ListView lvTask;
    ArrayList<String> alTask;
    ArrayAdapter aaTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTask.findViewById(R.id.editTextTask);
        spn.findViewById(R.id.spinner);
        btnAdd.findViewById(R.id.buttonAdd);
        btnDelete.findViewById(R.id.buttonDelete);
        btnClear.findViewById(R.id.buttonClear);
        lvTask.findViewById(R.id.listViewTask);

        alTask = new ArrayList<>();
        aaTask = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1 , alTask);

        lvTask.setAdapter(aaTask);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String task = etTask.getText().toString();

                alTask.add(task);
                etTask.setText(null);
                aaTask.notifyDataSetChanged();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                alTask.clear();
                etTask.setText(null);
                aaTask.notifyDataSetChanged();
            }
        });

        lvTask.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position, long id){




            }
        });

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        btnDelete.setEnabled(false);
                        btnAdd.setEnabled(true);
                        etTask.setHint("Type in a new task here");
                        String task = etTask.getText().toString();
                         alTask.add(task);
                        aaTask.notifyDataSetChanged();

                        break;
                    case 1:
                        btnAdd.setEnabled(false);
                        btnDelete.setEnabled(true);
                        etTask.setHint("Type in the index of the task to be removed");
                        int pos = Integer.parseInt(etTask.getText().toString());
                       alTask.remove(pos);
                        aaTask.notifyDataSetChanged();

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
