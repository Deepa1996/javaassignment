package first.internal.com.ursdoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class search extends AppCompatActivity {
    Button b1;
    Button b2;
    EditText e1;
    ListView l1;
    DBHelperClass db;
    String name;
    List item;
    private ArrayAdapter<String>adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        e1=(EditText)findViewById(R.id.e1);
        l1=(ListView)findViewById(R.id.l1);
        db= new DBHelperClass(this);

        item = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
        l1.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=new DBHelperClass(getApplicationContext());
                String id=e1.getText().toString();
                name=db.fetchByID(id);
                if(name != null)
                {
                    Toast.makeText(getApplicationContext(),"Search succesfull",Toast.LENGTH_LONG).show();
                    adapter.add(name);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No data found",Toast.LENGTH_LONG).show();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(search.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}