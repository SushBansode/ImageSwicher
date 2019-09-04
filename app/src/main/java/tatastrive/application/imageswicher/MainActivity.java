package tatastrive.application.imageswicher;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher is;
    Button b;
    int currentIndex=-1;
    int imageIds[]={R.drawable.aaa,R.drawable.ddd,R.drawable.sss,R.drawable.sush};
    int count=imageIds.length;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        b=findViewById( R.id.button3 );
        is=findViewById( R.id.image );
        is.setFactory( new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView( getApplicationContext() );
                imageView.setScaleType( ImageView.ScaleType.FIT_CENTER );
                imageView.setLayoutParams( new ImageSwitcher.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT ) );
                return imageView;
            }
        } );

        Animation in= AnimationUtils.loadAnimation( this,android.R.anim.slide_in_left );
        Animation out=AnimationUtils.loadAnimation( this,android.R.anim.slide_out_right );
        is.setInAnimation( in );
        is.setInAnimation( out );


        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentIndex++;
                if(currentIndex==count)
                    currentIndex=0;
                is.setImageResource(imageIds[currentIndex]);


            }
        } );

    }
}
