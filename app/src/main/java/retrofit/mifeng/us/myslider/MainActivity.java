package retrofit.mifeng.us.myslider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

public class MainActivity extends AppCompatActivity {

    private SliderLayout mSliderLayout;
    private PagerIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSliderLayout = (SliderLayout) findViewById(R.id.slider);
        indicator = (PagerIndicator) findViewById(R.id.custom_indicator);
        initSlider();
    }

    private void initSlider() {
        //SliderView有两种DefaultSliderView，TextSliderView用法一致，但是DefaultSliderView没有显示文字的功能
        //显示图片和文字
        TextSliderView textSliderView = new TextSliderView(MainActivity.this);
        textSliderView.image("http://m.360buyimg.com/mobilecms/s300x98_jfs/t2416/102/20949846/13425/a3027ebc/55e6d1b9Ne6fd6d8f.jpg");
        textSliderView.description("新品推荐");
        textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {

                Toast.makeText(MainActivity.this, "新品推荐", Toast.LENGTH_LONG).show();

            }
        });



        TextSliderView textSliderView2 = new TextSliderView(MainActivity.this);
        textSliderView2.image("http://m.360buyimg.com/mobilecms/s300x98_jfs/t1507/64/486775407/55927/d72d78cb/558d2fbaNb3c2f349.jpg");
        textSliderView2.description("时尚男装");

        textSliderView2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {

                Toast.makeText(MainActivity.this, "时尚男装", Toast.LENGTH_LONG).show();

            }
        });



        TextSliderView textSliderView3 = new TextSliderView(MainActivity.this);
        textSliderView3.image("http://m.360buyimg.com/mobilecms/s300x98_jfs/t1363/77/1381395719/60705/ce91ad5c/55dd271aN49efd216.jpg");
        textSliderView3.description("家电秒杀");


        textSliderView3.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {

                Toast.makeText(MainActivity.this, "家电秒杀", Toast.LENGTH_LONG).show();

            }
        });


        //添加到容器中
        mSliderLayout.addSlider(textSliderView);
        mSliderLayout.addSlider(textSliderView2);
        mSliderLayout.addSlider(textSliderView3);

        //使用默认的指示器
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);

        mSliderLayout.setCustomIndicator(indicator);
        //阴影显示的动画效果
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        //图片的转场效果
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Tablet);
        mSliderLayout.setDuration(3000);

        mSliderLayout.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {


                Log.d("e","onPageScrolled");

            }

            @Override
            public void onPageSelected(int i) {

                Log.d("e","onPageSelected");
            }

            @Override
            public void onPageScrollStateChanged(int i) {

                Log.d("e","onPageScrollStateChanged");
            }
        });


    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //停止循环
        mSliderLayout.stopAutoCycle();
    }

}
