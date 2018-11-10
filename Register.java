package first.internal.com.ursdoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DBHelperClass myDB;
    EditText id,username , createpassword ,confirmpassword;
    String s1,s2,s3,s4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        id=(EditText)findViewById(R.id.id);
        username = (EditText)findViewById(R.id.username);
        createpassword = (EditText)findViewById(R.id.createpassword);
        confirmpassword = (EditText)findViewById(R.id.confirmpassword);



        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                myDB = new DBHelperClass(getApplicationContext());
                s1=id.getText().toString();
                s2=username.getText().toString();
                s3=createpassword.getText().toString();
                s4=confirmpassword.getText().toString();
                boolean insert= myDB.insertData(s1,s2,s3,s4);
                if(insert==true )
                {
                    Toast.makeText(Register.this,"Registered",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Register.this,MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(Register.this,"Not Registered",Toast.LENGTH_LONG).show();
                }



            }
        });


    }
}