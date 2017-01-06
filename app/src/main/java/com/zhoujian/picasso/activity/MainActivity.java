package com.zhoujian.picasso.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import com.zhoujian.picasso.R;
import com.zhoujian.picasso.adapter.PictureAdapter;
import com.zhoujian.picasso.bean.Person;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends Activity
{
    ArrayList<Person> personList = new ArrayList<Person>();
    private Unbinder mBind;
    @BindView(R.id.list_person)
    ListView mListPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(MainActivity.this);
        initDates();
        setDatas();
    }

    private void setDatas()
    {
        PictureAdapter adapter = new PictureAdapter(MainActivity.this,personList);
        mListPerson.setAdapter(adapter);
    }

    private void initDates()
    {
        Person person0 = new Person("http://pic47.nipic.com/20140830/7487939_180041822000_2.jpg","湖光山色");
        personList.add(person0);
        Person person1 = new Person("http://pic41.nipic.com/20140518/4135003_102912523000_2.jpg","万紫千红");
        personList.add(person1);
        Person person2 = new Person("http://pic42.nipic.com/20140618/9448607_210533564001_2.jpg","青山绿水");
        personList.add(person2);
        Person person3 = new Person("http://pic10.nipic.com/20101027/3578782_201643041706_2.jpg","水天一色");
        personList.add(person3);
        Person person4 = new Person("http://pica.nipic.com/2007-12-21/2007122115114908_2.jpg","冰天雪窑");
        personList.add(person4);
        Person person5 = new Person("http://img2.3lian.com/2014/c7/51/d/26.jpg","春山如笑");
        personList.add(person5);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mBind.unbind();
    }
}
