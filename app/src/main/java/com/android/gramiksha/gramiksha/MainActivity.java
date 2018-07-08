package com.android.gramiksha.gramiksha;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
//import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements HomeFragment.OnFragmentInteractionListener, GalleryFragment.OnFragmentInteractionListener, ProjectsFragment.OnFragmentInteractionListener,
        SubmissionsFragment.OnFragmentInteractionListener, AboutUsFragment.OnFragmentInteractionListener, JoinUsFragment.OnFragmentInteractionListener,
        ContactUsFragment.OnFragmentInteractionListener, ATeamFragment.OnFragmentInteractionListener {


    private NavigationView navigationView;
    private DrawerLayout drawer;

    //for accessing toolbar from fragments
    private Toolbar toolbar;

    public static int navItemIndex = 0;

    private static final String fragment_home="home";
    private static final String fragment_gallery="gallery";
    private static final String fragment_projects="projects";
    private static final String fragment_submissions="submissions";
    private static final String fragment_about_us="about_us";
    private static final String fragment_join_us="join_us";
    private static final String fragment_contact_us="contact_us";
    private static final String fragment_ateam="a_team";

    public static String current_fragment_tag=fragment_home;

    private boolean shouldLoadHomeFragOnBackPress = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer =(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.nav_view);

        if(savedInstanceState==null)
        {
            navItemIndex = 0;
            current_fragment_tag = fragment_home;
            loadFragment();
        }

        // initializing navigation menu
        setUpNavigationView();
        navigationView.getMenu().getItem(0).setChecked(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void loadFragment() {
        if (getSupportFragmentManager().findFragmentByTag(current_fragment_tag) != null) {
            drawer.closeDrawers();
            return;
        }

        Handler mHandler = new Handler();
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                drawer.closeDrawers();
            }
        };
        if (mPendingRunnable!=null) {
            mHandler.post(mPendingRunnable);
        }
        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
        invalidateOptionsMenu();
        Fragment fragment = getFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.content_frame, fragment, current_fragment_tag);
        fragmentTransaction.commitAllowingStateLoss();

        // If mPendingRunnable is not null, then add to the message queue
        //Closing drawer on item click
        // refresh toolbar menu
    }

    private void setUpNavigationView() {

        // This method will trigger on item Click of navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            //Check to see which item was being clicked and perform appropriate action
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        navItemIndex = 0;
                        current_fragment_tag = fragment_home;
                        break;
                    case R.id.nav_projects:
                        navItemIndex = 1;
                        current_fragment_tag = fragment_projects;
                        break;
                    case R.id.nav_gallery:
                        navItemIndex = 2;
                        current_fragment_tag = fragment_gallery;
                        break;
                    case R.id.nav_submissions:
                        navItemIndex = 3;
                        current_fragment_tag = fragment_submissions;
                        break;
                    case R.id.nav_about_us:
                        navItemIndex = 4;
                        current_fragment_tag = fragment_about_us;
                        break;
                    case R.id.nav_contact_us:
                        navItemIndex = 5;
                        current_fragment_tag = fragment_contact_us;
                        break;
                    case R.id.nav_join_us:
                        navItemIndex = 6;
                        current_fragment_tag = fragment_join_us;
                        break;
                    case R.id.nav_a_team:
                        navItemIndex = 7;
                        current_fragment_tag = fragment_ateam;
                        break;


                    default:
                        navItemIndex = 0;
                }
                //setting item checked state as true
                item.setChecked(true);

                loadFragment();

                return true;
            }
        });
        setToggle(toolbar);
    }

    /*  public void setToolbar(Toolbar toolbar, String title){
          AppCompatActivity actionBar = this;
          actionBar.setSupportActionBar(toolbar);
          //drawer icon sync with fragments
          setToggle(toolbar);
          if(toolbar != null)
              toolbar.setTitle(title);
      }
  */
    public void setToggle(Toolbar toolbar){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
    }


    private Fragment getFragment() {
        switch (navItemIndex) {
            case 0:
                // home
                HomeFragment homeFragment = new HomeFragment();
                toolbar.setTitle("Home");
                return homeFragment;
            case 1:
                //medicine log
                ProjectsFragment projectsFragment = new ProjectsFragment();
                toolbar.setTitle("Projects");
                return projectsFragment;
            case 2:
                //my courses
                GalleryFragment galleryFragment = new GalleryFragment();
                toolbar.setTitle("Gallery");
                return galleryFragment;
            case 3:
                SubmissionsFragment submissionsFragment = new SubmissionsFragment();
                toolbar.setTitle("Submissions");
                return submissionsFragment;
            case 4:
                AboutUsFragment aboutUsFragment = new AboutUsFragment();
                toolbar.setTitle("About Us");
                return aboutUsFragment;
            case 5:
                ContactUsFragment contactUsFragment = new ContactUsFragment();
                toolbar.setTitle("Contact Us");
                return contactUsFragment;
            case 6:
                JoinUsFragment joinUsFragment = new JoinUsFragment();
                toolbar.setTitle("Submissions");
                return joinUsFragment;
            case 7:
                ATeamFragment aTeamFragment = new ATeamFragment();
                toolbar.setTitle("A-Team");
                return aTeamFragment;


            default:
                return new HomeFragment();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return;
        }
        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                current_fragment_tag = fragment_home;
                loadFragment();
                return;
            }
        }

        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
