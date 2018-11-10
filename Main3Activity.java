package first.internal.com.ursdoctor;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    DBHelperClass mydb;
    EditText first_name,last_name,dob,sex,height,weight,blood_group;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        first_name=(EditText)findViewById(R.id.first_name);
        last_name=(EditText)findViewById(R.id.last_name);
        dob=(EditText)findViewById(R.id.dob);
        sex=(EditText)findViewById(R.id.sex);
        height=(EditText)findViewById(R.id.height);
        weight=(EditText)findViewById(R.id.weight);
        blood_group=(EditText)findViewById(R.id.blood_group);
        save=(Button)findViewById(R.id.save);
        SQLiteDatabase.CursorFactory context;
        mydb = new DBHelperClass(getApplicationContext());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=first_name.getText().toString();
                String s2=last_name.getText().toString();
                String s3=dob.getText().toString();
                String s4=sex.getText().toString();
                String s5=height.getText().toString();
                String s6=weight.getText().toString();
                String s7=blood_group.getText().toString();
                boolean insert= mydb.insertData1(s1,s2,s3,s4,s5,s6,s7);
                if(insert==false )
                {
                    Toast.makeText(Main3Activity.this,"data has been inserted",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Main3Activity.this,search.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(Main3Activity.this,"Not inserted",Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
