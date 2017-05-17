package com.ilaboau.flippadapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class BlogPostActivity extends AppCompatActivity {
    @InjectView(R.id.blog_image)
    ImageView blogImage;
    @InjectView(R.id.blog_title)
    TextView blogTitle;
    @InjectView(R.id.blog_detail)
    TextView blogDetail;
    String blogNews = "Facebook CEO Mark Zuckerberg celebrated his 33rd birthday on Sunday, and on Monday his executive team surprised him with a special birthday cake shaped like pieces of meat.\n" +
            "\n" +
            "That is kinda fun, and bizarre, but even more interesting is the fact that Zuckerberg shared to his Facebook page this photo that includes nearly all of Facebook’s highest-ranking executives in the same place at the same time.\n" +
            "\n" +
            "It’s pretty rare to see so many top dogs from the company in one spot, so this feels like a good opportunity to look at which Facebookers are in Zuckerberg’s general orbit.\n" +
            "\n" +
            "Who are these lucky executives celebrating with the boss, and why should you care about them? We have answers.\n" +
            "\n" +
            "Mark Zuckerberg’s birthday buddies\n" +
            "Mark Zuckerberg, birthday boy.\n" +
            "Andrea Besmehn, Zuckerberg’s admin and frequent travel companion. It sounds like she was also the mastermind behind this meat cake.\n" +
            "Will Cathcart, VP of product management and one of Facebook’s top product executives reporting directly to product boss Chris Cox. Cathcart has been at Facebook for seven years and is responsible for Facebook’s trending product, among other things.\n" +
            "Kang-Xing Jin, known internally as “KX,” and another of Facebook’s top product execs; he’s been working on some of Facebook’s new camera features. KX joined Facebook over a decade ago as a software engineer and was a friend of Zuckerberg’s at Harvard before joining the company.\n" +
            "Kevin Systrom, CEO of Instagram and avid road cyclist.\n" +
            "Deb Liu, Facebook’s VP of platform and marketplace. Liu is credited with helping launch Facebook’s app install ads business, and also leads Facebook’s developer platform and efforts around commerce and payments.\n" +
            "Chris Cox, head of all Facebook products and a near 12-year company veteran. If Sheryl Sandberg is Zuckerberg’s right hand, Cox is probably his left.\n" +
            "Hiding back there is CFO Dave Wehner, the man responsible for explaining Facebook’s business operations to all those investors anxiously listening in on earnings calls.\n" +
            "Caryn Marooney, head of all communications at Facebook and gatekeeper to Mark Zuckerberg’s press availability\n" +
            "Mike Schroepfer, Facebook’s CTO and the man overseeing many of Facebook’s more ambitious tech efforts, like its artificial intelligence research and its connectivity projects.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setContentView(R.layout.activity_blog_post);
        ButterKnife.inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Blog Post");
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This will add the post to favorites", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        blogTitle.setText("Naruto Uzumaki!!!!!!");
        blogDetail.setText(blogNews);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_blog_post, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        /* TODO will implement share link intent share
         */
        if(id == R.id.action_share){
            String mimeType = "text/plain";
            String title ="share";
            String news_read = "read this blog post on ";
            String link = "https://www.recode.net/2017/5/16/15644418/fac" +
                    "ebook-executive-list-mark-zuckerberg-birthday-meast-cake-who-to-know" ;
            String text = news_read + link;
            //will replace the link from the link fro the api
            ShareCompat.IntentBuilder.from(this)
                    .setType(mimeType)
                    .setChooserTitle(title)
                    .setText(text)
                    .startChooser();

        }

        return super.onOptionsItemSelected(item);
    }
    public void readMore(View v){
        String link = "https://www.recode.net/2017/5/16/15644418/faceb" +
                "ook-executive-list-mark-zuckerberg-birthday-meast-cake-who-to-know" ;
        Uri uri = Uri.parse(link);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
}
