package com.example.alex.graphics.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alex.graphics.R;
import com.example.alex.graphics.model.Drawable;
import com.example.alex.graphics.model.Line;
import com.example.alex.graphics.model.Point;
import com.example.alex.graphics.model.Rectangle;
import com.example.alex.graphics.model.Trinagle;
import com.example.alex.graphics.until.Const;

import java.sql.SQLSyntaxErrorException;
import java.util.Random;

public class AppActivity extends AppCompatActivity {

    private static Random rnd = new Random();
    private static CheckBox checkBox;
    public static TextView kText;
    private static CheckBox checkGroop;
    public static boolean checkMove(){
        return checkBox.isChecked();
    }
    public static boolean checkGroops(){
        return checkGroop.isChecked();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        checkBox = findViewById(R.id.checkMove);
        checkGroop = findViewById(R.id.groopCheck);
        kText = findViewById(R.id.xyText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.addLine:
                Const.list.add(new Line(new Point(rnd.nextInt(500), rnd.nextInt(800)), new Point(rnd.nextInt(1000), rnd.nextInt(1800)), Color.BLACK));
                break;
            case R.id.operation:
                Intent intentOperation = new Intent(AppActivity.this, OperationActivity.class);
                startActivity(intentOperation);
                break;
            case R.id.addRectangle:
                Const.list.add(new Rectangle(500, 1000, Color.BLACK));
                break;
            case R.id.addTriangle:
                Const.list.add(new Trinagle(500, 1000, Color.BLACK));
                break;
            case R.id.groop:
                if(checkGroops()){
                    int groopId = Const.id++;
                    for (Drawable drawable : Const.list) {
                        if(drawable.isChoose())
                        drawable.setId(groopId);
                    }
                }else{
                    Toast.makeText(this, "Разрешите работу с группами", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.delete:
                Const.isTouch=0;
                for (Drawable drawable : Const.list) {
                    if (drawable.isChoose()) {
                       Const.isTouch++;
                    }
                }
                while (Const.isTouch != 0) {
                    for (Drawable drawable : Const.list) {
                        if (drawable.isChoose()) {
                            Const.list.remove(drawable);
                            break;
                        }
                    }
                    Const.isTouch--;
                }
                break;
            case R.id.ungroop:
                for (Drawable drawable : Const.list) {
                    if(drawable.isChoose())
                        Const.id++;
                        drawable.setId(Const.id);
                }
                break;
            case R.id.morf:
                Intent morfIntent = new Intent(AppActivity.this, MorfActivity.class);
                startActivity(morfIntent);
                break;
            case R.id.edit:
                 Intent editIntent = new Intent(AppActivity.this, EditActivity.class);
                 startActivity(editIntent);
                break;
            case R.id.exit:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
