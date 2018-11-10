package first.internal.com.ursdoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHelperClass db;
    EditText username;
    EditText confirmpassword;
    Button login;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.username);
        confirmpassword=(EditText)findViewById(R.id.confirmpassword);
        login=(Button)findViewById(R.id.login);
        db=new DBHelperClass(this);
        login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String p=username.getText().toString();
                        String n=confirmpassword.getText().toString();
                        boolean validate = db.validate(p,n);
                        if(validate==true) {
                            Toast.makeText(MainActivity.this, "login is successful", Toast.LENGTH_LONG).show();
                            String str = username.getText().toString();
                            Intent i = new Intent(getApplicationContext(),Main3Activity.class);
                            i.putExtra("message", str);
                            startActivity(i);
                        } else
                            Toast.makeText(MainActivity.this,"login failed enter valid data",Toast.LENGTH_LONG).show();

                    }
                });
        Button signup = (Button)findViewById(R.id.signin);
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this,Register.class);
                startActivity(i);
            }

        });

    }
}