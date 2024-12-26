package zeev.fraiman.edittextwithsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] info;
    ArrayAdapter<String> adapter;
    EditText et;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=findViewById(R.id.et);
        lv=findViewById(R.id.lv);

        String st=getResources().getString(R.string.text);
        info=st.split(" ");
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,info);
        lv.setAdapter(adapter);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ArrayList<String> al=new ArrayList<>();
                String st=et.getText().toString();
                int how=st.length();
                for (int j = 0; j < info.length; j++) {
                    if (info[j].length()>how && st.equals(info[j].substring(0,how)))
                        al.add(info[j]);
                }
                Toast.makeText(MainActivity.this, st+", "+how, Toast.LENGTH_SHORT).show();

                adapter=new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, al);
                lv.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
