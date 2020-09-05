package com.example.nazim_mobile_app_1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                recreate();
            }
        });

        final TextView output=(TextView) findViewById(R.id.output);
        output.setText("");
        this.ResDisnabled();
        this.OPsetEnabled();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        final TextView output=(TextView) findViewById(R.id.output);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            output.setText("action settings");
        }
        if (id == R.id.action_logout) {
            output.setText("action logout");
        }

        return super.onOptionsItemSelected(item);
    }



    //les operation
    public void clear(View view) {
        TextView output=(TextView) findViewById(R.id.output);
        String value =output.getText().toString();
       // output.setText(value);
        String newV = "";
        char [] str= value.toCharArray();
        for (int i=0;i<value.length()-1;i++){
            newV=newV.concat(String.valueOf(str[i]));
        }
        if (newV == ""){
           recreate();
        }
        output.setText(newV);
    }
    public void div(View view) {
        Toast.makeText(MainActivity.this,"division",Toast.LENGTH_SHORT).show();
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"/");
        this.OPsetDisnabled();
        this.ResDisnabled();

    }
    public void mul(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"*");
        this.OPsetDisnabled();
        this.ResDisnabled();

    }
    public void sub(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"-");
        this.OPsetDisnabled();
        this.ResDisnabled();
    }
    public void add(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"+");
        this.OPsetDisnabled();
        this.ResDisnabled();
    }
    public void puis(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"^");
        this.OPsetDisnabled();
        this.ResDisnabled();
    }
    public void mod(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"%");
        this.OPsetDisnabled();
        this.ResDisnabled();
    }
    public void ras(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText("\u221A");
        this.OPsetDisnabled();
        this.ResDisnabled();
        this.RasDisnabled();
    }
    public void resualt(View view) {
        this.OPsetEnabled();
        this.ResDisnabled();
        this.RasEnabled();
        final TextView output=(TextView) findViewById(R.id.output);
        String value=(output.getText().toString().trim());

        if (value.startsWith("/")||value.startsWith("*")||value.startsWith("-")||value.startsWith("+")){
            Snackbar.make(view, "Error : you cant start with ( + or - or * or / )  ", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }else{
            if (value.startsWith(".")||value.endsWith(".")){
                Snackbar.make(view, "Error : you cant start or ends with  ( . )  ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
            else{
                int length = value.length();
                boolean Add=value.contains("+");
                if (Add){
                    Float v1=Float.parseFloat(value.substring(0,value.indexOf("+")));
                    Float v2=Float.parseFloat(value.substring(value.indexOf("+")+1,length));
                    Float res=v1+v2;
                    output.setText(res.toString());

                }
                boolean Sub=value.contains("-");
                if (Sub){
                    Float v1=Float.parseFloat(value.substring(0,value.indexOf("-")));
                    Float v2=Float.parseFloat(value.substring(value.indexOf("-")+1,length));
                    Float res=v1-v2;
                    output.setText(res.toString());
                }
                boolean mul=value.contains("*");
                if (mul){
                    Float v1=Float.parseFloat(value.substring(0,value.indexOf("*")));
                    Float v2=Float.parseFloat(value.substring(value.indexOf("*")+1,length));
                    Float res=v1*v2;
                    output.setText(res.toString());
                }
                boolean div=value.contains("/");
                if (div){
                    Float v1=Float.parseFloat(value.substring(0,value.indexOf("/")));
                    Float v2=Float.parseFloat(value.substring(value.indexOf("/")+1,length));
                    if (v2 == 0){

                        Snackbar.make(view, "You can't make a divition on 0 ", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                    }else{
                        Float res=v1/v2;
                        output.setText(res.toString());
                    }

                }
                boolean puis=value.contains("^");
                if (puis){
                    Float v1=Float.parseFloat(value.substring(0,value.indexOf("^")));
                    Float v2=Float.parseFloat(value.substring(value.indexOf("^")+1,length));
                    if (v2 == 0){

                        Snackbar.make(view, "You can't make a divition on 0 ", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                    }else{
                        Double res = Math.pow(v1, v2);
                        output.setText(String.valueOf(res));
                    }

                }
                boolean mod=value.contains("%");
                if (mod){
                    Float v1=Float.parseFloat(value.substring(0,value.indexOf("%")));
                    Float v2=Float.parseFloat(value.substring(value.indexOf("%")+1,length));
                    Float res=v1%v2;
                   output.setText(res.toString());
                }
                boolean ras=value.startsWith("\u221A");
                if (ras){
                    Float v2=Float.parseFloat(value.substring(1,length));
                    Double res=Math.sqrt(v2);
                    output.setText(String.valueOf(res));
                }
            }
        }

    }

    //adding the numbers
    public void num_9(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"9");
        this.ResEnabled();
    }
    public void num_8(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"8");
        this.ResEnabled();
    }
    public void num_7(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"7");
        this.ResEnabled();
    }
    public void num_6(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"6");
        this.ResEnabled();
    }
    public void num_5(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"5");
        this.ResEnabled();
    }
    public void num_4(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"4");
        this.ResEnabled();
    }
    public void num_3(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"3");
        this.ResEnabled();
    }
    public void num_2(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"2");
        this.ResEnabled();
    }
    public void num_1(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"1");
        this.ResEnabled();
    }
    public void num_0(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+"0");
        this.ResEnabled();
    }
    public void num_dot(View view) {
        final TextView output=(TextView) findViewById(R.id.output);
        output.setText(output.getText()+".");
        this.ResEnabled();
    }

    // set Enabled
    public void OPsetDisnabled(){
        findViewById(R.id.btn_add).setEnabled(false);
        findViewById(R.id.btn_sub).setEnabled(false);
        findViewById(R.id.btn_mul).setEnabled(false);
        findViewById(R.id.btn_div).setEnabled(false);
        findViewById(R.id.btn_puis).setEnabled(false);
        findViewById(R.id.btn_mod).setEnabled(false);
    }
    public void OPsetEnabled(){
        findViewById(R.id.btn_add).setEnabled(true);
        findViewById(R.id.btn_sub).setEnabled(true);
        findViewById(R.id.btn_mul).setEnabled(true);
        findViewById(R.id.btn_div).setEnabled(true);
        findViewById(R.id.btn_puis).setEnabled(true);
        findViewById(R.id.btn_mod).setEnabled(true);
    }
    public void ResEnabled(){
        findViewById(R.id.btn_res).setEnabled(true);
    }
    public void ResDisnabled(){
        findViewById(R.id.btn_res).setEnabled(false);
    }

    public void RasEnabled(){
        findViewById(R.id.btn_ras).setEnabled(true);
    }
    public void RasDisnabled(){
        findViewById(R.id.btn_ras).setEnabled(false);
    }
}