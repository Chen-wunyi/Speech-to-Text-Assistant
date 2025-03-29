

package com.example.speechre;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import androidx.appcompat.app.AppCompatActivity;

        import java.util.List;

public class MainActivity extends AppCompatActivity {
//activity加入androidManifest:點兩下選取class名然後alt+enter即可自動註冊


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Btn common
        Button common = (Button) findViewById(R.id.common);
        common.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent();
               intent.setClass(MainActivity.this,CommonActivity.class);
               startActivity(intent);
            }
        });

        //Btn split
        Button split = (Button) findViewById(R.id.split);
        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,SplitActivity.class);
                startActivity(intent);
            }
        });

        //Btn emoji
        Button emoji = (Button) findViewById(R.id.emoji);
        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent();
                //intent.setClass(MainActivity.this,EmojiActivity.class);
                //startActivity(intent);
            }
        });

        //Btn start
        Button start = (Button) findViewById(R.id.emoji);
        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

}
