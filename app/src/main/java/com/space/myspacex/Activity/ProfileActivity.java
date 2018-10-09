package com.space.myspacex.Activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.space.myspacex.R;
import com.space.myspacex.api.ApiClient;
import com.space.myspacex.api.ApiInterface;
import com.space.myspacex.fragments.CoresDetails;
import com.space.myspacex.fragments.LaunchDetails;
import com.space.myspacex.fragments.PayloadDetails;
import com.space.myspacex.fragments.RocketDetails;
import com.space.myspacex.model.MasterJson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView txtprofileid;
    private ProgressDialog dialog;
    private MasterJson masterDetails;
    private TextView textLaunch;
    private TextView textRocket;
    private TextView textPayload;
    private TextView textCore;
    private Context mcontext;
    String emailFromIntent;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mcontext = ProfileActivity.this;

        textLaunch = findViewById(R.id.launchtext);
        textRocket = findViewById(R.id.rocket_text);
        textPayload = findViewById(R.id.payloadtext);
        textCore = findViewById(R.id.coretext);
        emailFromIntent = (getIntent() != null) ? getIntent().getStringExtra("EMAIL") : "xyz@gmail.com";
        Log.d("emailFromIntent", "emailFromIntent" + emailFromIntent);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Please wait...");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = LayoutInflater.from(this).inflate(R.layout.nav_header_profile, navigationView, false);
        navigationView.addHeaderView(headerView);
        txtprofileid = headerView.findViewById(R.id.text_profile);
        txtprofileid.setText(emailFromIntent);

        navigationView.setNavigationItemSelectedListener(this);
        textLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activeLaunch();
                LaunchDetails fragmentLaunch = new LaunchDetails();
                Bundle bundle = new Bundle();
                bundle.putParcelable(AppUtils.DETAILS, masterDetails);
                fragmentLaunch.setArguments(bundle);
                loadFragment(fragmentLaunch);

            }
        });
        textRocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activeRocket();
                RocketDetails fragmentRocket = new RocketDetails();
                Bundle bundle = new Bundle();
                bundle.putParcelable(AppUtils.DETAILS, masterDetails);
                fragmentRocket.setArguments(bundle);
                loadFragment(fragmentRocket);


            }
        });
        textCore.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                activeCore();
                CoresDetails fragmentCores = new CoresDetails();
                Bundle bundle = new Bundle();
                bundle.putParcelable(AppUtils.DETAILS, masterDetails);
                fragmentCores.setArguments(bundle);
                loadFragment(fragmentCores);

            }
        });
        textPayload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activePayload();
                PayloadDetails fragmentPayload = new PayloadDetails();
                Bundle bundle = new Bundle();
                bundle.putParcelable(AppUtils.DETAILS, masterDetails);
                fragmentPayload.setArguments(bundle);
                loadFragment(fragmentPayload);


            }
        });
        loadDetails();
    }

    @SuppressLint("NewApi")
    private void activeRocket() {
        textRocket.setTextColor(getResources().getColor(R.color.ActiveColorText));
        textRocket.setBackground(getDrawable(R.color.activeColor));
        textPayload.setTextColor(getResources().getColor(R.color.deActiveColorText));
        textPayload.setBackground(getDrawable(R.color.deActiveColor));
        textLaunch.setTextColor(getResources().getColor(R.color.deActiveColorText));
        textLaunch.setBackground(getDrawable(R.color.deActiveColor));
        textCore.setTextColor(getResources().getColor(R.color.deActiveColorText));
        textCore.setBackground(getDrawable(R.color.deActiveColor));
    }

    @SuppressLint("NewApi")
    private void activePayload() {
        textPayload.setTextColor(getResources().getColor(R.color.ActiveColorText));
        textPayload.setBackground(getDrawable(R.color.activeColor));
        textRocket.setTextColor(getResources().getColor(R.color.deActiveColorText));
        textRocket.setBackground(getDrawable(R.color.deActiveColor));
        textLaunch.setTextColor(getResources().getColor(R.color.deActiveColorText));
        textLaunch.setBackground(getDrawable(R.color.deActiveColor));
        textCore.setTextColor(getResources().getColor(R.color.deActiveColorText));
        textCore.setBackground(getDrawable(R.color.deActiveColor));
    }


    @SuppressLint("NewApi")
    private void activeCore() {
        textCore.setTextColor(getResources().getColor(R.color.ActiveColorText));
        textCore.setBackground(getDrawable(R.color.activeColor));
        textRocket.setTextColor(getResources().getColor(R.color.deActiveColorText));
        textRocket.setBackground(getDrawable(R.color.deActiveColor));
        textLaunch.setTextColor(getResources().getColor(R.color.deActiveColorText));
        textLaunch.setBackground(getDrawable(R.color.deActiveColor));
        textPayload.setTextColor(getResources().getColor(R.color.deActiveColorText));
        textPayload.setBackground(getDrawable(R.color.deActiveColor));
    }

    @SuppressLint("NewApi")
    private void activeLaunch() {
        textLaunch.setTextColor(getResources().getColor(R.color.ActiveColorText));
        textLaunch.setBackground(getDrawable(R.color.activeColor));
        textRocket.setTextColor(getResources().getColor(R.color.deActiveColorText));
        textRocket.setBackground(getDrawable(R.color.deActiveColor));
        textCore.setTextColor(getResources().getColor(R.color.deActiveColorText));
        textCore.setBackground(getDrawable(R.color.deActiveColor));
        textPayload.setTextColor(getResources().getColor(R.color.deActiveColorText));
        textPayload.setBackground(getDrawable(R.color.deActiveColor));
    }


    private void loadDetails() {
        showloadingDialog();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        try {
            Call<MasterJson> call = apiInterface.getDetails();
            call.enqueue(callbackParse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFragment(Fragment fragment) {
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // replace the FrameLayout with new Fragment
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit(); // save the changes
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_signout) {
            finish();
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private Callback<MasterJson> callbackParse = new Callback<MasterJson>() {
        @Override
        public void onResponse(@NonNull Call<MasterJson> call, @NonNull Response<MasterJson> response) {
            if (response.body() != null)
                //  startNewActivity(response.body());
                masterDetails = response.body();
            hideDialog();
        }

        @Override
        public void onFailure(@NonNull Call<MasterJson> call, @NonNull Throwable t) {
            hideDialog();
            Log.e("Parsing Failed", t.getMessage());
            Toast.makeText(mcontext, t.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };

    private void hideDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private void showloadingDialog() {
        if (dialog != null) {
            dialog.show();
        }
    }
}
