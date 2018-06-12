package jona.com.suamycv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnExperiencia, btnReferencia, btnFormacion, menuButton;
    Boolean pressed =false;
    RelativeLayout menuButtonRL;
    Toolbar toolbar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declaramos o referenciamos los botones
        btnExperiencia = (Button)findViewById(R.id.btnExperiencia);
        btnFormacion = (Button)findViewById(R.id.btnFormacion);
        btnReferencia = (Button)findViewById(R.id.btnReferencias);
        menuButton = (Button)findViewById(R.id.menuButton);
        menuButtonRL = (RelativeLayout) findViewById(R.id.menuButtonRL);

        // accion de dar clic en cada boton
        btnExperiencia.setOnClickListener(this);
        btnReferencia.setOnClickListener(this);
        btnFormacion.setOnClickListener(this);


        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pressed){
                    menuButtonRL.setVisibility(View.GONE);
                    pressed = false;
                    Log.v("if","fff");
                }else{
                    menuButtonRL.setVisibility(View.VISIBLE);
                    pressed = true;
                    Log.v("else","fff");
                }
            }
        });


        initToolBar();


    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Currículum Vitae");
        setSupportActionBar(toolbar);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnExperiencia:
                intent = new Intent(this,Experiencia.class);
                startActivity(intent);
                break;

            case R.id.btnFormacion:
                intent = new Intent(this,Estudios.class);
                startActivity(intent);
                break;

            case R.id.btnReferencias:
                intent = new Intent(this,Referencias.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
